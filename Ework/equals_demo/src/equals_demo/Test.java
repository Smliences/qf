package equals_demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class Test {
	public static void main(String[] args) {
		Person p = new Person("张三");
		Employee e1 = new Employee(1, "张三");
		Employee e2 = new Employee(2, "张三");
		
		System.out.println(e1.equals(e2));
		System.out.println(p.equals(e2));
		System.out.println(p.equals(e1));
		
		HashMap<Person, String> hashMap = new HashMap<Person, String>();
//		hashMap.put(e2, "e2");
//		hashMap.put(p, "p");
//		hashMap.put(e1, "e1");
		ArrayList<Person> list = new ArrayList<Person>();
		list.add(e2);
		list.add(p);
		list.add(e1);
		for (Person person : list) {
			System.out.println(person);
		}
//		Set<Entry<Person, String>> entrySet = hashMap.entrySet();
//		Iterator<Entry<Person, String>> iterator = entrySet.iterator();
//		while (iterator.hasNext()) {
//			Entry<Person, String> next = iterator.next();
//			System.out.println(next.getKey() + ":" + next.getValue());
//		}
	}
}

class Person {
	private String name;

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}
	public Person() {
	}

	public Person(String name) {
		this.name = name;
	}

	@Override
	public int hashCode() {
		return this.name.hashCode();
	}
	
	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Person){  
			Person p = (Person) obj;  
			return this.name.equals(p.getName());  
		}  
		return false;  
	}
	
	@Override
	public String toString() {
		return "Person [name=" + name + "]";
	}
	
}

class Employee extends Person{
	private int id;

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public Employee() {
	}

	public Employee(int id ,String name) {
		super(name);
		this.id = id;
	}
	
	@Override
	public int hashCode() {
		return this.id;
	}

	@Override
	public boolean equals(Object obj) {
		if(obj instanceof Employee){  
			Employee e = (Employee) obj;  
			return e.getId() == this.id;  
		}  
		return false;  
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", name=" + super.getName() + "]";
	}

}












//java语言规范要求equals方法具有下面的特性：
//(1)自反性:对于任何非空引用x,x.equals(x)应该返回true;
//(2)对称性:对于任何引用x,和y,当且仅当,y.equals(x)返回true,x.equals(y)也应该返回true;
//(3)传递性:对于任何引用x,y,z,如果x.equals(y)返回true,y.equals(z)返回true,那么x.equals(z)也应该返回true;
//(4)一致性:如果x,y引用的对象没有发生变化,反复调用x.equals(y)应该返回同样的结果;
//(5)对于任意非空引用x,x.equals(null)返回false;