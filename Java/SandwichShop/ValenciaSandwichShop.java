import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JList;
import javax.swing.JPanel;
import javax.swing.JTextField;

public class ValenciaSandwichShop {

	//Array for meat choices
	String meatChoice [] = {"Chicken", "Vegetarian", "Turkey"};

	//Array for bread choices
	String breadChoice[] = {"White", "Wheat", "Multi-Grain"};

	/*Create container*/
	JFrame jf;
	JPanel panel1, panel2, panel3, panel4, masterPanel;

	/*Create component object*/
	JList<String> mainIngredientLabel, bread;
	JLabel ingredientsLabel, breadLabel, amountLabel;
	JTextField totalAmount;
	JButton amountButton, exitButton;

	//Zero-arg constructor for ValenciaSandwichShop
	ValenciaSandwichShop() {

		/*Create the frame for the Sandwich Shop*/
		jf = new JFrame("Valencia Sandwich Shop");

		/*Create Panels for holding fields*/
		panel1 = new JPanel();
		panel2 = new JPanel();
		panel3 = new JPanel();
		panel4 = new JPanel();
		masterPanel = new JPanel();

		/*New List item for bread & meat choices*/
		mainIngredientLabel = new JList<>(meatChoice);
		bread = new JList<>(breadChoice);

		/*Create label objects for panels*/
		ingredientsLabel = new JLabel("Choose a main ingredient: ");
		breadLabel = new JLabel("Choose a bread type: ");
		amountLabel = new JLabel("Total Amount: ");

		//Creates text field
		totalAmount = new JTextField(3);
		totalAmount.setEditable(false);

		//Creates buttons
		amountButton = new JButton("Check Amount");
		exitButton = new JButton("Exit");

		/*Add in the panel contents*/
		panel1.add(ingredientsLabel);
		panel1.add(mainIngredientLabel);
		panel2.add(breadLabel);
		panel2.add(bread);
		panel3.add(amountLabel);
		panel3.add(totalAmount);
		panel4.add(amountButton);
		panel4.add(exitButton);

		/*Add to the main panel*/
		masterPanel.add(panel1);
		masterPanel.add(panel2);
		masterPanel.add(panel3);
		masterPanel.add(panel4);

		//Setup the master panel
		masterPanel.setLayout(new GridLayout(4, 1));
		jf.add(masterPanel);
		jf.setVisible(true);
		jf.setSize(300, 300);

		// Setup action listener for the exit button
		exitButton.addActionListener(new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent event) {
				System.exit(0);
			}
		});

		//Setup action listener for the choices
		amountButton.addActionListener(new ActionListener()	{
			@Override
			public void actionPerformed(ActionEvent event) {

				//Extracts index of the selected item from the list box
				int indexIngredient = mainIngredientLabel.getSelectedIndex();
				int indexBread = bread.getSelectedIndex();

				/*Set an amount based on what combination was chosen*/
				if(indexIngredient == 0 && indexBread == 0) {
					totalAmount.setText("5");
				}

				else if(indexIngredient == 0 && indexBread == 1) {
					totalAmount.setText("10");
				}

				else if(indexIngredient == 0 && indexBread == 2) {
					totalAmount.setText("15");
				}

				else if(indexIngredient == 1 && indexBread == 0) {
					totalAmount.setText("20");
				}

				else if(indexIngredient == 1 && indexBread == 1) {
					totalAmount.setText("25");
				}

				else if(indexIngredient == 1 && indexBread == 2) {
					totalAmount.setText("30");
				}

				else if(indexIngredient == 2 && indexBread == 0) {
					totalAmount.setText("35");
				}

				else if(indexIngredient == 2 && indexBread == 1) {
					totalAmount.setText("40");
				}

				else if(indexIngredient == 2 && indexBread == 2) {
					totalAmount.setText("45");
				}
			}

		});

	}
}