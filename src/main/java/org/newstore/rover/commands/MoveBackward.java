package org.newstore.rover.commands;

import org.newstore.rover.Position;

public class MoveBackward implements Command {

	@Override
	public Position move(Position current) {
		int latitudeDelta = current.getDirection().getForwardLatitudeDelta() * -1;
		int longtitudeDelta = current.getDirection().getForwardLongtitudeDelta() * -1;
		return current.add(latitudeDelta, longtitudeDelta);
	}

}
