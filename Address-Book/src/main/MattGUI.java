package main;

import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.EventQueue;
import java.awt.FlowLayout;
import java.awt.GridLayout;
import java.awt.List;
import java.awt.Panel;
import java.awt.TextField;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;
import javax.swing.JTextField;

import javafx.event.EventHandler;

public class MattGUI {

	private JFrame frame;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MattGUI window = new MattGUI();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public MattGUI() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 600, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		Panel panel = new Panel();
		frame.getContentPane().add(panel, BorderLayout.NORTH);
		panel.setLayout(new BorderLayout(0, 0));
		
		Panel panel_2 = new Panel();
		FlowLayout flowLayout_1 = (FlowLayout) panel_2.getLayout();
		flowLayout_1.setAlignment(FlowLayout.LEFT);
		panel.add(panel_2);
		
		Button button = new Button("New button");
		panel_2.add(button);
		
		Panel panel_3 = new Panel();
		FlowLayout flowLayout_2 = (FlowLayout) panel_3.getLayout();
		flowLayout_2.setAlignment(FlowLayout.RIGHT);
		panel.add(panel_3);
		
		TextField textField = new TextField();
		panel_3.add(textField);
		
		Panel panel_4 = new Panel();
		panel.add(panel_4);
		panel_4.setLayout(new GridLayout(0, 2, 0, 0));
		
		Panel panel_8 = new Panel();
		panel_4.add(panel_8);
		panel_8.setLayout(new GridLayout(0, 2, 0, 0));
		
		Button button_2 = new Button("Menu");
		panel_8.add(button_2);
		
		Button button_3 = new Button("Save Changes");
		panel_8.add(button_3);
		
		Panel panel_9 = new Panel();
		panel_4.add(panel_9);
		panel_9.setLayout(new GridLayout(0, 1, 0, 0));
		
		TextField textField_7 = new TextField();
		panel_9.add(textField_7);
		
		Panel panel_1 = new Panel();
		frame.getContentPane().add(panel_1, BorderLayout.SOUTH);
		panel_1.setLayout(new GridLayout(0, 7, 0, 0));
		
		Button button_1 = new Button("Add New Entry");
		panel_1.add(button_1);
		
		TextField textField_1 = new TextField();
		panel_1.add(textField_1);
		
		TextField textField_8 = new TextField();
		panel_1.add(textField_8);
		
		TextField textField_2 = new TextField();
		panel_1.add(textField_2);
		
		TextField textField_3 = new TextField();
		panel_1.add(textField_3);
		
		TextField textField_4 = new TextField();
		panel_1.add(textField_4);
		
		TextField textField_5 = new TextField();
		panel_1.add(textField_5);
		
		Panel panel_5 = new Panel();
		frame.getContentPane().add(panel_5, BorderLayout.WEST);
		
		Panel panel_6 = new Panel();
		frame.getContentPane().add(panel_6, BorderLayout.EAST);
		
		Panel panel_7 = new Panel();
		frame.getContentPane().add(panel_7, BorderLayout.CENTER);
		panel_7.setLayout(new GridLayout(0, 1, 0, 0));
		
		List list = new List();
		panel_7.add(list);
	}

}
