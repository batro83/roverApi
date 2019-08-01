package com.walla.rover.api.service;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.walla.rover.api.config.Obstacles;
import com.walla.rover.api.model.Bounds;
import com.walla.rover.api.model.RoverPosition;
import com.walla.rover.api.utils.Facing;

@RunWith(SpringJUnit4ClassRunner.class)
@FixMethodOrder(MethodSorters.NAME_ASCENDING)
@SpringBootTest
public class RoverServiceTest {
	
	@InjectMocks
	private RoverService roverService;
	
	@Mock
	private Obstacles obstacles;
	
	
	@Test
    public void leftFacingNorth_Test_Ok() {
    	    	
        final RoverPosition finalPosition = roverService.left(new RoverPosition(1, 1, Facing.NORTH), Bounds.of(0, 10, 0, 10));

        Assert.assertEquals(new RoverPosition(10, 1, Facing.NORTH), finalPosition);
        Assert.assertNull(finalPosition.getObstacle());
    }
		
	
	@Test
    public void rightFacingNorth_Test_Ok() {
    	    	
        final RoverPosition finalPosition = roverService.right(new RoverPosition(1, 1, Facing.NORTH), Bounds.of(0, 10, 0, 10));

        Assert.assertEquals(new RoverPosition(2, 1, Facing.NORTH), finalPosition);
        Assert.assertNull(finalPosition.getObstacle());
    }
	
	@Test
    public void backwardFacingNorth_Test_Ok() {
    	    	
        final RoverPosition finalPosition = roverService.backward(new RoverPosition(1, 1, Facing.NORTH), Bounds.of(0, 10, 0, 10));

        Assert.assertEquals(new RoverPosition(1, 10, Facing.NORTH), finalPosition);
        Assert.assertNull(finalPosition.getObstacle());
    }
	
	@Test
    public void forwardFacingNorth_Test_Ok() {
    	    	
        final RoverPosition finalPosition = roverService.forward(new RoverPosition(1, 1, Facing.NORTH), Bounds.of(0, 10, 0, 10));

        Assert.assertEquals(new RoverPosition(1, 2, Facing.NORTH), finalPosition);
        Assert.assertNull(finalPosition.getObstacle());
    }
	
	
	// TODO: more tests in all facing and moves cases, and with obstacles 

}
