package Day10;

import java.util.Arrays;

/*
  静态成员方法的使用：
  	做成工具类，提供给开发者使用，更加便利，但是所需的数据都需要通过参数传递
  	
  	Arrays Java当中的数组工具类，集成了大量的数组中常用的方法，所有的方法都是通过类名直接调用
  	
  	【重载】
  		在通过一个类里面，存在返回值类型，方法名相同的方法，但是参数不一样，这称之为方法的【重载】
  		重载操作可以简化方法的命名，而且可以提高开发效率
  
  	Arrays 工具类，学会三个方法
  		sort  toString  binarySearch方法
 */

public class Demo4 {
	public static void main(String[] args) {
		int[] arr = {1, 10, 3, 2, 5, 8, 7, 4, 6, 9};
//		int arr2[] = {1, 10, 3, 2, 5, 8, 7, 4, 6, 9};
//		int[] arr3 = new int[10];
//		int arr4[] = new int[10];
		//int arr[3] = {1, 2, 3}; //C语言中的数组，Java不支持
		
		//Arrays 工具类里面的sort方法，可以通过类名直接调用，因为这是一个用static修饰的静态方法
		Arrays.sort(arr);
		
		//Arrays 工具类里面的binarySearch方法，这个方法要求查询的数组是一个已经通过排序得到的有序数组
		int index = Arrays.binarySearch(arr, 6);
		System.out.println("6 at " + index);
		
		//Arrays 工具类当中的toString 方法，把数组转换成String字符串形式，返回给调用者
		String arrString = Arrays.toString(arr);
		System.out.println(arrString);
	}
}
