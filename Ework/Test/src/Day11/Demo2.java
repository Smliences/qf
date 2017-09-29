package Day11;

/*
	父亲  和 儿子 父子关系 
	继承
	
代码中的继承：
	游戏开发！！！
		英雄联盟 
		所有的人物角色都属于一个类，这个类包含了所有的共性属性 血量，攻击力，防御~~~~~
		
		每一个英雄都都属于这个类，但是在这个类的基础之上，不同的技能，不能的基础值，和成长值
		
	用继承来实现的
	
	【发现】
		1. 父类中的成员变量，子类通过继承也可以使用
		
 */

class Hero {
	int blood;
	int power;
	
	public Hero() {
		System.out.println("Hero类的无参构造方法");
	}
	
	public Hero(int blood, int power) {
		this.blood = blood;
		this.power = power;
	}
}

//extends 继承的关键字，表示当前类Timor是继承于Hero的这个类，也可以说Timor是Hero类的子类
class Timor extends Hero {
	String id;
	
	public Timor() {
		System.out.println("Timorl类的无参构造方法~~");
	}
	
	public Timor(String id) {
		System.out.println("Timor的带有一个参数的构造方法");
		this.id = id;
	}
	
	public Timor(String id, int blood, int power) {
		//this.id 是使用自己类当中的成员变量
		this.id = id;
		
		//blood 和 power是父类Hero里面的成员变量，但是这里存在继承关系，那么这个属性也可在子类中使用！！！
		this.blood = blood;
		this.power = power;
	}
}

public class Demo2 {
	public static void main(String[] args) {
		//这里是创建父类对象
//		Hero h = new Hero();
//		System.out.println(h);
		
		//创建子类对象
		Timor t = new Timor();
		System.out.println(t);
	}
}




















