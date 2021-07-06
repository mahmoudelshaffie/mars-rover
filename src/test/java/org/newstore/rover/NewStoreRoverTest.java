package org.newstore.rover;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;
import static org.newstore.rover.PositionAssertions.assertPositionCoordinatesAndDirection;

import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.newstore.rover.commands.Command;
import org.newstore.rover.commands.CommandRegistery;
import org.newstore.rover.commands.exceptions.InvalidCommandException;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class NewStoreRoverTest {
	
	private Character MOVE_FORWARD = 'F';
	private Character MOVE_BACKWARD = 'B'; 
	
	private int latitude = 0;
	private int longtitude = 0;
	private Position initialPosition = new Position(latitude, longtitude, Direction.NORTH);
	
	private Position newPositionAfterMoveForward = new Position(12, 21, Direction.NORTH);
	private Position newPositionAfterMoveForward_2 = new Position(12, 22, Direction.NORTH);
	private Position newPositionAfterMoveBackward = new Position(14, 15, Direction.NORTH);
	private Position newPositionAfterMoveBackward_2 = new Position(14, 14, Direction.NORTH);
	
	@Mock
	private Command moveForwardMock;
	
	@Mock
	private Command moveBackwardMock;
	
	@Mock
	private CommandRegistery commandRegisteryMock;

	@Test
	public void testMoveGivenBlankCommandWithoutAnyMovementRoverShouldSuccessfullStillInItsInitialPosition() {
		// Given
		String blankCommand = "";
		
		// Actual
		Position actual = target(initialPosition).move(blankCommand);
		
		// Expected
		assertPositionCoordinatesAndDirection(initialPosition, actual);
	}

	@Test
	public void testMoveGivenRegisteredForwardCommandShouldBeExecutedSuccessfullyAndRoverMoveToNewPosition() {
		// Given
		String command = "F";
		
		doReturn(Optional.of(moveForwardMock)).when(commandRegisteryMock).getCommand(eq(MOVE_FORWARD));
		when(moveForwardMock.move(any(Position.class))).thenReturn(newPositionAfterMoveForward);
		
		// Actual
		Position actual = target(initialPosition).move(command);
		
		//Expected
		assertPositionCoordinatesAndDirection(newPositionAfterMoveForward, actual);
	}
	
	@Test
	public void testMoveGivenRegisteredBackwardCommandShouldBeExecutedSuccessfullyAndRoverMoveToNewPosition() {
		// Given
		String command = "B";

		doReturn(Optional.of(moveBackwardMock)).when(commandRegisteryMock).getCommand(eq(MOVE_BACKWARD));
		when(moveBackwardMock.move(any(Position.class))).thenReturn(newPositionAfterMoveBackward);
		
		// Actual
		Position actual = target(initialPosition).move(command);
		
		//
		assertPositionCoordinatesAndDirection(newPositionAfterMoveBackward, actual);
	}
	
	@Test
	public void testMoveCommandOfMultipleRegisteredCommandsAllMovesShouldBeDoneAndRoverStoppedAtLastMovePosition() {
		// Given
		String command = "FBBF";
		
		doReturn(Optional.of(moveForwardMock)).when(commandRegisteryMock).getCommand(eq(MOVE_FORWARD));
		doReturn(Optional.of(moveBackwardMock)).when(commandRegisteryMock).getCommand(eq(MOVE_BACKWARD));
		
		when(moveForwardMock.move(any(Position.class))).thenReturn(newPositionAfterMoveForward, newPositionAfterMoveForward_2);
		when(moveBackwardMock.move(any(Position.class))).thenReturn(newPositionAfterMoveBackward, newPositionAfterMoveBackward_2);
		
		// Actual
		Position actual = target(initialPosition).move(command);
		
		//Expected
		Position lastMovePosition = newPositionAfterMoveForward_2;
		assertPositionCoordinatesAndDirection(lastMovePosition, actual);
		
		// Verfiying Sequence Of Calls
		verify(moveForwardMock, times(1)).move(eq(initialPosition));
		verify(moveBackwardMock, times(1)).move(eq(newPositionAfterMoveForward));
		verify(moveBackwardMock, times(1)).move(eq(newPositionAfterMoveBackward));
		verify(moveForwardMock, times(1)).move(eq(newPositionAfterMoveBackward_2));
	}
	
	@Test
	public void testMoveCommandOfMultipleRegisteredCommandsGiveObstacleOnThirdMoveShouldRoverStoppedAtSeconedMovePosition() {
		// Given
		String command = "FBBF";
		
		doReturn(Optional.of(moveForwardMock)).when(commandRegisteryMock).getCommand(eq(MOVE_FORWARD));
		doReturn(Optional.of(moveBackwardMock)).when(commandRegisteryMock).getCommand(eq(MOVE_BACKWARD));
		
		when(moveForwardMock.move(any(Position.class))).thenReturn(newPositionAfterMoveForward, newPositionAfterMoveForward_2);
		when(moveBackwardMock.move(any(Position.class))).thenReturn(newPositionAfterMoveBackward, newPositionAfterMoveBackward_2);
		
		Position expectedThirdPosition = newPositionAfterMoveBackward_2;
		Map<Integer, Integer> obstacles = new HashMap<>();
		obstacles.put(expectedThirdPosition.getLatitude(), expectedThirdPosition.getLongtitude());
		
		// Actual
		Position actual = target(initialPosition, obstacles).move(command);
		
		//Expected
		Position seconedMovePosition = newPositionAfterMoveBackward;
		assertPositionCoordinatesAndDirection(seconedMovePosition, actual);
		assertTrue("Expect robot to be stopped due to obstacle", actual.isStopped());
		
		// Verfiying Sequence Of Calls
		verify(moveForwardMock, times(1)).move(eq(initialPosition));
		verify(moveBackwardMock, times(1)).move(eq(newPositionAfterMoveForward));
		verify(moveBackwardMock, times(1)).move(eq(newPositionAfterMoveBackward));
	}
	
	@Test
	public void testMoveGivenUnRegisteredCommandShouldFailWithInvalidCommandException() {
		// Given
		String unRegisteredCommand = "!";
		
		assertThrows(InvalidCommandException.class, () ->  target(initialPosition).move(unRegisteredCommand));
	}
	
	private NewStoreMarsRover target(Position initialPosition) {
		Map<Integer, Integer> noObstacles = new HashMap<>();
		return target(initialPosition, noObstacles);
	}
	
	private NewStoreMarsRover target(Position initialPosition, Map<Integer, Integer> obstacles) {
		return new NewStoreMarsRover(initialPosition, commandRegisteryMock, obstacles);
	}
}
