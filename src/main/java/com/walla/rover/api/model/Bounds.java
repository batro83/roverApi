package com.walla.rover.api.model;

public class Bounds {

	private int minX;
	private final int maxX;
	private final int minY;
	private final int maxY;

	public Bounds(int minX, int maxX, int minY, int maxY) {
		this.minX = minX;
		this.maxX = maxX;
		this.minY = minY;
		this.maxY = maxY;
	}

	public static Bounds of(int minX, int maxX, int minY, int maxY) {
		if (minX > maxX || minY > maxY) {
			throw new IllegalArgumentException("Min value > max value");
		}

		return new Bounds(minX, maxX, minY, maxY);
	}

	public int getMinX() {
		return minX;
	}

	public int getMaxX() {
		return maxX;
	}

	public int getMinY() {
		return minY;
	}

	public int getMaxY() {
		return maxY;
	}

	@Override
	public String toString() {
		return "[minX=" + minX + ", maxX=" + maxX + ", minY=" + minY + ", maxY=" + maxY + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + maxX;
		result = prime * result + maxY;
		result = prime * result + minX;
		result = prime * result + minY;
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Bounds other = (Bounds) obj;
		if (maxX != other.maxX)
			return false;
		if (maxY != other.maxY)
			return false;
		if (minX != other.minX)
			return false;
		if (minY != other.minY)
			return false;
		return true;
	}

}
