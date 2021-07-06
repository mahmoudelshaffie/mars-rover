package org.newstore.rover.commands;

import org.newstore.rover.Position;

public class MoveForward implements Command {
	
	@Override
	public Position move(Position current) {
		int latitudeDelta = current.getDirection().getForwardLatitudeDelta();
		int longtitudeDelta = current.getDirection().getForwardLongtitudeDelta();
		return current.add(latitudeDelta, longtitudeDelta);
	}
}
