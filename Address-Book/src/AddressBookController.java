import java.io.File;

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
	 * TODO
	 */
	void addPerson() {

	}

	/*
	 * TODO
	 */
	void editPerson() {

	}

	/*
	 * TODO
	 */
	void deletePerson() {

	}

	/*
	 * TODO
	 */
	void sortName() {

	}

	/*
	 * TODO
	 */
	void sortZIP() {

	}

	/*
	 * TODO
	 */
	void createAddressBook() {
		addressBook = new AddressBook();
	}

	/*
	 * Opens current addressBook located at file
	 */
	void updateAddressBook() {
		FileSystem filesystem = new FileSystem();
		addressBook = filesystem.readFile(file);
	}

	/*
	 * Saves current address book
	 */
	void saveAddressBook() {
		FileSystem filesystem = new FileSystem();
		filesystem.saveFile(addressBook, file);
	}

	/*
	 * TODO
	 */
	void printEntries() {
		addressBook.print();
	}
}
