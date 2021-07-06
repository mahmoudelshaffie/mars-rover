package org.newstore.parsing.exceptions;

public class InvalidObstacleInputException extends IllegalArgumentException {
	private static final long serialVersionUID = 8689028207101762429L;

	public InvalidObstacleInputException(String invalidInput, Exception cause) {
		super(getFormattedMessage(invalidInput), cause);
	}
	
	private static String getFormattedMessage(String invalidInput) {
		String message = "Invalid Obstacles: [%1$s] is in invalid format expect [[1, 3], [4, 4]]";
		return String.format(message, invalidInput);
	}
}
