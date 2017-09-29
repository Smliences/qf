package Day07;
import java.util.Scanner;
/*1.有一个从小到大排序的数组，而且数组中一个空位置，用0表示，
 * 用户输入一个数，如果这个数存在，删除，如果不存添加
 */
public class Test4 {
	public static boolean getTheSameNum(int[] array,int num) {
		for(int i = 0; i < array.length-1;i++) {
			if(array[i] == num) {
				for(int j = i; j < array.length - 1; j++) {
					array[j] = array[j + 1];
				}
				array[array.length - 2] = 0;
			}
			break;
		}
		return true;
	}
	public static boolean printIntFromArray(int[] array) {
		//参数合法性判断
		if (null == array) {
			System.out.println("传入参数不合法");
			return false; //函数运行异常！
		}
		
		for (int i = 0; i < array.length; i++) {
			System.out.println("array[" + i + "] = " + array[i]);
		}
		
		return true; //函数运行正常
	} 


	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8,9,0};
		
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		getTheSameNum(arr,a);
		printIntFromArray(arr);
	}


}
