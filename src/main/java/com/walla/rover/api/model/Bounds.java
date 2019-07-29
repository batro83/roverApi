package com.walla.rover.api.model;



public class Bounds {

	private final int minX;
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
		return "Bounds [minX=" + minX + ", maxX=" + maxX + ", minY=" + minY + ", maxY=" + maxY + "]";
	}


}
