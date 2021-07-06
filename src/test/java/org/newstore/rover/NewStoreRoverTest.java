package org.newstore.rover;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.eq;
import static org.mockito.Mockito.doReturn;
import static org.mockito.Mockito.when;
import static org.newstore.rover.PositionAssertions.assertPositionCoordinatesAndDirection;

import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.newstore.rover.commands.Command;
import org.newstore.rover.commands.CommandRegistery;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class NewStoreRoverTest {
	
	private Character MOVE_FORWARD = 'F';
	private Character MOVE_BACKWARD = 'B'; 
	
	@Mock
	private Command moveForwardMock;
	
	@Mock
	private Command moveBackwardMock;
	
	@Mock
	private CommandRegistery commandRegisteryMock;

	@Test
	public void testMoveGivenBlankCommandWithoutAnyMovementRoverShouldSuccessfullStillInItsInitialPosition() {
		// Given
		int latitude = 0;
		int longtitude = 0;
		Position initialPosition = new Position(latitude, longtitude, Direction.NORTH);
		String blankCommand = "";
		
		// Actual
		Position actual = target(initialPosition).move(blankCommand);
		
		// Expected
		int expectLatitudeNotChanged = 0;
		int expectLongtitudeNotChanged = 0;
		Direction expectDirectionNotChanged = Direction.NORTH;
		
		assertPositionCoordinatesAndDirection(expectLatitudeNotChanged, expectLongtitudeNotChanged, expectDirectionNotChanged, actual);
	}

	@Test
	public void testMoveGivenRegisteredForwardCommandShouldBeExecutedSuccessfullyAndRoverMoveToNewPosition() {
		// Given
		int latitude = 0;
		int longtitude = 0;
		Position initialPosition = new Position(latitude, longtitude, Direction.NORTH);
		
		String command = "F";
		
		doReturn(Optional.of(moveForwardMock)).when(commandRegisteryMock).getCommand(eq(MOVE_FORWARD));
		Position newPositionAfterMoveForward = new Position(12, 21, Direction.NORTH);
		when(moveForwardMock.move(any(Position.class))).thenReturn(newPositionAfterMoveForward);
		
		// Actual
		Position actual = target(initialPosition).move(command);
		
		assertPositionCoordinatesAndDirection(newPositionAfterMoveForward, actual);
	}
	
	@Test
	public void testMoveGivenRegisteredBackwardCommandShouldBeExecutedSuccessfullyAndRoverMoveToNewPosition() {
		// Given
		int latitude = 0;
		int longtitude = 0;
		Position initialPosition = new Position(latitude, longtitude, Direction.NORTH);
		
		doReturn(Optional.of(moveBackwardMock)).when(commandRegisteryMock).getCommand(eq(MOVE_BACKWARD));
		Position newPositionAfterMoveForward = new Position(29, 123, Direction.SOUTH);
		when(moveBackwardMock.move(any(Position.class))).thenReturn(newPositionAfterMoveForward);
		
		String command = "B";
		
		// Actual
		Position actual = target(initialPosition).move(command);
		
		assertPositionCoordinatesAndDirection(newPositionAfterMoveForward, actual);
	}
	
	private NewStoreMarsRover target(Position initialPosition) {
		return new NewStoreMarsRover(initialPosition, commandRegisteryMock);
	}
}
