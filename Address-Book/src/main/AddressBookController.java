package main;

import java.io.File;
import java.io.IOException;
import java.util.Collections;
import static main.PersonComparator.*;

/*
# IN PROGRESS @ HENK
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

	public AddressBookController(AddressBook addressBook){
		this.addressBook = addressBook;
	}
	/*
	 * adds a person to the addressBook calls to the addressBook to add returns
	 * true if success
	 */
	boolean addPerson(String firstName, String lastName, String address, String city, String state, String zip,
			String phone) {
		Person person = new Person(firstName, lastName, address, city, state, zip, phone);
		if (!addressBook.entries.contains(person)) {
			addressBook.entries.add(person);
		}
		return true;

	}

	/*
	 * edits a person in a list, given information and list index
	 */
	boolean editPerson(int index, String firstName, String lastName, String address, String city, String state,
			String zip, String phone) {
		if (addressBook.entries.size() < index) {
			return false;
		} else {
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
	}

	/*
	 * deletes a person in a list
	 */
	boolean deletePerson(int index) {
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
	 * Sorts by first name
	 */
	boolean sortName() {
		try {
			Collections.sort(addressBook.entries, (getComparator(FIRST_NAME_SORT)));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/*
	 * Sorts by zip
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
		if(file == null)
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
	String printEntries() {
		String results = "";
		for (Person temp : addressBook.entries) {
			String info = "";
			info +=(temp.getAddress() + " ");
			info +=(temp.getCity() + " ");
			info +=(temp.getFirstName() + " ");
			info +=(temp.getLastName() + " ");
			info +=(temp.getPhone() + " ");
			info +=(temp.getState() + " ");
			info +=(temp.getZip() + " ");
			System.out.println(info);
			results += (info);
		}
		return results;
	}
	public boolean loadFile(File file) throws IOException {
		if (file == null || file.equals("")) {
			System.out.println("null file");
			return false;
		}

		FileSystem filesystem = new FileSystem();
		addressBook = filesystem.loadFile(file);
		return true;

	}
	public Person getPerson(String lastName, String firstName) {
		return addressBook.findPerson(lastName, firstName);
	}
}
