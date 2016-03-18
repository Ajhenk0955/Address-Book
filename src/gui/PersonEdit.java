import java.awt.BorderLayout;
import java.awt.GridLayout;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
/**
 * Window prompt that appears on getOutput() that goal
 * is to gather basic contact information
 * 
 * @author eyez
 *
 */
public class PersonEdit {

	private JFrame frmEdit;
	private JTextField LastNametxtbox;
	private JTextField FirstNametxtbox;
	private JTextField Phonetxtbox;
	private JTextField Streettxtbox;
	private JTextField Citytxtbox;
	private JTextField Statetxtbox;
	private JTextField Ziptxtbox;
	
	private boolean names_only = false;
	private String[] input = null,
						output = new String[7];
	private String title;
	/**
	 * Basic display of the code 
	 * @param args
	 */
	public static void main(String[] args){
		PersonEdit p = new PersonEdit("Create");
		String[] out = p.getOutput();
		System.out.println(out[0] + out[1] + out[2] + out[3] + out[4] + out[5] + out[6] );
	}
	/**
	 * Constructor
	 * @param Title, the title of the prompt window
	 */
	public PersonEdit(String Title) {
		for(int i  = 0; i < output.length ; i++)
			output[i] = "";
		title = Title;
	}
	/**
	 * Constructor
	 * @param Title, title of the prompt window
	 * @param args, the auto fill for the prompt text boxes
	 */
	public PersonEdit(String Title, String[] args) {
		input = args;
		title = Title;
	}
	/**
	 * Removes Address and Phone elements from the prompt
	 */
	public void setNamesPrompt(){
		names_only = true;
	}
	/**
	 * Adds back the Address and Phone elements from the prompt
	 */
	public void setNamesAndContactPrompt(){
		names_only = false;
	}
	/**
	 * 
	 * @return
	 */
	public String[] getOutput(){
		return initialize(title);
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private String[] initialize(String Title) {
		frmEdit = new JFrame();
		frmEdit.setBounds(100, 100, 353, 223);
		frmEdit.getContentPane().setLayout(null);
		
		JPanel p = new JPanel(new BorderLayout(5,5));

        JPanel labels = new JPanel(new GridLayout(0,1,2,2));
        JPanel txtboxes = new JPanel(new GridLayout(0,1,2,2));
        
		JLabel lblLastName = new JLabel("Last Name :");
		labels.add(lblLastName);

		LastNametxtbox = new JTextField();
		txtboxes.add(LastNametxtbox);
		if(input != null){
			LastNametxtbox.setText(input[0]);
		}

		JLabel lblFirstName = new JLabel("First Name:");
		labels.add(lblFirstName);
		
		FirstNametxtbox = new JTextField();
		txtboxes.add(FirstNametxtbox);
		if(input != null){
			FirstNametxtbox.setText(input[1]);
		}
		if(!names_only){
			JLabel lblPhone = new JLabel("Phone # :");
			labels.add(lblPhone);

			Phonetxtbox = new JTextField();
			txtboxes.add(Phonetxtbox);
			if(input != null){
				Phonetxtbox.setText(input[2]);
			}

			JLabel lblStreet = new JLabel("Street :");
			labels.add(lblStreet);

			Streettxtbox = new JTextField();
			txtboxes.add(Streettxtbox);
			if(input != null){
				Streettxtbox.setText(input[3]);
			}

			JLabel lblCity = new JLabel(" City :");
			labels.add(lblCity);

			Citytxtbox = new JTextField();
			txtboxes.add(Citytxtbox);
			if(input != null){
				Citytxtbox.setText(input[4]);
			}

			JLabel lblState = new JLabel("State :");
			labels.add(lblState);

			Statetxtbox = new JTextField();
			txtboxes.add(Statetxtbox);
			if(input != null){
				Statetxtbox.setText(input[5]);
			}

			JLabel lblZip = new JLabel("ZIP :");
			labels.add(lblZip);

			Ziptxtbox = new JTextField();
			txtboxes.add(Ziptxtbox);
			if(input != null){
				Ziptxtbox.setText(input[6]);
			}
		}
		
		p.add(labels, BorderLayout.WEST);
		p.add(txtboxes, BorderLayout.CENTER);
		
		int result = JOptionPane.showConfirmDialog(frmEdit,  p, 
	               title, JOptionPane.OK_CANCEL_OPTION);

		return (result == JOptionPane.OK_OPTION)? 
				new String[]{getText(LastNametxtbox), 
				getText(FirstNametxtbox),
				getText(Phonetxtbox),
				getText(Streettxtbox),
				getText(Citytxtbox),
				getText(Statetxtbox),
				getText(Ziptxtbox) 
			}:
				input ;
		
	}
	/**
	 * 
	 * @param txtfield
	 * @return
	 */
	private String getText(JTextField txtfield){
		String out = txtfield.getText();
		if(out != null)
			return out;
		else
			return "";
	}
}
