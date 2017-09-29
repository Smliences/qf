package Day10;

import java.util.Arrays;

/*
  �Զ���ʵ�ֹ����� MyArrayTools 
  	���еķ���ȫ����static���Σ�����Ҫ��Ա�����͹��췽��
  	
  	���ܽ᡿
  		�����࣬û�г�Ա������û�й��췽��
  		
  		��̬�ķ���������Ҫ�ⲿ�����ݴ��ݵģ�����Ҫ�����ڳ�Ա��������������
 */
class MyArrayTools {
	/**
	 * ʹ��static���εľ�̬������ʵ��ѡ������
	 * 
	 * @param arr ��Ҫ����ѡ�������int���͵�����
	 * @return boolean���ͣ� ����true��ʾ�������гɹ�������false��ʾ��������ʧ��
	 * 			ʧ��ԭ��	1. ����������׵�ַΪnull 2. ���������Ԫ�ظ���Ϊ0
	 * @since v1.0
	 * @author ������
	 */
	public static boolean selectSort(int[] arr) {
		//�����Ϸ����ж�
		if (null == arr || 0 == arr.length) {
			return false; //��ʾ��������ʧ��
		}
		
		//�ⲿѭ������Ҫ���еĲ��Ҵ���
		for (int i = 0; i < arr.length - 1; i++) {
			//������Сֵ���±�Ϊi��Ԫ��
			int index = i;
			
			//����ѭ�����±�i + 1�������������飬������������Сֵ���������±굽index ����
			for (int j = i + 1; j < arr.length; j++) {
				if (arr[index] > arr[j]) {
					index = j;
				}
			}
			
			//����ҵ�����Сֵ����Ԥ�ڼ����iֵ������λ��
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
	 * ʹ��static���εľ�̬������ʵ��ð������
	 * 
	 * @param arr ��Ҫ����ѡ�������int���͵�����
	 * @return boolean���ͣ� ����true��ʾ�������гɹ�������false��ʾ��������ʧ��
	 * 			ʧ��ԭ��	1. ����������׵�ַΪnull 2. ���������Ԫ�ظ���Ϊ0
	 * @since v1.0
	 * @author ������
	 */
	public static boolean bubbleSort(int[] arr) {
		//�����Ϸ����ж�
		if (null == arr || 0 == arr.length) {
			return false;
		}
		
		//���ѭ��������Ҫ�Ƚϵ��ִ�
		for (int i = 0; i < arr.length - 1; i++) {
			//�ڲ�ѭ�����Ƶ�ǰ�ִ�Ҫ���е������Ƚϴ���
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
	 * �Լ�ʵ��myToString����
	 * @param arr ��Ҫת����String���͵�����
	 * @return	String ����һ���ַ���
	 * 			ʵ��:	{1, 2, 3, 4, 5}
	 * 			���:   [1, 2, 3, 4, 5]
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
		
		//ʹ���Զ���Ĺ�����MyArrayTools 
		MyArrayTools.selectSort(arr);
		System.out.println(Arrays.toString(arr));
		
		MyArrayTools.bubbleSort(arr);
		System.out.println(Arrays.toString(arr));
		
	}
}













