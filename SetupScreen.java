import java.awt.EventQueue;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.concurrent.CountDownLatch;

// TODO: Auto-generated Javadoc
/**
 * The Class SetupScreen.
 */
public class SetupScreen {
	
	/** The frame. */
	private JFrame frame;
	
	/** The game. */
	private Game game;
	
	/** The latch. */
	private CountDownLatch latch;
	
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
	
	/**
	 * Instantiates a new setup screen.
	 *
	 * @param game the game
	 * @param latch the latch
	 */
	public SetupScreen(Game game, CountDownLatch latch) {
		this.game = game;
		this.latch = latch;
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
	 */
	public void finishedWindow() {
		this.latch.countDown();
		this.game.closeSetupScreen(this);
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
	 * Generate rainbow.
	 *
	 * @param string the string
	 * @return the string
	 */
	private String generateRainbow(String string) {
		String[] colors = {"#f77","#ff7","#7f7","#7ff","#77f","#f7f"};
		String output = "<html>";
		for (int i = 0; i < string.length(); i++) {
			if (string.charAt(i) == '\n') {
				output += "<br>";
			} else {
				output += "<a style='background-color:#333;color:" + colors[i % colors.length] + ";'>" + string.charAt(i) + "</a>";
			}
		}
		output += "</html>";
		return output;
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame("Axe Masters Setup Screen");
		frame.setSize(700, 590);
		frame.setLayout(null);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		SetupScreen reference = this;
		Game game = reference.game;
		int offX;
		int offY;
		
		// LABELS BELOW
		
		offX = 0;
		offY = 0;
		
		JLabel label;
		
		// FEEDBACK BELOW
		
		this.feedbackText = new JLabel();
		this.feedbackText.setBounds(offX + 20, offY + 525, 1000, 30);
		frame.add(this.feedbackText);
		
		
		//label.setText("Change label...");
		label = new JLabel("<html><h1>Welcome to <i>" + this.generateRainbow("Axe Masters") + "</i>!</h1></html>");
		label.setBounds(offX + 10, offY + 10, 1000, 60);
		frame.add(label);
		
		label = new JLabel("Name Your Team:");
		label.setBounds(offX + 10, offY + 70, 1000, 30);
		frame.add(label);
		
		
		// TEXT INPUT BELOW
		
		JTextField text = new JTextField("");
		text.setBounds(offX + 400, offY + 70, 200, 30);
		frame.add(text);
		
		label = new JLabel("How many weeks will the season last..?");
		label.setBounds(offX + 10, offY + 120, 1000, 30);
		frame.add(label);
		
		// SLIDER BELOW
		
		JSlider slider = new JSlider(JSlider.HORIZONTAL, 5, 15, 5);
		slider.setMinorTickSpacing(1);
		slider.setMajorTickSpacing(5);
		slider.setPaintTicks(true);
		slider.setPaintLabels(true);
		
		slider.setBounds(offX + 400, offY + 120, 200, 50);
		frame.add(slider);
		
		// BUTTONS BELOW
		
		offX = 0;
		offY = 150;
		
		JButton button;
		
		// LITTLE PANEL THING BELOW
		
		offX = 10;
		offY = 170;
		
		JPanel panel = new JPanel();
		panel.setBounds(offX, offY, 680, 350);    
        panel.setBorder(BorderFactory.createLineBorder(Color.gray));
		panel.setLayout(null);
		
		label = new JLabel(game.rules());
		label.setBounds(0 + 00, 0 + 00, 680, 350);
		panel.add(label);
		
        frame.add(panel);
		
		// ACCEPT BUTTON BELOW
		
		offX = 540;
		offY = 530;

		button = new JButton("Start Game");
		button.setBounds(offX + 0, offY + 0, 150, 25);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Here goes the action (method) you want to execute when clicked
				//System.out.println("You clicked the accept button");
				
				Validator nameValidator = new NameValidator(3, 15);
				
				boolean valid = false;
				try {
					valid = nameValidator.validate( text.getText() );
				} catch (Exception except) {
					// provides feedback and tries again
					reference.feedback(except.getMessage()); // implement!
				}
				if (valid) {
					game.player = new Team( text.getText() , game.teamSize, game.fieldSize);
					// ^^ does the same thing as:
					// Team player = new Team();
					// player.setName( game.ui("Choose a team name", nameValidator) );
					
					//game.output( player );
					
					//Validator weeksValidator = new IntValidator(5, 15);
					// choose and set the number of weeks in the season.
					// ... uses a weeksValidator function
					//game.weeks = game.ui("How many weeks will the season be?", weeksValidator, ReturnType.INT);
					game.weeks = slider.getValue();
					
					finishedWindow();
					
					//reference.game.startGame();
				}
				
			}
		});
		frame.add(button);
	}
	
}


































