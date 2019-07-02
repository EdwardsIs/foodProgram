/*
 * Contestant #: 512
 * Program #: 1
 * Title: Food Program
 */

package food;

/*
 * This class is the main class for the program. It contains all code for the GUI, 
 * including button click handlers.
 */

import java.awt.event.*;

import javax.swing.*; // This import is needed for all swing GUI widgets

// JOptionPane.showMessageDialog()

public class Main {
	public static void main(String args[]) {
		// Total class object to hold all information
		Total total = new Total();
		
		// Frame to contain all other widgets
		JFrame frame = new JFrame("Contestant # 512");
		
		// Labels
		JLabel lblHeader, lblInstructions, lblDeluxePrompt, lblCheeseburgerPrompt, lblHamburgerPrompt, 
		lblFriesPrompt, lblSodaPrompt, lblWaterPrompt; // Creating labels
		
		lblHeader = new JLabel("Restaurant Sales Totals"); // Assigning new label
		lblHeader.setBounds(100, 15, 170, 20); // Setting positioning and size for label
		frame.add(lblHeader); // Adding label to frame
		
		lblInstructions = new JLabel("(Enter # amounts of each item purchased in text boxes)");
		lblInstructions.setBounds(10, 45, 400, 20);
		frame.add(lblInstructions);
		
		lblDeluxePrompt = new JLabel("Cheeseburger Deluxe $5.00:"); // Assigning new label
		lblDeluxePrompt.setBounds(10, 70, 200, 20); // Setting positioning and size for label
		frame.add(lblDeluxePrompt); // Adding label to frame
		
		lblCheeseburgerPrompt = new JLabel("Cheeseburger $4.00:"); // Assigning new label
		lblCheeseburgerPrompt.setBounds(60, 100, 200, 20); // Setting positioning and size for label
		frame.add(lblCheeseburgerPrompt); // Adding label to frame
		
		lblHamburgerPrompt = new JLabel("Hamburger $3.00:"); // Assigning new label
		lblHamburgerPrompt.setBounds(78, 130, 200, 20); // Setting positioning and size for label
		frame.add(lblHamburgerPrompt); // Adding label to frame
		
		lblFriesPrompt = new JLabel("Fries $2.00:"); // Assigning new label
		lblFriesPrompt.setBounds(123, 160, 200, 20); // Setting positioning and size for label
		frame.add(lblFriesPrompt); // Adding label to frame
		
		lblSodaPrompt = new JLabel("Soda $2.00:"); // Assigning new label
		lblSodaPrompt.setBounds(123, 190, 200, 20); // Setting positioning and size for label
		frame.add(lblSodaPrompt); // Adding label to frame
		
		lblWaterPrompt = new JLabel("Water $0.00:"); // Assigning new label
		lblWaterPrompt.setBounds(115, 220, 200, 20); // Setting positioning and size for label
		frame.add(lblWaterPrompt); // Adding label to frame
		
		// Text Fields
		JTextField txtDeluxe = new JTextField(); // Declaring new text field
		txtDeluxe.setBounds(210, 70, 40, 20); // Setting positioning and size for text field
		frame.add(txtDeluxe); // Adding label to frame
		
		JTextField txtCheeseburger = new JTextField(); // Declaring new text field
		txtCheeseburger.setBounds(210, 100, 40, 20); // Setting positioning and size for text field
		frame.add(txtCheeseburger); // Adding label to frame
		
		JTextField txtHamburger = new JTextField(); // Declaring new text field
		txtHamburger.setBounds(210, 130, 40, 20); // Setting positioning and size for text field
		frame.add(txtHamburger); // Adding label to frame
		
		JTextField txtFries = new JTextField(); // Declaring new text field
		txtFries.setBounds(210, 160, 40, 20); // Setting positioning and size for text field
		frame.add(txtFries); // Adding label to frame
		
		JTextField txtSoda = new JTextField(); // Declaring new text field
		txtSoda.setBounds(210, 190, 40, 20); // Setting positioning and size for text field
		frame.add(txtSoda); // Adding label to frame
		
		JTextField txtWater = new JTextField(); // Declaring new text field
		txtWater.setBounds(210, 220, 40, 20); // Setting positioning and size for text field
		frame.add(txtWater); // Adding label to frame
		
		// Text area
		JTextArea tAreaOutput = new JTextArea(); // Declaring new TextArea object
		tAreaOutput.setEditable(false); // Disabling editing on text area, as it is solely for output
		tAreaOutput.setBounds(10, 250, 315, 120); // Setting size and location for TextArea
		frame.add(tAreaOutput); // Adding TextArea to frame
		
		// Buttons
		JButton btnCalculate = new JButton("Calculate");
		btnCalculate.setBounds(70, 380, 100, 30);
		frame.add(btnCalculate);
		
		// Creating action handler for calculate button
		btnCalculate.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Declaring variables for each item's amount
				int deluxeAmount = 0, cheeseburgerAmount = 0,
						hamburgerAmount = 0, friesAmount = 0,
						sodaAmount = 0, waterAmount = 0;
				try {
					// Attempting to parse integer amounts from text fields
					// This will throw an error if the user entered non-numeric information
					// If the field is empty, the amount will simply be assigned as 0
					if (txtDeluxe.getText().isEmpty()) {
						deluxeAmount = 0;
					} else {
						deluxeAmount = Integer.parseInt(txtDeluxe.getText());
					}
					if (txtCheeseburger.getText().isEmpty()) {
						cheeseburgerAmount = 0;
					} else {
						cheeseburgerAmount = Integer.parseInt(txtCheeseburger.getText());
					}
					if (txtHamburger.getText().isEmpty()) {
						hamburgerAmount = 0;
					} else {
						hamburgerAmount = Integer.parseInt(txtHamburger.getText());
					}
					if (txtFries.getText().isEmpty()) {
						friesAmount = 0;
					} else {
						friesAmount = Integer.parseInt(txtFries.getText());
					}
					if (txtSoda.getText().isEmpty()) {
						sodaAmount = 0;
					} else {
						sodaAmount = Integer.parseInt(txtSoda.getText());
					}
					if (txtWater.getText().isEmpty()) {
						waterAmount = 0;
					} else {
						waterAmount = Integer.parseInt(txtWater.getText());
					}
					
					// Creating array of these amounts to pass to the Total object
					int amounts[] = {deluxeAmount, cheeseburgerAmount, hamburgerAmount,
							friesAmount, sodaAmount, waterAmount};
					total.updateItemQuantities(amounts);
					
					// Clearing text fields
					txtDeluxe.setText("");
					txtCheeseburger.setText("");
					txtHamburger.setText("");
					txtFries.setText("");
					txtSoda.setText("");
					txtWater.setText("");
					
					// Clearing text area
					tAreaOutput.setText("");
					
					tAreaOutput.setText(total.toString());
				} catch (Exception exc) {
					// User entered non-numeric value - Display error message
					JOptionPane.showMessageDialog(null, "Error - "
							+ "Enter only numeric input for item quantities. (Ex. 5)");
				}
			}
		});
		
		JButton btnClear = new JButton("Clear");
		btnClear.setBounds(180, 380, 100, 30);
		frame.add(btnClear);
		
		// Creating action handler for clear button
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Clearing text fields
				txtDeluxe.setText("");
				txtCheeseburger.setText("");
				txtHamburger.setText("");
				txtFries.setText("");
				txtSoda.setText("");
				txtWater.setText("");
				
				// Clearing text area
				tAreaOutput.setText("");
				
				// Resetting all amounts through total object
				total.reset();
			}
		});
		
		JButton btnExit = new JButton("Exit");
		btnExit.setBounds(290, 380, 100, 30);
		frame.add(btnExit);
		
		// Creating action handler for exit button
		btnExit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.exit(0); // Exiting program
			}
		});
		
		JButton btnHelp = new JButton("Help");
		btnHelp.setBounds(310, 5, 80, 20);
		frame.add(btnHelp);
		
		// Creating action handler for help button
		btnHelp.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// Displays pop-up with user documentation
				JOptionPane.showMessageDialog(null, 
						"Enter numeric amounts of each item sold in the text boxes\n"
						+ "beside the appropriate label.  When the calculate button is pressed,\n"
						+ "each amount in the boxes will be added to the running total\n"
						+ "for that item, and the final output will be updated.\n"
						+ "To clear all amounts for a new day's entries, click clear.\n"
						+ "To exit, press the exit button.");
			}
		});
		
		// Configuring frame size and layout for run
		frame.setSize(400, 450); // Setting window size to 200 X 300
		frame.setLayout(null); // Using no layout manager
		frame.setVisible(true); // Showing frame200
	}
}
