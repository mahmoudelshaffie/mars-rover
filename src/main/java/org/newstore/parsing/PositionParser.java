package org.newstore.parsing;

import org.newstore.parsing.exceptions.InvalidPositionInputException;
import org.newstore.rover.Direction;
import org.newstore.rover.Position;

public class PositionParser implements InputParser<Position> {
	
	private final String POSITION_FORMAT = "(-108, 90) NORTH";
	private final int NOT_FOUND = -1;
	
	public Position parse(String input) {
		Position parsedPosition;
		input = input.trim();
		if (input.isBlank()) {
			parsedPosition = new Position();
		} else {
			parsedPosition = parseToPosition(input);
		}
		return parsedPosition;
	}
	
	private Position parseToPosition(String input) {
		int startOfCoordinates = getCooardinatesStartIndex(input);
		int coordinatesSeparatorIndex = getCooardinatesSeparatorIndex(input, startOfCoordinates);
		int endOfCoordinates = getIndexOfTheEndOfCoordinates(input, coordinatesSeparatorIndex);
		try {
			int latitude = parseLatitude(input, coordinatesSeparatorIndex);
			int longtitude = parseLongtitude(input, coordinatesSeparatorIndex, endOfCoordinates);
			Direction direction = parseDirection(input, endOfCoordinates);
			return new Position(latitude, longtitude, direction);
		} catch (Exception cause) {
			throw new InvalidPositionInputException(input, POSITION_FORMAT, cause);
		}
	}
	
	private int getCooardinatesStartIndex(String input) {
		final char startOfCoordinates = '(';
		int fromTheBegining = 0;
		return findIndexOf(input, startOfCoordinates, fromTheBegining);
	}
	
	private int getCooardinatesSeparatorIndex(String input, int startOfCoordinates) {
		final char coordinatesSeparator = ',';
		return findIndexOf(input, coordinatesSeparator, startOfCoordinates);
	}
	
	private int getIndexOfTheEndOfCoordinates(String input, int coordinatesSeparatorIndex) {
		final char endOfCoordinates = ')';
		return findIndexOf(input, endOfCoordinates, coordinatesSeparatorIndex);
	}
	
	private int findIndexOf(String input, char separtor, int fromIndex) {
		int index = input.indexOf(separtor, fromIndex);
		if (index == NOT_FOUND) {
			throw new InvalidPositionInputException(input, POSITION_FORMAT);
		}
		return index;
	}
	
	private int parseLatitude(String input, int indexOfCoordinatesSeparator) {
		int latitudeStartsAt = 1;
		int latitudeEndsAt = indexOfCoordinatesSeparator;
		return parseInt(input, latitudeStartsAt, latitudeEndsAt);
	}
	
	private int parseLongtitude(String input, int indexOfCoordinatesSeparator, int indexOfEndCoordinates) {
		int longtitudeStartsAt = indexOfCoordinatesSeparator + 1;
		int longtitudesEndsAt = indexOfEndCoordinates;
		return parseInt(input, longtitudeStartsAt, longtitudesEndsAt);
	}
	
	private int parseInt(String input, int startsAt, int endsAt) {
		String integerStr = input.substring(startsAt, endsAt);
		integerStr = integerStr.trim();
		return Integer.parseInt(integerStr);
	}
	
	private Direction parseDirection(String input, int indexOfEndCoordinates) {
		int directionStartsAt = indexOfEndCoordinates + 1;
		int directionEndsAt = input.length();
		String direction = input.substring(directionStartsAt, directionEndsAt);
		direction = direction.trim();
		return Direction.valueOf(direction);
	}
}
