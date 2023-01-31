//CP1340 Lab 1 - Arrays and Strings
//Student: Cade Molloy - 20175269
//Due Date: October 4th, 2022
//Prof: Branko Cirovic


public class Lab11 {

	public static void main(String[] args) {
		int[] a = new int[1000];
		init(a);
		findPrimes(a);
		printPrimes(a);
	}
	
	public static void init(int[] a) {
		for(int i = 2; i < 1000; i++) {
			a[i] = 1;
		}
	}
	
	public static void findPrimes(int[] a) {
		for(int p = 2; p*p <= 999; p++) {
			
			for(int i = p*p; i <=999; i += p) {
				a[i] = 0;
			}
		}
	}
	
	public static void printPrimes(int[] a) {
		for(int i = 2; i <=999; i++) {
			if(a[i] == 1) {
				System.out.print(i + " , ");
			}
		}
	}
}
			
