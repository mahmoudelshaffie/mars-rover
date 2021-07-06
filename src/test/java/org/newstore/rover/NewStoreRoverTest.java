package org.newstore.rover;

import static org.newstore.rover.PositionAssertions.assertPositionCoordinatesAndDirection;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.newstore.rover.commands.Command;
import org.newstore.rover.commands.MoveBackward;
import org.newstore.rover.commands.MoveForward;

public class NewStoreRoverTest {
	
	private Command moveForward;
	private Command moveBackward;
	
	@BeforeEach
	public void beforeEach() {
		moveForward = new MoveForward();
		moveBackward = new MoveBackward();
	}
	
	@Test
	public void testMoveGivenBlankCommandWithoutAnyMovementRoverShouldSuccessfullStillInItsInitialPosition() {
		// Given
		int latitude = 0;
		int longtitude = 0;
		Position initialPosition = new Position(latitude, longtitude, Direction.NORTH);
		
		NewStoreMarsRover marsRover = new NewStoreMarsRover(initialPosition, moveForward, moveBackward);
		String blankCommand = "";
		
		// Actual
		Position actual = marsRover.move(blankCommand);
		
		// Expected
		int expectLatitudeNotChanged = 0;
		int expectLongtitudeNotChanged = 0;
		Direction expectDirectionNotChanged = Direction.NORTH;
		
		assertPositionCoordinatesAndDirection(expectLatitudeNotChanged, expectLongtitudeNotChanged, expectDirectionNotChanged, actual);
	}

	@Test
	public void testMoveGivenOnlyForwardToTheNorthFromInitialPositionShouldLongtitudeIncreasedByOneSuccessfully() {
		// Given
		int latitude = 0;
		int longtitude = 0;
		Position initialPosition = new Position(latitude, longtitude, Direction.NORTH);
		
		NewStoreMarsRover marsRover = new NewStoreMarsRover(initialPosition, moveForward, moveBackward);
		String command = "F";
		
		// Actual
		Position actual = marsRover.move(command);
		
		// Expected
		int expectLatitudeNotChanged = 0;
		int expectLongtitudedIncreasedByOne = 1;
		Direction expectDirectionNotChanged = Direction.NORTH;
		
		assertPositionCoordinatesAndDirection(expectLatitudeNotChanged, expectLongtitudedIncreasedByOne, expectDirectionNotChanged, actual);
	}
	
	@Test
	public void testMoveGivenOnlyForwardToTheSouthFromInitialPositionShouldLongtitudeDecreasedByOneSuccessfully() {
		// Given
		int latitude = 0;
		int longtitude = 0;
		Position initialPosition = new Position(latitude, longtitude, Direction.SOUTH);
		
		NewStoreMarsRover marsRover = new NewStoreMarsRover(initialPosition, moveForward, moveBackward);
		String command = "F";
		
		// Actual
		Position actual = marsRover.move(command);
		
		// Expected
		int expectLatitudeNotChanged = 0;
		int expectLongtitudedDecreasedByOne = -1;
		Direction expectDirectionNotChanged = Direction.SOUTH;
		
		assertPositionCoordinatesAndDirection(expectLatitudeNotChanged, expectLongtitudedDecreasedByOne, expectDirectionNotChanged, actual);
	}
	
	@Test
	public void testMoveGivenOnlyForwardToEastFromInitialPositionShouldLatitudeIncreasedByOneSuccessfully() {
		// Given
		int latitude = 0;
		int longtitude = 0;
		Position initialPosition = new Position(latitude, longtitude, Direction.EAST);
		
		NewStoreMarsRover marsRover = new NewStoreMarsRover(initialPosition, moveForward, moveBackward);
		String command = "F";
		
		// Actual
		Position actual = marsRover.move(command);
		
		// Expected
		int expectLatitudeIncreaseByOne = 1;
		int expectLongtitudedNotChanged = 0;
		Direction expectDirectionNotChanged = Direction.EAST;
		
		assertPositionCoordinatesAndDirection(expectLatitudeIncreaseByOne, expectLongtitudedNotChanged, expectDirectionNotChanged, actual);
	}
	
	@Test
	public void testMoveGivenOnlyForwardToWestFromInitialPositionShouldLatitudedDecreasedByOneSuccessfully() {
		// Given
		int latitude = 0;
		int longtitude = 0;
		Position initialPosition = new Position(latitude, longtitude, Direction.WEST);
		
		NewStoreMarsRover marsRover = new NewStoreMarsRover(initialPosition, moveForward, moveBackward);
		String command = "F";
		
		// Actual
		Position actual = marsRover.move(command);
		
		// Expected
		int expectLatitudeDecreaseByOne = -1;
		int expectLongtitudedNotChanged = 0;
		Direction expectDirectionNotChanged = Direction.WEST;
		
		assertPositionCoordinatesAndDirection(expectLatitudeDecreaseByOne, expectLongtitudedNotChanged, expectDirectionNotChanged, actual);
	}
	
	@Test
	public void testMoveBackwardFromNorthIAfterInitializationPositionShouldLongtitudeDecreasedByOneSuccessfully() {
		// Given
		int latitude = 0;
		int longtitude = 0;
		Position initialPosition = new Position(latitude, longtitude, Direction.NORTH);
		
		NewStoreMarsRover marsRover = new NewStoreMarsRover(initialPosition, moveForward, moveBackward);
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
		
		NewStoreMarsRover marsRover = new NewStoreMarsRover(initialPosition, moveForward, moveBackward);
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
		
		NewStoreMarsRover marsRover = new NewStoreMarsRover(initialPosition, moveForward, moveBackward);
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
		
		NewStoreMarsRover marsRover = new NewStoreMarsRover(initialPosition, moveForward, moveBackward);
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
