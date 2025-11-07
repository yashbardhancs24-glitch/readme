package javapractice;

import java.util.Scanner;

public class Perimeter {
	public static void main(String[] abc) {
		Scanner sc= new Scanner(System.in);
		int  length= sc.nextInt();
		int  width= sc.nextInt();
		sc.close();
		

		System.out.println(2 * (length + width));
	}

	

}
