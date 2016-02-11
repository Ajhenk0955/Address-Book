package main;
import java.io.Serializable;
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
}