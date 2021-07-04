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
		int startIndexOfCoordinates = getCooardinatesStartIndex(input);
		int indexOfCoordinatesSeparator = getCooardinatesSeparatorIndex(input);
		int indexOfEndCoordinates = getIndexOfTheEndOfCoordinates(input);
		int latitude = parseLatitude(input, indexOfCoordinatesSeparator);
		int longtitude = parseLongtitude(input, indexOfCoordinatesSeparator, indexOfEndCoordinates);
		Direction direction = parseDirection(input, indexOfEndCoordinates);
		return new Position(latitude, longtitude, direction);
	}
	
	private int getCooardinatesStartIndex(String input) {
		final char startOfCoordinates = '(';
		int startIndexOfCoordinates = input.indexOf(startOfCoordinates);
		if (startIndexOfCoordinates == NOT_FOUND) {
			throw new InvalidPositionInputException(input, POSITION_FORMAT);
		}
		return startIndexOfCoordinates;
	}
	
	private int getCooardinatesSeparatorIndex(String input) {
		final char coordinatesSeparator = ',';
		int commaSepartorIndex = input.indexOf(coordinatesSeparator);
		if (commaSepartorIndex == NOT_FOUND) {
			throw new InvalidPositionInputException(input, POSITION_FORMAT);
		}
		return commaSepartorIndex;
	}
	
	private int getIndexOfTheEndOfCoordinates(String input) {
		final char endOfCoordinates = ')';
		return input.indexOf(endOfCoordinates);
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
