import java.util.Observable;

import javax.swing.AbstractListModel;
import javax.swing.JButton;
import javax.swing.JList;
import javax.swing.JMenuItem;

/**
 * 
 */

/**
 * Keep track of the address book object it is displaying Display a list of the
 * names of persons in the current address book display the title of the current
 * address book - if any maintain the state of the "Save" menu option - usable
 * only when the address book has been changed since the last time it was
 * opened/saved allow the user to request the performance of a use case
 *
 *TODO we should add an action listener
 */
public class AddressBookGUI {
	AddressBookController controller;
	private AddressBook addressBook;
	
	// TODO add type to listModel and NameList
	AbstractListModel<?> nameListModel;
	JList<?> nameList;
	JButton addButton;
	JButton editButton;
	JButton deleteButton;
	JButton sortByNameButton;
	JButton sortByZipButton;
	JMenuItem newItem;
	JMenuItem openItem;
	JMenuItem saveItem;
	JMenuItem saveAsItem;
	JMenuItem printItem;
	JMenuItem quitItem;

	// TODO arrange layout
	/*
	 * initialization
	 */
	AddressBookGUI(AddressBookController controller, AddressBook addressBook) {
		this.controller = controller;
		setAddressBook(addressBook);
		
		addButton = new JButton("add");
		editButton = new JButton("edit");
		deleteButton = new JButton("delete");
		sortByNameButton = new JButton("sort by name");
		sortByZipButton = new JButton("sort by ZIP");
		
		newItem = new JMenuItem("new item");
		openItem = new JMenuItem("open item");
		saveItem = new JMenuItem("save item");
		saveAsItem = new JMenuItem("save as item");
		printItem = new JMenuItem("print item");
		quitItem = new JMenuItem("quit item");
		
	}

	/**
	 * @return the addressBook
	 */
	AddressBook getAddressBook() {
		return addressBook;
	}
	
	/**
	 * @param the addressBook
	 * TODO
	 */
	void setAddressBook(AddressBook addressBook) {
		this.addressBook = addressBook;
	}

	// TODO
	void reportError(String message) {

	}

	// TODO
	void update(Observable o, Object arg) {

	}
}
