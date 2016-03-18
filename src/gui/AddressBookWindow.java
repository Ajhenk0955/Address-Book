import java.awt.BorderLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTable;
import javax.swing.table.DefaultTableModel;
import javax.swing.JLabel;

import main.AddressBook;
import main.AddressBookController;
import main.Person;

public class AddressBookWindow {
	private AddressBookController addrBook = new AddressBookController(new AddressBook());
	private JFrame frmAddressBooklet;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		@SuppressWarnings("unused")
		AddressBookWindow window = new AddressBookWindow();
	}

	/**
	 * Create the application.
	 */
	public AddressBookWindow() {
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
		frmAddressBooklet.setVisible(true);

		JPanel panel = new JPanel();
		frmAddressBooklet.getContentPane().add(panel, BorderLayout.NORTH);
		GridBagLayout gbl_panel = new GridBagLayout();
		gbl_panel.columnWidths = new int[] { 50, 55, 0, 0, 0, 29, 0, 0, 0, 0, 0, 0, 0 };
		gbl_panel.rowHeights = new int[] { 30, 0 };
		gbl_panel.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		gbl_panel.rowWeights = new double[] { 1.0, Double.MIN_VALUE };
		panel.setLayout(gbl_panel);

		JButton btnLoad = new JButton("Load");
		SimpleButtonFileDialog fileDialog = new SimpleButtonFileDialog(btnLoad);
		btnLoad.addActionListener(new LoadAction(fileDialog));
		GridBagConstraints gbc_btnLoad = new GridBagConstraints();
		gbc_btnLoad.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnLoad.insets = new Insets(0, 0, 0, 5);
		gbc_btnLoad.gridx = 0;
		gbc_btnLoad.gridy = 0;
		panel.add(btnLoad, gbc_btnLoad);

		JButton btnSave = new JButton("Save");
		btnSave.addActionListener(new LoadAction(fileDialog));
		GridBagConstraints gbc_btnSave = new GridBagConstraints();
		gbc_btnSave.insets = new Insets(0, 0, 0, 5);
		gbc_btnSave.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnSave.gridx = 1;
		gbc_btnSave.gridy = 0;
		panel.add(btnSave, gbc_btnSave);

		JButton btnFind = new JButton("Find");
		btnFind.addActionListener(new FindAction());
		GridBagConstraints gbc_btnFind = new GridBagConstraints();
		gbc_btnFind.insets = new Insets(0, 0, 0, 5);
		gbc_btnFind.anchor = GridBagConstraints.NORTHEAST;
		gbc_btnFind.gridx = 8;
		gbc_btnFind.gridy = 0;
		panel.add(btnFind, gbc_btnFind);

		JButton btnAdd = new JButton("Add");
		btnAdd.addActionListener(new AddAction());
		GridBagConstraints gbc_btnAdd = new GridBagConstraints();
		gbc_btnAdd.insets = new Insets(0, 0, 0, 5);
		gbc_btnAdd.anchor = GridBagConstraints.NORTHEAST;
		gbc_btnAdd.gridx = 9;
		gbc_btnAdd.gridy = 0;
		panel.add(btnAdd, gbc_btnAdd);

		JButton btnEdit = new JButton("Edit");
		btnEdit.addActionListener(new EditAction());
		GridBagConstraints gbc_btnEdit = new GridBagConstraints();
		gbc_btnEdit.insets = new Insets(0, 0, 0, 5);
		gbc_btnEdit.anchor = GridBagConstraints.NORTHEAST;
		gbc_btnEdit.gridx = 10;
		gbc_btnEdit.gridy = 0;
		panel.add(btnEdit, gbc_btnEdit);

		JButton btnSort = new JButton("Sort");
		btnSort.addActionListener(new SortAction());
		GridBagConstraints gbc_btnSort = new GridBagConstraints();
		gbc_btnSort.anchor = GridBagConstraints.NORTHEAST;
		gbc_btnSort.gridx = 11;
		gbc_btnSort.gridy = 0;
		panel.add(btnSort, gbc_btnSort);

		JScrollPane scrollPane = new JScrollPane();
		frmAddressBooklet.getContentPane().add(scrollPane, BorderLayout.CENTER);
		table = new JTable();
		updateTable();
		scrollPane.setViewportView(table);

		JLabel label = new JLabel("        ");
		scrollPane.setRowHeaderView(label);
		
		frmAddressBooklet.invalidate();
		frmAddressBooklet.repaint();
	}
	/**
	 * Reload the elements to the table
	 */
	private void updateTable(){
		table.setModel(new DefaultTableModel(
				addrBook.getEntriesDataPoints(),
				new String[] { "Last Name", "First Name", "Phone Number", "Street Address", "City", "State",
				"ZIP code" }) {
					private static final long serialVersionUID = 3361446288819744958L;
			@SuppressWarnings("rawtypes")
			Class[] columnTypes = new Class[] { String.class, String.class, String.class, String.class, String.class,
					String.class, String.class };

			@SuppressWarnings({ "unchecked", "rawtypes" })
			public Class getColumnClass(int columnIndex) {
				return columnTypes[columnIndex];
			}
		});
	}
	/**
	 * Load File action listener
	 * @author eyez
	 *
	 */
	class LoadAction implements ActionListener{
		private SimpleButtonFileDialog dialogBox;
		private Map<String, String[]> file_types = new HashMap<String, String[]>();
		/**
		 * 
		 * @param fileDialog, The File Dialog to launch on click
		 */
		public LoadAction(SimpleButtonFileDialog fileDialog){
			dialogBox = fileDialog;
		}
		/**
		 * 
		 */
		@SuppressWarnings("unused")
		private void loadFileTypes(){
			//map.put("Title, { file extensions});
			file_types.put("Address Book File", 
							new String[]{
								".adbk"
			});
		}
		/**
		 * Autofill
		 * @param e
		 */
		public void actionPerformed(ActionEvent e){
			try{
				addrBook.loadFile(dialogBox.toLoadFile());
				
			} catch (IOException e1) {
				return;
			}
			updateTable();
		}
	}
	/**
	 * Save addrbook to file
	 * @author eyez
	 *
	 */
	class SaveAction implements ActionListener{
		private SimpleButtonFileDialog dialogBox;
		/**
		 * 
		 * @param fileDialog, the file Dialog to use on action seg
		 */
		public SaveAction(SimpleButtonFileDialog fileDialog){
			dialogBox = fileDialog;
		}
		/**
		 * 
		 * @param e
		 */
		public void actionPerformed(ActionEvent e){
			addrBook.saveAddressBook(dialogBox.toSaveFile());
			updateTable();
		}
	}
	/**
	 * Locate Person from the addrBook on release
	 * @author eyez
	 *
	 */
	class FindAction implements ActionListener{
		/**
		 * 
		 * @param e
		 */
		public void actionPerformed(ActionEvent e){
			PersonEdit prompt = new PersonEdit("Search Filter");
			prompt.setNamesPrompt();
			String[] data = prompt.getOutput();
			Person p;
			try{
				p = addrBook.getPerson(data[0], data[1]);
			}catch(NullPointerException e4){
				return;
			}
			String[][] person = new String[][]{p.getDataPoints()};
			
			table.setModel(new DefaultTableModel(
					person,
					new String[] { "Last Name", "First Name", "Phone Number", "Street Address", "City", "State",
					"ZIP code" }) {
						private static final long serialVersionUID = 3361446288819744958L;
				@SuppressWarnings("rawtypes")
				Class[] columnTypes = new Class[] { String.class, String.class, String.class, String.class, String.class,
						String.class, String.class };

				@SuppressWarnings({ "unchecked", "rawtypes" })
				public Class getColumnClass(int columnIndex) {
					return columnTypes[columnIndex];
				}
			});
		}
	}
	/**
	 * Opens new person prompt window on action release
	 * @author eyez
	 *
	 */
	class AddAction implements ActionListener{
		/**
		 * 
		 * @param e
		 */
		public void actionPerformed(ActionEvent e){
			String[] data = new PersonEdit("Add Person").getOutput();
			
			try{
				addrBook.addPerson(data[1],//first 
					data[0], //last
					data[3], //Street
					data[4], //city
					data[5], //state
					data[6], //zip
					data[2]);//phone
			}catch(NullPointerException e5){
				return;
			}
			updateTable();
		}
	}
	/**
	 * open Edit person prompt if a table element is selected
	 * @author eyez
	 *
	 */
	class EditAction implements ActionListener{
		/**
		 * 
		 * @param e
		 */
		public void actionPerformed(ActionEvent e){
			int row = table.getSelectedRow();
			String[] in_data;
			try{
			in_data = new String[] {
					(String) table.getValueAt(row, 0),
					(String) table.getValueAt(row, 1),
					(String) table.getValueAt(row, 2),
					(String) table.getValueAt(row, 3),
					(String) table.getValueAt(row, 4),
					(String) table.getValueAt(row, 5),
					(String) table.getValueAt(row, 6)};
			}catch(ArrayIndexOutOfBoundsException e2){
				updateTable();
				return;
			}
			String[] out_data = new PersonEdit("Edit Contact", in_data).getOutput();
			addrBook.editPerson(row, 
					out_data[1],//first 
					out_data[0], //last
					out_data[3], //street
					out_data[4], //city
					out_data[5], //state
					out_data[6], //zip
					out_data[2]);//phone
			updateTable();
		}
	}
	/**
	 * Opens sort prompt and applies to the table
	 * @author eyez
	 *
	 */
	class SortAction implements ActionListener{
		public SortAction(){
		}
		/**
		 * 
		 * @param e
		 */
		public void actionPerformed(ActionEvent e){
			filterWindow filt = new filterWindow();
			int Selection = filt.getEnum();
			addrBook.sortValue(Selection);
			updateTable();
		}
	}
}