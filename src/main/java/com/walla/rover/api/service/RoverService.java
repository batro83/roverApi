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
			if(position.getX()>bounds.getMinX()+1)
				position.setX(position.getX()-1);
			else
				position.setX(bounds.getMaxX());
				
		}else if(position.getFacing() == Facing.SOUTH){
			if(position.getX()<bounds.getMaxX())
				position.setX(position.getX()+1);
			else
				position.setX(bounds.getMinX()+1);
						
		} else if(position.getFacing() == Facing.EAST){
			if(position.getY() < bounds.getMaxY())
				position.setY(position.getY()+1);
			else
				position.setY(bounds.getMinY()+1);
			
		} else if(position.getFacing() == Facing.WEST){
			if(position.getY()>bounds.getMinY()+1)
				position.setY(position.getY() - 1);
			else
				position.setY(bounds.getMaxY());			
		}
		
		return checkPositionObstacles(position, prevPosition);
	}

	public RoverPosition right(RoverPosition position, Bounds bounds) {
		RoverPosition prevPosition = new RoverPosition(position.getX(), position.getY(), position.getFacing());
		
		if(position.getFacing() == Facing.NORTH){
			if(position.getX()<bounds.getMaxX())
				position.setX(position.getX()+1);
			else
				position.setX(bounds.getMinX()+1);
				
		}else if(position.getFacing() == Facing.SOUTH){
			if(position.getX()>bounds.getMinX()+1)
				position.setX(position.getX()-1);
			else
				position.setX(bounds.getMaxX());
						
		} else if(position.getFacing() == Facing.EAST){
			if(position.getY() > bounds.getMinY()+1)
				position.setY(position.getY()-1);
			else
				position.setY(bounds.getMaxY());
			
		} else if(position.getFacing() == Facing.WEST){
			if(position.getY()<bounds.getMaxY())
				position.setY(position.getY() + 1);
			else
				position.setY(bounds.getMinY()+1);			
		}
		
		return checkPositionObstacles(position, prevPosition);

	}

	public RoverPosition forward(RoverPosition position, Bounds bounds) {
		RoverPosition prevPosition = new RoverPosition(position.getX(), position.getY(), position.getFacing());
		
		if(position.getFacing() == Facing.NORTH){
			if(position.getY()<bounds.getMaxY())
				position.setY(position.getY()+1);
			else
				position.setY(bounds.getMinY()+1);
				
		}else if(position.getFacing() == Facing.SOUTH){
			if(position.getY()>bounds.getMinY()+1)
				position.setY(position.getY()-1);
			else
				position.setY(bounds.getMaxY());
						
		} else if(position.getFacing() == Facing.EAST){
			if(position.getX() < bounds.getMaxX())
				position.setX(position.getX()+1);
			else
				position.setX(bounds.getMinX()+1);
			
		} else if(position.getFacing() == Facing.WEST){
			if(position.getX()>bounds.getMinX()+1)
				position.setX(position.getX() - 1);
			else
				position.setX(bounds.getMaxX());			
		}
		
		return checkPositionObstacles(position, prevPosition);

	}

	public RoverPosition backward(RoverPosition position, Bounds bounds) {
		RoverPosition prevPosition = new RoverPosition(position.getX(), position.getY(), position.getFacing());
		
		if(position.getFacing() == Facing.NORTH){
			if(position.getY()>bounds.getMinY()+1)
				position.setY(position.getY()-1);
			else
				position.setY(bounds.getMaxY());
				
		}else if(position.getFacing() == Facing.SOUTH){
			if(position.getY()<bounds.getMaxY())
				position.setY(position.getY()+1);
			else
				position.setY(bounds.getMinY()+1);
						
		} else if(position.getFacing() == Facing.EAST){
			if(position.getX() > bounds.getMinX()+1)
				position.setX(position.getX()-1);
			else
				position.setX(bounds.getMaxX());
			
		} else if(position.getFacing() == Facing.WEST){
			if(position.getX()<bounds.getMaxX())
				position.setX(position.getX() + 1);
			else
				position.setX(bounds.getMinX()+1);			
		}
		
		return checkPositionObstacles(position, prevPosition);
	}
	
	
	private RoverPosition checkPositionObstacles(RoverPosition position, RoverPosition prevPosition) {		
		Obstacle checkObstacle = new Obstacle();
		checkObstacle.setX(position.getX());
		checkObstacle.setY(position.getY());
		
		boolean hasObstacle = obstacles.getList().contains(checkObstacle);
		
		if(hasObstacle){
			prevPosition.setObstacle(checkObstacle);
			return prevPosition;
		}else{
			position.setObstacle(null);
			return position;
		}
	}

}
