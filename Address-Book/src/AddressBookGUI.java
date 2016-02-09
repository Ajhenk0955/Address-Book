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
 */
public class AddressBookGUI {
	AddressBookController controller;
	AddressBook addressBook;
	// TODO add type to listModel and NameList
	AbstractListModel<?> nameListModel;
	JList<?> nameList;
	JButton addButton;
	JButton editButton;
	JButton deleteButton;
	JButton sortByNameButton;
	JButton sortByZipBUtton;
	JMenuItem newItem;
	JMenuItem openItem;
	JMenuItem saveItem;
	JMenuItem saveAsItem;
	JMenuItem printItem;
	JMenuItem quitItem;

	// TODO
	AddressBookGUI(AddressBookController controller, AddressBook addressBook) {

	}

	// TODO
	AddressBook getAddressBook() {
		return null;
	}

	// TODO
	void setAddressBook(AddressBook addressBook) {

	}

	// TODO
	void reportError(String message) {

	}

	// TODO
	void update(Observable o, Object arg) {

	}
}
