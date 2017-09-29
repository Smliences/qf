package Day07;

import java.util.Scanner;

public class Test1 {
	public static void main(String[] args) {
		int[] arr = {1,3,3,3,3,11,13,0};
		Scanner sc = new Scanner(System.in);
		int num = sc.nextInt();
		insertOrDeleteNumber(arr, num);
		printIntFromArray(arr);
	}
	public static boolean insertOrDeleteNumber(int[] arr,int num) {
		if (null == arr || 0 == arr.length || 0 >= num) {
			System.out.println("参数输入不合法");
			return false;
		}
		int j = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			//判断是否又相同的元素
			if (arr[i] == num) {
				j = 1;
				break;
			} else {
				j = 0;
				
				
			}
		}
		if (j == 1) {
			deleteNumber(arr, num);
		} else {
			insertNumber(arr, num);
		}
		return true;
	}
	//插入元素方法
	public static boolean insertNumber(int[] arr,int insert) {
		//判断参数是否合法
		if (null == arr || 0 == arr.length || 0 >= insert) {
			System.out.println("参数输入不合法");
			return false;
		}
		int index = arr.length - 1;
		for (int i = 0; i < arr.length - 1; i++) {
			if (arr[i] > insert) {
				index = i;
				break;
			}
		}
		for (int i = arr.length - 1; i > index; i--) {
			arr[i] = arr[i - 1];
		}
		arr[index] = insert;
		return true;
	}
	//删除元素方法
	public static boolean deleteNumber(int[] arr, int delete) {
		//判断参数是否合法
		if (null == arr || 0 == arr.length || 0 >= delete) {
			System.out.println("参数输入不合法");
			return false;
		}
		//定义一个index数组，用来存储元素相同的下标
		int[] index = new int[arr.length];
		int g = 0;
			for (int i = 0; i <= arr.length - 1; i++) {
				if (delete == arr[i]) {
					index[g] = i;
					g++;
				}
			}
			//因为每一次前移，相同元素的数组下标都会迁移，所以
			for (int i = 1; i < index.length; i++) {
				if (index[i] != 0) {
					index[i] = index[i] - i;
				}
			}
			//相同元素下标数组除了第一位 其他循环前移
		for (int i = 0; i < index.length; i++) {
			if (index[i] != 0) 
			for (int j = index[i]; j < arr.length - 1; j++) {
				arr[j] = arr[j+1];
			}
			
		}
		return true;
	}
	//打印
	public static boolean printIntFromArray(int[] arr) {
		if (null == arr) {
			System.out.println("传入参数不合法");
			return false;
		}
		
		for (int i = 0; i < arr.length; i++) {
			System.out.println("array[" + i + "] = " + arr[i]);
		}
		return true;
	}
}
