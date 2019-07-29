package com.walla.rover.api.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.walla.rover.api.model.Bounds;
import com.walla.rover.api.model.RoverPosition;
import com.walla.rover.api.service.MarsService;

@Configuration
public class AppConfig {
	
	
	@Bean
    public MarsService marsService(@Value("${mars.bounds.min-x}") int minX,
	                       @Value("${mars.bounds.max-x}") int maxX,
	                       @Value("${mars.bounds.min-y}") int minY,
	                       @Value("${mars.bounds.max-y}") int maxY,
	                       @Value("${mars.initial-position.x}") int x,
	                       @Value("${mars.initial-position.y}") int y,
	                       @Value("${mars.initial-position.direction}") char facing) {
		
        return new MarsService( Bounds.of(minX, maxX, minY, maxY), new RoverPosition(x, y, facing));
    }

}
