package Test;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;

class Person implements Comparable {
	int id;
	String name;
	int salary;
	
	public Person(int id, String name, int salary) {
		super();
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	@Override
	public String toString() {
		return "Person [id=" + id + ", name=" + name + ", salary=" + salary + "]";
	}

	@Override
	public int compareTo(Object o) {
		Person p = (Person) o;
		return this.salary - p.salary;
	}
	
}

class MyComparator implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		Person p1 = (Person) o1;
		Person p2 = (Person) o2;
		return p1.salary - p2.salary;
	}
	
}
public class Demo3 {
	public static void main(String[] args) {
		List list = new ArrayList();
	}
}
