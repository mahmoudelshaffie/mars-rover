package org.newstore.rover.commands;

import org.newstore.rover.Position;

public interface Command {
	/**
	 * Move from current position
	 * @param current position should move from
	 * @return new position should move to
	 */
	Position move(Position current);

	/**
	 * @return Input for the command 4ex 'F' for move forward, 'B' for move backward
	 */
	Character getCommandInput();
}
