package application;

import java.awt.Color;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
import javax.swing.Timer;


public class trivia implements ActionListener {

	String[] questions = 	{
			"What color is the sky",
			"What year is it? ",
			"Who was the first president of the US?",
			"How many letters are in 'Hello'?",
			"Which big cat is the largest?",
			"Which is the largest planet in the solar system?",
			"How many Olympic rings are there?",
			"Which is the world’s largest ocean?",
			"Which is the largest continent?",
			"How many Great Lakes are there?",
	};

	String[][] options = 	{
			{"RED","BLUE","ORANGE","PURPLE"},
			{"2000","2010","2020","2022"},
			{"GEORGE WASHINGTON","DONALD TRUMP","JOE BIDEN","OBAMA"},
			{"1", "2", "5", "9"},
			{"TIGER", "CHEETAH", "LION", "PANTHER"},
			{"MARS","VENUS","SATURN","JUPITER"},
			{"3","7","5","12"},
			{"PACIFIC", "ATLANTIC", "INDIAN", "ARCTIC"},
			{"ANTARCTICA", "NORTH AMERICA", "ASIA", "AFRICA"},
			{"5", "7", "3", "1"},
	};

	char[] correctAnswers = {
			'B',
			'D',
			'A',
			'C',
			'A',
			'D',
			'C',
			'A',
			'C',
			'A',
			
	};
	
	//Declare Variables
	char playerChoice;
	char correctAnswer;
	int index;
	int totalCorrectQuestions = 0;
	int total_questions = questions.length;
	int result;
	int seconds = 5;
	
	//Create objects for frames, buttons, labels, and textFields
	JFrame frame = new JFrame();
	JTextField welcomeBanner = new JTextField();
	JTextArea questionBanner = new JTextArea();
	
	JButton buttonA = new JButton();
	JButton buttonB = new JButton();
	JButton buttonC = new JButton();
	JButton buttonD = new JButton();
	
	JLabel correctAnswer_labelA = new JLabel();
	JLabel correctAnswer_labelB = new JLabel();
	JLabel correctAnswer_labelC = new JLabel();
	JLabel correctAnswer_labelD = new JLabel();
	
	JLabel timeRemaining_label = new JLabel();
	JLabel seconds_left = new JLabel();
	
	JTextField number_of_questions_correct = new JTextField();
	JTextField percentage_of_questions_correct = new JTextField();
	
	Timer countdownClock = new Timer(1000, new ActionListener() {

		@Override
		public void actionPerformed(ActionEvent e) {
			seconds--;
			seconds_left.setText(String.valueOf(seconds));
			if(seconds <= 0) {
				generateReport();
			}
		}
	});
	
