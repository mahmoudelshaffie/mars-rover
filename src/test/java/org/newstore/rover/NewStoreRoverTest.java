package org.newstore.rover;

import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.newstore.rover.PositionAssertions.assertPositionCoordinatesAndDirection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.junit.platform.runner.JUnitPlatform;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.newstore.rover.commands.Command;
import org.newstore.rover.commands.MoveBackward;

@ExtendWith(MockitoExtension.class)
@RunWith(JUnitPlatform.class)
public class NewStoreRoverTest {
	
	@Mock
	private Command moveForwardMock;
	private Command moveBackward;
	
	@BeforeEach
	public void beforeEach() {
		moveBackward = new MoveBackward();
	}
	
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
		
		NewStoreMarsRover marsRover = new NewStoreMarsRover(initialPosition, moveForwardMock, moveBackward);
		
		String command = "F";
		
		Position newPositionAfterMoveForward = new Position(12, 21, Direction.NORTH);
		when(moveForwardMock.move(any(Position.class))).thenReturn(newPositionAfterMoveForward);
		
		// Actual
		Position actual = marsRover.move(command);
		
		assertPositionCoordinatesAndDirection(newPositionAfterMoveForward, actual);
	}
	
	private NewStoreMarsRover target(Position initialPosition) {
		return new NewStoreMarsRover(initialPosition, moveForwardMock, moveBackward);
	}
	
	@Test
	public void testMoveBackwardFromNorthIAfterInitializationPositionShouldLongtitudeDecreasedByOneSuccessfully() {
		// Given
		int latitude = 0;
		int longtitude = 0;
		Position initialPosition = new Position(latitude, longtitude, Direction.NORTH);
		
		NewStoreMarsRover marsRover = new NewStoreMarsRover(initialPosition, moveForwardMock, moveBackward);
		String command = "B";
		
		// Actual
		Position actual = marsRover.move(command);
		
		// Expected
		int expectLatitudeNotChanged = 0;
		int expectLongtitudedDecreasedByOne = -1;
		Direction expectDirectionNotChanged = Direction.NORTH;
		
		assertPositionCoordinatesAndDirection(expectLatitudeNotChanged, expectLongtitudedDecreasedByOne, expectDirectionNotChanged, actual);
	}
	
	@Test
	public void testMoveBackwardInSouthDirectionAfterInitializationPositionShouldLongtitudeIncreasedByOneSuccessfully() {
		// Given
		int latitude = 0;
		int longtitude = 0;
		Position initialPosition = new Position(latitude, longtitude, Direction.SOUTH);
		
		NewStoreMarsRover marsRover = new NewStoreMarsRover(initialPosition, moveForwardMock, moveBackward);
		String command = "B";
		
		// Actual
		Position actual = marsRover.move(command);
		
		// Expected
		int expectLatitudeNotChanged = 0;
		int expectLongtitudedIncreasedByOne = 1;
		Direction expectDirectionNotChanged = Direction.SOUTH;
		
		assertPositionCoordinatesAndDirection(expectLatitudeNotChanged, expectLongtitudedIncreasedByOne, expectDirectionNotChanged, actual);
	}
	
	@Test
	public void testMoveBackwardInEastDirectionAfterInitializationPositionShouldLatitudeDecreasedByOneSuccessfully() {
		// Given
		int latitude = 0;
		int longtitude = 0;
		Position initialPosition = new Position(latitude, longtitude, Direction.EAST);
		
		NewStoreMarsRover marsRover = new NewStoreMarsRover(initialPosition, moveForwardMock, moveBackward);
		String command = "B";
		
		// Actual
		Position actual = marsRover.move(command);
		
		// Expected
		int expectLatitudeDecreasedByOne = -1;
		int expectLongtitudedNotChanged = 0;
		Direction expectDirectionNotChanged = Direction.EAST;
		
		assertPositionCoordinatesAndDirection(expectLatitudeDecreasedByOne, expectLongtitudedNotChanged, expectDirectionNotChanged, actual);
	}
	
	@Test
	public void testMoveBackwardInWestDirectionAfterInitializationPositionShouldLatitudeIncreasedByOneSuccessfully() {
		// Given
		int latitude = 0;
		int longtitude = 0;
		Position initialPosition = new Position(latitude, longtitude, Direction.WEST);
		
		NewStoreMarsRover marsRover = new NewStoreMarsRover(initialPosition, moveForwardMock, moveBackward);
		String command = "B";
		
		// Actual
		Position actual = marsRover.move(command);
		
		// Expected
		int expectLatitudeIncreasedByOne = 1;
		int expectLongtitudedNotChanged = 0;
		Direction expectDirectionNotChanged = Direction.WEST;
		
		assertPositionCoordinatesAndDirection(expectLatitudeIncreasedByOne, expectLongtitudedNotChanged, expectDirectionNotChanged, actual);
	}
}
