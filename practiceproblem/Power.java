package javapractice;

import java.util.Scanner;

public class Power {
	public static void main(String[] abc) {
		Scanner sc= new Scanner(System.in);
		int base = sc.nextInt();
		int exponent= sc.nextInt();
		

		System.out.println(Math.pow(base, exponent));
	}

}
