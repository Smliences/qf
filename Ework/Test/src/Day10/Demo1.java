package Day10;

/*
 	问题：
 		发现在代码中，可能存在有一个成员变量的数值是一样的，大量重复，这回导致内存资源的浪费
 		
 	解决问题：
 		使用static关键字
 		
 	static关键字的使用:
 		1. 如果用static修饰的成员变量，称之为【静态】成员变量，这个【静态】成员变量是保存在内存的【数据
 		共享区域】，和对象内存没有关系，也就是说，这个内存空间不在对象【堆区】内存里面
 		2. 如果一个用static修饰的成员变量，这个成员变量可以提供给多个类对象使用，而且不占用对象的内存空间
 		3. 使用static场景就是出现了大量的重复的数据，情况下可以使用static来修饰这个成员变量
 		
 	小问题:
 		发现用static修饰的成员变量，如果用对象来调用，会报警告
 		中文直译:	一个用static修饰的静态的成员变量，必须用【静态的方式】访问
 		
 		【静态的方式】
 			是通过类名来调用static修饰的成员变量
 
 	【重点】
 		用static修饰的成员变量，这个成员变量是【早于】类对象的创建而创建，而且是【晚于】类对象的销毁而销毁
 		所以说，用static修饰的静态成员变量是和类对象"无关的"
 		那么在语法上就不能通过类对象调用这个成员变量，所以这里会有一个警告

 		
 	【修改问题】
 		这里用static修饰的成员变量，不管通过哪一种方式修改了内容，那么所有用到这个数据的地方都会被修改，
 		这里是一个【隐含的共享资源】
 			例如：饮水机里放巴豆
 			
 	【推荐调用/使用静态成员变量的格式】
 		类名.成员变量; 
 		让你记得用static修饰的成员变量和类对象没有关系
 		
 	
  	
 */
class Dog {
	//成员变量
	private String name;
	static String country = "JP"; //乡村
	
	public Dog() {
		System.out.println("无参的构造方法");
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
		
		System.out.println("xq.country ：" + xq.getCountry()); //JP
		
//		xq.country = "RB"; //不允许的
//		Dog.country = "RB";
//		//Dog.
		Dog.country = "RB";
		Dog asan = new Dog();
		
		System.out.println("asan.country : " + asan.getCountry()); //RB
		
		System.out.println("xq.country ：" + xq.getCountry()); //???  JP RB
	}
}
















