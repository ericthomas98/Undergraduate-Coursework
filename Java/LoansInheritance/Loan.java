import java.util.Objects;

public abstract class Loan implements LoanConstants/*implements LoanConstants*/{

	@Override
	public int hashCode() {
		return Objects.hash(customer_last_name, interest_rate, loan_amount, loan_number, loan_term);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Loan other = (Loan) obj;
		return Objects.equals(customer_last_name, other.customer_last_name)
				&& Double.doubleToLongBits(interest_rate) == Double.doubleToLongBits(other.interest_rate)
				&& Double.doubleToLongBits(loan_amount) == Double.doubleToLongBits(other.loan_amount)
				&& loan_number == other.loan_number && loan_term == other.loan_term;
	}

	protected int loan_number; 
	protected String customer_last_name;
	protected double loan_amount;
	protected double interest_rate;
	protected int loan_term;
		
	//0-arg Constructor
	public Loan() {
		this.loan_number = 0;
		this.customer_last_name = "No customer on file";
		this.loan_amount = 0;
		this.loan_term = 0;
	}
	
	//Full argument Loan Constructor
	public Loan(int number, String lastname, double amount, double rate, int term) {
		this.setLoan_number(number);
		this.setCustomer_last_name(lastname);
		this.setLoan_amount(amount);
		this.setInterest_rate(rate);
		this.setLoan_term(term);
	}
	
	
	//Getters and Setters
	public int getLoan_number() {
		return loan_number;
	}

	public void setLoan_number(int loan_number) {
		this.loan_number = loan_number;
	}

	public String getCustomer_last_name() {
		return customer_last_name;
	}

	public void setCustomer_last_name(String customer_last_name) {
		this.customer_last_name = customer_last_name;
	}

	public double getLoan_amount() {
		   return this.loan_amount;
		   }

	public void setLoan_amount(double loan_amount) {
        if (loan_amount <= MAXLOAN)
        	this.loan_amount = loan_amount;
        else
        	System.out.println("Loan must be less than 50,000\n");//**MOST LIKELY ADD THIS TO THE TOSTRING
	}

	public double getInterest_rate() {
	
		return interest_rate;
	}

	public void setInterest_rate(double interest_rate) {
		this.interest_rate = interest_rate;
	}

	public int getLoan_term() {
		return loan_term;
	}

	 void setLoan_term(int loan_term) {
		 //If loan_term is not 3 or 5, set to 1.
		 switch(loan_term){
		 	case MEDIUM_TERM:
				this.loan_term = loan_term;
		 		break;
		 	case LONG_TERM:
				this.loan_term = loan_term;
				break;
		 	default:
				this.loan_term = SHORT_TERM;
		 }
	 }
	
	//PRINT STATEMENTS
	public String toString() {
		String result;
		result = "Loan number: " + getLoan_number() + 
				 "\nLast name: " + getCustomer_last_name() +
				 "\nLoan amount: " + getLoan_amount() +
				 "\nInterest Rate: " + getInterest_rate() +
				 "\nLoan Term: " + getLoan_term() + "\n";
		return result;
	}

}