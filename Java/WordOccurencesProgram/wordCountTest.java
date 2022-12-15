import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test; 

class wordCountTest extends fileReader {
	@Test
	/**
	 * J-Unit test that verifies an x number of words were read in.
	 */

	void test() {
		fileReader test = new fileReader();
		int output = test.inputFile(0);
		assertEquals(1069, output);
	
	}

}
