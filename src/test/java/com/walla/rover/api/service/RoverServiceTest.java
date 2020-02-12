package com.walla.rover.api.service;

import static com.walla.rover.api.utils.Facing.NORTH;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertNull;

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

		final RoverPosition finalPosition = roverService.left(new RoverPosition(1, 1, NORTH),
				Bounds.of(0, 10, 0, 10));

		assertEquals(new RoverPosition(10, 1, NORTH), finalPosition);
		assertNull(finalPosition.getObstacle());
	}

	@Test
	public void rightFacingNorth_Test_Ok() {

		final RoverPosition finalPosition = roverService.right(new RoverPosition(1, 1, NORTH),
				Bounds.of(0, 10, 0, 10));

		assertEquals(new RoverPosition(2, 1, NORTH), finalPosition);
		assertNull(finalPosition.getObstacle());
	}

	@Test
	public void backwardFacingNorth_Test_Ok() {

		final RoverPosition finalPosition = roverService.backward(new RoverPosition(1, 1, NORTH),
				Bounds.of(0, 10, 0, 10));

		assertEquals(new RoverPosition(1, 10, NORTH), finalPosition);
		assertNull(finalPosition.getObstacle());
	}

	@Test
	public void forwardFacingNorth_Test_Ok() {

		final RoverPosition finalPosition = roverService.forward(new RoverPosition(1, 1, NORTH),
				Bounds.of(0, 10, 0, 10));

		assertEquals(new RoverPosition(1, 2, NORTH), finalPosition);
		assertNull(finalPosition.getObstacle());
	}

	// TODO: more tests in all facing and moves cases, and with obstacles

}
