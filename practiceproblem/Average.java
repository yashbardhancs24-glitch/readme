package javapractice;

import java.util.Scanner;

public class Average {
	public static void main(String[] abc) {
		Scanner sc= new Scanner(System.in);
		int  first= sc.nextInt();
		int  second= sc.nextInt();
		int  third= sc.nextInt();
		sc.close();
		

		System.out.println((first +second +third) / 100);
	}

}


