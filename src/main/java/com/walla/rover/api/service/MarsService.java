package com.walla.rover.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.walla.rover.api.model.Bounds;
import com.walla.rover.api.model.RoverPosition;
import com.walla.rover.api.utils.Moves;

@Service
public class MarsService {
	
	@Autowired
	private final Bounds bounds;
	@Autowired
	private RoverPosition position;	
	@Autowired
	private RoverService roverService;
	
	@Autowired
	public MarsService(Bounds bounds, RoverPosition position, RoverService roverService) {
		super();
		this.bounds = bounds;
		this.position = position;
		this.roverService = roverService;
	}


	public RoverPosition move(List<Character> movesList) {
		for (Character move : movesList) {
			switch (move) {
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
