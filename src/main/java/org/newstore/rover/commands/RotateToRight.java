package org.newstore.rover.commands;

import org.newstore.rover.Position;

public class RotateToRight implements Command {

	private Character commandInput = 'R';

	@Override
	public Position move(Position current) {
		throw new UnsupportedOperationException();
	}

	@Override
	public Character getCommandInput() {
		return commandInput;
	}

}
