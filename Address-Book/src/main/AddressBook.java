package main;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/*
 * Base AddressBook class
 * just contains a list of people - entries
 */
public class AddressBook implements Serializable{
	private static final long serialVersionUID = 1L;

	List<Person> entries;

/*
* creates the addressBook
*/
	public AddressBook(){
		entries = new ArrayList<Person>();
	}

	@Override
	public String toString(){
		String out = " Entries : ";
		for(Person p : entries.toArray(new Person[0]))
			out += " Person : "+p.toString();

		return out;
	}
}
