package com.walla.rover.api.model;

public class RoverPosition {
	
	private final int x;
    private final int y;
    private final char facing;
    
    
	public RoverPosition(int x, int y, char facing) {
		super();
		this.x = x;
		this.y = y;
		this.facing = facing;
	}


	public int getX() {
		return x;
	}


	public int getY() {
		return y;
	}


	public char getFacing() {
		return facing;
	}
    
    

}
