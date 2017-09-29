package Day10;

/*
  静态成员变量的使用
  	
  统计一个类创建了多少个对象！！！
 
 	人口统计，数据统计，ID自动生成
 	
 */

class Student {
	private int id; //这个就是用来统计不同用户的ID
	String name;
	char sex;
	
	//在数据共享区的数据，程序没有退出之前都是存在的  重点知识 【单例】
	static int count = 0; //计数器，统计这个类创建了多少个对象
	
	//构造代码块在成员变量之后，构造方法之前
	{
		this.id = count++; //利用构造代码块，来完成在创建类对象的时候，需要统一操作的代码
	} 
	
	public Student() {
		//this.id = count++; //在每一个构造方法中，都需要使用this.id = count++ 
						   //代码非常的臃肿，这里可以使用构造代码块来解决问题
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
		Student stu1 = new Student("李狗蛋", '男');
		System.out.println(stu1.getId()); //1
		
		Student stu2 = new Student("李狗剩", '男');
		System.out.println(stu2.getId()); //2
		
		Student stu3 = new Student("李狗剩", '男');
		System.out.println(stu3.getId()); //2
		
		Student stu4 = new Student();
		System.out.println(stu4.getId());
		
	}
}






