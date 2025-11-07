package javapractice;

import java.util.Scanner;

public class Add {
	public static void main(String[] abc) {
		Scanner sc= new Scanner(System.in);
		int a = sc.nextInt();
		int b = sc.nextInt();
		sc.close();

		System.out.println(a+b);
	}

}
