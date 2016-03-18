

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

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
	
	private Semaphore mutex = new Semaphore(1);
	private String[] input = null,
						output = new String[7];
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		PersonEdit window = new PersonEdit("Create Person");
		System.out.println(window.getOutput()[0] );
	}

	/**
	 * Create the application.
	 */
	public PersonEdit(String Title) {
		for(int i  = 0; i < output.length ; i++)
			output[i] = "";
		initialize(Title);
	}
	public PersonEdit(String Title, String[] args) {
		input = args;
		initialize(Title);
	}
	public String[] getOutput(){
		try {
			mutex.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		mutex.release();
		return output;
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize(String Title) {
		try {
			mutex.acquire();
		} catch (InterruptedException e1) {
			e1.printStackTrace();
		}
		frmEdit = new JFrame();
		frmEdit.setTitle(Title);
		frmEdit.setBounds(100, 100, 353, 223);
		frmEdit.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEdit.getContentPane().setLayout(null);
		frmEdit.addWindowListener(new WindowListener(){
			public void windowActivated(WindowEvent e) {
			}
			public void windowClosing(WindowEvent e) {
				mutex.release();
			}
			public void windowDeactivated(WindowEvent e) {
			}
			public void windowDeiconified(WindowEvent e) {
			}
			public void windowIconified(WindowEvent e) {
			}
			public void windowOpened(WindowEvent e) {
			}
			public void windowClosed(WindowEvent e) {
				mutex.release();
			}
		});

		JLabel lblLastName = new JLabel("Last Name :");
		lblLastName.setBounds(10, 11, 70, 14);
		frmEdit.getContentPane().add(lblLastName);

		LastNametxtbox = new JTextField();
		LastNametxtbox.setBounds(77, 8, 86, 20);
		frmEdit.getContentPane().add(LastNametxtbox);
		LastNametxtbox.setColumns(10);
		if(input != null){
			LastNametxtbox.setText(input[0]);
		}

		JLabel lblFirstName = new JLabel("First Name:");
		lblFirstName.setBounds(173, 11, 70, 14);
		frmEdit.getContentPane().add(lblFirstName);

		FirstNametxtbox = new JTextField();
		FirstNametxtbox.setBounds(238, 8, 86, 20);
		frmEdit.getContentPane().add(FirstNametxtbox);
		FirstNametxtbox.setColumns(10);
		if(input != null){
			FirstNametxtbox.setText(input[1]);
		}

		JLabel lblPhone = new JLabel("Phone # :");
		lblPhone.setBounds(10, 36, 60, 14);
		frmEdit.getContentPane().add(lblPhone);

		Phonetxtbox = new JTextField();
		Phonetxtbox.setBounds(77, 33, 86, 20);
		frmEdit.getContentPane().add(Phonetxtbox);
		Phonetxtbox.setColumns(10);
		if(input != null){
			Phonetxtbox.setText(input[2]);
		}

		JLabel lblAddress = new JLabel("Address");
		lblAddress.setBounds(10, 61, 60, 14);
		frmEdit.getContentPane().add(lblAddress);

		JLabel lblStreet = new JLabel("Street :");
		lblStreet.setBounds(20, 86, 50, 14);
		frmEdit.getContentPane().add(lblStreet);

		Streettxtbox = new JTextField();
		Streettxtbox.setBounds(77, 83, 86, 20);
		frmEdit.getContentPane().add(Streettxtbox);
		Streettxtbox.setColumns(10);
		if(input != null){
			Streettxtbox.setText(input[3]);
		}

		JLabel lblCity = new JLabel(" City :");
		lblCity.setBounds(30, 116, 30, 14);
		frmEdit.getContentPane().add(lblCity);

		Citytxtbox = new JTextField();
		Citytxtbox.setBounds(77, 114, 86, 20);
		frmEdit.getContentPane().add(Citytxtbox);
		Citytxtbox.setColumns(10);
		if(input != null){
			Citytxtbox.setText(input[4]);
		}

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
		if(input != null){
			Statetxtbox.setText(input[5]);
		}

		Ziptxtbox = new JTextField();
		Ziptxtbox.setBounds(215, 114, 86, 20);
		frmEdit.getContentPane().add(Ziptxtbox);
		Ziptxtbox.setColumns(10);
		if(input != null){
			Ziptxtbox.setText(input[6]);
		}

		JButton btnSubmit = new JButton("Submit");
		btnSubmit.setBounds(74, 149, 89, 23);
		frmEdit.getContentPane().add(btnSubmit);
		btnSubmit.addActionListener(new ActionListener(){

			public void actionPerformed(ActionEvent arg0) {
				List<String> out = new ArrayList<String>();
				out.add(getText(LastNametxtbox));
				out.add(getText(FirstNametxtbox));
				out.add(getText(Phonetxtbox));
				out.add(getText(Streettxtbox));
				out.add(getText(Citytxtbox));
				out.add(getText(Statetxtbox));
				out.add(getText(Ziptxtbox));
				output = out.toArray(new String[0]);
				mutex.release();
				frmEdit.dispose();
			}
		});

		JButton btnCancel = new JButton("Cancel");
		btnCancel.setBounds(173, 149, 89, 23);
		frmEdit.getContentPane().add(btnCancel);
		

		frmEdit.setVisible(true);
	}
	private String getText(JTextField txtfield){
		String out = txtfield.getText();
		if(out != null)
			return out;
		else
			return "";
	}
}
