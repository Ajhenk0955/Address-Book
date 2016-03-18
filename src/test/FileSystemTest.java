

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.AddressBook;
import main.AddressBookController;
import main.Person;

public class FileSystemTest {
	private AddressBookController adsbook;
	String firstName = "f", lastName = "l", addrss = "242 sw 41 blvd", city = "fort myers", st = "fl", zip = "33901",
			phone = "none, HAHAHAHa", file = "saveFileSysTest1.adbk";

	/*
	 * Set up the save file for the test to load putting the target person in
	 * the middle
	 */
	@Before
	public void setUp() throws Exception {
		adsbook = new AddressBookController(new AddressBook());
		for (int i = 0; i < 2; i++)
			adsbook.addPerson(firstName + i, lastName + i, addrss + i, city + i, st + i, zip + i, phone + i);
		adsbook.addPerson(firstName, lastName, addrss, city, st, zip, phone);
		for (int i = 3; i < 5; i++)
			adsbook.addPerson(firstName + i, lastName + i, addrss + i, city + i, st + i, zip + i, phone + i);
		adsbook.saveAddressBook(new File(file));
	}

	@After
	public void tearDown() throws Exception {
	}

	/*
	 * Test to see if addressbookcontroller correctly loads from the file
	 */
	@Test
	public void test() {
		adsbook = new AddressBookController(new AddressBook());
		try {
			adsbook.loadFile(new File(file));
		} catch (IOException e) {
			fail("Unable to open file");
		}
		Person p = adsbook.getPerson(lastName, firstName);
		if (p != null && p.getAddress().equals(addrss) && p.getCity().equals(city) && p.getState().equals(st)
				&& p.getZip().equals(zip) && p.getPhone().equals(phone))
			return;// pass()
		else
			fail();
	}

}
