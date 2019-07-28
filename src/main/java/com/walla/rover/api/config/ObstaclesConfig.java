package com.walla.rover.api.config;

import java.util.ArrayList;
import java.util.List;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Configuration
@ConfigurationProperties(prefix = "mars.obstacles")
public class ObstaclesConfig {

	private List<String> list;
	 
	ObstaclesConfig() {
        this.list = new ArrayList<>();
    }
 
    public List<String> getList() {
        return this.list;
    }
}
