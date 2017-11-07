package Test;

import java.util.ArrayList;
import java.util.Comparator;

class Student4 {
	int id;
	int score;
	int age;
	String name;
	public Student4(int id, int score, int age, String name) {
		super();
		this.id = id;
		this.score = score;
		this.age = age;
		this.name = name;
	}

	@Override
	public String toString() {
		return "Student [id=" + id + ", score=" + score + ", age=" + age + ", name=" + name + "]";
	}

}

class AgeDescedingCompare implements Comparator {

	@Override
	public int compare(Object o1, Object o2) {
		Student4 stu1 = (Student4) o1;
		Student4 stu2 = (Student4) o2;
		return stu2.age - stu1.age;
	}
}


public class demo2 {
	public static void main(String[] args) {
		StringBuffer sb = new StringBuffer();
		
	}
	
	public static void selectSortUsingComarator(ArrayList list, Comparator comp) {
		if (null == list || null == comp || list.size() == 0) {
			System.out.println("传入参数不合法");
			return;
		}
		
		for (int i = 0; i < list.size() - 1; i++) {
			int index = i;
		}
	}
}











