package Day10;

/*
  ��̬��Ա������ʹ��
  	
  ͳ��һ���ഴ���˶��ٸ����󣡣���
 
 	�˿�ͳ�ƣ�����ͳ�ƣ�ID�Զ�����
 	
 */

class Student {
	private int id; //�����������ͳ�Ʋ�ͬ�û���ID
	String name;
	char sex;
	
	//�����ݹ����������ݣ�����û���˳�֮ǰ���Ǵ��ڵ�  �ص�֪ʶ ��������
	static int count = 0; //��������ͳ������ഴ���˶��ٸ�����
	
	//���������ڳ�Ա����֮�󣬹��췽��֮ǰ
	{
		this.id = count++; //���ù������飬������ڴ���������ʱ����Ҫͳһ�����Ĵ���
	} 
	
	public Student() {
		//this.id = count++; //��ÿһ�����췽���У�����Ҫʹ��this.id = count++ 
						   //����ǳ���ӷ�ף��������ʹ�ù����������������
	}
	
	public Student(String name, char sex) {
		this.name = name;
		this.sex = sex;
		//this.id = count++;
	}
	
	public Student(String name) {
		this.name = name;
		//this.id = count++;
	} 
	
	public int getId() {
		return id;
	}
}

public class Demo3 {
	public static void main(String[] args) {
		Student stu1 = new Student("���", '��');
		System.out.println(stu1.getId()); //1
		
		Student stu2 = new Student("�ʣ", '��');
		System.out.println(stu2.getId()); //2
		
		Student stu3 = new Student("�ʣ", '��');
		System.out.println(stu3.getId()); //2
		
		Student stu4 = new Student();
		System.out.println(stu4.getId());
		
	}
}






