import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Semaphore;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JButton;

public class filterWindow {

	private JFrame Filter;
	private int sort_func = 0;
	private JComboBox<String> comboBox;
	private Semaphore mutex = new Semaphore(1);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		filterWindow window = new filterWindow();
		window.Filter.setVisible(true);
		System.out.println(window.getEnum());
	}

	/**
	 * Create the application.
	 */
	public filterWindow() {
		try {
			mutex.acquire();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		initialize();
	}
	public int getEnum(){
		try {
			mutex.acquire();
			mutex.release();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		return sort_func;
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		Filter = new JFrame("Filter Options");
		Filter.setBounds(100, 100, 265, 118);
		Filter.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		Filter.getContentPane().setLayout(null);
		
		
		Filter.addWindowListener(new WindowListener(){

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

		JLabel lblSelectFilter = new JLabel("Select Filter :");
		lblSelectFilter.setBounds(10, 18, 76, 14);
		Filter.getContentPane().add(lblSelectFilter);

		comboBox = new JComboBox<String>( getSort() );
		comboBox.setBounds(90, 15, 140, 20);
		Filter.getContentPane().add(comboBox);

		JButton btnFilter = new JButton("Filter");
		btnFilter.setBounds(81, 46, 89, 23);
		Filter.getContentPane().add(btnFilter);
		btnFilter.addActionListener(new FilterAction());
		
	}
	private String[] getSort(){
		List<String> enums = new ArrayList<String>();
		enums.add("Last Name");
		enums.add("First Name");
		enums.add("ZIP descending");
		enums.add("ZIP ascending");
		return enums.toArray(new String[0]);
	}
	class FilterAction implements ActionListener{

		public void actionPerformed(ActionEvent arg0) {
			sort_func = comboBox.getSelectedIndex();
			mutex.release();
			Filter.dispose();
		}
	}
}
