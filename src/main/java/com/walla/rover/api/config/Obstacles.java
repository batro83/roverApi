package com.walla.rover.api.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

import com.walla.rover.api.model.Obstacle;

@Component
@ConfigurationProperties(prefix = "mars.obstacles")
@EnableConfigurationProperties
public class Obstacles {

	private final List<Obstacle> list = new ArrayList<>();
	 
	public Obstacles() {
    }

	public List<Obstacle> getList() {
		return list;
	}

 
}
