package main;

import static org.junit.Assert.*;

import java.io.File;
import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class FileSystemTest {
	private AddressBookController adsbook;
	String firstName = "f",
			lastName = "l",
			addrss = "242 sw 41 blvd",
			city = "fort myers",
			st = "fl",
			zip = "33901",
			phone = "none, HAHAHAHa",
			file = "save1.adbk";
	@Before
	public void setUp() throws Exception {
		adsbook = new AddressBookController(new AddressBook());
		adsbook.addPerson(firstName, lastName, addrss, city, st, zip, phone);
		adsbook.saveAddressBook(new File(file));
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		adsbook = new AddressBookController(new AddressBook());
		try {
			adsbook.loadFile(new File(file));
		} catch (IOException e) {
			fail("Unable to open file");
		}
		Person p = adsbook.getPerson(lastName, firstName);
		if( p != null )
			return;//pass()
		else
			fail();
	}

}
