package org.newstore.parsing.exceptions;

public class InvalidPositionInputException extends IllegalArgumentException {

	private static final long serialVersionUID = -7439430492026974834L;

	public InvalidPositionInputException(String invalidInput, String expectedFormat) {
		super(getFormattedMessage(invalidInput, expectedFormat));
	}
	
	public InvalidPositionInputException(String invalidInput, String expectedFormat, Exception cause) {
		super(getFormattedMessage(invalidInput, expectedFormat), cause);
	}
	
	private static String getFormattedMessage(String invalidInput, String expectedFormat) {
		String message = "Invalid Position: [%1$s] it doesn't match [%2$s]";
		return String.format(message, invalidInput, expectedFormat);
	}
}
