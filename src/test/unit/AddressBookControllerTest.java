package unit;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;
import main.AddressBook;
import main.AddressBookController;
import main.Person;

/**
 * Unit testing for addressBook controller
 *
 */
public class AddressBookControllerTest {

	File file;
	AddressBookController controller;

	/**
	 * @throws java.lang.Exception
	 */
	@Before
	public void setUp() throws Exception {
		addTestFile();
		controller = new AddressBookController(null);
		controller.createAddressBook();
	}
	private void addTestFile(){
		file = new File("testSave.adbk");
		controller = new AddressBookController(null);
		controller.createAddressBook();
		
		controller.addPerson("Isaac", "Gainey", "Se 17", "Cape", "Fl", "33990", "239 555 8875");
		controller.addPerson("Luke", "Gainey", "Se 17", "Cape", "Fl", "33990", "239 555 8008");
		controller.addPerson("Jess", "River", "Crement Block", "North Fort", "Florida", "33904", "239 555 5127");
		
		controller.saveAddressBook(file);
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
		String phone = "239-154-9584";

		controller.addPerson(firstName, lastName, address, city, state, zip, phone);
		String output = "serialVersionUID : 1 "
				+ "Entries :  "
					+ "Person : "
						+ "serialVersionUID : 1 "
						+ "LastName : " + lastName
						+ " FirstName : " + firstName
						+ " Address : " + address
						+ " City : " + city
						+ " State : " + state
						+ " Zip : " + zip
						+ " Phone : " + phone;
		assertEquals("add a person", output, controller.printEntries());
	}
	/**TODO not working
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
		String phone = "239-154-9584";

		controller.addPerson(firstName, lastName, address, city, state, zip, phone);
		
		controller.deletePerson(0);
		
		assertEquals(null, controller.getPerson(lastName, firstName));
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
		String phone = "239-154-9584";

		controller.addPerson(firstName, lastName, address, city, state, zip, phone);
		// now editing person
		city = "Miami";
		
		String output = "serialVersionUID : 1 "
				+ "Entries :  "
					+ "Person : "
						+ "serialVersionUID : 1 "
						+ "LastName : " + lastName
						+ " FirstName : " + firstName
						+ " Address : " + address
						+ " City : " + city
						+ " State : " + state
						+ " Zip : " + zip
						+ " Phone : " + phone;
		
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
		String phone = "239-154-9584";

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
		String phone = "239-154-9584";

		controller.addPerson(firstName, lastName, address, city, state, zip, phone);
		controller.deletePerson(index);
		
		String expected = "serialVersionUID : 1 Entries : ";		
		assertEquals("delete a person", expected, controller.printEntries());
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
		controller.addPerson("Joe", "Bob", "kowloon ln", "Punta Rassa", "FL", "33333", "239-154-9584");
		controller.addPerson("Jill", "Bob", "kowloon ln", "Punta Rassa", "FL", "33333", "239-154-9584");
		controller.addPerson("Jan", "Bob", "kowloon ln", "Punta Rassa", "FL", "33333", "239-154-9584");
		controller.addPerson("Zeke", "Bob", "kowloon ln", "Punta Rassa", "FL", "33333", "239-154-9584");
		controller.addPerson("Andrew", "Bob", "kowloon ln", "Punta Rassa", "FL", "33333", "239-154-9584");

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
					+ "Phone : 239-154-9584 "
				+ "Person : "
					+ "serialVersionUID : 1 "
					+ "LastName : Bob "
					+ "FirstName : Jan "
					+ "Address : kowloon ln "
					+ "City : Punta Rassa "
					+ "State : FL "
					+ "Zip : 33333 "
					+ "Phone : 239-154-9584 "
				+ "Person : "
					+ "serialVersionUID : 1 "
					+ "LastName : Bob "
					+ "FirstName : Jill "
					+ "Address : kowloon ln "
					+ "City : Punta Rassa "
					+ "State : FL Zip : 33333 "
					+ "Phone : 239-154-9584 "
				+ "Person : "
					+ "serialVersionUID : 1 "
					+ "LastName : Bob "
					+ "FirstName : Joe "
					+ "Address : kowloon ln "
					+ "City : Punta Rassa "
					+ "State : FL "
					+ "Zip : 33333 "
					+ "Phone : 239-154-9584 "
				+ "Person : "
					+ "serialVersionUID : 1 "
					+ "LastName : Bob "
					+ "FirstName : Zeke "
					+ "Address : kowloon ln "
					+ "City : Punta Rassa "
					+ "State : FL "
					+ "Zip : 33333 "
					+ "Phone : 239-154-9584";

		assertEquals("Sort Test", expected, controller.printEntries());
	}
	/**
	 * Test method for sortName descending by lastName
	 */
	@Test
	public void testSortNameLast() {
		controller.addPerson("Joe", "D", "kowloon ln", "Punta Rassa", "FL", "33333", "239-154-9584");
		controller.addPerson("Jill", "C", "kowloon ln", "Punta Rassa", "FL", "33333", "239-154-9584");
		controller.addPerson("Jan", "B", "kowloon ln", "Punta Rassa", "FL", "33333", "239-154-9584");
		controller.addPerson("Zeke", "E", "kowloon ln", "Punta Rassa", "FL", "33333", "239-154-9584");
		controller.addPerson("Andrew", "A", "kowloon ln", "Punta Rassa", "FL", "33333", "239-154-9584");



		String expected = "serialVersionUID : 1 Entries :  "
				+ "Person : serialVersionUID : 1 "
					+ "LastName : A "
					+ "FirstName : Andrew "
					+ "Address : kowloon ln "
					+ "City : Punta Rassa "
					+ "State : FL "
					+ "Zip : 33333 "
					+ "Phone : 239-154-9584 "
				+ "Person : "
					+ "serialVersionUID : 1 "
					+ "LastName : B "
					+ "FirstName : Jan "
					+ "Address : kowloon ln "
					+ "City : Punta Rassa "
					+ "State : FL "
					+ "Zip : 33333 "
					+ "Phone : 239-154-9584 "
				+ "Person : "
					+ "serialVersionUID : 1 "
					+ "LastName : C "
					+ "FirstName : Jill "
					+ "Address : kowloon ln "
					+ "City : Punta Rassa "
					+ "State : FL Zip : 33333 "
					+ "Phone : 239-154-9584 "
				+ "Person : "
					+ "serialVersionUID : 1 "
					+ "LastName : D "
					+ "FirstName : Joe "
					+ "Address : kowloon ln "
					+ "City : Punta Rassa "
					+ "State : FL "
					+ "Zip : 33333 "
					+ "Phone : 239-154-9584 "
				+ "Person : "
					+ "serialVersionUID : 1 "
					+ "LastName : E "
					+ "FirstName : Zeke "
					+ "Address : kowloon ln "
					+ "City : Punta Rassa "
					+ "State : FL "
					+ "Zip : 33333 "
					+ "Phone : 239-154-9584";

		assertEquals("Sort Test", expected, controller.printEntries());
	}
	/**
	 * Test method for sortZIP descending
	 */
	@Test
	public void testSortZIPDescending() {
		controller.addPerson("Joe", "Bob", "kowloon ln", "Punta Rassa", "FL", "33331", "239-154-9584");
		controller.addPerson("Jill", "Bob", "kowloon ln", "Punta Rassa", "FL", "33332", "239-154-9584");
		controller.addPerson("Jan", "Bob", "kowloon ln", "Punta Rassa", "FL", "33433", "239-154-9584");
		controller.addPerson("Zeke", "Bob", "kowloon ln", "Punta Rassa", "FL", "13333", "239-154-9584");
		controller.addPerson("Andrew", "Bob", "kowloon ln", "Punta Rassa", "FL", "33633", "239-154-9584");

		controller.sortValue(2);

		String expected = "serialVersionUID : 1 "
				+ "Entries :  "
				+ "Person : "
					+ "serialVersionUID : 1 "
					+ "LastName : Bob "
					+ "FirstName : Andrew "
					+ "Address : kowloon ln "
					+ "City : Punta Rassa "
					+ "State : FL "
					+ "Zip : 33633 "
					+ "Phone : 239-154-9584 "
				+ "Person : "
					+ "serialVersionUID : 1 "
					+ "LastName : Bob "
					+ "FirstName : Jan "
					+ "Address : kowloon ln "
					+ "City : Punta Rassa "
					+ "State : FL "
					+ "Zip : 33433 "
					+ "Phone : 239-154-9584 "
				+ "Person : "
					+ "serialVersionUID : 1 "
					+ "LastName : Bob "
					+ "FirstName : Jill "
					+ "Address : kowloon ln "
					+ "City : Punta Rassa "
					+ "State : FL "
					+ "Zip : 33332 "
					+ "Phone : 239-154-9584 "
				+ "Person : "
					+ "serialVersionUID : 1 "
					+ "LastName : Bob "
					+ "FirstName : Joe "
					+ "Address : kowloon ln "
					+ "City : Punta Rassa "
					+ "State : FL "
					+ "Zip : 33331 "
					+ "Phone : 239-154-9584 "
				+ "Person : "
					+ "serialVersionUID : 1 "
					+ "LastName : Bob "
					+ "FirstName : Zeke "
					+ "Address : kowloon ln "
					+ "City : Punta Rassa "
					+ "State : FL "
					+ "Zip : 13333 "
					+ "Phone : 239-154-9584";

		assertEquals("Sort Test", expected, controller.printEntries());
	}
	/**
	 * Test method for sortZIP ascending
	 */
	@Test
	public void testSortZIPAscending() {
		controller.addPerson("Joe", "Bob", "kowloon ln", "Punta Rassa", "FL", "33331", "239-154-9584");
		controller.addPerson("Jill", "Bob", "kowloon ln", "Punta Rassa", "FL", "33332", "239-154-9584");
		controller.addPerson("Jan", "Bob", "kowloon ln", "Punta Rassa", "FL", "33433", "239-154-9584");
		controller.addPerson("Zeke", "Bob", "kowloon ln", "Punta Rassa", "FL", "13333", "239-154-9584");
		controller.addPerson("Andrew", "Bob", "kowloon ln", "Punta Rassa", "FL", "33633", "239-154-9584");

		controller.sortValue(3);

		String expected = "serialVersionUID : 1 "
				+ "Entries :  "
					+ "Person : "
						+ "serialVersionUID : 1 "
						+ "LastName : Bob "
						+ "FirstName : Zeke "
						+ "Address : kowloon ln "
						+ "City : Punta Rassa "
						+ "State : FL "
						+ "Zip : 13333 "
						+ "Phone : 239-154-9584 "
					+ "Person : "
						+ "serialVersionUID : 1 "
						+ "LastName : Bob "
						+ "FirstName : Joe "
						+ "Address : kowloon ln "
						+ "City : Punta Rassa "
						+ "State : FL "
						+ "Zip : 33331 "
						+ "Phone : 239-154-9584 "
					+ "Person : "
						+ "serialVersionUID : 1 "
						+ "LastName : Bob "
						+ "FirstName : Jill "
						+ "Address : kowloon ln "
						+ "City : Punta Rassa "
						+ "State : FL "
						+ "Zip : 33332 "
						+ "Phone : 239-154-9584 "
					+ "Person : "
						+ "serialVersionUID : 1 "
						+ "LastName : Bob "
						+ "FirstName : Jan "
						+ "Address : kowloon ln "
						+ "City : Punta Rassa "
						+ "State : FL "
						+ "Zip : 33433 "
						+ "Phone : 239-154-9584 "
					+ "Person : "
						+ "serialVersionUID : 1 "
						+ "LastName : Bob "
						+ "FirstName : Andrew "
						+ "Address : kowloon ln "
						+ "City : Punta Rassa "
						+ "State : FL "
						+ "Zip : 33633 "
						+ "Phone : 239-154-9584";

		assertEquals("Sort Test", expected, controller.printEntries());
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
		String phone = "239-154-9584";

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
	 * upda
	 */
	@Test
	public void testUpdateAddressBook() throws IOException{
		String firstName = "Joe";
		String lastName = "Bob";
		String address = "kowloon ln";
		String city = "Punta Rassa";
		String state = "FL";
		String zip = "33333";
		String phone = "239-154-9584";
		controller.createAddressBook();
		
		controller.addPerson(firstName, lastName, address, city, state, zip, phone);

		boolean success = controller.updateAddressBook(new File("testSave.adbk"));

		if (success) {
			firstName = "Joey";
			lastName = "Bobby";
			address = "kowloony lny";
			city = "Puntay Rassay";
			state = "FLY";
			zip = "3333y";
			phone = "239-154-9584";

			controller.addPerson(firstName, lastName, address, city, state, zip, phone);
			controller.loadFile(new File("testSave.log"));

			String output = "serialVersionUID : 1 Entries : ";

			assertEquals("Print Test", output, controller.printEntries());
		}
	}

	/**
	 * TODO
	 * Test method for saveAddressBook
	 */
	@Test
	public void testSaveAddressBook() throws IOException{
		String firstName = "Joe";
		String lastName = "Bob";
		String address = "kowloon ln";
		String city = "Punta Rassa";
		String state = "FL";
		String zip = "33333";
		String phone = "239-154-9584";

		controller.addPerson(firstName, lastName, address, city, state, zip, phone);

		boolean success = controller.saveAddressBook(file);

		if (success) {
			controller.addPerson("Joey", 
					"Bobby",  
					"kowloony lny", 
					"Puntay Rassay", 
					"FLY", 
					"3333y", 
					"239-154-9584");
			controller.loadFile(file);

			String output = "serialVersionUID : 1 "
					+ "Entries :  "
						+ "Person : "
							+ "serialVersionUID : 1 "
							+ "LastName : " + lastName
							+ " FirstName : " + firstName
							+ " Address : " + address
							+ " City : " + city
							+ " State : " + state
							+ " Zip : " + zip
							+ " Phone : " + phone;

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
		String phone = "239-154-9584";

		controller.addPerson(firstName, lastName, address, city, state, zip, phone);
		controller.addPerson(firstName, lastName, address, city, state, zip, phone);
		String output = "serialVersionUID : 1 "
				+ "Entries :  "
					+ "Person : "
						+ "serialVersionUID : 1 "
						+ "LastName : " + lastName
						+ " FirstName : " + firstName
						+ " Address : " + address
						+ " City : " + city
						+ " State : " + state
						+ " Zip : " + zip
						+ " Phone : " + phone
					+ " Person : "
						+ "serialVersionUID : 1 "
						+ "LastName : " + lastName
						+ " FirstName : " + firstName
						+ " Address : "+  address
						+ " City : " + city
						+ " State : " + state
						+ " Zip : " + zip
						+ " Phone : " + phone;

		assertEquals("Print Test", output, controller.printEntries());

	}
	/*
	 * test for get data points
	 */
	@Test
	public void testGetDataPoints(){
		String firstName = "Joe";
		String lastName = "Bob";
		String address = "kowloon ln";
		String city = "Punta Rassa";
		String state = "FL";
		String zip = "33333";
		String phone = "000-000-000";
			
		controller.addPerson(firstName, lastName, address, city, state, zip, phone);
		
		String firstName1 = "Bob";
		String lastName1 = "joe";
		String address1 = "Raintree ln";
		String city1 = "Punta Rassa";
		String state1 = "FL";
		String zip1 = "33333";
		String phone1 = "000-000-000";
		controller.addPerson(firstName1, lastName1, address1, city1, state1, zip1, phone1);
		
		String[][] output = {{lastName,firstName,phone,address,city,state,zip},
				{lastName1,firstName1,phone1,address1,city1,state1,zip1}};
		
		assertArrayEquals(output, controller.getEntriesDataPoints());
	}

}
