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
		
		button = new JButton("Rocket 1");
		button.setBounds(offX + 10, offY + 0, 100, 70);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Here goes the action (method) you want to execute when clicked
				System.out.println("You clicked the button 1");
			}
		});
		frame.add(button);
		
		button = new JButton("Rocket 2");
		this.frame.setVisible(true);
		button.setBounds(offX + 120, offY + 0, 100, 70);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Here goes the action (method) you want to execute when clicked
				System.out.println("You clicked the button 2");
			}
		});
		frame.add(button);
		
		button = new JButton("Rocket 3");
		button.setBounds(offX + 230, offY + 0, 100, 70);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Here goes the action (method) you want to execute when clicked
				System.out.println("You clicked the button 3");
			}
		});
		frame.add(button);
		
		button = new JButton("Rocket 4");
		button.setBounds(offX + 10, offY + 80, 100, 70);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Here goes the action (method) you want to execute when clicked
				System.out.println("You clicked the button 4");
			}
		});
		frame.add(button);
		
		button = new JButton("Rocket 5");
		button.setBounds(offX + 120, offY + 80, 100, 70);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Here goes the action (method) you want to execute when clicked
				System.out.println("You clicked the button 5");
			}
		});
		frame.add(button);
		
		button = new JButton("Rocket 6");
		button.setBounds(offX + 230, offY + 80, 100, 70);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Here goes the action (method) you want to execute when clicked
				System.out.println("You clicked the button 6");
			}
		});
		frame.add(button);
		
		// SELECTED BELOW
		
		offX = 0;
		offY = 310;
		
		label = new JLabel("Selected:");
		label.setBounds(offX + 10, offY + 0, 1000, 30);
		frame.add(label);
		
		button = new JButton("");
		button.setBounds(offX + 10, offY + 35, 100, 60);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Here goes the action (method) you want to execute when clicked
				System.out.println("You clicked the button");
			}
		});
		frame.add(button);
		
		button = new JButton("");
		button.setBounds(offX + 120, offY + 35, 100, 60);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Here goes the action (method) you want to execute when clicked
				System.out.println("You clicked the button");
			}
		});
		frame.add(button);
		
		button = new JButton("");
		button.setBounds(offX + 230, offY + 35, 100, 60);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Here goes the action (method) you want to execute when clicked
				System.out.println("You clicked the button");
			}
		});
		frame.add(button);
		
		// LITTLE PANEL THING BELOW
		
		offX = 370;
		offY = 170;
		
		JPanel panel = new JPanel();
		panel.setBounds(offX, offY, 200, 150);    
        panel.setBorder(BorderFactory.createLineBorder(Color.gray));
		panel.setLayout(null);
		
		label = new JLabel("Rocket Stats");
		label.setBounds(0 + 50, 0 + 10, 1000, 30);
		panel.add(label);
		
		label = new JLabel("Name: ");
		label.setBounds(0 + 10, 0 + 40, 1000, 30);
		panel.add(label);
		
		label = new JLabel("Fuel: ");
		label.setBounds(0 + 10, 0 + 70, 1000, 30);
		panel.add(label);
		
		label = new JLabel("Cleaniness: ");
		label.setBounds(0 + 10, 0 + 100, 1000, 30);
		
		panel.add(label);
        frame.add(panel);
		
		// ACCEPT BUTTON BELOW
		
		offX = 390;
		offY = 362;

		button = new JButton("Accept");
		button.setBounds(offX + 0, offY + 0, 150, 25);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Here goes the action (method) you want to execute when clicked
				System.out.println("You clicked the accept button");
				finishedWindow();
			}
		});
		frame.add(button);
	}
	
}


































