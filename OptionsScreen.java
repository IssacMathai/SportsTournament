import java.awt.EventQueue;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.concurrent.CountDownLatch;

// TODO: Auto-generated Javadoc
/**
 * The Class OptionsScreen.
 */
public class OptionsScreen {
	
	/** The frame. */
	private JFrame frame;
	
	/** The game. */
	private Game game;
	
	/** The options. */
	private Options options;
	
	/** The latch. */
	private CountDownLatch latch;
	
	/** The type. */
	private int type;
	
	/** The text. */
	private String text;
	
	/**
	 * Launch the application.
	 *
	 * @param args the arguments
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OptionsScreen window = new OptionsScreen();
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
	public OptionsScreen() {
		initialize();
	}
	
	/**
	 * Instantiates a new options screen.
	 *
	 * @param game the game
	 * @param options the options
	 * @param latch the latch
	 */
	public OptionsScreen(Game game, Options options, CountDownLatch latch) {
		this.options = options;
		this.game = game;
		this.latch = latch;
		this.type = 0;
		initialize();
		this.frame.setVisible(true);
	}
	
	/**
	 * Instantiates a new options screen.
	 *
	 * @param game the game
	 * @param options the options
	 * @param latch the latch
	 * @param butText the but text
	 */
	public OptionsScreen(Game game, Options options, CountDownLatch latch, String butText) {
		this.options = options;
		this.game = game;
		this.latch = latch;
		this.type = 1;
		this.text = butText;
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
	 * @param choice the choice
	 */
	public void finishedWindow(int choice) {
		this.latch.countDown();
		this.game.closeOptionsScreen(this, choice);
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private int optionHeight = 40;
	
	/** The gap. */
	private int gap = 5;
	
	/** The width. */
	private int width = 700;
	
	/** The line height. */
	private int lineHeight = 30;
	
	/**
	 * Initialize.
	 */
	private void initialize() {
		frame = new JFrame("Select an Option");
		int buttonOffY = this.lineHeight * this.game.prevOutputs.size() + 40;
		frame.setLayout(null);
		frame.setVisible(true);
		
		int buttonOffX = 0;
		if (this.type == 1) {
			buttonOffX = this.width - 100;
			this.optionHeight = 40;
			this.gap = 20;
		}
		if (buttonOffY < 150) {
			buttonOffY = 150;
		}
		frame.setSize(this.width + 20, this.optionHeight * this.options.last() + buttonOffY + 75);
		//frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		int offX;
		int offY;
		
		// LABELS BELOW
		
		offX = 0;
		offY = 0;
		
		JLabel label;
		
		
		for (int i = this.game.prevOutputs.size()-1; i >= 0; i--) {
			label = new JLabel(this.game.prevOutputs.get(i));
			label.setBounds(offX + 10, offY + 10 + i * this.lineHeight, 1000, 30);
			frame.add(label);
		}
		
		/*
		label = new JLabel(this.game.lastOutput);
		label.setBounds(offX + 10, offY + 10 + 0 * this.lineHeight, 1000, 30);
		frame.add(label);
		*/
		
		// BUTTONS BELOW
		
		offX = buttonOffX;
		offY = buttonOffY;
		
		JPanel panel;
		
		if (this.type == 1) {
			for (int i = 0; i < this.options.last(); i++) {
				panel = new JPanel();
				panel.setBounds(10, offY - 5 + i * this.optionHeight, buttonOffX - 30, 30);    
				if (options.getHigh() == i) {
	     			panel.setBorder(BorderFactory.createLineBorder(Color.decode("#2b4"), 3));
				} else {
	     			panel.setBorder(BorderFactory.createLineBorder(Color.gray));
				}
				panel.setLayout(null);
				
				label = new JLabel( "<html>" + this.options.option(i) + "</html>" );
				label.setBounds( 10, 0, 1000, 30);
				
				panel.add(label);
				
				frame.add(panel);
			}
		}
		
		// move button over a bit
		offX -= 15;
		
		JButton button;
		
		OptionsScreen reference = this;
		// Manual for loop
		int i = 0;
		
		// Itteration Start
		if (i == this.options.last()) {
			this.type = 0;
		}
		if (this.type == 1) {
			button = new JButton( this.text );
		} else {
			button = new JButton(this.options.option(i));
			buttonOffX = 0;
			offX = 0;
			this.gap = 5;
		}
		button.setBounds(offX + 10, offY + this.optionHeight * i, this.width - buttonOffX, this.optionHeight - this.gap);
		button.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				//Here goes the action (method) you want to execute when clicked
				reference.finishedWindow(0);
				latch.countDown();
			}
		});
		frame.add(button);
		
