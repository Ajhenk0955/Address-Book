package main;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

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
	 * compares the class to a new person
	 * should probably check for a null pointer instead
	 */
	@Test
	public void testPerson() {
		assertEquals(Person.class, person.getClass());
	}

/*
* test to check to String method
*still need to update the output string TODO
*/
	@Test
	public void testToString() {

		String output = "";
		assertEquals(output, person.toString());
	}

}
