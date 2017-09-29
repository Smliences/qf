import java.util.Scanner;

public class Test {
	public static void main(String[] args) {
		int[] arr = new int[10];
		getNumberFromKeyBord(arr);
		MaoPaoSort(arr);
		printIntFromArray(arr);
}
	//选择排序法
	public static boolean mySelectSort(int[] arr) {
		//参数合法性判断
		if (null == arr || 0 == arr.length) {
			System.out.println("传入参数不合法");
			return false;
		}

		for (int i = 0; i < arr.length - 1; i++) {
			int index = i; //假设
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[index] >  arr[j]) 
					index = j;
			}
			if (index != i) {
				int temp = arr[index];
				arr[index] = arr[i];
				arr[i] = temp;
		}
		}
		return true;
	}
	
	//从键盘上获取int类型的数据
	public static boolean getNumberFromKeyBord(int[] arr) {
		if (null == arr) {
			System.out.println("输入参数不合法");
			return false;
		}
		
		Scanner sc = new Scanner(System.in);
		for (int i = 0; i < arr.length; i++) {
			arr[i] = sc.nextInt();
		}
		return true;
	}
	//打印int类型的数组
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
	
	public static boolean MaoPaoSort(int[] arr) {
		if (null == arr) {
			System.out.println("输入参数有问题");
			return false;
		}
		for (int i = 0; i < arr.length - 1; i++) {
			for (int j = 0; j < arr.length - 1 - i; j++) {
				if (arr[j] > arr[j+1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
		return true;
	}
	
}



