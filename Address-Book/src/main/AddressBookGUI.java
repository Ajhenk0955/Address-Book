package main;
import java.util.Observable;
import java.util.Scanner;

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
	private AddressBookController controller;
	
	// TODO add type to listModel and NameList
	private AbstractListModel<?> nameListModel;
	private JList<?> nameList;
	private JButton  addButton;
	private JButton editButton;
	private JButton deleteButton;
	private JButton  sortByNameButton;
	private JButton sortByZipButton;
	private JMenuItem newItem;
	private JMenuItem openItem;
	private JMenuItem saveItem;
	private JMenuItem saveAsItem;
	private JMenuItem printItem;
	private JMenuItem quitItem;

	// TODO arrange layout
	/*
	 * initialization
	 */
	AddressBookGUI(AddressBookController controller) {
		this.controller = controller;
		
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

	// TODO
	void reportError(String message) {

	}

	// TODO
	void update(Observable o, Object arg) {

	}
	@SuppressWarnings("resource")
	public static void main(String args[]){
		//System.out.println("01234567890".substring(0, 3));
		Scanner in = new Scanner(System.in);
		String file = "";
		String cmd;
		do{	
			System.out.println("Please type a command (? for a list)");
			
			AddressBookController addrBook = new AddressBookController(new AddressBook() );
			cmd = in.nextLine().toLowerCase();
			switch( (cmd+"    ").substring(0, 4)){
				case("add "):
					System.out.println("\tcmd insert");
					break;
				case("?   "):
					System.out.println("\texit : to quit the program\n"
							+ "\tadd : add a person to the book\n"
							+ "\tload : open the save to load an old book\n"
							+ "\tsave : save the book\n"
							+ "\tfind : load a person with all their information\n"
							+ "\tlist : shows the list of everybody");
					break;
				case("load"):
					System.out.println("\tcmd open");
					break;
				case("list"):
					System.out.println("\tcmd show");
					break;
				case("find"):
					System.out.println("\tcmd search");
					break;
			}
			System.out.println();		
		}while( !cmd.contains("exit") );
	}
}
