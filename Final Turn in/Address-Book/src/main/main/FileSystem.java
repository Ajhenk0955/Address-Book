package main;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;

/*
 * Read a stored address book from a file, given its file name
 * save an address book to a file, given its file name
 */
public class FileSystem {

	/*
	 * Returns address book at file location
	 */
	public AddressBook readFile(File file) {
		AddressBook addressBook;
		ObjectInputStream ois = null;
		try {
			FileInputStream fin = new FileInputStream(file);
			ois = new ObjectInputStream(fin);
			addressBook = (AddressBook) ois.readObject();
			ois.close();

			return addressBook;
		} catch (Exception e) {
			//e.printStackTrace();
			return null;
		}
	}

	/*
	 * Saves serialized file
	 */
	public boolean saveFile(AddressBook addressBook, File file) {
		ObjectOutputStream oos = null;
		try {
			FileOutputStream fout = new FileOutputStream(file);
			oos = new ObjectOutputStream(fout);
			oos.writeObject(addressBook);
			oos.close();
			return true;

		} catch (Exception e) {
			//e.printStackTrace();
			return false;
		}
	}

	public AddressBook loadFile(File file) {
		ObjectInputStream ois = null;
		try {
			AddressBook out = null;
			FileInputStream fin = new FileInputStream(file);
			ois = new ObjectInputStream(fin);
			out = (AddressBook) ois.readObject();
			ois.close();
			return out;

		} catch (Exception e) {
			//e.printStackTrace();
			return new AddressBook();
		}
	}
}
