package Day10;

import java.util.Arrays;

/*
  自定义实现工具类 MyArrayTools 
  	所有的方法全部用static修饰，不需要成员变量和构造方法
  	
  	【总结】
  		工具类，没有成员变量，没有构造方法
  		
  		静态的方法都是需要外部的数据传递的，不需要借助于成员变量来保存数据
 */
class MyArrayTools {
	/**
	 * 使用static修饰的静态方法，实现选择排序
	 * 
	 * @param arr 需要进行选择排序的int类型的数组
	 * @return boolean类型， 返回true表示函数运行成功，返回false表示函数运行失败
	 * 			失败原因：	1. 传入的数组首地址为null 2. 传入的数组元素个数为0
	 * @since v1.0
	 * @author 刘晓磊
	 */
	public static boolean selectSort(int[] arr) {
		//参数合法性判断
		if (null == arr || 0 == arr.length) {
			return false; //表示函数运行失败
		}
		
		//外部循环控制要进行的查找次数
		for (int i = 0; i < arr.length - 1; i++) {
			//假设最小值是下标为i的元素
			int index = i;
			
			//利用循环从下标i + 1，遍历整个数组，从数组中找最小值，保存其下标到index 当中
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[index] > arr[j]) {
					index = j;
				}
			}
			
			//如果找到的最小值不是预期假设的i值，交换位置
			if (index != i) {
				int temp = arr[index];
				arr[index] = arr[i];
				arr[i] = temp;
			}
		}
		
		return true;
	}
	/**
	 * 
	 * 使用static修饰的静态方法，实现冒泡排序
	 * 
	 * @param arr 需要进行选择排序的int类型的数组
	 * @return boolean类型， 返回true表示函数运行成功，返回false表示函数运行失败
	 * 			失败原因：	1. 传入的数组首地址为null 2. 传入的数组元素个数为0
	 * @since v1.0
	 * @author 刘晓磊
	 */
	public static boolean bubbleSort(int[] arr) {
		//参数合法性判断
		if (null == arr || 0 == arr.length) {
			return false;
		}
		
		//外层循环控制需要比较的轮次
		for (int i = 0; i < arr.length - 1; i++) {
			//内层循环控制当前轮次要进行的两两比较次数
			for (int j = 0; j < arr.length - i - 1; j++) {
				if (arr[j] < arr[j + 1]) {
					int temp = arr[j];
					arr[j] = arr[j + 1];
					arr[j + 1] = temp;
				}
			}
		}
		
		return true;
	}
	
	/**
	 * 自己实现myToString方法
	 * @param arr 需要转换成String类型的数组
	 * @return	String 返回一个字符串
	 * 			实例:	{1, 2, 3, 4, 5}
	 * 			结果:   [1, 2, 3, 4, 5]
	 */
	public static String myToString(int[] arr) {
		String arrString = "[";
		for (int i = 0; i < arr.length; i++) {
			arrString += arr[i];
			arrString += ", ";
		}
		arrString += "]";
		return arrString;
	}
	
}

public class Demo5 {
	public static void main(String[] args) {
		int[] arr = {1, 10, 3, 2, 5, 8, 7, 4, 6, 9};
		
		//使用自定义的工具类MyArrayTools 
		MyArrayTools.selectSort(arr);
		System.out.println(Arrays.toString(arr));
		
		MyArrayTools.bubbleSort(arr);
		System.out.println(Arrays.toString(arr));
		
	}
}













