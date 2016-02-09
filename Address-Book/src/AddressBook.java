import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;

/*
 * Base AddressBook
 * 
 */
public class AddressBook {
	private final 	Map<String, List<Person>> 
						alphabictic_sorted_people 
							= new LinkedHashMap<String, List<Person>>(),
						zip_sorted_people 
							= new LinkedHashMap<String, List<Person>>();
	/*
	 * Returns an ArrayList<Person> that has people with the last name beginning with 'letter'
	 * , null if none exist
	 */
	public List<Person> getLastNameList(char letter){
		return alphabictic_sorted_people.get(letter+"");
	}
	/*	
	 * Returns an ArrayList<Person> that has people with people in the Zip code
	 * , null if none exist
	 */
	public List<Person> getZipList(String zipCode){
		return zip_sorted_people.get(zipCode);
	}
	/*
	 * 
	 */
	public void add(Person p){
		addSubElement(alphabictic_sorted_people, p, p.getLastName().charAt(0)+"");
		addSubElement(zip_sorted_people, p, p.getZip());
	}
	/*
	 * 
	 */
	private void addSubElement(Map<String, List<Person>> m, Person p, String element){
		List<Person> letterList;
		if(m.containsKey(element ) )
			letterList = m.get(element);
		else
			letterList = new ArrayList<Person>();
		
		letterList.add(p);
		
		m.put(element, letterList);
	}
	/*
	 * 
	 */
	public Person getPersonByName(String first, String last){
		List<Person> familyName = getLastNameList(last.charAt(0));
		
		for(Person p : familyName.toArray(new Person[0]))
			if(p.getLastName().equals(last) && p.getFirstName().equals(first))
				return p;
		
		return null;
	}
}
