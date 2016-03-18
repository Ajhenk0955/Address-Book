package unit;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import main.Person;

/*
 * unit testing for class person
 */
public class PersonTest {

	Person person;


	/*
	 * test string output
	 */
	@Test
	public void testNewPerson(){
		String firstName = "Joe";
		String lastName = "Bob";
		String address = "kowloon ln";
		String city = "Punta Rassa";
		String state = "FL";
		String zip = "33333";
		String phone = "000-000-000";
			
		person = new Person(firstName, lastName, address, city, state, zip, phone);
		String output = "serialVersionUID : " + person.serialVersionUID;
		output += " LastName : " + lastName;
		output += " FirstName : " + firstName;
		output += " Address : " + address;
		output += " City : " + city;
		output += " State : " + state;
		output += " Zip : " + zip;
		output += " Phone : " + phone;
		
		assertEquals(output, person.toString());
	}
	/*
	 * test to check to String method still need to update the output string
	 * TODO
	 */
	@Test
	public void testToString() {
		String firstName = "Joe";
		String lastName = "Bob";
		String address = "kowloon ln";
		String city = "Punta Rassa";
		String state = "FL";
		String zip = "33333";
		String phone = "000-000-000";
			
		person = new Person(firstName, lastName, address, city, state, zip, phone);
		
		String output = "serialVersionUID : " + person.serialVersionUID;
		output += " LastName : " + lastName;
		output += " FirstName : " + firstName;
		output += " Address : " + address;
		output += " City : " + city;
		output += " State : " + state;
		output += " Zip : " + zip;
		output += " Phone : " + phone;
		
		assertEquals(output, person.toString());
	}

}
