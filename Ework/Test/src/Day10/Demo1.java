package Day10;

/*
 	���⣺
 		�����ڴ����У����ܴ�����һ����Ա��������ֵ��һ���ģ������ظ�����ص����ڴ���Դ���˷�
 		
 	������⣺
 		ʹ��static�ؼ���
 		
 	static�ؼ��ֵ�ʹ��:
 		1. �����static���εĳ�Ա��������֮Ϊ����̬����Ա�������������̬����Ա�����Ǳ������ڴ�ġ�����
 		�������򡿣��Ͷ����ڴ�û�й�ϵ��Ҳ����˵������ڴ�ռ䲻�ڶ��󡾶������ڴ�����
 		2. ���һ����static���εĳ�Ա�����������Ա���������ṩ����������ʹ�ã����Ҳ�ռ�ö�����ڴ�ռ�
 		3. ʹ��static�������ǳ����˴������ظ������ݣ�����¿���ʹ��static�����������Ա����
 		
 	С����:
 		������static���εĳ�Ա����������ö��������ã��ᱨ����
 		����ֱ��:	һ����static���εľ�̬�ĳ�Ա�����������á���̬�ķ�ʽ������
 		
 		����̬�ķ�ʽ��
 			��ͨ������������static���εĳ�Ա����
 
 	���ص㡿
 		��static���εĳ�Ա�����������Ա�����ǡ����ڡ������Ĵ����������������ǡ����ڡ����������ٶ�����
 		����˵����static���εľ�̬��Ա�����Ǻ������"�޹ص�"
 		��ô���﷨�ϾͲ���ͨ���������������Ա�����������������һ������

 		
 	���޸����⡿
 		������static���εĳ�Ա����������ͨ����һ�ַ�ʽ�޸������ݣ���ô�����õ�������ݵĵط����ᱻ�޸ģ�
 		������һ���������Ĺ�����Դ��
 			���磺��ˮ����ŰͶ�
 			
 	���Ƽ�����/ʹ�þ�̬��Ա�����ĸ�ʽ��
 		����.��Ա����; 
 		����ǵ���static���εĳ�Ա�����������û�й�ϵ
 		
 	
  	
 */
class Dog {
	//��Ա����
	private String name;
	static String country = "JP"; //���
	
	public Dog() {
		System.out.println("�޲εĹ��췽��");
	}
	
	public Dog(String name, String country) {
		this.name = name;
		this.country = country;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	public String getCountry() {
		return country;
	}
	
}

public class Demo1 {
	public static void main(String[] args) {
		
		
		
		Dog xq = new Dog();
		
		System.out.println("xq.country ��" + xq.getCountry()); //JP
		
//		xq.country = "RB"; //�������
//		Dog.country = "RB";
//		//Dog.
		Dog.country = "RB";
		Dog asan = new Dog();
		
		System.out.println("asan.country : " + asan.getCountry()); //RB
		
		System.out.println("xq.country ��" + xq.getCountry()); //???  JP RB
	}
}
















