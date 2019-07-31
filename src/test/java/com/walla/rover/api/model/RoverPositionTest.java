package com.walla.rover.api.model;

import org.junit.Assert;
import org.junit.Test;

import com.walla.rover.api.utils.Facing;


public class RoverPositionTest {
	
	@Test
    public void shouldCreatePosition() {
        final RoverPosition position = new RoverPosition(5, 10, Facing.WEST);
        
        Assert.assertEquals(Facing.WEST, position.getFacing());
        Assert.assertEquals(5, position.getX());
        Assert.assertEquals(10, position.getY());        
    }

    @Test
    public void createPositionToString() {
        final RoverPosition position = new RoverPosition(0, 6, Facing.NORTH);
        Assert.assertEquals("(0,6,N)", position.toString());
    }

    @Test
    public void shouldEquals() {
        final RoverPosition position1 = new RoverPosition(0, 0, Facing.NORTH);
        final RoverPosition position2 = new RoverPosition(0, 0, Facing.NORTH);

        Assert.assertEquals(position1, position2);
        Assert.assertEquals(position1.hashCode(), position2.hashCode());
    }

    // TODO: Not equal
}
