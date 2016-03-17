package main;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class AddressBookTest {

	AddressBook addressBook;
	@Before
	public void setUp() throws Exception {
		addressBook = new AddressBook();
	}

	@After
	public void tearDown() throws Exception {
	}

	/*
	 * compares the class to a new AddressBook
	 * should probably check for a null pointer instead
	 */
	@Test
	public void testAddressBook() {
		assertEquals(AddressBook.class, addressBook.getClass());
	}

/*
* test to check to String method
*still need to update the output string TODO
*/
	@Test
	public void testToString() {
		addressBook.addPerson(new Person("Joe", "Bob", "kowloon ln", "Punta Rassa", "FL", "33333", "000-000-000"));
		addressBook.addPerson(new Person("Jill", "Bob", "kowloon ln", "Punta Rassa", "FL", "33333", "000-000-000"));
		addressBook.addPerson(new Person("Jan", "Bob", "kowloon ln", "Punta Rassa", "FL", "33333", "000-000-000"));
		addressBook.addPerson(new Person("Zeke", "Bob", "kowloon ln", "Punta Rassa", "FL", "33333", "000-000-000"));
		addressBook.addPerson(new Person("Andrew", "Bob", "kowloon ln", "Punta Rassa", "FL", "33333", "000-000-000"));

		String output = "";
		assertEquals(output, addressBook.toString());
	}

}
