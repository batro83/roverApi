package com.walla.rover.api.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;

import com.walla.rover.api.model.Bounds;
import com.walla.rover.api.model.RoverPosition;
import com.walla.rover.api.utils.Moves;

public class MarsService {
	private static final Logger logger = LogManager.getLogger(MarsService.class);
	private final Bounds bounds;
	private RoverPosition position;
	
	@Autowired
	private RoverService roverService;

	public MarsService(Bounds bounds, RoverPosition initposition) {
		this.bounds = bounds;
		this.position = initposition;
	}

	public RoverPosition move(List<Character> movesList) {
		for (Character move : movesList) {
			switch (move.toString()) {
				case Moves.LEFT:				
					position = roverService.left(position, bounds);				
					break;
				case Moves.RIGHT:
					position = roverService.right(position, bounds);
					break;
				case Moves.FORWARD:
					position = roverService.forward(position, bounds);
					break;
				case Moves.BACKWARD:
					position = roverService.backward(position, bounds);
					break;
	
				default:
					break;
			}
			
			// if we are in front of an obstacle don't continue, and show the obstacle position
			if(position.getObstacle()!=null)
				break;			

		}
		
		return position;
	}

}
