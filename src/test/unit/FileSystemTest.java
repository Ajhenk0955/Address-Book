package unit;

import static org.junit.Assert.*;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.AddressBook;
import main.FileSystem;

/*
 * unit test for filesystem creation
 */
public class FileSystemTest {
	FileSystem filesys = new FileSystem();
	File file;

	/*
	 * Set up the save file for the test to load putting the target person in
	 * the middle
	 */
	@Before
	public void setUp() throws Exception {
		file = new File("FileSysTest.jok");
		FileOutputStream fout = new FileOutputStream(file);
		ObjectOutputStream oos = new ObjectOutputStream(fout);
		oos.writeObject( new AddressBook() );
		oos.close();
	}

	/*
	 * Test to see if addressbookcontroller correctly loads from the file
	 */
	@Test
	public void loadTest(){
		filesys.loadFile(file);
	}
	@Test
	public void readTest(){
		filesys.readFile(file);
	}
	@Test
	public void IOExceptionReadTest(){
		assertNull(filesys.readFile(null));
	}
	@Test
	public void IOExceptionLoadAddressBookTest(){
		assertNotNull(filesys.loadFile(null) );
	}
	@Test
	public void IOExceptionSaveFile(){
		assertFalse( filesys.saveFile(new AddressBook(), null) );
	}
}
