package main;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Stack;

import static main.PersonComparator.*;

/*
 * The basic responsibility of an AdressBookController object is to carry out the following functions:
 * Add, Edit and delete a person
 * Sort entries by name and ZIP code
 * Create, update and save an existing address book
 * print entries in the address book
 * offer the user to save changes when necessary
 */
public class AddressBookController {

	AddressBook addressBook;
	File file;

	/*
	 * adds a person to the addressBook
	 */
	boolean addPerson(String firstName, String lastName, String address, String city, String state, String zip,
			String phone) {
		try {
			addressBook.entries.add(new Person(firstName, lastName, address, city, state, zip, phone));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/*
	 * edits a person in a list
	 */
	boolean editPerson(int index, String firstName, String lastName, String address, String city, String state,
			String zip, String phone) {
		try {
			Person temp = addressBook.entries.get(index);

			if (temp.getAddress() != address)
				temp.setAddress(address);
			if (temp.getCity() != city)
				temp.setCity(city);
			if (temp.getFirstName() != firstName)
				temp.setFirstName(firstName);
			if (temp.getLastName() != lastName)
				temp.setLastName(lastName);
			if (temp.getPhone() != phone)
				temp.setPhone(phone);
			if (temp.getState() != state)
				temp.setState(state);
			if (temp.getZip() != zip)
				temp.setZip(zip);

			addressBook.entries.set(index, temp);

			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/*
	 * deletes a person in a list
	 */
	boolean deletePerson(int index) {
		try {
			addressBook.entries.remove(index);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/*
	 * Sorts by first name
	 */
	boolean sortName() {
		try {
			Collections.sort(addressBook.entries, decending(getComparator(NAME_SORT)));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/*
	 * Sorts by first name
	 */
	boolean sortZIP() {
		try {
			Collections.sort(addressBook.entries, decending(getComparator(ZIP_SORT)));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/*
	 * Creates a new instance of the address book
	 */
	void createAddressBook() {
		addressBook = new AddressBook();
	}

	/*
	 * Opens current addressBook located at file
	 */
	boolean updateAddressBook(File file) {
		this.file = file;
		FileSystem filesystem = new FileSystem();
		addressBook = filesystem.readFile(file);
		if (addressBook == null)
			return false;
		return true;
	}

	/*
	 * Saves current address book without being given file
	 */
	boolean saveAddressBook() {
		if (file == null) {
			System.out.println("null file");
			return false;
		}

		FileSystem filesystem = new FileSystem();
		try {
			filesystem.saveFile(addressBook, file);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	/*
	 * Saves current address book if given file
	 */
	boolean saveAddressBook(File file) {
		if (file == null) {
			System.out.println("null file");
			return false;
		}

		FileSystem filesystem = new FileSystem();
		try {
			filesystem.saveFile(addressBook, file);
			return true;
		} catch (IOException e) {
			e.printStackTrace();
			return false;
		}
	}

	/*
	 * Prints each entry in the current addressBook
	 */
	void printEntries() {
		for (Person temp : addressBook.entries) {
			String info = "";
			info.concat(temp.getAddress() + " ");
			info.concat(temp.getCity() + " ");
			info.concat(temp.getFirstName() + " ");
			info.concat(temp.getLastName() + " ");
			info.concat(temp.getPhone() + " ");
			info.concat(temp.getState() + " ");
			info.concat(temp.getZip() + " ");
			info.concat(temp.getClass() + " ");
			System.out.println(info);
		}
	}
}