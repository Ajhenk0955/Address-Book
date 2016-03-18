package main;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/*
 * Base AddressBook class
 * 
 */
public class AddressBook implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public List<Person> entries;

	public AddressBook() {
		entries = new ArrayList<Person>();
	}

	/* prints the string output with the serialUID
	 * (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		String out ="serialVersionUID : " + serialVersionUID +
				" Entries : ";
		for (Person p : entries.toArray(new Person[0]))
			out += " Person : " + p.toString();

		return out;
	}
}