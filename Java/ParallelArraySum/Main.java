/*
 * Eric Thomas
 * Professor Mary Walauskis
 * Software Development Class
 * This program will implement a parallel array sum and compare the performance with a single thread sum. It will create
 * an array of 200 million random numbers between 1 and 10. After this it will compute the sum in parallel by utilizing multiple threads.
 * Finally it will compute the sum with only ONE thread and display the sum as well as times for each case.
 * */

import java.util.Random;

class Summation extends Thread {

	private int[] dataInMilliseconds;
	private int smallest, largest, partial;
	
	public Summation(int[] arr, int low, int high){
		this.dataInMilliseconds = arr;
		this.smallest = low;
		this.largest = Math.min(high, arr.length);
	}
	
	public int getPartialSum(){
		return partial;
	}
	
	public void run(){
		partial = sum(dataInMilliseconds, smallest, largest);
	}
	
	public static int sum(int[] arr){
		return sum(arr, 0, arr.length);
	}
	
	public static int sum(int[] arr, int low, int high){
		int total = 0;
		for (int i = low; i < high; i++) {
			total += arr[i];
		}
		return total;
	}
	
	public static int parallelSum(int[] arr){
		return parallelSum(arr, Runtime.getRuntime().availableProcessors());
	}
	
	public static int parallelSum(int[] arr, int threads){
		
		int size = (int) Math.ceil(arr.length * 1.0 / threads);
		Summation[] sums = new Summation[threads];
		
		for (int i = 0; i < threads; i++) {
			sums[i] = new Summation(arr, i * size, (i + 1) * size);
			sums[i].start();
		}
		
		try {
			for (Summation sum : sums) {
				sum.join();
			}
		} catch (InterruptedException e){}
		
		int total = 0;
		for (Summation sum : sums) {
			total += sum.getPartialSum();
		}
		
		return total;
	}
} 

public class Main {

	public static void main(String[] args)
	{
		Random rand = new Random();
		int[] arr = new int[200000000];
		for (int i = 0; i < arr.length; i++) {
			arr[i] = rand.nextInt(10) + 1;
		}
		
		long start = System.currentTimeMillis();
		System.out.println("Individual total: " + Summation.sum(arr));
		System.out.println("Single time in milliseconds: " + (System.currentTimeMillis() - start));
		System.out.println("");

		start = System.currentTimeMillis();
		System.out.println("Parallel total: " +Summation.parallelSum(arr));
		System.out.println("Parallel time in milliseconds: " + (System.currentTimeMillis() - start));
	}
}