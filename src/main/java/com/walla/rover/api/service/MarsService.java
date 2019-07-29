package com.walla.rover.api.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.walla.rover.api.config.Obstacles;
import com.walla.rover.api.model.Bounds;
import com.walla.rover.api.model.RoverPosition;
import com.walla.rover.api.utils.Moves;

public class MarsService {

	private final Bounds bounds;
	private RoverPosition position;
	@Autowired
	private Obstacles obstacles;
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

				break;
			case Moves.FORWARD:

				break;
			case Moves.BACKWARD:

				break;

			default:
				break;
			}
		}

		return position;
	}

}
