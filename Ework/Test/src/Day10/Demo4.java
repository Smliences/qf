package Day10;

import java.util.Arrays;

/*
  ��̬��Ա������ʹ�ã�
  	���ɹ����࣬�ṩ��������ʹ�ã����ӱ�����������������ݶ���Ҫͨ����������
  	
  	Arrays Java���е����鹤���࣬�����˴����������г��õķ��������еķ�������ͨ������ֱ�ӵ���
  	
  	�����ء�
  		��ͨ��һ�������棬���ڷ���ֵ���ͣ���������ͬ�ķ��������ǲ�����һ�������֮Ϊ�����ġ����ء�
  		���ز������Լ򻯷��������������ҿ�����߿���Ч��
  
  	Arrays �����࣬ѧ����������
  		sort  toString  binarySearch����
 */

public class Demo4 {
	public static void main(String[] args) {
		int[] arr = {1, 10, 3, 2, 5, 8, 7, 4, 6, 9};
//		int arr2[] = {1, 10, 3, 2, 5, 8, 7, 4, 6, 9};
//		int[] arr3 = new int[10];
//		int arr4[] = new int[10];
		//int arr[3] = {1, 2, 3}; //C�����е����飬Java��֧��
		
		//Arrays �����������sort����������ͨ������ֱ�ӵ��ã���Ϊ����һ����static���εľ�̬����
		Arrays.sort(arr);
		
		//Arrays �����������binarySearch�������������Ҫ���ѯ��������һ���Ѿ�ͨ������õ�����������
		int index = Arrays.binarySearch(arr, 6);
		System.out.println("6 at " + index);
		
		//Arrays �����൱�е�toString ������������ת����String�ַ�����ʽ�����ظ�������
		String arrString = Arrays.toString(arr);
		System.out.println(arrString);
	}
}