	//Trivia Method
	trivia(){

		//FRAME DECLARATION
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setTitle("Valencia Trivia Game");//Title for frame
		frame.getContentPane().setBackground(new Color(0x43464B));//Background color for Frame
		frame.pack();//Center the frame
		frame.setSize(700,750);//Size of frame
		frame.setLayout(null);//No layout manager
		frame.setResizable(false);//Dont let frame be resized
		frame.setLocationRelativeTo(null);  //Used to center the window
		
		//Welcome banner
		welcomeBanner.setBounds(50,50,500,100);
		welcomeBanner.setBackground(Color.BLACK);
		welcomeBanner.setForeground(Color.WHITE);
		welcomeBanner.setFont(new Font("Trebuchet MS", Font.BOLD, 35));
		welcomeBanner.setHorizontalAlignment(JTextField.CENTER);
		welcomeBanner.setText("Welcome to Trivia Night!");
 
		//Question banner
		questionBanner.setBounds(50,175,500,100);
		questionBanner.setLineWrap(true);
		questionBanner.setWrapStyleWord(true);
		questionBanner.setBackground(Color.BLACK);
		questionBanner.setForeground(Color.WHITE);
		questionBanner.setFont(new Font("Trebuchet MS", Font.BOLD,25));
		questionBanner.setEditable(false);
		
		//--------------------------- Buttons ---------------------------
		
		//Button A
		buttonA.setBounds(50,300,100,100);
		buttonA.setFont(new Font("Trebuchet MS", Font.BOLD, 35));
		buttonA.setFocusable(false);
		buttonA.addActionListener(this);
		buttonA.setText("A");
		
		//Button B
		buttonB.setBounds(50,400,100,100);
		buttonB.setFont(new Font("Trebuchet MS", Font.BOLD, 35));
		buttonB.setFocusable(false);
		buttonB.addActionListener(this);
		buttonB.setText("B");

		//Button C
		buttonC.setBounds(50,500,100,100);
		buttonC.setFont(new Font("Trebuchet MS", Font.BOLD, 35));
		buttonC.setFocusable(false);
		buttonC.addActionListener(this);
		buttonC.setText("C");

		//Button D
		buttonD.setBounds(50,600,100,100);
		buttonD.setFont(new Font("Trebuchet MS", Font.BOLD, 35));
		buttonD.setFocusable(false);
		buttonD.addActionListener(this);
		buttonD.setText("D");
		
		//--------------------------- Correct Answer Labels ---------------------------
		
		//Label A
		correctAnswer_labelA.setBounds(175,300,500,100);
		correctAnswer_labelA.setBackground(Color.BLACK);
		correctAnswer_labelA.setForeground(Color.GREEN);
		correctAnswer_labelA.setFont(new Font("Trebuchet MS", Font.BOLD, 35));
		
		//Label B
		correctAnswer_labelB.setBounds(175,400,500,100);
		correctAnswer_labelB.setBackground(Color.BLACK);
		correctAnswer_labelB.setForeground(Color.GREEN);
		correctAnswer_labelB.setFont(new Font("Trebuchet MS", Font.BOLD, 35));
		
		//Label C
		correctAnswer_labelC.setBounds(175,500,500,100);
		correctAnswer_labelC.setBackground(Color.BLACK);
		correctAnswer_labelC.setForeground(Color.GREEN);
		correctAnswer_labelC.setFont(new Font("Trebuchet MS", Font.BOLD, 35));
		
		//Label D
		correctAnswer_labelD.setBounds(175,600,500,100);
		correctAnswer_labelD.setBackground(Color.BLACK);
		correctAnswer_labelD.setForeground(Color.GREEN);
		correctAnswer_labelD.setFont(new Font("Trebuchet MS", Font.BOLD, 35));
		
		//Countdown clock
		seconds_left.setBounds(575,300,100,400);
		seconds_left.setBackground(Color.YELLOW);
		seconds_left.setForeground(Color.BLACK);
		seconds_left.setFont(new Font("Trebuchet MS", Font.BOLD, 35));
		seconds_left.setBorder(BorderFactory.createBevelBorder(1));
		seconds_left.setOpaque(true);
		seconds_left.setHorizontalAlignment(JTextField.CENTER);
		seconds_left.setText(String.valueOf(seconds));
		
		//countdownClockLabel
		timeRemaining_label.setBounds(575,175,100,400);
		timeRemaining_label.setBackground(Color.YELLOW);
		timeRemaining_label.setForeground(Color.BLACK);
		timeRemaining_label.setFont(new Font("Trebuchet MS", Font.BOLD, 20));
		timeRemaining_label.setHorizontalAlignment(JTextField.CENTER);
		timeRemaining_label.setText("TIMER:");
		
		
		//Label for the number of questions correctly guessed.
		number_of_questions_correct.setBounds(575,50,100,100);
		number_of_questions_correct.setBackground(Color.BLACK);
		number_of_questions_correct.setForeground(Color.WHITE);
		number_of_questions_correct.setFont(new Font("Trebuchet MS",Font.BOLD,20));
		number_of_questions_correct.setBorder(BorderFactory.createBevelBorder(1));
		number_of_questions_correct.setHorizontalAlignment(JTextField.CENTER);
		number_of_questions_correct.setEditable(false);
		
		//Percentage of questions correctly guessed
		percentage_of_questions_correct.setBounds(575,175,100,100);
		percentage_of_questions_correct.setBackground(Color.BLACK);
		percentage_of_questions_correct.setForeground(Color.WHITE);
		percentage_of_questions_correct.setFont(new Font("Trebuchet MS",Font.BOLD,20));
		percentage_of_questions_correct.setBorder(BorderFactory.createBevelBorder(1));
		percentage_of_questions_correct.setHorizontalAlignment(JTextField.CENTER);
		percentage_of_questions_correct.setEditable(false);

		//Add to frame
		frame.add(timeRemaining_label);
		frame.add(seconds_left);
		
		frame.add(correctAnswer_labelA);
		frame.add(correctAnswer_labelB);
		frame.add(correctAnswer_labelC);
		frame.add(correctAnswer_labelD);

		
		frame.add(buttonA);
		frame.add(buttonB);
		frame.add(buttonC);
		frame.add(buttonD);
		
		frame.add(welcomeBanner);
		frame.add(questionBanner);
		
		frame.setVisible(true);
		
		nextQuestion();
		
	}

