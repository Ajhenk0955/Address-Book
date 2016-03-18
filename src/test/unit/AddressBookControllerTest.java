package unit;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;
import main.AddressBook;
import main.AddressBookController;

/**
 * Unit testing for addressBook controller
 *
 */
public class AddressBookControllerTest {

	File file;
	AddressBook addressBook;
	AddressBookController controller;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		addressBook = new AddressBook();
		controller = new AddressBookController(addressBook);
	}

	/**
	 * Test method for addPerson
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

		controller.addPerson(firstName, lastName, address, city, state, zip, phone);
		String output = "kowloon ln Punta Rassa Joe Bob 000-000-000 FL 33333 ";
		assertEquals("add a person", output, controller.printEntries());
	}
	/**
	 * Test method for addPerson who already exists
	 */
	@Test
	public void testAddPersonExists() {
		String firstName = "Joe";
		String lastName = "Bob";
		String address = "kowloon ln";
		String city = "Punta Rassa";
		String state = "FL";
		String zip = "33333";
		String phone = "000-000-000";

		controller.addPerson(firstName, lastName, address, city, state, zip, phone);
		String output = "kowloon ln Punta Rassa Joe Bob 000-000-000 FL 33333 ";
		assertEquals(false, controller.addPerson(firstName, lastName, address, city, state, zip, phone));
	}
	/**
	 * Test method for edit person
	 */
	@Test
	public void testEditPerson() {
		int index = 0;
		String firstName = "Joe";
		String lastName = "Bob";
		String address = "kowloon ln";
		String city = "Punta Rassa";
		String state = "FL";
		String zip = "33333";
		String phone = "000-000-000";

		controller.addPerson(firstName, lastName, address, city, state, zip, phone);

		// now editing person
		city = "Miami";
		String output = "kowloon ln Miami Joe Bob 000-000-000 FL 33333 ";
		controller.editPerson(index, firstName, lastName, address, city, state, zip, phone);
		assertEquals("edit a person", output, controller.printEntries());

	}

	/**
	 * Test method for edit person when list is empty
	 */
	@Test
	public void testEditPersonEmpty() {
		int index = 0;
		String firstName = "Joe";
		String lastName = "Bob";
		String address = "kowloon ln";
		String city = "Punta Rassa";
		String state = "FL";
		String zip = "33333";
		String phone = "000-000-000";

		// now editing person
		city = "Miami";
		assertEquals(false, controller.editPerson(index, firstName, lastName, address, city, state, zip, phone));

	}

	/**
	 * TODO test for exception catching
	 */
	@Test
	public void testEditPersonCatch() {

	}
	/**
	 * Test method for deletePerson
	 */
	@Test
	public void testDeletePerson() {
		int index = 0;
		String firstName = "joe";
		String lastName = "Bob";
		String address = "kowloon ln";
		String city = "Punta Rassa";
		String state = "FL";
		String zip = "33333";
		String phone = "000-000-000";

		controller.addPerson(firstName, lastName, address, city, state, zip, phone);
		controller.deletePerson(index);
		assertEquals("delete a person", "", controller.printEntries());
	}
	/**
	 * Test method for deletePerson from an empty list
	 */
	@Test
	public void testDeletePersonNoValues() {
		int index = 0;
		controller.deletePerson(index);
		assertEquals(false, controller.deletePerson(index));
	}
	/**
	 * TODO
	 * Test method for deletePerson and catching error
	 */
	@Test
	public void testDeletePersonCatch() {

	}

	/**
	 * Test method for sortName descending by firstName
	 */
	@Test
	public void testSortNameFirst() {
		controller.addPerson("Joe", "Bob", "kowloon ln", "Punta Rassa", "FL", "33333", "000-000-000");
		controller.addPerson("Jill", "Bob", "kowloon ln", "Punta Rassa", "FL", "33333", "000-000-000");
		controller.addPerson("Jan", "Bob", "kowloon ln", "Punta Rassa", "FL", "33333", "000-000-000");
		controller.addPerson("Zeke", "Bob", "kowloon ln", "Punta Rassa", "FL", "33333", "000-000-000");
		controller.addPerson("Andrew", "Bob", "kowloon ln", "Punta Rassa", "FL", "33333", "000-000-000");

		// option 1
		controller.sortValue(1);

		String expected = "serialVersionUID : 1 Entries :  "
				+ "Person : serialVersionUID : 1 "
					+ "LastName : Bob "
					+ "FirstName : Andrew "
					+ "Address : kowloon ln "
					+ "City : Punta Rassa "
					+ "State : FL "
					+ "Zip : 33333 "
					+ "Phone : 000-000-000 "
				+ "Person : "
					+ "serialVersionUID : 1 "
					+ "LastName : Bob "
					+ "FirstName : Jan "
					+ "Address : kowloon ln "
					+ "City : Punta Rassa "
					+ "State : FL "
					+ "Zip : 33333 "
					+ "Phone : 000-000-000 "
				+ "Person : "
					+ "serialVersionUID : 1 "
					+ "LastName : Bob "
					+ "FirstName : Jill "
					+ "Address : kowloon ln "
					+ "City : Punta Rassa "
					+ "State : FL Zip : 33333 "
					+ "Phone : 000-000-000 "
				+ "Person : "
					+ "serialVersionUID : 1 "
					+ "LastName : Bob "
					+ "FirstName : Joe "
					+ "Address : kowloon ln "
					+ "City : Punta Rassa "
					+ "State : FL "
					+ "Zip : 33333 "
					+ "Phone : 000-000-000 "
				+ "Person : "
					+ "serialVersionUID : 1 "
					+ "LastName : Bob "
					+ "FirstName : Zeke "
					+ "Address : kowloon ln "
					+ "City : Punta Rassa "
					+ "State : FL "
					+ "Zip : 33333 "
					+ "Phone : 000-000-000";

		assertEquals("Sort Test", expected, controller.printEntries());
	}
	/**
	 * TODO
	 * Test method for sortName descending by lastName
	 */
	@Test
	public void testSortNameLast() {

	}

	/**
	 * Test method for sortZIP descending
	 */
	@Test
	public void testSortZIPDescending() {
		controller.addPerson("Joe", "Bob", "kowloon ln", "Punta Rassa", "FL", "33331", "000-000-000");
		controller.addPerson("Jill", "Bob", "kowloon ln", "Punta Rassa", "FL", "33332", "000-000-000");
		controller.addPerson("Jan", "Bob", "kowloon ln", "Punta Rassa", "FL", "33433", "000-000-000");
		controller.addPerson("Zeke", "Bob", "kowloon ln", "Punta Rassa", "FL", "13333", "000-000-000");
		controller.addPerson("Andrew", "Bob", "kowloon ln", "Punta Rassa", "FL", "33633", "000-000-000");

		controller.sortValue(2);

		String output = "kowloon ln Punta Rassa Andrew Bob 000-000-000 FL 33633 "
				+ "kowloon ln Punta Rassa Jan Bob 000-000-000 FL 33433 "
				+ "kowloon ln Punta Rassa Jill Bob 000-000-000 FL 33332 "
				+ "kowloon ln Punta Rassa Joe Bob 000-000-000 FL 33331 "
				+ "kowloon ln Punta Rassa Zeke Bob 000-000-000 FL 13333 ";

		assertEquals("Sort Test", output, controller.printEntries());
	}
	/**
	 * TODO
	 * Test method for sortZIP ascending
	 */
	@Test
	public void testSortZIPAscending() {

	}

	/**
	 * Test method for createAddressBook.
	 */
	@Test
	public void testCreateAddressBook() {
		String firstName = "Joe";
		String lastName = "Bob";
		String address = "kowloon ln";
		String city = "Punta Rassa";
		String state = "FL";
		String zip = "33333";
		String phone = "000-000-000";

		controller.createAddressBook();
		controller.addPerson(firstName, lastName, address, city, state, zip, phone);
		String book1 = controller.printEntries();

		city = "Bunta Rassa";
		controller.createAddressBook();
		controller.addPerson(firstName, lastName, address, city, state, zip, phone);
		String book2 = controller.printEntries();
		assertNotEquals("Address Book Exists Test", book1, book2);
	}
	/**
	 * TODO
	 * Test method for sort error catching
	 */
	@Test
	public void testSortError() {

	}

	/**
	 * Test method for updateaddressBook.
	 */
	@Test
	public void testUpdateAddressBook() {
		String firstName = "Joe";
		String lastName = "Bob";
		String address = "kowloon ln";
		String city = "Punta Rassa";
		String state = "FL";
		String zip = "33333";
		String phone = "000-000-000";

		controller.addPerson(firstName, lastName, address, city, state, zip, phone);

		boolean success = controller.updateAddressBook(new File("testSave.log"));

		if (success) {
			firstName = "Joey";
			lastName = "Bobby";
			address = "kowloony lny";
			city = "Puntay Rassay";
			state = "FLY";
			zip = "3333y";
			phone = "000-000-000y";

			controller.addPerson(firstName, lastName, address, city, state, zip, phone);

			try {
				controller.loadFile(new File("testSave.log"));
			} catch (IOException e) {
				fail("Failed to load file");
				e.printStackTrace();
			}

			String output = "kowloon ln Punta Rassa Joe Bob 000-000-000 FL 33333 ";

			assertEquals("Print Test", output, controller.printEntries());
		}
	}

	/**
	 * TODO
	 * Test method for saveAddressBook
	 */
	@Test
	public void testSaveAddressBook() {
		String firstName = "Joe";
		String lastName = "Bob";
		String address = "kowloon ln";
		String city = "Punta Rassa";
		String state = "FL";
		String zip = "33333";
		String phone = "000-000-000";

		controller.addPerson(firstName, lastName, address, city, state, zip, phone);

		boolean success = controller.updateAddressBook(new File("testSave.log"));

		if (success) {
			firstName = "Joey";
			lastName = "Bobby";
			address = "kowloony lny";
			city = "Puntay Rassay";
			state = "FLY";
			zip = "3333y";
			phone = "000-000-000y";

			controller.addPerson(firstName, lastName, address, city, state, zip, phone);

			try {
				controller.loadFile(new File("testSave.log"));
			} catch (IOException e) {
				fail("Failed to load file");
				e.printStackTrace();
			}

			String output = "kowloon ln Punta Rassa Joe Bob 000-000-000 FL 33333 ";

			assertEquals("Print Test", output, controller.printEntries());
		}
	}

	/**
	 * Test method for printEntries
	 */
	@Test
	public void testPrintEntries() {
		String firstName = "Joe";
		String lastName = "Bob";
		String address = "kowloon ln";
		String city = "Punta Rassa";
		String state = "FL";
		String zip = "33333";
		String phone = "000-000-000";

		controller.addPerson(firstName, lastName, address, city, state, zip, phone);
		controller.addPerson(firstName, lastName, address, city, state, zip, phone);
		String output = "kowloon ln Punta Rassa Joe Bob 000-000-000 FL 33333 "
				+ "kowloon ln Punta Rassa Joe Bob 000-000-000 FL 33333 ";

		assertEquals("Print Test", output, controller.printEntries());

	}
	/*
	 * TODO
	 * test for get data points
	 */
	@Test
	public void testGetDataPoints(){
		
	}

}
