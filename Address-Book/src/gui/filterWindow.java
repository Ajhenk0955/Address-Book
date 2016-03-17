package gui;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class filterWindow {

	private JFrame Filter;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					filterWindow window = new filterWindow();
					window.Filter.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public filterWindow() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Filter = new JFrame();
		Filter.setBounds(100, 100, 218, 118);
		Filter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Filter.getContentPane().setLayout(null);
		
		JLabel lblSelectFilter = new JLabel("Select Filter :");
		lblSelectFilter.setBounds(10, 18, 71, 14);
		Filter.getContentPane().add(lblSelectFilter);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(105, 15, 60, 20);
		Filter.getContentPane().add(comboBox);
		
		JButton btnFilter = new JButton("Filter");
		btnFilter.setBounds(51, 46, 89, 23);
		Filter.getContentPane().add(btnFilter);
	}
}