		if (i >= this.options.last()) {
			return;
		}
		i++;
		// Itteration End
		// Itteration Start
		if (i == this.options.last()) {
			this.type = 0;
		}
		if (this.type == 1) {
			button = new JButton( this.text );
		} else {
			button = new JButton(this.options.option(i));
			buttonOffX = 0;
			offX = 0;
			this.gap = 5;
		}
		button.setBounds(offX + 10, offY + this.optionHeight * i, this.width - buttonOffX, this.optionHeight - this.gap);
		button.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				//Here goes the action (method) you want to execute when clicked
				reference.finishedWindow(1);
				latch.countDown();
			}
		});
		frame.add(button);
		
		if (i >= this.options.last()) {
			return;
		}
		i++;
		// Itteration End
		// Itteration Start
		if (i == this.options.last()) {
			this.type = 0;
		}
		if (this.type == 1) {
			button = new JButton( this.text );
		} else {
			button = new JButton(this.options.option(i));
			buttonOffX = 0;
			offX = 0;
			this.gap = 5;
		}
		button.setBounds(offX + 10, offY + this.optionHeight * i, this.width - buttonOffX, this.optionHeight - this.gap);
		button.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				//Here goes the action (method) you want to execute when clicked
				reference.finishedWindow(2);
				latch.countDown();
			}
		});
		frame.add(button);
		
		if (i >= this.options.last()) {
			return;
		}
		i++;
		// Itteration End
		// Itteration Start
		if (i == this.options.last()) {
			this.type = 0;
		}
		if (this.type == 1) {
			button = new JButton( this.text );
		} else {
			button = new JButton(this.options.option(i));
			buttonOffX = 0;
			offX = 0;
			this.gap = 5;
		}
		button.setBounds(offX + 10, offY + this.optionHeight * i, this.width - buttonOffX, this.optionHeight - this.gap);
		button.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				//Here goes the action (method) you want to execute when clicked
				reference.finishedWindow(3);
				latch.countDown();
			}
		});
		frame.add(button);
		
		if (i >= this.options.last()) {
			return;
		}
		i++;
		// Itteration End
		// Itteration Start
		if (i == this.options.last()) {
			this.type = 0;
		}
		if (this.type == 1) {
			button = new JButton( this.text );
		} else {
			button = new JButton(this.options.option(i));
			buttonOffX = 0;
			offX = 0;
			this.gap = 5;
		}
		button.setBounds(offX + 10, offY + this.optionHeight * i, this.width - buttonOffX, this.optionHeight - this.gap);
		button.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				//Here goes the action (method) you want to execute when clicked
				reference.finishedWindow(4);
				latch.countDown();
			}
		});
		frame.add(button);
		
		if (i >= this.options.last()) {
			return;
		}
		i++;
		// Itteration End
		// Itteration Start
		if (i == this.options.last()) {
			this.type = 0;
		}
		if (this.type == 1) {
			button = new JButton( this.text );
		} else {
			button = new JButton(this.options.option(i));
			buttonOffX = 0;
			offX = 0;
			this.gap = 5;
		}
		button.setBounds(offX + 10, offY + this.optionHeight * i, this.width - buttonOffX, this.optionHeight - this.gap);
		button.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				//Here goes the action (method) you want to execute when clicked
				reference.finishedWindow(5);
				latch.countDown();
			}
		});
		frame.add(button);
		
		if (i >= this.options.last()) {
			return;
		}
		i++;
		// Itteration End
		// Itteration Start
		if (i == this.options.last()) {
			this.type = 0;
		}
		if (this.type == 1) {
			button = new JButton( this.text );
		} else {
			button = new JButton(this.options.option(i));
			buttonOffX = 0;
			offX = 0;
			this.gap = 5;
		}
		button.setBounds(offX + 10, offY + this.optionHeight * i, this.width - buttonOffX, this.optionHeight - this.gap);
		button.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				//Here goes the action (method) you want to execute when clicked
				reference.finishedWindow(6);
				latch.countDown();
			}
		});
		frame.add(button);
		
		if (i >= this.options.last()) {
			return;
		}
		i++;
		// Itteration End
		// Itteration Start
		if (i == this.options.last()) {
			this.type = 0;
		}
		if (this.type == 1) {
			button = new JButton( this.text );
		} else {
			button = new JButton(this.options.option(i));
			buttonOffX = 0;
			offX = 0;
			this.gap = 5;
		}
		button.setBounds(offX + 10, offY + this.optionHeight * i, this.width - buttonOffX, this.optionHeight - this.gap);
		button.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				//Here goes the action (method) you want to execute when clicked
				reference.finishedWindow(7);
				latch.countDown();
			}
		});
		frame.add(button);
		
		if (i >= this.options.last()) {
			return;
		}
		i++;
		// Itteration End
		// Itteration Start
		if (i == this.options.last()) {
			this.type = 0;
		}
		if (this.type == 1) {
			button = new JButton( this.text );
		} else {
			button = new JButton(this.options.option(i));
			buttonOffX = 0;
			offX = 0;
			this.gap = 5;
		}
		button.setBounds(offX + 10, offY + this.optionHeight * i, this.width - buttonOffX, this.optionHeight - this.gap);
		button.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				//Here goes the action (method) you want to execute when clicked
				reference.finishedWindow(8);
				latch.countDown();
			}
		});
		frame.add(button);
		
		if (i >= this.options.last()) {
			return;
		}
		i++;
		// Itteration End
		// Itteration Start
		if (i == this.options.last()) {
			this.type = 0;
		}
		if (this.type == 1) {
			button = new JButton( this.text );
		} else {
			button = new JButton(this.options.option(i));
			buttonOffX = 0;
			offX = 0;
			this.gap = 5;
		}
		button.setBounds(offX + 10, offY + this.optionHeight * i, this.width - buttonOffX, this.optionHeight - this.gap);
		button.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				//Here goes the action (method) you want to execute when clicked
				reference.finishedWindow(9);
				latch.countDown();
			}
		});
		frame.add(button);
		
		if (i >= this.options.last()) {
			return;
		}
		i++;
		// Itteration End
		// Itteration Start
		if (i == this.options.last()) {
			this.type = 0;
		}
		if (this.type == 1) {
			button = new JButton( this.text );
		} else {
			button = new JButton(this.options.option(i));
			buttonOffX = 0;
			offX = 0;
			this.gap = 5;
		}
		button.setBounds(offX + 10, offY + this.optionHeight * i, this.width - buttonOffX, this.optionHeight - this.gap);
		button.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				//Here goes the action (method) you want to execute when clicked
				reference.finishedWindow(10);
				latch.countDown();
			}
		});
		frame.add(button);
		
		if (i >= this.options.last()) {
			return;
		}
		i++;
		// Itteration End
		// Itteration Start
		if (i == this.options.last()) {
			this.type = 0;
		}
		if (this.type == 1) {
			button = new JButton( this.text );
		} else {
			button = new JButton(this.options.option(i));
			buttonOffX = 0;
			offX = 0;
			this.gap = 5;
		}
		button.setBounds(offX + 10, offY + this.optionHeight * i, this.width - buttonOffX, this.optionHeight - this.gap);
		button.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				//Here goes the action (method) you want to execute when clicked
				reference.finishedWindow(11);
				latch.countDown();
			}
		});
		frame.add(button);
		
		if (i >= this.options.last()) {
			return;
		}
		i++;
		// Itteration End
		// Itteration Start
		if (i == this.options.last()) {
			this.type = 0;
		}
		if (this.type == 1) {
			button = new JButton( this.text );
		} else {
			button = new JButton(this.options.option(i));
			buttonOffX = 0;
			offX = 0;
			this.gap = 5;
		}
		button.setBounds(offX + 10, offY + this.optionHeight * i, this.width - buttonOffX, this.optionHeight - this.gap);
		button.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				//Here goes the action (method) you want to execute when clicked
				reference.finishedWindow(12);
				latch.countDown();
			}
		});
		frame.add(button);
		
		if (i >= this.options.last()) {
			return;
		}
		i++;
		// Itteration End
		// Itteration Start
		if (i == this.options.last()) {
			this.type = 0;
		}
		if (this.type == 1) {
			button = new JButton( this.text );
		} else {
			button = new JButton(this.options.option(i));
			buttonOffX = 0;
			offX = 0;
			this.gap = 5;
		}
		button.setBounds(offX + 10, offY + this.optionHeight * i, this.width - buttonOffX, this.optionHeight - this.gap);
		button.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				//Here goes the action (method) you want to execute when clicked
				reference.finishedWindow(13);
				latch.countDown();
			}
		});
		frame.add(button);
		
		if (i >= this.options.last()) {
			return;
		}
		i++;
		// Itteration End
		// Itteration Start
		if (i == this.options.last()) {
			this.type = 0;
		}
		if (this.type == 1) {
			button = new JButton( this.text );
		} else {
			button = new JButton(this.options.option(i));
			buttonOffX = 0;
			offX = 0;
			this.gap = 5;
		}
		button.setBounds(offX + 10, offY + this.optionHeight * i, this.width - buttonOffX, this.optionHeight - this.gap);
		button.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				//Here goes the action (method) you want to execute when clicked
				reference.finishedWindow(14);
				latch.countDown();
			}
		});
		frame.add(button);
		
		if (i >= this.options.last()) {
			return;
		}
		i++;
		// Itteration End
		// Itteration Start
		if (i == this.options.last()) {
			this.type = 0;
		}
		if (this.type == 1) {
			button = new JButton( this.text );
		} else {
			button = new JButton(this.options.option(i));
			buttonOffX = 0;
			offX = 0;
			this.gap = 5;
		}
		button.setBounds(offX + 10, offY + this.optionHeight * i, this.width - buttonOffX, this.optionHeight - this.gap);
		button.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				//Here goes the action (method) you want to execute when clicked
				reference.finishedWindow(15);
				latch.countDown();
			}
		});
		frame.add(button);
		
		if (i >= this.options.last()) {
			return;
		}
		i++;
		// Itteration End
		// Itteration Start
		if (i == this.options.last()) {
			this.type = 0;
		}
		if (this.type == 1) {
			button = new JButton( this.text );
		} else {
			button = new JButton(this.options.option(i));
			buttonOffX = 0;
			offX = 0;
			this.gap = 5;
		}
		button.setBounds(offX + 10, offY + this.optionHeight * i, this.width - buttonOffX, this.optionHeight - this.gap);
		button.addActionListener(new ActionListener() {
			public void actionPerformed (ActionEvent e) {
				//Here goes the action (method) you want to execute when clicked
				reference.finishedWindow(16);
				latch.countDown();
			}
		});
		frame.add(button);
		
		if (i >= this.options.last()) {
			return;
		}
		i++;
		// Itteration End
		
		
		
		
		
		
		//Validator optionsValidator = new IntValidator(options.first(), options.last());
		
	}
	
}


































