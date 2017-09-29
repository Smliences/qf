package Test;

public class Fu {
	int age;
	int height;
	
	public Fu() {
		System.out.println("这是父类的无参构造函数");
	}

	public Fu(int age, int height) {
		if (age <= 0 || height <= 0) {
			 this.age = 1;
			 this.height = 100;
		} else {
			this.age = age;
			this.height = height;
		}
		System.out.println("同时初始化age还有height属性的构造方法");
	}
	
	public void cooking() {
		System.out.println("回锅肉~~");
	}
}

class Zi extends Fu {
	String name;
	
	public Zi(String name) {
		this.name = name;
		System.out.println("子类自由的name属性构造方法");
	}
	
	public Zi(String name, int age, int height) {
		super(age,height);
	}
}
