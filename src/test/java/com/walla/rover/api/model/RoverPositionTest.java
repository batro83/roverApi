package com.walla.rover.api.model;

import static com.walla.rover.api.utils.Facing.NORTH;
import static com.walla.rover.api.utils.Facing.WEST;
import static org.junit.Assert.assertEquals;

import org.junit.Test;

public class RoverPositionTest {

	@Test
	public void shouldCreatePosition() {
		final RoverPosition position = new RoverPosition(5, 10, WEST);

		assertEquals(WEST, position.getFacing());
		assertEquals(5, position.getX());
		assertEquals(10, position.getY());
	}

	@Test
	public void createPositionToString() {
		final RoverPosition position = new RoverPosition(0, 6, NORTH);
		assertEquals("(0,6,N)", position.toString());
	}

	@Test
	public void shouldEquals() {
		final RoverPosition position1 = new RoverPosition(0, 0, NORTH);
		final RoverPosition position2 = new RoverPosition(0, 0, NORTH);

		assertEquals(position1, position2);
		assertEquals(position1.hashCode(), position2.hashCode());
	}

	// TODO: Not equal
}
