package Day11;

/*
 	�������������ʱ�� �кܶ࿪��ģʽ
 	
 	�����������̣�
 		1. �������
 		2. ָ�������ĵ�
 		3. ��ʼ���տ����ĵ������󡣷�ģ����д���� 25 - 35
 		4. �׶λ����ԣ������Ŀ
 		5. ����
 		6. ����ά��
 	
 	���������20����ģʽ
 		1. ����ģʽ
 		2. �۲���ģʽ(OB)
 		3. ����ģʽ
 		4. װ����ģʽ
 		������������������������
 
 	���ص�֪ʶ����Ĭд��
 		����ģʽ������Ŀ����:
 			�����������У�ĳһ���࣬����ֻ����һ�������
 	
 	[����]
 		Single�ڴ������еĹ����У�����ֻ����һ�������
 	
 	[����1]
 		�����Ĺ��췽��������ֻ����һ��
 	
 	[����1]
 		�п��������ĵ����߻�����������飬�����������޷�����Լ��
 		
 	[���1]
 		�����õ�����ֱ�������ù��췽����������private���ι��췽��
 		
 	[����2]
 		���췽��˽�л�����ô��ô�������󣿣���
 		1. Ŀǰû�ж������ʹ��
 		2. ����ͨ��new ����() ��������
 		��ô�������󣬶������������޷����ù��췽��������£��������󣿣���
 	
 	[���2]
 		��������Ҫͨ���������õķ������������ˣ�������Խ�������������static���εľ�̬��������������
 		˼����
 			ͨ���������ã�static�ؼ���
 			���������Ҫ������ʹ�õģ����в���˽�л�����Ҫ��public����
 			���������������ȡ����ģ���Ҫͨ���÷����ķ���ֵ��ȡһ�����󣬷���ֵ������ Single
 			���Single˽�л��Ĺ��췽��������Ҫint id �Ĳ������÷�����Ҫ������int id
 		
 		��������ĸ�ʽ����:
 			public static Single getInstance(int id)
 			
 	[����3]
 		����ͨ��getInstance��ȡ���Ķ���Ҳ�ǲ�ͬ�Ķ���
 	
 	[���3]
 		˼����
 			����ϣ���ܹ�����Լ�������֮ǰû�ж��󣬴����µĶ����ж��󣬷���ԭ���Ķ����ַ
 			
 			��Ҫ�������ĵ�ַ��
 				��Ҫһ����������͵ı������������ַ Single s �������
 			
 			���������Ҫ�־û���
 				���������Ҫstatic���� static Single s
 			
 			�Ҳ�ϣ��������ݿ���������ⲿ����ȡ���߱��޸ģ�
 				���������Ҫ��private ����
 			
 			�����ݸ�ʽ��
 				private static Single s = null;
 							
 	
 */

class Single {
	int id;
	
	private static Single s = null;
	
	private Single(int id) {
		this.id = id;
	}
	
	public static Single getInstance(int id) {
		//���ڿ��Ե����൱�е����еķ���
		//Ŀǰ����£�����Ĵ�������Ĳ���û�����κε�Լ��������ϣ���ܹ�����һ��Լ��
		//���֮ǰ��������󣬾Ͳ�����������֮ǰ�����õĶ����׵�ַ�����û�У������µĶ��󣬱��������ַ
		//�Ա�����
		if (null == s) {
			s = new Single(id);
		}
		return s;
	}
	
}

public class Demo1 {
	public static void main(String[] args) {
		//������Ѿ������������ˣ����ǲ�Ҫ������~
		Single s = Single.getInstance(5);
		
		System.out.println(s);
		
		Single s2 = Single.getInstance(5);		
		System.out.println(s2);
		Single s3 = Single.getInstance(5);		
		System.out.println(s3);
		Single s4 = Single.getInstance(5);		
		System.out.println(s4);
		Single s5 = Single.getInstance(5);		
		System.out.println(s5);
		Single s6 = Single.getInstance(5);		
		System.out.println(s6);
		Single s7 = Single.getInstance(5);		
		System.out.println(s7);
		Single s8 = Single.getInstance(5);		
		System.out.println(s8);
		Single s9 = Single.getInstance(5);		
		System.out.println(s9);
	}
}









