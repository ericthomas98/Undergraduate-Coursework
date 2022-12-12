/*
 * Eric Thomas
 * Last Update: Oct 09, 2022
 * A text analyzer that reads a file and outputs statistics about that file. It outputs the word frequencies 
 * of all words in the file, sorted by the most frequently used word. The output is a set of pairs, each pair 
 * containing a word and how many times it occurred in the file.
*/

import java.awt.EventQueue;

import javax.swing.JFrame;
import java.awt.BorderLayout;
import javax.swing.JPanel;
import java.awt.FlowLayout;
import javax.swing.JSplitPane;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.border.TitledBorder;
import java.awt.Font;
import javax.swing.SwingConstants;
import java.awt.Color;
import javax.swing.JDesktopPane;
import javax.swing.border.CompoundBorder;
import javax.swing.border.EtchedBorder;
import javax.swing.JComboBox;
import javax.swing.JToggleButton;

public class Main_Frame {

	private JFrame frame;

	/*Create the application.*/
	public Main_Frame() {
	//initialize();
	}

	/* Initialize the contents of the frame. */
	private void initialize() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Main_Frame window = new Main_Frame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		
		//Work in progress..
		
		JLabel titleText = new JLabel("Java Word Occurence Program");
		titleText.setForeground(Color.WHITE);
		titleText.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		titleText.setForeground(Color.WHITE);
		titleText.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		
		JLabel myCredintials = new JLabel("Eric Thomas Software Development");
		myCredintials.setForeground(Color.WHITE);
		myCredintials.setFont(new Font("Times New Roman", Font.BOLD | Font.ITALIC, 18));
		
		frame = new JFrame();
		frame.setResizable(false);
		frame.getContentPane().setBackground(Color.BLACK);
		frame.getContentPane().setLayout(new BorderLayout(0, 0));
		frame.setBounds(100, 200, 552, 403);

		//Add working areas
		JPanel northArea = new JPanel();
		frame.getContentPane().add(northArea, BorderLayout.NORTH);
		northArea.setForeground(Color.WHITE);
		northArea.setBackground(Color.BLACK);
		northArea.add(titleText);
		
		JPanel southArea = new JPanel();
		frame.getContentPane().add(southArea, BorderLayout.SOUTH);
		southArea.setForeground(Color.WHITE);
		southArea.setBackground(Color.BLACK);
		southArea.add(myCredintials);
		
		JToggleButton tglbtnNewToggleButton = new JToggleButton("Do you like this program?");
		frame.getContentPane().add(tglbtnNewToggleButton, BorderLayout.CENTER);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
}
