package exceptions;

import static org.junit.Assert.*;

import org.junit.Before;
import org.junit.Test;

public class testTest {

	int[] x={5, -2, 0, 1, 4};
	@Before
	public void setUp() throws Exception {
	}

	@Test
	public void testOddOrPos() {
		assertEquals(3,test.oddOrPos(x),0);
	}

}
