package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class PersonEdit {

	private JFrame frmEdit;
	private JTextField LastNametxtbox;
	private JTextField FirstNametxtbox;
	private JTextField Phonetxtbox;
	private JTextField Streettxtbox;
	private JTextField Citytxtbox;
	private JTextField Statetxtbox;
	private JTextField Ziptxtbox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					PersonEdit window = new PersonEdit();
					window.frmEdit.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public PersonEdit() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEdit = new JFrame();
		frmEdit.setTitle("Edit");
		frmEdit.setBounds(100, 100, 351, 223);
		frmEdit.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEdit.getContentPane().setLayout(null);
		
		JLabel lblLastName = new JLabel("Last Name :");
		lblLastName.setBounds(10, 11, 57, 14);
		frmEdit.getContentPane().add(lblLastName);
		
		LastNametxtbox = new JTextField();
		LastNametxtbox.setBounds(77, 8, 86, 20);
		frmEdit.getContentPane().add(LastNametxtbox);
		LastNametxtbox.setColumns(10);
		
		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setBounds(173, 11, 55, 14);
		frmEdit.getContentPane().add(lblFirstName);
		
		FirstNametxtbox = new JTextField();
		FirstNametxtbox.setBounds(238, 8, 86, 20);
		frmEdit.getContentPane().add(FirstNametxtbox);
		FirstNametxtbox.setColumns(10);
		
		JLabel lblPhone = new JLabel("Phone # :");
		lblPhone.setBounds(10, 36, 48, 14);
		frmEdit.getContentPane().add(lblPhone);
		
		Phonetxtbox = new JTextField();
		Phonetxtbox.setBounds(77, 33, 86, 20);
		frmEdit.getContentPane().add(Phonetxtbox);
		Phonetxtbox.setColumns(10);
		
		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(10, 61, 46, 14);
		frmEdit.getContentPane().add(lblAddress);
		
		JLabel lblStreet = new JLabel("Street :");
		lblStreet.setBounds(20, 86, 37, 14);
		frmEdit.getContentPane().add(lblStreet);
		
		Streettxtbox = new JTextField();
		Streettxtbox.setBounds(77, 83, 86, 20);
		frmEdit.getContentPane().add(Streettxtbox);
		Streettxtbox.setColumns(10);
		
		JLabel lblCity = new JLabel(" City :");
		lblCity.setBounds(30, 111, 29, 14);
		frmEdit.getContentPane().add(lblCity);
		
		Citytxtbox = new JTextField();
		Citytxtbox.setBounds(77, 114, 86, 20);
		frmEdit.getContentPane().add(Citytxtbox);
		Citytxtbox.setColumns(10);
		
		JLabel lblState = new JLabel("State :");
		lblState.setBounds(173, 86, 46, 14);
		frmEdit.getContentPane().add(lblState);
		
		JLabel lblZip = new JLabel("ZIP :");
		lblZip.setBounds(173, 117, 46, 14);
		frmEdit.getContentPane().add(lblZip);
		
		Statetxtbox = new JTextField();
		Statetxtbox.setBounds(215, 83, 86, 20);
		frmEdit.getContentPane().add(Statetxtbox);
		Statetxtbox.setColumns(10);
		
		Ziptxtbox = new JTextField();
		Ziptxtbox.setBounds(215, 114, 86, 20);
		frmEdit.getContentPane().add(Ziptxtbox);
		Ziptxtbox.setColumns(10);
		
		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(74, 149, 89, 23);
		frmEdit.getContentPane().add(btnSubmit);
		
		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(173, 149, 89, 23);
		frmEdit.getContentPane().add(btnCancel);
	}
}
