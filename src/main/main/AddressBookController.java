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

	public AddressBookController(AddressBook addressBook) {
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
	boolean sortFirstName() {
		try {
			Collections.sort(addressBook.entries, (getComparator(FIRST_NAME_SORT)));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/*
	 * Sorts by last name
	 */
	boolean sortLastName() {
		try {
			Collections.sort(addressBook.entries, (getComparator(LAST_NAME_SORT)));
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
	 * Sorts by last name
	 */
	boolean sortAddress() {
		try {
			Collections.sort(addressBook.entries, (getComparator(LAST_NAME_SORT)));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/*
	 * Sorts by last name
	 */
	boolean sortState() {
		try {
			Collections.sort(addressBook.entries, (getComparator(LAST_NAME_SORT)));
			return true;
		} catch (Exception e) {
			e.printStackTrace();
			return false;
		}
	}

	/*
	 * Sorts by last name
	 */
	boolean sortCity() {
		try {
			Collections.sort(addressBook.entries, (getComparator(LAST_NAME_SORT)));
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
	String printEntries() {
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
	public String[][] getEntriesDataPoints(){
		Person[] people = addressBook.getEntries().toArray(new Person[0]);
		if(people[0] == null)
			return new String[0][0];
		
		final int num_datapoints = people[o].getNumDataPoints();
		String[][] out = new String[people.length][num_datapoints];
		
		for(int i = 0; i < people.length; i++){
			if(people[i] != null){
				out[i] = people[i];
			}else{
				out[i] = new String[num_datapoints];
				for(int j = 0; j < num_datapoints; j++){
					out[i][j] = "";
				}
			}
		}
		return out;
	}

}
