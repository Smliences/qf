package Day07;

public class Test3 {
	public static void main(String[] args) {
		Student xiaoming = new Student();
		xiaoming.name = "С��";
		xiaoming.age = 11;
		xiaoming.sex = 'm';
	}
}

class Student {
	String name;
	int age;
	char sex;
	public void xueXi() {
		System.out.println("����ѧϰ");
	}
}

class Teacher {
	String name;
	int age;
	public void jiangKe() {
		System.out.println("���ڽ���");
	}
	
	
}