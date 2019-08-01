package com.walla.rover.api.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.walla.rover.api.model.Bounds;
import com.walla.rover.api.model.RoverPosition;

@Configuration
public class AppConfig {
	
	
		
	@Bean
    public Bounds bounds(@Value("${mars.bounds.min-x}") int minX,
	                       @Value("${mars.bounds.max-x}") int maxX,
	                       @Value("${mars.bounds.min-y}") int minY,
	                       @Value("${mars.bounds.max-y}") int maxY) {
		
        return Bounds.of(minX, maxX, minY, maxY);
    }
	
	@Bean
    public RoverPosition roverPosition(@Value("${mars.initial-position.x}") int x,
	                       @Value("${mars.initial-position.y}") int y,
	                       @Value("${mars.initial-position.direction}") char facing) {
		
        return new RoverPosition(x, y, facing);
    }

}
