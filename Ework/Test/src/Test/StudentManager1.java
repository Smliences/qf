package Test;

import java.util.ArrayList;
import java.util.Comparator;

class Student1 {
	private String name;
	private int age;
	private int grade;
	private int mathScore;
	private int englishScore;
	private int totalScore;
	private int chineseScore;
	private static Student s;

	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public int getGrade() {
		return grade;
	}
	public void setGrade(int grade) {
		this.grade = grade;
	}
	public int getMathScore() {
		return mathScore;
	}
	public void setMathScore(int mathScore) {
		this.mathScore = mathScore;
	}
	public int getEnglishScore() {
		return englishScore;
	}
	public void setEnglishScore(int englishScore) {
		this.englishScore = englishScore;
	}
	public int getTotalScore() {
		return totalScore;
	}
	public void setTotalScore(int totalScore) {
		this.totalScore = totalScore;
	}
	public int getChineseScore() {
		return chineseScore;
	}
	public void setChineseScore(int chineseScore) {
		this.chineseScore = chineseScore;
	}

	public Student1() {
		
	}

	public Student1(String name, int age, int grade, int mathScore, int englishScore, int totalScore, int chineseScore) {
		super();
		this.name = name;
		this.age = age;
		this.grade = grade;
		this.mathScore = mathScore;
		this.englishScore = englishScore;
		this.totalScore = totalScore;
		this.chineseScore = chineseScore;
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", grade=" + grade + ", mathScore=" + mathScore
				+ ", englishScore=" + englishScore + ", totalScore=" + totalScore + ", chineseScore=" + chineseScore
				+ "]";
	}


}
public class StudentManager1<Student1> {
	private ArrayList<Student1> studentList = new ArrayList<Student1>();
	
	public void addStudent(Student1 student1) {
		studentList.add(student1);
	}
	
	public void delStudentByName(String name) {
		int index = findIndexByName(name);
		studentList.remove(index);
	}
	
	public int findIndexByName(String name) {
		for (Student1 student1 : studentList) {
			((Test.Student1) student1).getName().equals(name);
		}
		return studentList.indexOf(name);
	}
	
}

class MyComparetor<E> implements Comparator<E> {

	@Override
	public int compare(E o1, E o2) {
		
		return 0;
	}

	
}