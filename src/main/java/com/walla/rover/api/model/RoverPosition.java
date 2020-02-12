package com.walla.rover.api.model;

public class RoverPosition {

	private int x;
	private int y;
	private char facing;
	private Obstacle obstacle;

	public RoverPosition() {
		super();
	}

	public RoverPosition(int x, int y, char facing) {
		super();
		this.x = x;
		this.y = y;
		this.facing = facing;
	}

	public char getFacing() {
		return facing;
	}

	@Override
	public String toString() {
		if (obstacle != null)
			return String.format("(%d,%d,%s) Obstacle(%d,%d)", x, y, facing, obstacle.getX(), obstacle.getY());
		else
			return String.format("(%d,%d,%s)", x, y, facing);
	}

	public int getX() {
		return x;
	}

	public void setX(int x) {
		this.x = x;
	}

	public int getY() {
		return y;
	}

	public void setY(int y) {
		this.y = y;
	}

	public Obstacle getObstacle() {
		return obstacle;
	}

	public void setObstacle(Obstacle obstacle) {
		this.obstacle = obstacle;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + facing;
		result = prime * result + ((obstacle == null) ? 0 : obstacle.hashCode());
		result = prime * result + x;
		result = prime * result + y;
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
		RoverPosition other = (RoverPosition) obj;
		if (facing != other.facing)
			return false;
		if (obstacle == null) {
			if (other.obstacle != null)
				return false;
		} else if (!obstacle.equals(other.obstacle))
			return false;
		if (x != other.x)
			return false;
		if (y != other.y)
			return false;
		return true;
	}

	public void setFacing(char facing) {
		this.facing = facing;
	}

}
