package com.walla.rover.api.service;

import java.util.Arrays;
import java.util.List;

import org.junit.Assert;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.Spy;
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
			
	@InjectMocks
	private MarsService marsService;
	
	@Mock
	private Bounds bounds;	
	
	@Mock
	private RoverPosition initialPosition;
	
	@Spy	
	private RoverService roverService;
		
	

    @Test
    public void moveLeftOneMoveFacingNorth_Test_Ok() {
    	List<Character> movestList = Arrays.asList(Moves.LEFT);
    	
    	Mockito.doReturn(10).when(bounds).getMaxX();
    	Mockito.doReturn(0).when(bounds).getMinX();
    	Mockito.doReturn(10).when(bounds).getMaxY();
    	Mockito.doReturn(0).when(bounds).getMinY();
    	    	
    	Mockito.doReturn(1).when(initialPosition).getX();
    	Mockito.doReturn(1).when(initialPosition).getY();

		Mockito.doReturn(new RoverPosition(10, 1, Facing.NORTH)).when(roverService).left(Mockito.any(), Mockito.any());
    	    	
        final RoverPosition finalPosition = marsService.move(movestList);

        Assert.assertEquals(new RoverPosition(10, 1, Facing.NORTH), finalPosition);
    }
    
    @Test
    public void moveLeftOneMoveFacingSouth_Test_Ok() {
    	List<Character> movestList = Arrays.asList(Moves.LEFT);
    	
    	Mockito.doReturn(10).when(bounds).getMaxX();
    	Mockito.doReturn(0).when(bounds).getMinX();
    	Mockito.doReturn(10).when(bounds).getMaxY();
    	Mockito.doReturn(0).when(bounds).getMinY();
    	    	
    	Mockito.doReturn(1).when(initialPosition).getX();
    	Mockito.doReturn(1).when(initialPosition).getY();

		Mockito.doReturn(new RoverPosition(10, 1, Facing.SOUTH)).when(roverService).left(Mockito.any(), Mockito.any());
    	    	
        final RoverPosition finalPosition = marsService.move(movestList);

        Assert.assertEquals(new RoverPosition(10, 1, Facing.SOUTH), finalPosition);
    }
    
    // TODO: TEst left in all facing cases, including with obstacles, and multiple moves
    
    @Test
    public void moveRightOneMoveTest() {
    	List<Character> movestList = Arrays.asList(Moves.RIGHT);
    	
    	Mockito.doReturn(10).when(bounds).getMaxX();
    	Mockito.doReturn(0).when(bounds).getMinX();
    	Mockito.doReturn(10).when(bounds).getMaxY();
    	Mockito.doReturn(0).when(bounds).getMinY();
    	    	
    	Mockito.doReturn(1).when(initialPosition).getX();
    	Mockito.doReturn(1).when(initialPosition).getY();

		Mockito.doReturn(new RoverPosition(2, 1, Facing.NORTH)).when(roverService).right(Mockito.any(), Mockito.any());
    	    	
        final RoverPosition finalPosition = marsService.move(movestList);

        Assert.assertEquals(new RoverPosition(2, 1, Facing.NORTH), finalPosition);
    }
    
    // TODO: TEst right in all facing cases, including with obstacles, and multiple moves
    
    // TODO: TEst fordward in all facing cases, including with obstacles, and multiple moves
    
    // TODO: TEst backward in all facing cases, including with obstacles, and multiple moves
    

}
