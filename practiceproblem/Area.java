package javapractice;

import java.util.Scanner;

public class Area {
	public static void main(String[] abc) {
		Scanner sc= new Scanner (System.in);
		int  radius= sc.nextInt();
		int height= sc.nextInt();
		sc.close();
		

		System.out.println(3.14 * radius*radius * height);
	}


}
