package com.walla.rover.api.service;

import java.util.Arrays;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.walla.rover.api.model.Bounds;
import com.walla.rover.api.model.RoverPosition;
import com.walla.rover.api.utils.Facing;
import com.walla.rover.api.utils.Moves;

@RunWith(SpringJUnit4ClassRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest
public class MarsServiceTest {
		
	@Autowired
	private RoverPosition initialPosition ;
	
	@Autowired
	private RoverService roverService;
	
	@Autowired
	private Bounds bounds;	
	
	private MarsService marsService;
	
	@Before
	public void setUp() {
		initialPosition = new RoverPosition(2, 2, Facing.SOUTH);
		bounds = new Bounds(0, 10, 0, 10);
		marsService = new MarsService(bounds, initialPosition);
	}
	
	

    @Test
    public void leftOneMoveTest() {
    	List<Character> movestList = Arrays.asList(Moves.LEFT);
    	    	
        final RoverPosition finalPosition = marsService.move(movestList);

        Assert.assertEquals(new RoverPosition(5, 1, Facing.NORTH), finalPosition);
    }
    

}
