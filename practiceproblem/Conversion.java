package javapractice;

import java.util.Scanner;

public class Conversion {
	public static void main(String[] abc) {
		Scanner sc= new Scanner(System.in);
		int  Celsius= sc.nextInt();
		sc.close();
		

		System.out.println((Celsius * 9/5) + 32.);
	}

}
