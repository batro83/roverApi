package com.walla.rover.api.model;

public class RoverPosition {
	
	private int x;
    private int y;
    private final char facing;
    
    
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
    

}
