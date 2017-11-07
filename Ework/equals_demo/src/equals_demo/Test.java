package equals_demo;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class Test {
	public static void main(String[] args) {
		Person p = new Person("����");
		Employee e1 = new Employee(1, "����");
		Employee e2 = new Employee(2, "����");
		
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












//java���Թ淶Ҫ��equals����������������ԣ�
//(1)�Է���:�����κηǿ�����x,x.equals(x)Ӧ�÷���true;
//(2)�Գ���:�����κ�����x,��y,���ҽ���,y.equals(x)����true,x.equals(y)ҲӦ�÷���true;
//(3)������:�����κ�����x,y,z,���x.equals(y)����true,y.equals(z)����true,��ôx.equals(z)ҲӦ�÷���true;
//(4)һ����:���x,y���õĶ���û�з����仯,��������x.equals(y)Ӧ�÷���ͬ���Ľ��;
//(5)��������ǿ�����x,x.equals(null)����false;