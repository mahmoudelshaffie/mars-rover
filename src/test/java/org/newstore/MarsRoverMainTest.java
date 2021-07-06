package org.newstore;

import static org.junit.jupiter.api.Assertions.assertDoesNotThrow;
import static org.newstore.MarsRoverMain.main;

import org.junit.jupiter.api.Test;

public class MarsRoverMainTest {

	@Test
	public void testMainWithEmptyArgumentsShouldRunsSuccessfully() {
		String[] emptyArguments = {};
		assertDoesNotThrow(() -> main(emptyArguments));
	}
}
