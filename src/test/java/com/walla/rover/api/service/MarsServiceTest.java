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
		
//	@Spy
//	private RoverPosition initialPosition ;
//	
	
		
	
	@InjectMocks
	private MarsService marsService;
	
	@Mock
	private Bounds bounds;	
	
	@Mock
	private RoverPosition initialPosition;
	
	@Mock	
	private RoverService roverService;
		
	

    @Test
    public void leftOneMoveTest() {
    	List<Character> movestList = Arrays.asList(Moves.LEFT);
    	
    	Mockito.doReturn(Bounds.of(0, 10, 0, 10)).when(bounds);
    	Mockito.doReturn(0).when(bounds).getMinX();
    	Mockito.doReturn(10).when(bounds).getMaxY();
    	Mockito.doReturn(0).when(bounds).getMinY();
    	
    	
    	Mockito.doReturn(1).when(initialPosition).getX();
    	Mockito.doReturn(1).when(initialPosition).getY();
    	
    	Mockito.doReturn(new RoverPosition(10, 1, Facing.NORTH)).when(roverService).left(new RoverPosition(1, 1, Facing.NORTH),  Bounds.of(0, 10, 0, 10));
    	
        final RoverPosition finalPosition = marsService.move(movestList);

        Assert.assertEquals(new RoverPosition(10, 1, Facing.NORTH), finalPosition);
    }
    

}
