import java.awt.EventQueue;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.concurrent.CountDownLatch;

// TODO: Auto-generated Javadoc
/**
 * The Class InputScreen.
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
	 * Launch the application.
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
	 * Create the application.
	 */
	public InputScreen() {
		initialize();
	}
	
	/**
	 * Instantiates a new input screen.
	 *
	 * @param game the game
	 * @param latch the latch
	 * @param text the text
	 * @param def the def
	 * @param v the v
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
	 * Finished window.
	 *
	 * @param string the string
	 */
	public void finishedWindow(String string) {
		this.latch.countDown();
		this.game.closeInputScreen(this, string);
	}
	
	/**
	 * Feedback.
	 *
	 * @param string the string
	 */
	private void feedback(String string) {
		this.feedbackText.setText("<html><font color='red'>[!] " + string + "</font></html>");
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private int width = 370;
	
	/** The height. */
	private int height = 115;
	
	/**
	 * Initialize.
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


































