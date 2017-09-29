package day05;

import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {
		int[] arr = new int[10];
		Scanner sn = new Scanner(System.in);
		int s; 
		int max = 0;
		int index = 0;
		
		for (int i = 0; i < arr.length; i++) {
			s = sn.nextInt();
			arr[i] = s;
			
			if (arr[i] >= max) {
				max = arr[i]; 
				index = i;
			}
		}
		
		System.out.println(max);
		System.out.println(index);
	}
}
