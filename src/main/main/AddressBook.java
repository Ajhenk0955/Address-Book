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

	protected List<Person> entries;

	public AddressBook() {
		entries = new ArrayList<Person>();
	}

	@Override
	public String toString() {
		String out ="serialVersionUID : " + serialVersionUID +
				" Entries : ";
		for (Person p : entries.toArray(new Person[0]))
			out += " Person : " + p.toString();

		return out;
	}
}