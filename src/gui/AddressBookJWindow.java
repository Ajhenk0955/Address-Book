package gui;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import java.awt.GridBagLayout;
import javax.swing.JButton;
import java.awt.GridBagConstraints;
import java.awt.GridLayout;
import java.awt.Insets;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;
import javax.swing.ListSelectionModel;

public class AddressBookJWindow {
	private AddressBookController addrBookCtrl = new AddressBookController(null);
	private JFrame frmAddressBooklet;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		AddressBookJWindow window = new AddressBookJWindow();
		window.frmAddressBooklet.setVisible(true);
	}

	/**
	 * Create the application.
	 */
	public AddressBookJWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmAddressBooklet = new JFrame();
		frmAddressBooklet.setTitle("Address Booklet");
		frmAddressBooklet.setBounds(100, 100, 520, 300);
		frmAddressBooklet.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmAddressBooklet.getContentPane().setLayout(new BorderLayout(0, 0));

		JPanel panel = new JPanel();
		frmAddressBooklet.getContentPane().add(panel, BorderLayout.NORTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 50, 55, 0, 0, 0, 29, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 30, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);
		
		SimpleButtonFileDialog fileDialog = new SimpleButtonFileDialog(this);
		
		JButton btnLoad = new JButton("Load");
		btnLoad.addActionListener(new LoadAction(fileDialog, addrBookCtrl));
		GridBagConstraints gbc_btnLoad = new GridBagConstraints();
		gbc_btnLoad.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnLoad.insets = new Insets(0, 0, 0, 5);
		gbc_btnLoad.gridx = 0;
		gbc_btnLoad.gridy = 0;
		panel.add(btnLoad, gbc_btnLoad);

		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new LoadAction(fileDialog, addrBookCtrl));
		GridBagConstraints gbc_btnSave = new GridBagConstraints();
		gbc_btnSave.insets = new Insets(0, 0, 0, 5);
		gbc_btnSave.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnSave.gridx = 1;
		gbc_btnSave.gridy = 0;
		panel.add(btnSave, gbc_btnSave);

		JButton btnFind = new JButton("Find");
		btnSave.addActionListener(new FindAction());
		GridBagConstraints gbc_btnFind = new GridBagConstraints();
		gbc_btnFind.insets = new Insets(0, 0, 0, 5);
		gbc_btnFind.anchor = GridBagConstraints.NORTHEAST;
		gbc_btnFind.gridx = 8;
		gbc_btnFind.gridy = 0;
		panel.add(btnFind, gbc_btnFind);

		JButton btnAdd = new JButton("Add");
		btnSave.addActionListener(new AddAction());
		GridBagConstraints gbc_btnAdd = new GridBagConstraints();
		gbc_btnAdd.insets = new Insets(0, 0, 0, 5);
		gbc_btnAdd.anchor = GridBagConstraints.NORTHEAST;
		gbc_btnAdd.gridx = 9;
		gbc_btnAdd.gridy = 0;
		panel.add(btnAdd, gbc_btnAdd);

		JButton btnEdit = new JButton("Edit");
		btnSave.addActionListener(new EditAction());
		GridBagConstraints gbc_btnEdit = new GridBagConstraints();
		gbc_btnEdit.insets = new Insets(0, 0, 0, 5);
		gbc_btnEdit.anchor = GridBagConstraints.NORTHEAST;
		gbc_btnEdit.gridx = 10;
		gbc_btnEdit.gridy = 0;
		panel.add(btnEdit, gbc_btnEdit);

		JButton btnFilter = new JButton("Filter");
		btnSave.addActionListener(new FilterAction());
		GridBagConstraints gbc_btnFilter = new GridBagConstraints();
		gbc_btnFilter.anchor = GridBagConstraints.EAST;
		gbc_btnFilter.gridx = 11;
		gbc_btnFilter.gridy = 0;
		panel.add(btnFilter, gbc_btnFilter);

		JScrollPane scrollPane = new JScrollPane();
		frmAddressBooklet.getContentPane().add(scrollPane, BorderLayout.CENTER);
		String[][] entries = addrBookCtrl.getEntriesDataPoints(); 
		table = new JTable();
		updateTable();
		scrollPane.setViewportView(table);

		JLabel label = new JLabel("        ");
		scrollPane.setRowHeaderView(label);
	}
	private updateTable(){
		table.setModel(new DefaultTableModel(
				entries,
				new String[] { "Last Name", "First Name", "Phone Number", "Street Address", "City", "State",
						"ZIP code" }) {
			Class[] columnTypes = new Class[] { String.class, String.class, String.class, String.class, String.class,
					String.class, String.class };

			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
	}
}
class LoadAction implements ActionListener{
	private SimpleButtonFileDialog dialogBox;
	private AddressBookController addrBook;
	/**
	 * 
	 * @param fileDialog
	 * @param addrBookCtrl
	 */
	public LoadAction(SimpleButtonFileDialog fileDialog, AddressBookController addrBookCtrl){
		dialogBox = fileDialog;
		addrBook = addrBookCtrl;
	}
	/**
	 * 
	 * @param e
	 */
	void actionPerformed(ActionEvent e){
		try{
			addrBook.LoadAddressBook(dialogBox.toLoadFile());
		}catch(IOException e1){
			JOptionPane.showMessageDialog(new JFrame(),
				    "File Loading Error",
				    "File Error",
				    JOptionPane.ERROR_MESSAGE);
		}
	}
}
class SaveAction implements ActionListener{
	private SimpleButtonFileDialog dialogBox;
	private AddressBookController addrBook;
	/**
	 * 
	 * @param fileDialog
	 * @param addrBookCtrl
	 */
	public SaveAction(SimpleButtonFileDialog fileDialog, AddressBookController addrBookCtrl){
		dialogBox = fileDialog;
		addrBook = addrBookCtrl;
	}
	/**
	 * 
	 * @param e
	 */
	void actionPerformed(ActionEvent e){
		addrBook.SaveAddressBook(dialogBox.toSaveFile());
	}
}
class FindAction implements ActionListener{
	/**
	 * 
	 * @param e
	 */
	void actionPerformed(ActionEvent e){
	}
}
class AddAction implements ActionListener{
	/**
	 * 
	 * @param e
	 */
	void actionPerformed(ActionEvent e){
	}
}
class EditAction implements ActionListener{
	/**
	 * 
	 * @param e
	 */
	void actionPerformed(ActionEvent e){
	}
}class FilterAction implements ActionListener{
	/**
	 * 
	 * @param e
	 */
	void actionPerformed(ActionEvent e){
	}
}