	//nextQuestion method
	public void nextQuestion() {
		if(index >= total_questions) {
			results();
		}
		else {
			//Algorithm for setting text for current question as well as the correct answer for each
			welcomeBanner.setText("Question #" + (index + 1));
			questionBanner.setText(questions[index]);
			correctAnswer_labelA.setText(options[index][0]);
			correctAnswer_labelB.setText(options[index][1]);
			correctAnswer_labelC.setText(options[index][2]);
			correctAnswer_labelD.setText(options[index][3]);
			countdownClock.start();

		}
	}
	
	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		buttonA.setEnabled(false);
		buttonB.setEnabled(false);
		buttonC.setEnabled(false);
		buttonD.setEnabled(false);
		
		if(e.getSource() == buttonA) {
			correctAnswer = 'A';
			if(correctAnswer == correctAnswers[index]) {
				totalCorrectQuestions ++;
			}
		}		
		
		if(e.getSource() == buttonB) {
			correctAnswer = 'B';
			if(correctAnswer == correctAnswers[index]) {
				totalCorrectQuestions ++;
			}
		}
		
		if(e.getSource() == buttonC) {
			correctAnswer = 'C';
			if(correctAnswer == correctAnswers[index]) {
				totalCorrectQuestions ++;
			}
		}
		
		if(e.getSource() == buttonD) {
			correctAnswer = 'D';
			if(correctAnswer == correctAnswers[index]) {
				totalCorrectQuestions ++;
			}
		}
		
		generateReport();
	}
	
	public void generateReport() {
		//Change font to red IF the answer is incorrect
		// TODO Auto-generated method stub
		countdownClock.stop();

		buttonA.setEnabled(false);
		buttonB.setEnabled(false);
		buttonC.setEnabled(false);
		buttonD.setEnabled(false);
		
		if(correctAnswers[index] != 'A') {
			correctAnswer_labelA.setForeground(Color.RED);
		}
		
		if(correctAnswers[index] != 'B') {
			correctAnswer_labelB.setForeground(Color.RED);
		}
		
		if(correctAnswers[index] != 'C') {
			correctAnswer_labelC.setForeground(Color.RED);
		}
		
		if(correctAnswers[index] != 'D') {
			correctAnswer_labelD.setForeground(Color.RED);
		}
		
		//Set to revert the color back to green after it shows red. (USE TIMER (2.5s))
		Timer pause = new Timer(2500, new ActionListener() {
			
			//Flip colors back TO green FROM red after the 2.5s pause
			@Override
			public void actionPerformed (ActionEvent e) {
				correctAnswer_labelA.setForeground(Color.GREEN);
				correctAnswer_labelB.setForeground(Color.GREEN);
				correctAnswer_labelC.setForeground(Color.GREEN);
				correctAnswer_labelD.setForeground(Color.GREEN);

				correctAnswer = ' ';
				seconds = 5;
				seconds_left.setText(String.valueOf(seconds));
				
				buttonA.setEnabled(true);
				buttonB.setEnabled(true);
				buttonC.setEnabled(true);
				buttonD.setEnabled(true);
				index ++;
				nextQuestion();
			}
		});
		
		//Start the timer
		pause.setRepeats(false);
		pause.start();
				
	}
	
	public void results() {
		
		buttonA.setEnabled(false);
		buttonB.setEnabled(false);
		buttonC.setEnabled(false);
		buttonD.setEnabled(false);
		
		result = (int)((totalCorrectQuestions / (double)total_questions) * 100);

		welcomeBanner.setText("RESULTS --->");
		questionBanner.setText("");
		correctAnswer_labelA.setText("");
		correctAnswer_labelB.setText("");
		correctAnswer_labelC.setText("");
		correctAnswer_labelD.setText("");

		number_of_questions_correct.setText("("+totalCorrectQuestions+"/"+total_questions+")");
		percentage_of_questions_correct.setText(result + "%");

		frame.add(number_of_questions_correct);
		frame.add(percentage_of_questions_correct );
	}
}