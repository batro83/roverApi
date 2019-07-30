package com.walla.rover.api.service;

import java.util.Arrays;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.runners.MethodSorters;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.junit.Assert;
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
		
	@Spy
	@InjectMocks
	private RoverService roverService;
	
	private final Bounds bounds = Bounds.of(0, 5, 0, 5);

    @Test
    public void leftOneMoveTest() {
    	List<Character> movestList = Arrays.asList(Moves.LEFT);
        final RoverPosition initialPosition = new RoverPosition(1, 1, Facing.NORTH);
        final RoverPosition finalPosition = new MarsService(bounds, initialPosition).move(movestList);

        Assert.assertEquals(new RoverPosition(2, 1, Facing.NORTH), finalPosition);
    }
    
    @Test
    public void leftOneMoveBoundsTest() {
    	List<Character> movestList = Arrays.asList(Moves.LEFT);
        final RoverPosition initialPosition = new RoverPosition(5, 1, Facing.NORTH);
        final RoverPosition finalPosition = new MarsService(bounds, initialPosition).move(movestList);

        Assert.assertEquals(new RoverPosition(1, 1, Facing.NORTH), finalPosition);
    }

}
