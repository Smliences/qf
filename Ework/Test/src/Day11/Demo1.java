package Day11;

/*
 	在做软件开发的时候， 有很多开发模式
 	
 	做开发的流程：
 		1. 需求分析
 		2. 指定开发文档
 		3. 开始按照开发文档的需求。分模块书写代码 25 - 35
 		4. 阶段化测试，完成项目
 		5. 上线
 		6. 后期维护
 	
 	软件开发的20多种模式
 		1. 单例模式
 		2. 观察者模式(OB)
 		3. 工厂模式
 		4. 装饰者模式
 		………………………………
 
 	【重点知识】【默写】
 		单例模式的最终目的是:
 			在整个代码中，某一个类，有且只能有一个类对象
 	
 	[需求]
 		Single在代码运行的过程中，有且只能有一个类对象
 	
 	[方案1]
 		这个类的构造方法，有且只调用一次
 	
 	[问题1]
 		有可能其他的调用者会忘记这个事情，存在隐患，无法做到约束
 		
 	[解决1]
 		不想让调用者直接来调用构造方法，所以用private修饰构造方法
 		
 	[问题2]
 		构造方法私有化，那么怎么创建对象？？？
 		1. 目前没有对象可以使用
 		2. 不能通过new 类名() 创建对象
 		怎么创建对象，而且是在类外无法调用构造方法的情况下，创建对象？？？
 	
 	[解决2]
 		现在所有要通过类对象调用的方法都不能用了，这里可以借助于类名操作static修饰的静态方法来创建对象
 		思考：
 			通过类名调用，static关键字
 			这个方法是要在类外使用的，所有不能私有化，需要用public修饰
 			这个方法是用来获取对象的，是要通过该方法的返回值获取一个对象，返回值类型是 Single
 			这个Single私有化的构造方法里面需要int id 的参数，该方法需要参数是int id
 		
 		这个方法的格式如下:
 			public static Single getInstance(int id)
 			
 	[问题3]
 		发现通过getInstance获取到的对象，也是不同的对象
 	
 	[解决3]
 		思考：
 			这里希望能够做到约束，如果之前没有对象，创建新的对象，有对象，返回原本的对象地址
 			
 			需要保存对象的地址：
 				需要一个类对象类型的变量，来保存地址 Single s 这个变量
 			
 			这个数据需要持久化：
 				这个数据需要static修饰 static Single s
 			
 			我不希望这个数据可以在类的外部被获取或者被修改：
 				这个数据需要用private 修饰
 			
 			该数据格式：
 				private static Single s = null;
 							
 	
 */

class Single {
	int id;
	
	private static Single s = null;
	
	private Single(int id) {
		this.id = id;
	}
	
	public static Single getInstance(int id) {
		//类内可以调用类当中的所有的方法
		//目前情况下，这里的创建对象的操作没有做任何的约束，我们希望能够加上一个约束
		//如果之前有这个对象，就不创建，返回之前创建好的对象首地址，如果没有，创建新的对象，保存这个地址
		//以备后用
		if (null == s) {
			s = new Single(id);
		}
		return s;
	}
	
}

public class Demo1 {
	public static void main(String[] args) {
		//这个类已经创建过对象了，你们不要创建了~
		Single s = Single.getInstance(5);
		
		System.out.println(s);
		
		Single s2 = Single.getInstance(5);		
		System.out.println(s2);
		Single s3 = Single.getInstance(5);		
		System.out.println(s3);
		Single s4 = Single.getInstance(5);		
		System.out.println(s4);
		Single s5 = Single.getInstance(5);		
		System.out.println(s5);
		Single s6 = Single.getInstance(5);		
		System.out.println(s6);
		Single s7 = Single.getInstance(5);		
		System.out.println(s7);
		Single s8 = Single.getInstance(5);		
		System.out.println(s8);
		Single s9 = Single.getInstance(5);		
		System.out.println(s9);
	}
}









