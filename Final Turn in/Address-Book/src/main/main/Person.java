package main;

import java.io.Serializable;

/*
 * create a new object, given an individual's name, address, city, state, ZIP, and phone
 * get the individual's first name, last name, address, city, state, ZIP, phone number
 * update the stored information (except the name) about the individual
 */
public class Person implements Serializable {
	/**
	 * 
	 */
	public static final long serialVersionUID = 1L;
	private String firstName;
	private String lastName;
	private String address;
	private String city;
	private String state;
	private String zip;
	private String phone;

	/*
	 * create a new object
	 */
	public Person(String firstName, String lastName, String address, String city, String state, String zip, String phone) {
		setFirstName(firstName);
		setLastName(lastName);
		setAddress(address);
		setCity(city);
		setState(state);
		setZip(zip);
		setPhone(phone);
	}

	/**
	 * @return the firstName
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * @param firstName
	 *            the firstName to set
	 */
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	/**
	 * @return the lastName
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * @param lastName
	 *            the lastName to set
	 */
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	/**
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * @param address
	 *            the address to set
	 */
	public void setAddress(String address) {
		this.address = address;
	}

	/**
	 * @return the city
	 */
	public String getCity() {
		return city;
	}

	/**
	 * @param city
	 *            the city to set
	 */
	public void setCity(String city) {
		this.city = city;
	}

	/**
	 * @return the state
	 */
	public String getState() {
		return state;
	}

	/**
	 * @param state
	 *            the state to set
	 */
	public void setState(String state) {
		this.state = state;
	}

	/**
	 * @return the zip
	 */
	public String getZip() {
		return zip;
	}

	/**
	 * @param zip
	 *            the zip to set
	 */
	public void setZip(String zip) {
		this.zip = zip;
	}

	/**
	 * @return the phone
	 */
	public String getPhone() {
		return phone;
	}

	/**
	 * @param phone
	 *            the phone to set
	 */
	public void setPhone(String phone) {
		this.phone = phone;
	}

	/**
	 * @return String List of the local variables currently are
	 */
	public String toString() {
		String out = "serialVersionUID : " + serialVersionUID;
		out += " LastName : " + lastName;
		out += " FirstName : " + firstName;
		out += " Address : " + getAddress();
		out += " City : " + getCity();
		out += " State : " + getState();
		out += " Zip : " + zip;
		out += " Phone : " + getPhone();
		return out;
	}
	
	/*
	 * returns a string array of the data
	 */
	public String[] getDataPoints(){
		return new String[]{
				lastName,
				firstName,
				phone,
				address,
				city,
				state,
				zip
		};
	}
	
	/*
	 * returns size of the data
	 */
	public int getNumDataPoints(){
		return getDataPoints().length;
	}

}
