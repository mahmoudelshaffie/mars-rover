package org.newstore;

import java.util.HashMap;
import java.util.Map;

import org.newstore.parsing.PositionParser;
import org.newstore.rover.NewStoreMarsRover;
import org.newstore.rover.Position;
import org.newstore.rover.Rover;
import org.newstore.rover.commands.Command;
import org.newstore.rover.commands.CommandRegistery;
import org.newstore.rover.commands.MoveBackward;
import org.newstore.rover.commands.MoveForward;
import org.newstore.rover.commands.RotateToLeft;
import org.newstore.rover.commands.RotateToRight;

public class MarsRoverMain {

	private static int START_POSITION_ARG = 0;
	private static int COMMAND_ARG = 1;
	
	public static void main(String[] args) {
		try {			
			CommandRegistery commandsRegistery = initCommandRegistery();
			Position startPosition = getInitialPosition(args);
			String command = getCommand(args);
			
			Map<Integer, Integer> obstacles = new HashMap<>();
			
			Rover rover = new NewStoreMarsRover(startPosition, commandsRegistery, obstacles);
			Position newPosition = rover.move(command);
			System.out.println(newPosition.toString());
		} catch (IllegalArgumentException e) {
			System.out.println(e.getMessage());
		} catch (Exception e) {
			System.out.println("Internal Error");
		}
	}
	
	private static CommandRegistery initCommandRegistery() {
		Command moveForward = new MoveForward();
		Command moveBackward = new MoveBackward();
		Command rotateRight = new RotateToRight();
		Command rotateLeft = new RotateToLeft();
		return CommandRegistery.register(moveForward, moveBackward, rotateRight, rotateLeft);
	}
	
	private static Position getInitialPosition(String[] args) {
		if (args.length <= START_POSITION_ARG) {
			throw new IllegalArgumentException("Start position argument is required to start Rover");
		}
		
		String startPosition = args[START_POSITION_ARG];
		return new PositionParser().parse(startPosition);
	}

	private static String getCommand(String[] args) {
		if (args.length <= COMMAND_ARG) {
			throw new IllegalArgumentException("Start position argument is required to start Rover");
		}
		
		return args[COMMAND_ARG];
	}
}
