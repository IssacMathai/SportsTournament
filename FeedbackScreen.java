import java.awt.EventQueue;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.concurrent.CountDownLatch;

public class FeedbackScreen {
	
	private JFrame frame;
	private Game game;
	private CountDownLatch latch;
	private String text;
	/**
	 * Launch the application
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					FeedbackScreen window = new FeedbackScreen();
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
	public FeedbackScreen() {
		initialize();
	}
	public FeedbackScreen(Game game, CountDownLatch latch, String text) {
		this.game = game;
		this.latch = latch;
		this.text = text;
		initialize();
		this.frame.setVisible(true);
	}
	
	public void closeWindow() {
		frame.dispose();
	}
	
	public void finishedWindow() {
		this.latch.countDown();
		this.game.closeFeedbackScreen(this);
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private int width = 350;
	private int height = 200;
	
	private void initialize() {
		FeedbackScreen reference = this;
		frame = new JFrame("Feedback");
		
		frame.setLayout(null);
		frame.setVisible(true);
		
		frame.setSize(this.width, this.height);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		JLabel label;
		label = new JLabel( this.text );
		label.setBounds( 5, 0, this.width, this.height-55);
		
		frame.add(label);
		
		JButton button;
		button = new JButton("Ok");
		button.setBounds((this.width-100)/2, this.height-55, 100, 25);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Here goes the action (method) you want to execute when clicked
				//System.out.println("You clicked the accept button");
				reference.finishedWindow();
				
			}
		});
		frame.add(button);
		
	}
	
}


































