package org.newstore.rover.commands.exceptions;

public class InvalidCommandException extends IllegalArgumentException {

	private static final long serialVersionUID = -988334492089647287L;

	public InvalidCommandException(Character commandInput) {
		super(getFormattedMessage(commandInput));
	}
	
	private static String getFormattedMessage(Character commandInput) {
		String message = "Invalid Command: [%1$s] Is UnDefined";
		return String.format(message, commandInput);
	}
}
