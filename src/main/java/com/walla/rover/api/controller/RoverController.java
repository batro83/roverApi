package com.walla.rover.api.controller;

import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.log;

import java.util.List;
import java.util.stream.Collectors;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.walla.rover.api.model.RoverPosition;
import com.walla.rover.api.service.MarsService;




@RestController
@RequestMapping("/mars")
public class RoverController {
	
	private static final Logger logger = LogManager.getLogger(RoverController.class);
	
	@Autowired
	private MarsService marsService; 
		
	@PostMapping(path = "/{command}")
    public ResponseEntity<String> move(@PathVariable("command") String command) {
		
		final List<Character> move = command.chars()
			      .mapToObj(item -> (char) item)
			      .collect(Collectors.toList());
		logger.info("Moves list: {}", move.toString());
		RoverPosition roverposition = marsService.move(move);
        return ResponseEntity.ok(String.valueOf(roverposition));
    }

}
