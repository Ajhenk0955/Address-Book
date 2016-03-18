package unit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.Person;

/*
 * unit testing for class person
 */
public class PersonTest {

	Person person;

	@Before
	public void setUp() throws Exception {
		person = new Person("Joe", "Bob", "kowloon ln", "Punta Rassa", "FL", "33333", "000-000-000");
	}

	@After
	public void tearDown() throws Exception {
	}


	/*
	 * test to check to String method still need to update the output string
	 * TODO
	 */
	@Test
	public void testToString() {

		String output = "";
		assertEquals(output, person.toString());
	}

}
