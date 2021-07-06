package org.newstore.rover.commands;

import org.newstore.rover.Position;

public interface Command {
	Position move(Position current);
}
