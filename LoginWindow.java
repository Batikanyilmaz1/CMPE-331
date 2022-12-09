/*
 * Stage: Development-01
 * @author: Batıkan Yılmaz
 * @author Abdulrahman Aorfahlı
 * @Waleed Khaled Mohammad Alghool
 *
 */

import java.awt.GridLayout;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.SwingConstants;


public class LoginWindow extends JFrame implements ActionListener {

	// main method for testing the application
	public static void main(String[] args) {
		loginWindow = new LoginWindow(); //creating loginwindow
	}


	/*
	 * Graphical User Interface (GUI) Elements
	 *
	 * ! PLEASE RENAME THE OBJECTS ACCORDING TO THEIR PURPOSES !
	 * ! YOU CAN ADD MORE ELEMENTS IF IT IS NECESSARY !
	 */
	private JButton btn01, btn02;
	private JLabel lbl01, lbl02;
	private JTextField txt01, txt02;
	private String name,password;
	private static JFrame loginWindow; //I created loginwindow variable to access this from other methods and it is also static because we need it in main method


	// Constructor
	public LoginWindow () {
		setNamePass("myname", "mypass");
		this.initializeGUI();
		this.setWindowProperties(3, 2);
		this.addGUIElementsToFrame();

	}


	/**
	 * Initialize GUI elements. If it is necessary, you can add more
	 * 	elements.
	 */
	public void initializeGUI() {
		lbl01 = new JLabel("Name", SwingConstants.CENTER);
		lbl02 = new JLabel("Password", SwingConstants.CENTER);

		txt01 = new JTextField("Enter a Username");
		txt02 = new JTextField("Enter a Password");

		txt01.setHorizontalAlignment(SwingConstants.CENTER);
		txt02.setHorizontalAlignment(SwingConstants.CENTER);

		btn01 = new JButton("Login");
		btn02 = new JButton("Reset");

		btn01.addActionListener(this);
		btn02.addActionListener(this);
	}


	/**
	 * Set the necessary properties for the window
	 *
	 * @param numRow number of row for GUI elements
	 * @param numCol number of column for GUI elements
	 */
	public void setWindowProperties(int numRow, int numCol) {
		this.setLayout(new GridLayout(numRow, numCol));

		this.setSize(800, 800);
		this.setDefaultCloseOperation(EXIT_ON_CLOSE);
		this.setVisible(true);
	}


	/**
	 * Add GUI elements to the layout of the frame. If it is necessary,
	 * 	you can add more elements.
	 */
	public void addGUIElementsToFrame() {
		this.add(lbl01);
		this.add(txt01);

		this.add(lbl02);
		this.add(txt02);

		this.add(btn01);
		this.add(btn02);
	}


	/**
	 * Add margin to the frame.
	 */
	@Override
    public Insets getInsets() {
        return new Insets(100, 50, 100, 50);
    }
	
	public void setNamePass(String name, String password) {
		this.name=name;
		this.password=password;
		
	}
	
	//create a new page
	public void createBlankPage() {
		JFrame frame = new JFrame();

	    // Set the size of the frame
	    frame.setSize(800, 800);

	    // Make the frame visible
	    frame.setVisible(true);
	}


	/**
	 * Action listener for the buttons. If e.getSource() is from
	 * 	one of the buttons, apply the related operation.
	 *
	 * @param e action event for detecting which button is clicked
	 */
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if(e.getSource().equals(btn01) && txt01.getText().equals(name) && txt02.getText().equals(password)) {
			System.out.println("You Logged-in");
			loginWindow.dispose(); //close the loginwindow
			createBlankPage(); //call blankpage function
		}else {
			System.out.println("Incorrect username or password");
		}
		//reset button
		if(e.getSource().equals(btn02)) {
			txt01.setText("");
			txt02.setText("");
		}

	}

}