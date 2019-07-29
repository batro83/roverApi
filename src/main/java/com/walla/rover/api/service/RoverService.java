package com.walla.rover.api.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.walla.rover.api.config.Obstacles;
import com.walla.rover.api.model.Bounds;
import com.walla.rover.api.model.Obstacle;
import com.walla.rover.api.model.RoverPosition;
import com.walla.rover.api.utils.Facing;

@Service
public class RoverService {
	
	@Autowired
	private Obstacles obstacles;

	public RoverPosition left(RoverPosition position, Bounds bounds) {
		
		RoverPosition prevPosition = new RoverPosition(position.getX(), position.getY(), position.getFacing());
		
		if(position.getFacing() == Facing.NORTH){
			if(position.getX()<bounds.getMaxX())
				position.setX(position.getX() + 1);
			else
				position.setX(1);
				
		}else if(position.getFacing() == Facing.SOUTH){
			if(position.getX() == bounds.getMinX()+1)
				position.setX(bounds.getMaxX());
			else
				position.setX(position.getX() - 1);
						
		} else if(position.getFacing() == Facing.EAST){
			if(position.getY() == bounds.getMinY()+1)
				position.setY(bounds.getMaxY());
			else
				position.setY(position.getY() - 1);
			
		} else if(position.getFacing() == Facing.WEST){
			if(position.getY()<bounds.getMaxY())
				position.setY(position.getY() + 1);
			else
				position.setY(1);			
		}
		
		Obstacle obstacle = checkObstacles(position);
		if(obstacle!=null){
			prevPosition.setObstacle(obstacle);
			return prevPosition;
		}else{
			return position;
		}
	}

	public void right() {

	}

	public void forward() {

	}

	public void backward() {

	}
	
	
	private Obstacle checkObstacles(RoverPosition position) {		
		Obstacle checkObstacle = new Obstacle();
		checkObstacle.setX(position.getX());
		checkObstacle.setY(position.getY());
		
		boolean isObstacle = obstacles.getList().contains(checkObstacle);
		if(!isObstacle)
			checkObstacle=null;
		
		return checkObstacle;
	}

}