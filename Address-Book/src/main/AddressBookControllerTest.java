/**
 * 
 */
package main;

import static org.junit.Assert.*;

import java.io.File;

import org.junit.Before;
import org.junit.Test;

import junit.framework.Assert;

/**
 * Testing Case
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
		
		city = "Miami";
		String output = "kowloon ln Miami Joe Bob 000-000-000 FL 33333 ";
		controller.editPerson(index, firstName, lastName, address, city, state, zip, phone);
		assertEquals("add a person", output, controller.printEntries());	
		
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
	 * Test method for sortName.
	 */
	@Test
	public void testSortName() {
		controller.addPerson("Joe", "Bob", "kowloon ln", "Punta Rassa", "FL", "33333", "000-000-000");
		controller.addPerson("Jill", "Bob", "kowloon ln", "Punta Rassa", "FL", "33333", "000-000-000");
		controller.addPerson("Jan", "Bob", "kowloon ln", "Punta Rassa", "FL", "33333", "000-000-000");
		controller.addPerson("Zeke", "Bob", "kowloon ln", "Punta Rassa", "FL", "33333", "000-000-000");
		controller.addPerson("Andrew", "Bob", "kowloon ln", "Punta Rassa", "FL", "33333", "000-000-000");
		
		controller.sortName();

		String output = "kowloon ln Punta Rassa Zeke Bob 000-000-000 FL 33333 " + 
		"kowloon ln Punta Rassa Joe Bob 000-000-000 FL 33333 " + 
		"kowloon ln Punta Rassa Jill Bob 000-000-000 FL 33333 " + 
		"kowloon ln Punta Rassa Jan Bob 000-000-000 FL 33333 " + 
		"kowloon ln Punta Rassa Andrew Bob 000-000-000 FL 33333 ";
		
		assertEquals("Sort Test", output, controller.printEntries());
	}

	/**
	 * Test method for sortZIP.
	 */
	@Test
	public void testSortZIP() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for createAddressBook.
	 */
	@Test
	public void testCreateAddressBook() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for updateaddressBook.
	 */
	@Test
	public void testUpdateAddressBook() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for saveAddressBook
	 */
	@Test
	public void testSaveAddressBook() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for saveAddressBook2
	 */
	@Test
	public void testSaveAddressBookFile() {
		fail("Not yet implemented");
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
			String output = "kowloon ln Punta Rassa Joe Bob 000-000-000 FL 33333 " + 
			"kowloon ln Punta Rassa Joe Bob 000-000-000 FL 33333 ";
			
			assertEquals("Print Test", output, controller.printEntries());
			
	}

}
