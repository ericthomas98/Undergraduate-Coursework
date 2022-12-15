import java.util.*;
import java.util.Scanner;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public class Main {
		
	public static void main(String[] args) {		

			//array of 5 loans
			Scanner scan = new Scanner(System.in);
			//loan object
			Loan[] usersLoans = new Loan[5];
			double companiesTotalLoanedAmt = 0;
			
			//Ask user for Prime interest rate then scan in
			System.out.println("Enter the current prime interest rate: ");
			double prime_interest_rate = scan.nextDouble();
			scan.nextLine(); // clear buffer
				
				for(int i = 0; i < usersLoans.length; i++) {
					//Get user input for the type of loan
					System.out.println("\nWhat type of loan would you like to create? (B)usiness or (P)ersonal): ");
					String loan_type = scan.nextLine();
				    
					//Business Loans
					if(loan_type.equalsIgnoreCase(("b"))) {
						//What number of loan
						System.out.println("\nLoan #" + (i + 1) + " (Business Loan)");

						System.out.println("Enter the loan number: ");
						int number = scan.nextInt();
						scan.nextLine(); // clear buffer

						System.out.println("\nEnter the last name: ");
						String lastname = scan.nextLine();

						System.out.println("Enter the loan amount: ");
						double amount = scan.nextDouble();
						scan.nextLine(); // clear buffer

						//Call method to calculate the new interest
						double interest_rate = BusinessLoan.calc_interest(prime_interest_rate);
						System.out.println( "Interest rate for you is: " + interest_rate );

						System.out.println("\nEnter the loan term: ");
						int term = scan.nextInt();
						scan.nextLine(); // clear buffer
												
						//Interest calculation
						double accruedInterest = (amount * interest_rate * term) / 100;
						
						//Total amount due calculation
						double endLoanAmtOwed = amount + accruedInterest;
						System.out.println("Total amount due at end of loan is: " + endLoanAmtOwed);
						System.out.println("Total amount of interest payed for this loan is: " + (endLoanAmtOwed - amount));

						//Calc for total with interest
						companiesTotalLoanedAmt += amount; //keep running total
						//Send data to User loans array
						usersLoans[i] = new BusinessLoan(number, lastname, amount, interest_rate, term);

					}				
					//Personal Loans
					else if(loan_type.equalsIgnoreCase(("p"))) {
						//What number of loan
						
						System.out.println("\nLoan #" + (i + 1) + " (Personal Loan)");

						System.out.println("Enter the loan number: ");
						int number = scan.nextInt();
						scan.nextLine(); // clear buffer

						System.out.println("Enter the last name: ");
						String lastname = scan.nextLine();

						System.out.println("Enter the loan amount: ");
						double amount = scan.nextDouble();
						scan.nextLine(); // clear buffer
						
						//Call method to calculate the new interest
						double interest_rate = PersonalLoan.calc_interest(prime_interest_rate);
						System.out.println( "New Interest rate is: " + interest_rate );

						System.out.println("\nEnter the loan term: ");
						int term = scan.nextInt();
						scan.nextLine(); // clear buffer
						
						//Interest calculation
						double accruedInterest = (amount * interest_rate * term) / 100;
						accruedInterest = amount - accruedInterest;
						System.out.println("accrued interest is: " + accruedInterest);
						
						//Total amount due calculation
						double endLoanAmtOwed = amount + accruedInterest;
						System.out.println("Total amount due at end of loan is: " + endLoanAmtOwed);
						
						//Calc for total with interest
						companiesTotalLoanedAmt += amount; //keep running total
						
						usersLoans[i] = new PersonalLoan(number, lastname, amount, interest_rate, term);
						
					}
					
					System.out.println("\nTotal the company has loaned out (not counting interest) amounts to: " + companiesTotalLoanedAmt);

					/* Sir, I am not sure if you wanted us to include the loan check in the run time, so I added the algorithm here just in case.
					//check for equals !=0 so index(0) isn't out of bounds, then check users loan against the last loan amount
					if(i != 0 && usersLoans[i].equals(usersLoans[i-1])) {
						System.out.println("Duplicate loan detected.. ");
					}
					else {
						System.out.println("No duplicate loans detected, please continue.. ");
		
				}*/
			}

				//For loop to print results
				for(int j = 0; j < usersLoans.length; j++) {
					System.out.println("\n" + usersLoans[j]);
				}
	}
}
