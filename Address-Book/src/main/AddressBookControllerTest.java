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
		controller.addPerson("Joe", "Bob", "kowloon ln", "Punta Rassa", "FL", "33333", "000-000-000");
		String output = "kowloon ln Punta Rassa Joe Bob 000-000-000 FL 33333 ";
		assertEquals("add a person", output, controller.printEntries());
	}

	/**
	 * Test method for edit person
	 */
	@Test
	public void testEditPerson() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for deletePerson
	 */
	@Test
	public void testDeletePerson() {
		fail("Not yet implemented");
	}

	/**
	 * Test method for sortName.
	 */
	@Test
	public void testSortName() {
		fail("Not yet implemented");
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
		fail("Not yet implemented");
	}

}
