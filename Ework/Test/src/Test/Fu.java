package Test;

public class Fu {
	int age;
	int height;
	
	public Fu() {
		System.out.println("���Ǹ�����޲ι��캯��");
	}

	public Fu(int age, int height) {
		if (age <= 0 || height <= 0) {
			 this.age = 1;
			 this.height = 100;
		} else {
			this.age = age;
			this.height = height;
		}
		System.out.println("ͬʱ��ʼ��age����height���ԵĹ��췽��");
	}
	
	public void cooking() {
		System.out.println("�ع���~~");
	}
}

class Zi extends Fu {
	String name;
	
	public Zi(String name) {
		this.name = name;
		System.out.println("�������ɵ�name���Թ��췽��");
	}
	
	public Zi(String name, int age, int height) {
		super(age,height);
	}
}
