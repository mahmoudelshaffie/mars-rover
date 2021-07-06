package org.newstore.rover;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.newstore.rover.PositionAssertions.assertPositionCoordinatesAndDirection;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.newstore.rover.commands.Command;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class NewStoreRoverTest {
	
	@Mock
	private Command moveForwardMock;
	
	@Mock
	private Command moveBackwardMock;
	
	
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
	public void testMoveGivenMoveForwardFromInitialPositionShouldMoveForwardSuccessfully() {
		// Given
		int latitude = 0;
		int longtitude = 0;
		Position initialPosition = new Position(latitude, longtitude, Direction.NORTH);
		
		String command = "F";
		
		Position newPositionAfterMoveForward = new Position(12, 21, Direction.NORTH);
		when(moveForwardMock.move(any(Position.class))).thenReturn(newPositionAfterMoveForward);
		
		// Actual
		Position actual = target(initialPosition).move(command);
		
		assertPositionCoordinatesAndDirection(newPositionAfterMoveForward, actual);
	}
	
	@Test
	public void testMoveBackwardFromNorthIAfterInitializationPositionShouldLongtitudeDecreasedByOneSuccessfully() {
		// Given
		int latitude = 0;
		int longtitude = 0;
		Position initialPosition = new Position(latitude, longtitude, Direction.NORTH);
		
		Position newPositionAfterMoveForward = new Position(29, 123, Direction.SOUTH);
		when(moveBackwardMock.move(any(Position.class))).thenReturn(newPositionAfterMoveForward);
		
		String command = "B";
		
		// Actual
		Position actual = target(initialPosition).move(command);
		
		assertPositionCoordinatesAndDirection(newPositionAfterMoveForward, actual);
	}
	
	private NewStoreMarsRover target(Position initialPosition) {
		return new NewStoreMarsRover(initialPosition, moveForwardMock, moveBackwardMock);
	}
}
