package main;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/*
 * Base AddressBook class
 * 
 */
public class AddressBook implements Serializable{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	List<Person> entries;
	
	public AddressBook(){
		entries = new ArrayList<Person>();
	}
	public void addPerson(Person p){
		entries.add(p);
	}
	public void addPeople(Collection<Person> p){
		entries.addAll(p);
	}
	public Person findPerson(String lastName, String firstName){
		for(Person p : entries.toArray(new Person[0])){
			if(p.getLastName().equals(lastName)
					&& p.getFirstName().equals(firstName))
				return p;
		}
		return null;
	}
	@Override
	public String toString(){
		String out = " Entries : ";
		for(Person p : entries.toArray(new Person[0]))
			out += " Person : "+p.toString();
		
		return out;
	}
}