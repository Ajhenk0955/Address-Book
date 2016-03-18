import java.awt.BorderLayout;
import java.awt.GridLayout;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class filterWindow {

	private JFrame Filter;
	private JComboBox<String> comboBox;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		filterWindow window = new filterWindow();
		System.out.println(window.getEnum());
	}

	/**
	 * Create the application.
	 */
	public filterWindow() {
	}
	public int getEnum(){
		return initialize();
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private int initialize() {
		Filter = new JFrame("Sort Options");
		Filter.setBounds(100, 100, 265, 118);
		Filter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel p = new JPanel(new BorderLayout(5,5));

        JPanel labels = new JPanel(new GridLayout(0,1,2,2));
        JPanel input = new JPanel(new GridLayout(0,1,2,2));
		
		JLabel lblSelectFilter = new JLabel("Select Filter :");
		labels.add(lblSelectFilter);

		comboBox = new JComboBox<String>( getSort() );
		input.add(comboBox);
		
		
		p.add(labels, BorderLayout.WEST);
		p.add(input, BorderLayout.CENTER);
		
		int result = JOptionPane.showConfirmDialog(Filter,  p, 
	               "Sort Settings", JOptionPane.OK_CANCEL_OPTION);
		
		return (result == JOptionPane.OK_OPTION)?
					comboBox.getSelectedIndex()
				:
					0;
		
	}
	private String[] getSort(){
		List<String> enums = new ArrayList<String>();
		enums.add("Last Name");
		enums.add("First Name");
		enums.add("ZIP descending");
		enums.add("ZIP ascending");
		return enums.toArray(new String[0]);
	}
}
