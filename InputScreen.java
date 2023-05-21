import java.awt.EventQueue;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.concurrent.CountDownLatch;


/**
 * The InputScreen class represents a graphical user interface (GUI) screen for inputting data.
 */
public class InputScreen {
	
	/** The frame. */
	private JFrame frame;
	
	/** The game. */
	private Game game;
	
	/** The latch. */
	private CountDownLatch latch;
	
	/** The text. */
	private String text;
	
	/** The def. */
	private String def;
	
	/** The v. */
	private Validator v;
	
	/** The feedback text. */
	private JLabel feedbackText;
	
	/**
	 * Launch the input screen
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					InputScreen window = new InputScreen();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	
	/**
	 * Create an instance of the InputScreen
	 */
	public InputScreen() {
		initialize();
	}
	
	/**
	 * Instantiates a new input screen.
	 *
	 * @param game the game object
	 * @param latch the latch
	 * @param text the input prompt text
	 * @param def the default input value
	 * @param v the validator object for input validation
	 */
	public InputScreen(Game game, CountDownLatch latch, String text, String def, Validator v) {
		this.game = game;
		this.latch = latch;
		this.text = text;
		this.def = def;
		this.v = v;
		initialize();
		this.frame.setVisible(true);
	}
	
	/**
	 * Close window.
	 */
	public void closeWindow() {
		frame.dispose();
	}
	
	/**
	 * Notifies the window that it has finished and passes the entered string
	 *
	 * @param string the string
	 */
	public void finishedWindow(String string) {
		this.latch.countDown();
		this.game.closeInputScreen(this, string);
	}
	
	/**
	 * Displays feedback message on the screen
	 *
	 * @param string the string
	 */
	private void feedback(String string) {
		this.feedbackText.setText("<html><font color='red'>[!] " + string + "</font></html>");
	}
	/**
	 * width of the frame.
	 */
	private int width = 370;
	
	/** The height. */
	private int height = 115;
	
	/**
	 * Initializes the contents of the frame
	 */
	private void initialize() {
		InputScreen reference = this;
		frame = new JFrame(this.text);
		
		frame.setLayout(null);
		frame.setVisible(true);
		
		frame.setSize(this.width, this.height);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// FEEDBACK BELOW
		
		this.feedbackText = new JLabel();
		this.feedbackText.setBounds(5, 30, 1000, 30);
		frame.add(this.feedbackText);
		
		
		
		
		JTextField text = new JTextField( this.def );
		text.setBounds(5, 5, this.width-10, 30);
		frame.add(text);
		
		
		JButton button;
		button = new JButton("Enter");
		button.setBounds((this.width-100)/2, this.height-55, 100, 25);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Here goes the action (method) you want to execute when clicked
				//System.out.println("You clicked the accept button");
				
				boolean valid = false;
				try {
					valid = reference.v.validate( text.getText() );
				} catch (Exception except) {
					// provides feedback and tries again
					reference.feedback(except.getMessage()); // implement!
				}
				if (valid) {
					reference.finishedWindow(text.getText());
				}
				
			}
		});
		frame.add(button);
		
	}
	
}


































