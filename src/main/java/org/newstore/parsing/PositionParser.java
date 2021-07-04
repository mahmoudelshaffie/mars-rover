package org.newstore.parsing;

import org.newstore.rover.Position;

public class PositionParser implements InputParser<Position> {

	public Position parse(String position) {
		Position parsedPosition = null;
		position = position.trim();
		if (position.isBlank()) {
			parsedPosition = new Position();
		}
		return parsedPosition;
	}
}
