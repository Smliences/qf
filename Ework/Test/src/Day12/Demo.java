package Day12;
/*
 * 1. 重写的练习
		用Java描述一个普通的学生，Java基础班的学生， Java就业班的学生
		
		这些学生都属于Student类
		这些学生都回学习，但是每一个班的学生，学习的内容不一样
		
		普通的学生：马克思列宁主义
		基础班的学生： JavaSE
		就业班的学生： JavaEE + SSH
 * */
public class Demo {
	
}

class Student {
	public String name;
	public Student(String name) {
		this.name = name;
	}
	public void study() {
		System.out.println("学习");
	}
}

class Nortal extends Student {
	public Nortal(String name) {
		super(name);
	}

	@Override
	public void study() {
		System.out.println("学习马克思列宁主义");
	}
}

class JavaSE extends Student {
	public JavaSE(String name) {
		super(name);
	}

	@Override
	public void study() {
		System.out.println("学习JavaSE");
	}
}

class JavaEE extends Student {
	public JavaEE(String name) {
		super(name);
	}

	@Override
	public void study() {
		System.out.println("学习JavaEE ");
	}
}