package Day12;
/*
 * 1. ��д����ϰ
		��Java����һ����ͨ��ѧ����Java�������ѧ���� Java��ҵ���ѧ��
		
		��Щѧ��������Student��
		��Щѧ������ѧϰ������ÿһ�����ѧ����ѧϰ�����ݲ�һ��
		
		��ͨ��ѧ�������˼��������
		�������ѧ���� JavaSE
		��ҵ���ѧ���� JavaEE + SSH
 * */
public class Demo {
	
}

class Student {
	public String name;
	public Student(String name) {
		this.name = name;
	}
	public void study() {
		System.out.println("ѧϰ");
	}
}

class Nortal extends Student {
	public Nortal(String name) {
		super(name);
	}

	@Override
	public void study() {
		System.out.println("ѧϰ���˼��������");
	}
}

class JavaSE extends Student {
	public JavaSE(String name) {
		super(name);
	}

	@Override
	public void study() {
		System.out.println("ѧϰJavaSE");
	}
}

class JavaEE extends Student {
	public JavaEE(String name) {
		super(name);
	}

	@Override
	public void study() {
		System.out.println("ѧϰJavaEE ");
	}
}