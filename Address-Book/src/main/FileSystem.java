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
	AddressBook readFile(File file) {
		AddressBook addressBook;
		
		try{
			FileInputStream fin = new FileInputStream(file);
			ObjectInputStream ois = new ObjectInputStream(fin);
			addressBook = (AddressBook) ois.readObject();
			ois.close();
			
			return addressBook;
		}catch(Exception e){
			e.printStackTrace();
			return null;
		}
	}

	/*
	 * Saves serialized file
	 */
	boolean saveFile(AddressBook addressBook, File file) throws IOException {
		try{
			FileOutputStream fout = new FileOutputStream(file);
			ObjectOutputStream oos = new ObjectOutputStream(fout);
			oos.writeObject(addressBook);
			oos.close();
			return true;
			
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}
}
