/*Program to compare iterative vs recursion time in nano-seconds*/
public class FibonacciProblem {
	
	public static void main(String[] args) {

		final double amountToCount = 20;
		
		//Declare recursive and iterative array to compare 
		double[] iterativeTime = new double[20];
		double[] recursiveTime = new double[20];

		//Fill iterative time array
		for(int i = 0; i < amountToCount; i++){
			
			long startTime = System.nanoTime();
			FibonacciIterative(i);
			long endTime = System.nanoTime();
			var elapsedTime = endTime-startTime;
			iterativeTime[i] = elapsedTime;
		}

		//Fill recursive array
		for(int i = 0; i < amountToCount; i++){
			long startTime = System.nanoTime();
			FibonacciRecursive(i);
			long endTime = System.nanoTime();
			var elapsedTime = endTime-startTime;
			recursiveTime[i] = elapsedTime;
			
		}

		//Compare results side by side
		 System.out.println("Here are the comparisons side by side:\n");
		 
		for(int i = 0; i < amountToCount; i++) {
			 System.out.println("Place holder: " + (i + 1) );
			 
			 System.out.println("Iterative time in nano-seconds... " + iterativeTime[i]);
			 
			 System.out.println("Recursive time in nano-seconds... " + recursiveTime[i]);
			 
			 System.out.println("\n");
		}

	}// end main

	//Fibonacci function (Recursive)
	public static long FibonacciRecursive(long n) {
		if (n == 0){ return n;}
		if (n == 1){ return n;}
		else
			return FibonacciRecursive(n - 1) + FibonacciRecursive(n - 2);
	}
	//Fibonacci function (Iterative)
	
	public static long FibonacciIterative(long n) {
		
		int PrevPrev, PrevNumber = 0, CurrNumber = 1;

		for (int i = 1; i < n ; i++) {
			PrevPrev = PrevNumber;
			PrevNumber = CurrNumber;
			CurrNumber = PrevPrev + PrevNumber;
		}
		return CurrNumber;
	}
}