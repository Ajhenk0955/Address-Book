package main;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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

	private AddressBook addressBook;
	private File file;
	/*
	 * constructor
	 */
	public AddressBookController(AddressBook addressBook) {
		this.addressBook = addressBook;
		
	}


	/*
	 * adds a person to the addressBook calls to the addressBook to add returns
	 * true if success
	 */
	public boolean addPerson(String firstName, String lastName, String address, String city, String state, String zip,
			String phone) {
		Person person = new Person(firstName, lastName, address, city, state, zip, phone);

		if (!addressBook.entries.contains(person)) {
			addressBook.entries.add(person);
			return true;
		} else {
			return false;
		}

	}

	/*
	 * edits a person in a list, given information and list index
	 */
	public boolean editPerson(int index, String firstName, String lastName, String address, String city, String state,
			String zip, String phone) {
		if (addressBook.entries.size() < index) {
			return false;
		} else {
			try {
				
				Person person = new Person(firstName, lastName, address, city, state, zip, phone);

				addressBook.entries.set(index, person);
				return true;

			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}
	}

	/*
	 * deletes a person in a list
	 */
	public boolean deletePerson(int index) {
		if (addressBook.entries.size() < index) {
			return false;
		} else {
			try {
				addressBook.entries.remove(index);
				return true;
			} catch (Exception e) {
				e.printStackTrace();
				return false;
			}
		}
	}

	/*
	 * sorts based on the value using a switch to set the comparator
	 * 0 = lastNameSortAscending
	 * 1 = firstNameSortAscending
	 * 2 = zipSort descending
	 * 3 = zipSort ascending
	 */
	public boolean sortValue(int option) {
		Comparator compare = null;
		if(option == -1){
			return false;
		}
		switch(option){
		case 0: // last name
			compare = getComparator(LAST_NAME_SORT);
			break;
		case 1: // first name
			compare = getComparator(FIRST_NAME_SORT);
			break;
		case 2: // sortZIP
			compare = decending(getComparator(ZIP_SORT));
			break;
		case 3: // zip
			compare = getComparator(ZIP_SORT);
			break;
		}
		
		
		try {
			Collections.sort(addressBook.entries, compare);
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/*
	 * Creates a new instance of the address book
	 */
	public void createAddressBook() {
		addressBook = new AddressBook();
	}

	/*
	 * Opens current addressBook located at file
	 */
	public boolean updateAddressBook(File file) {
		if (file == null)
			return false;

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
	public boolean saveAddressBook() {
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
	public boolean saveAddressBook(File file) {
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
	public String printEntries() {
		return addressBook.toString();
	}

	/*
	 * loads the file that contains an AddressBook
	 */
	public boolean loadFile(File file) throws IOException {
		if (file == null || file.equals("")) {
			System.out.println("null file");
			return false;
		}

		FileSystem filesystem = new FileSystem();
		addressBook = filesystem.loadFile(file);
		return true;

	}

	/*
	 * retrieves a person by lastName and first name
	 */
	public Person getPerson(String lastName, String firstName) {

		for (Person p : addressBook.entries) {
			if (p.getLastName().equals(lastName) && p.getFirstName().equals(firstName))
				return p;
		}
		return null;
	}

	public String[][] getEntriesDataPoints() {
		Person[] people = addressBook.entries.toArray(new Person[0]);
		if (people == null || people.length == 0 || people[0] == null)
			return new String[0][0];

		final int num_datapoints = people[0].getNumDataPoints();
		String[][] out = new String[people.length][num_datapoints];

		for (int i = 0; i < people.length; i++) {
			if (people[i] != null) {
				out[i] = people[i].getDataPoints();
			} else {
				out[i] = new String[num_datapoints];
				for (int j = 0; j < num_datapoints; j++) {
					out[i][j] = "";
				}
			}
		}
		return out;
	}

}
