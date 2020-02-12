package com.walla.rover.api.service;

import static com.walla.rover.api.utils.Facing.NORTH;
import static com.walla.rover.api.utils.Facing.SOUTH;
import static com.walla.rover.api.utils.Moves.LEFT;
import static com.walla.rover.api.utils.Moves.RIGHT;
import static org.junit.Assert.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.doReturn;

import java.util.Arrays;
import java.util.List;

import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.MethodSorters;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Spy;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import com.walla.rover.api.model.Bounds;
import com.walla.rover.api.model.RoverPosition;

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
		List<Character> movestList = Arrays.asList(LEFT);

		doReturn(10).when(bounds).getMaxX();
		doReturn(0).when(bounds).getMinX();
		doReturn(10).when(bounds).getMaxY();
		doReturn(0).when(bounds).getMinY();

		doReturn(1).when(initialPosition).getX();
		doReturn(1).when(initialPosition).getY();

		doReturn(new RoverPosition(10, 1, NORTH)).when(roverService).left(any(), any());

		final RoverPosition finalPosition = marsService.move(movestList);

		assertEquals(new RoverPosition(10, 1, NORTH), finalPosition);
	}

	@Test
	public void moveLeftOneMoveFacingSouth_Test_Ok() {
		List<Character> movestList = Arrays.asList(LEFT);

		doReturn(10).when(bounds).getMaxX();
		doReturn(0).when(bounds).getMinX();
		doReturn(10).when(bounds).getMaxY();
		doReturn(0).when(bounds).getMinY();

		doReturn(1).when(initialPosition).getX();
		doReturn(1).when(initialPosition).getY();

		doReturn(new RoverPosition(10, 1, SOUTH)).when(roverService).left(any(), any());

		final RoverPosition finalPosition = marsService.move(movestList);

		assertEquals(new RoverPosition(10, 1, SOUTH), finalPosition);
	}

	// TODO: TEst left in all facing cases, including with obstacles, and multiple
	// moves

	@Test
	public void moveRightOneMoveTest() {
		List<Character> movestList = Arrays.asList(RIGHT);

		doReturn(10).when(bounds).getMaxX();
		doReturn(0).when(bounds).getMinX();
		doReturn(10).when(bounds).getMaxY();
		doReturn(0).when(bounds).getMinY();

		doReturn(1).when(initialPosition).getX();
		doReturn(1).when(initialPosition).getY();

		doReturn(new RoverPosition(2, 1, NORTH)).when(roverService).right(any(), any());

		final RoverPosition finalPosition = marsService.move(movestList);

		assertEquals(new RoverPosition(2, 1, NORTH), finalPosition);
	}

	// TODO: TEst right in all facing cases, including with obstacles, and multiple
	// moves

	// TODO: TEst fordward in all facing cases, including with obstacles, and
	// multiple moves

	// TODO: TEst backward in all facing cases, including with obstacles, and
	// multiple moves

}
