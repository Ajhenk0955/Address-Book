package main;
import java.io.File;
import java.io.IOException;
import java.util.Collections;
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
	void addPerson(String firstName, String lastName, String address, String city, String state, String zip,
			String phone) {
		addressBook.entries.add(new Person(firstName, lastName, address, city, state, zip, phone));
	}

	/*
	 * edits a person in a list
	 */
	void editPerson(int index, String firstName, String lastName, String address, String city, String state, String zip,
			String phone) {
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
	}

	/*
	 * deletes a person in a list
	 */
	void deletePerson(int index) {
		addressBook.entries.remove(index);
	}

	/*
	 * Sorts by first name
	 */
	void sortName() {
		Collections.sort(addressBook.entries, decending(getComparator(NAME_SORT)));
	}

	/*
	 * Sorts by first name
	 */
	void sortZIP() {
		Collections.sort(addressBook.entries, decending(getComparator(ZIP_SORT)));
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
	void updateAddressBook(File file) {
		this.file = file;
		FileSystem filesystem = new FileSystem();
		addressBook = filesystem.readFile(file);
	}

	/*
	 * Saves current address book without being given file
	 */
	void saveAddressBook() throws IOException {
		if(file == null)
			return;
		FileSystem filesystem = new FileSystem();
		filesystem.saveFile(addressBook, file);
	}
	
	/*
	 * Saves current address book if given file
	 */
	void saveAddressBook(File file) throws IOException {
		FileSystem filesystem = new FileSystem();
		filesystem.saveFile(addressBook, file);
	}

	/*
	 * Prints each entry in the current addressBook
	 */
	void printEntries() {
		for(Person temp:addressBook.entries){
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
