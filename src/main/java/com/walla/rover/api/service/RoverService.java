package com.walla.rover.api.service;

import org.springframework.stereotype.Service;

import com.walla.rover.api.model.Bounds;
import com.walla.rover.api.model.RoverPosition;
import com.walla.rover.api.utils.Facing;

@Service
public class RoverService {

	public RoverPosition left(RoverPosition position, Bounds bounds) {
		if(position.getFacing() == Facing.NORTH){
			if(position.getX()<bounds.getMaxX())
				position.setX(position.getX() + 1);
			else
				position.setX(1);
				
		}else if(position.getFacing() == Facing.SOUTH){
			if(position.getX()>bounds.getMinX())
				position.setX(position.getX() + 1);
			else
				position.setX(1);
			
		} else if(position.getFacing() == Facing.EAST){
			if(position.getX()<bounds.getMaxX())
				position.setX(position.getX() + 1);
			else
				position.setX(1);
			
		} else if(position.getFacing() == Facing.WEST){
			if(position.getX()<bounds.getMaxX())
				position.setX(position.getX() + 1);
			else
				position.setX(1);
			
		}
		return position;

	}

	public void right() {

	}

	public void forward() {

	}

	public void backward() {

	}

}
