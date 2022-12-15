
public class PersonalLoan extends Loan{
	
	//0-arg Constructor
	public PersonalLoan() {
		super();
	}
	
	//PersonalLoan subclass constructor
	public PersonalLoan(int number, String lastname, double amount, double rate, int term) {
		super(number, lastname, amount, rate, term);
		this.setLoan_number(number);
		this.setCustomer_last_name(lastname);
		this.setLoan_amount(amount);
		this.setInterest_rate(rate);
		this.setLoan_term(term);
		toString();
	}
	
	public static double calc_interest(double prime_interest_rate) {
		double interest_rate = prime_interest_rate + 2;
		return interest_rate;
	}
}
