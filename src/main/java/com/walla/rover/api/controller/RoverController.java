package com.walla.rover.api.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.walla.rover.api.config.ObstaclesConfig;


@RestController
@RequestMapping("/mars")
public class RoverController {
	
	@Autowired
	private ObstaclesConfig obstaclesConfig;
	
		
	@PostMapping(path = "/{command}")
    public ResponseEntity<String> move(@PathVariable("command") String command) {
		System.out.println(obstaclesConfig.getList().toString());
        return ResponseEntity.ok(command);
    }

}
