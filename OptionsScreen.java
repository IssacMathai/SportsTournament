import java.awt.EventQueue;
import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.util.concurrent.CountDownLatch;

public class OptionsScreen {
	
	private JFrame frame;
	private Game game;
	private Options options;
	private CountDownLatch latch;
	/**
	 * Launch the application
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
	public OptionsScreen(Game game, Options options, CountDownLatch latch) {
		this.options = options;
		this.game = game;
		this.latch = latch;
		initialize();
		this.frame.setVisible(true);
	}
	
	public void closeWindow() {
		frame.dispose();
	}
	
	public void finishedWindow(int choice) {
		this.latch.countDown();
		this.game.closeOptionsScreen(this, choice);
	}
	
	/**
	 * Initialize the contents of the frame.
	 */
	private int optionHeight = 40;
	private int gap = 5;
	private int width = 500;
	private int lineHeight = 40;
	private void initialize() {
		frame = new JFrame("Select an Option");
		int buttonOffY = this.lineHeight * this.game.prevOutputs.size() + 40;
		
		if (buttonOffY < 150) {
			buttonOffY = 150;
		}
		
		frame.setSize(this.width + 20, this.optionHeight * this.options.last() + buttonOffY + 75);
		frame.setLayout(null);
		frame.setVisible(true);
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
		
		// BUTTONS BELOW
		
		offX = 0;
		offY = buttonOffY;
		
		JButton button;
		
		OptionsScreen reference = this;
		// Manual for loop
		int i = 0;
		
		button = new JButton(this.options.option(i));
		button.setBounds(offX + 10, offY + this.optionHeight * i, this.width, this.optionHeight - this.gap);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		button = new JButton(this.options.option(i));
		button.setBounds(offX + 10, offY + this.optionHeight * i, this.width, this.optionHeight - this.gap);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		button = new JButton(this.options.option(i));
		button.setBounds(offX + 10, offY + this.optionHeight * i, this.width, this.optionHeight - this.gap);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		button = new JButton(this.options.option(i));
		button.setBounds(offX + 10, offY + this.optionHeight * i, this.width, this.optionHeight - this.gap);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		button = new JButton(this.options.option(i));
		button.setBounds(offX + 10, offY + this.optionHeight * i, this.width, this.optionHeight - this.gap);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		button = new JButton(this.options.option(i));
		button.setBounds(offX + 10, offY + this.optionHeight * i, this.width, this.optionHeight - this.gap);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		button = new JButton(this.options.option(i));
		button.setBounds(offX + 10, offY + this.optionHeight * i, this.width, this.optionHeight - this.gap);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		button = new JButton(this.options.option(i));
		button.setBounds(offX + 10, offY + this.optionHeight * i, this.width, this.optionHeight - this.gap);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		button = new JButton(this.options.option(i));
		button.setBounds(offX + 10, offY + this.optionHeight * i, this.width, this.optionHeight - this.gap);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		button = new JButton(this.options.option(i));
		button.setBounds(offX + 10, offY + this.optionHeight * i, this.width, this.optionHeight - this.gap);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		button = new JButton(this.options.option(i));
		button.setBounds(offX + 10, offY + this.optionHeight * i, this.width, this.optionHeight - this.gap);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		button = new JButton(this.options.option(i));
		button.setBounds(offX + 10, offY + this.optionHeight * i, this.width, this.optionHeight - this.gap);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		button = new JButton(this.options.option(i));
		button.setBounds(offX + 10, offY + this.optionHeight * i, this.width, this.optionHeight - this.gap);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		button = new JButton(this.options.option(i));
		button.setBounds(offX + 10, offY + this.optionHeight * i, this.width, this.optionHeight - this.gap);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		button = new JButton(this.options.option(i));
		button.setBounds(offX + 10, offY + this.optionHeight * i, this.width, this.optionHeight - this.gap);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		button = new JButton(this.options.option(i));
		button.setBounds(offX + 10, offY + this.optionHeight * i, this.width, this.optionHeight - this.gap);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		button = new JButton(this.options.option(i));
		button.setBounds(offX + 10, offY + this.optionHeight * i, this.width, this.optionHeight - this.gap);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				//Here goes the action (method) you want to execute when clicked
				reference.finishedWindow(16);
				latch.countDown();
			}
		});
		frame.add(button);
		
		
		
		
		
		
		
		//Validator optionsValidator = new IntValidator(options.first(), options.last());
		
	}
	
}


































