import java.awt.EventQueue;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.concurrent.CountDownLatch;

public class InputScreen {
	
	private JFrame frame;
	private Game game;
	private CountDownLatch latch;
	private String text;
	private String def;
	private Validator v;
	private JLabel feedbackText;
	/**
	 * Launch the application
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
	public InputScreen(Game game, CountDownLatch latch, String text, String def, Validator v) {
		this.game = game;
		this.latch = latch;
		this.text = text;
		this.def = def;
		this.v = v;
		initialize();
		this.frame.setVisible(true);
	}
	
	public void closeWindow() {
		frame.dispose();
	}
	
	public void finishedWindow(String string) {
		this.latch.countDown();
		this.game.closeInputScreen(this, string);
	}
	
	private void feedback(String string) {
		this.feedbackText.setText("<html><font color='red'>[!] " + string + "</font></html>");
	}
	/**
	 * Initialize the contents of the frame.
	 */
	private int width = 370;
	private int height = 115;
	
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


































