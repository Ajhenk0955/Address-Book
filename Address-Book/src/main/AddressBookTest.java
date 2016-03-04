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
	 * testing for addPerson. Searches for person with last and first names
	 */
	@Test
	public void testAddPerson() {
		String firstName = "Joe";
		String lastName = "Bob";
		String address = "kowloon ln";
		String city = "Punta Rassa";
		String state = "FL";
		String zip = "33333";
		String phone = "000-000-000";

		Person person = new Person(firstName, lastName, address, city, state, zip, phone);
		addressBook.addPerson(person);
		
		assertEquals(person, addressBook.findPerson(lastName, firstName));
		
		
	}

	
	@Test
	public void testAddPeople() {
		fail("Not yet implemented");
	}

	/*
	 * adds people and then searches for a person
	 */
	@Test
	public void testFindPerson() {
		addressBook.addPerson(new Person("Joe", "Bob", "kowloon ln", "Punta Rassa", "FL", "33333", "000-000-000"));
		addressBook.addPerson(new Person("Jill", "Bob", "kowloon ln", "Punta Rassa", "FL", "33333", "000-000-000"));
		addressBook.addPerson(new Person("Jan", "Bob", "kowloon ln", "Punta Rassa", "FL", "33333", "000-000-000"));
		addressBook.addPerson(new Person("Zeke", "Bob", "kowloon ln", "Punta Rassa", "FL", "33333", "000-000-000"));
		addressBook.addPerson(new Person("Andrew", "Bob", "kowloon ln", "Punta Rassa", "FL", "33333", "000-000-000"));

		Person person = new Person("Andrew", "Jay", "kowloon ln", "Punta Rassa", "FL", "33333", "000-000-000");
		addressBook.addPerson(person);
		
		assertEquals(person, addressBook.findPerson("Jay", "Andrew"));
	}

	@Test
	public void testToString() {
		fail("Not yet implemented");
	}

}
