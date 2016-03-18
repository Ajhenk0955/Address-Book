package unit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
/*
 * runs all unit tests
 */
@RunWith(Suite.class)
@SuiteClasses({ AddressBookControllerTest.class, AddressBookGUITest.class, FileSystemTest.class })
public class AllTests {

}
