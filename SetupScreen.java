import java.awt.EventQueue;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;

public class SetupScreen {
	
	private JFrame frame;
	private Game game;
	/**
	 * Launch the application
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					SetupScreen window = new SetupScreen();
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
	public SetupScreen() {
		initialize();
	}
	public SetupScreen(Game game) {
		this.game = game;
		initialize();
		this.frame.setVisible(true);
	}
	
	public void closeWindow() {
		frame.dispose();
	}
	
	public void finishedWindow() {
		this.game.closeSetupScreen(this);
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Axe Masters Setup Screen");
		frame.setSize(700, 350);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SetupScreen reference = this;
		int offX;
		int offY;
		
		// LABELS BELOW
		
		offX = 0;
		offY = 0;
		
		JLabel label;
		
		//label.setText("Change label...");
		label = new JLabel("Welcome to Axe Masters!");
		label.setBounds(offX + 10, offY + 10, 1000, 30);
		frame.add(label);
		
		label = new JLabel("What is your team name?");
		label.setBounds(offX + 10, offY + 50, 1000, 30);
		frame.add(label);
		
		// TEXT INPUT BELOW
		
		JTextField text = new JTextField("");
		text.setBounds(offX + 400, offY + 50, 200, 30);
		frame.add(text);
		
		label = new JLabel("How many weeks do you want? (between 5 and 15)");
		label.setBounds(offX + 10, offY + 90, 1000, 30);
		frame.add(label);
		
		// SLIDER BELOW
		
		JSlider slider = new JSlider(JSlider.HORIZONTAL, 5, 15, 5);
		slider.setMinorTickSpacing(1);
		slider.setMajorTickSpacing(5);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		
		slider.setBounds(offX + 400, offY + 90, 200, 50);
		frame.add(slider);
		
		// BUTTONS BELOW
		
		offX = 0;
		offY = 150;
		
		JButton button;
		
		// LITTLE PANEL THING BELOW
		
		offX = 10;
		offY = 170;
		
		JPanel panel = new JPanel();
		panel.setBounds(offX, offY, 200, 150);    
        panel.setBorder(BorderFactory.createLineBorder(Color.gray));
		panel.setLayout(null);
		
		label = new JLabel("rules");
		label.setBounds(0 + 50, 0 + 10, 1000, 30);
		panel.add(label);
		
        frame.add(panel);
		
		// ACCEPT BUTTON BELOW
		
		offX = 390;
		offY = 230;

		button = new JButton("Start Game");
		button.setBounds(offX + 0, offY + 0, 150, 25);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Here goes the action (method) you want to execute when clicked
				//System.out.println("You clicked the accept button");
				
				finishedWindow();
				
				reference.game.startGame();
				
			}
		});
		frame.add(button);
	}
	
}


































