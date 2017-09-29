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
			System.out.println("�������벻�Ϸ�");
			return false;
		}
		int j = 0;
		for (int i = 0; i < arr.length - 1; i++) {
			//�ж��Ƿ�����ͬ��Ԫ��
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
	//����Ԫ�ط���
	public static boolean insertNumber(int[] arr,int insert) {
		//�жϲ����Ƿ�Ϸ�
		if (null == arr || 0 == arr.length || 0 >= insert) {
			System.out.println("�������벻�Ϸ�");
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
	//ɾ��Ԫ�ط���
	public static boolean deleteNumber(int[] arr, int delete) {
		//�жϲ����Ƿ�Ϸ�
		if (null == arr || 0 == arr.length || 0 >= delete) {
			System.out.println("�������벻�Ϸ�");
			return false;
		}
		//����һ��index���飬�����洢Ԫ����ͬ���±�
		int[] index = new int[arr.length];
		int g = 0;
			for (int i = 0; i <= arr.length - 1; i++) {
				if (delete == arr[i]) {
					index[g] = i;
					g++;
				}
			}
			//��Ϊÿһ��ǰ�ƣ���ͬԪ�ص������±궼��Ǩ�ƣ�����
			for (int i = 1; i < index.length; i++) {
				if (index[i] != 0) {
					index[i] = index[i] - i;
				}
			}
			//��ͬԪ���±�������˵�һλ ����ѭ��ǰ��
		for (int i = 0; i < index.length; i++) {
			if (index[i] != 0) 
			for (int j = index[i]; j < arr.length - 1; j++) {
				arr[j] = arr[j+1];
			}
			
		}
		return true;
	}
	//��ӡ
	public static boolean printIntFromArray(int[] arr) {
		if (null == arr) {
			System.out.println("����������Ϸ�");
			return false;
		}
		
		for (int i = 0; i < arr.length; i++) {
			System.out.println("array[" + i + "] = " + arr[i]);
		}
		return true;
	}
}
