package unit;

import org.junit.runner.RunWith;
import org.junit.runners.Suite;
import org.junit.runners.Suite.SuiteClasses;
/*
 * runs all unit tests
 */
@RunWith(Suite.class)
@SuiteClasses({ AddressBookControllerTest.class, FileSystemTest.class, PersonTest.class })
public class AllTests {

}
