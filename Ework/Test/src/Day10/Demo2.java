package Day10;

/*
	static 不单单能修饰成员变量，也可以修饰成员方法
	
	用static修饰的成员方法/函数，称之为静态方法/函数
	
	格式 ：
		权限修饰符 static 返回值类型  函数名(形式参数列表) {
			函数体();
		}
	
	【重点】
		用static修饰的成员方法，称之为【静态】方法，这个静态方法，是在对象创建之前就已经存在，对象销毁之后
		依然存在，所以这里【静态】方法和对象是"无关的"
		
	【注意事项】
		1. 在【静态】方法中不能使用this关键字，因为this关键字是表示调用该方法的类对象本身，但是【静态】
		的方法最合适的调用方式是通过类名调用。那么这里不存在对象，所以不能使用this 【没有对象】
		
		2. 在【静态】方法中不能使用【非静态】的成员变量，因为【非静态】的成员变量必须通过类对象来调用，但是
		在静态方式中，调用者通常是类名，所有不存在对象，不能使用      【没有对象】
		
		3. 在【静态】方法中可以直接使用【静态】的成员变量，难兄难弟！！！
		
		4. 如果在【静态】方法中，需要使用【非静态】的成员变量，有且只有一种方式，创建一个当前类的类对象
		       通过这个类对象，来操作成员变量，但是实际上，这个操作和方法无关，只是和创建的类对象有关
			
	【总结】
		静态对静态，非静态对非静态
		
	【用途】
		用static修饰成员变量 是为了解决大量重复出现的数据
		用static修饰成员方法的作用是什么？？？
		
		可以不借助于 对象，就可以使用方法
		
		Arrays 工具类 下午
	
					
	
 */

class Person {
	//【非静态】的成员变量
	String name;
	//【静态】的成员变量
	static String country = "中华人民共和国"; 
	
	public Person() {}
	
	public Person(String name) {
		this.name = name;
	}
	
	//普通的成员方法  【非静态】成员方法
	public void run() {
		System.out.println("老子100m 12秒04");
	}
	
	//用static 修饰的成员方法，【静态】成员方法
	public static void play() {
		//name = "周总理";
		System.out.println(country);
		
		Person p = new Person();
		p.name = "朱镕基";
		
		System.out.println("每天多多少少都有锻炼一下");
	}
}

public class Demo2 {
	public static void main(String[] args) {
		Person p = new Person("李良良");
		
		System.out.println(p.country);
		
		p.run(); //用一个类对象，调用【非静态】的成员方法
		p.play(); //通过类对象，调用【静态】的成员方法 报警告 
				//中文直译:在Person类当中，用static修饰的成员方法play方法，应该通过静态的方式访问
				//The static method play() from type
				//Person should be accessed in a static way
		Person.play(); //类名.静态方法() 
	}
	
	
}













