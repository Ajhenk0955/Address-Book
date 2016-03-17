package main;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;

@RunWith(Suite.class)
@SuiteClasses({ AddressBookControllerTest.class, AddressBookGUITest.class, AddressBookTest.class,
		FileSystemTest.class })
public class AllTests {

}
