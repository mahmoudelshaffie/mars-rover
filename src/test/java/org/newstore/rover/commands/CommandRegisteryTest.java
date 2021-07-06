package org.newstore.rover.commands;

import static org.junit.Assert.assertTrue;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.util.Optional;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

public class CommandRegisteryTest {

	private CommandRegistery registery;
	
	private Command moveForwardCommand;
	private Character MOVE_FORWARD = 'F';
	
	private Command moveBackwardCommand;
	private Character MOVE_BACKWARD = 'B';
	
	@BeforeEach
	public void beforeEach() {
		moveForwardCommand = mock(Command.class);
		when(moveForwardCommand.getCommandInput()).thenReturn(MOVE_FORWARD);
		
		moveBackwardCommand = mock(Command.class);
		when(moveBackwardCommand.getCommandInput()).thenReturn(MOVE_BACKWARD);
		
		registery = CommandRegistery.register(moveForwardCommand, moveBackwardCommand);
	}	
	
	@Test
	public void testGetRegisteredMoveFrowardCommandShouldBeRetrievedSuccessfully() {
		Optional<Command> actual = registery.getCommand(MOVE_FORWARD);
		assertTrue("Expect command is registered", actual.isPresent());
		assertEquals(moveForwardCommand.getCommandInput(), actual.get().getCommandInput(), "Expect moveForward command");
	}
	
	@Test
	public void testGetTwoDifferentRegisteredCommandsShouldBeRetrieveSuccessfully() {
		Optional<Command> actual = registery.getCommand(MOVE_FORWARD);
		assertTrue("Expect command is registered", actual.isPresent());
		assertEquals(moveForwardCommand, actual.get(), "Expect moveForward command");
		
		actual = registery.getCommand(MOVE_BACKWARD);
		assertTrue("Expect command is registered", actual.isPresent());
		assertEquals(moveBackwardCommand, actual.get(), "Expect moveBackward command");
	}
	
	@Test
	public void testGetUnRegisteredCommandShouldRetrieveEmptyResult() {
		Character unRegisteredCommand = 'X';
		Optional<Command> actual = registery.getCommand(unRegisteredCommand);
		assertTrue("Expect command is not registered", actual.isEmpty());
	}
}
