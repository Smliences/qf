package Day07;
import java.util.Scanner;
/*1.��һ����С������������飬����������һ����λ�ã���0��ʾ��
 * �û�����һ�����������������ڣ�ɾ��������������
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
		//�����Ϸ����ж�
		if (null == array) {
			System.out.println("����������Ϸ�");
			return false; //���������쳣��
		}
		
		for (int i = 0; i < array.length; i++) {
			System.out.println("array[" + i + "] = " + array[i]);
		}
		
		return true; //������������
	} 


	public static void main(String[] args) {
		int[] arr = {1,2,3,4,5,6,7,8,9,0};
		
		Scanner sc = new Scanner(System.in);
		int a = sc.nextInt();
		getTheSameNum(arr,a);
		printIntFromArray(arr);
	}


}
