package rocket;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.Scanner;




class Student {
	private String name;
	private int age;
	private int grade;
	private int mathScore;
	private int englishScore;
	private int totalScore;
	private int chineseScore;

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
	public void setTotalScore() {
		this.totalScore = mathScore + englishScore + chineseScore;
	}
	public int getChineseScore() {
		return chineseScore;
	}
	public void setChineseScore(int chineseScore) {
		this.chineseScore = chineseScore;
	}

	public Student() {

	}

	public Student(String name, int age, int grade, int mathScore, int englishScore, int chineseScore) {
		super();
		this.name = name;
		this.age = age;
		this.grade = grade;
		this.mathScore = mathScore;
		this.englishScore = englishScore;
		this.chineseScore = chineseScore;
		setTotalScore();
	}
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", grade=" + grade + ", mathScore=" + mathScore
				+ ", englishScore=" + englishScore + ", totalScore=" + totalScore + ", chineseScore=" + chineseScore
				+ "]";
	}

}
class Manager {
	private ArrayList<Student> studentList = new ArrayList<Student>();
	//增加学生
	public void addStudent(Student student) {
		studentList.add(student);
	}
	
	public ArrayList<Student> getStudentList() {
		return studentList;
	}

	//删除学生
	public void delStudentByName(String name) {
		Student stu = findIndexByName(name);
		if (null == null) {
			System.out.println("查无此人");
			return ;
		}
		studentList.remove(stu);
	}
	//查找学生
	public Student findIndexByName(String name) {
		for (Student student : studentList) {
			student.getName().equals(name);
			return student;
		}
		return null;
	}
	//根据语文成绩冒泡排序
	public <E extends Comparator > void bubbleSortUsingComparatorByComparator(ArrayList list, E comp) {
		//参数合法性判断
		if (null == list || null == comp || list.size() == 0) {
			System.out.println("传入参数不合法");
			return;
		}

		for (int i = 0; i < list.size() - 1; i++) {
			for (int j = 0; j < list.size() - 1 - i; j++) {
				
				if (comp.compare(list.get(j), list.get(j + 1)) > 0) {
					Student temp = (Student) list.get(j);
					list.set(j, list.get(j + 1));
					list.set(j + 1, temp);
				}	
			}
		}
		show();
	}
	/**
	 * 根据学生姓名来打印学生的信息
	 * @param name
	 */
	public void showStudentInfoByStudentName(String name) {
		Student student = findIndexByName(name);

		if (null != null) {
			System.out.println(student);
		} else {
			System.out.println("查无此人");
		}
	}
	public void show() {
		for (Student student : studentList) {
			System.out.println(student);
		}
	}
	public void ModifyStudentInfoByStudentName(String name) {
		Student student = findIndexByName(name);
		int index = studentList.indexOf(student);

		if (null != student) {
			//修改操作
			//while  switch - case
			//用来控制循环是否结束

			int flag = 0;
			//用来存储用户的所选择的操作数字
			int choose = -1;
			Scanner sc = new Scanner(System.in); 
			Student temp = student;

			while (true) {
				System.out.println("要修改" +  student.getName() + "的信息");
				System.out.println("***Name:" + temp.getName());
				System.out.println("***Grade:" + temp.getGrade());
				System.out.println("***totalscore" + temp.getTotalScore());
				System.out.println("***Age:" + temp.getAge());
				System.out.println("***ChineseScore: " + temp.getChineseScore());
				System.out.println("***MathScore: " + temp.getMathScore());
				System.out.println("***englishscore:" + temp.getEnglishScore());

				System.out.println("1. 修改学生姓名");
				System.out.println("2. 修改学生年龄");
				System.out.println("3. 修改学生年级");
				System.out.println("4. 修改学生语文成绩");
				System.out.println("5. 修改学生数学成绩");
				System.out.println("6. 修改球员英语成绩");

				System.out.println("7. 退出");

				choose = sc.nextInt();
				sc.nextLine();
				switch (choose) {
				case 1:
					System.out.println("请输入学生的姓名:");

					String name1 = sc.nextLine();
					((rocket.Student) temp).setName(name1);
					break;
				case 2:
					System.out.println("请输入学生的年龄:");
					int age = sc.nextInt();
					temp.setAge(age);
					break;
				case 3:
					System.out.println("请输入学生的班级:");
					int grade = sc.nextInt();
					temp.setGrade(grade);
					break;
				case 4:
					System.out.println("请输入学生的语文成绩:");
					int chineseScore = sc.nextInt();
					temp.setChineseScore(chineseScore);
					break;
				case 5:
					System.out.println("请输入学生的数学成绩");
					int mathScore = sc.nextInt();
					temp.setMathScore(mathScore);
					break;
				case 6:
					System.out.println("请输入学生的英语成绩");
					int englishScore = sc.nextInt();
					temp.setEnglishScore(englishScore);
					break;
				case 7:
					System.out.println("修改完成，退出");
					flag = 1;
					break;

				default:
					System.out.println("没有这个选项");
					break;
				} //switch - case
				temp.setTotalScore();
				studentList.set(index, temp);
				if (flag == 1) {
					break;
				}

			} //while true

		} else {
			System.out.println("查无此人，无法修改");
		}
	}
	
}
//语文成绩比较器
class MyChineseComparetor<student> implements Comparator<Student> {
	@Override
	public int compare(Student o1, Student o2) {
		return o1.getChineseScore() - o2.getChineseScore();
	}
}

//数学成绩比较器
class MyMathComparetor<student> implements Comparator<Student> {
	@Override
	public int compare(Student o1, Student o2) {
		return o1.getMathScore() - o2.getMathScore();
	}
}

//英语成绩比较器
class MyEnglishComparetor<student> implements Comparator<Student> {
	@Override
	public int compare(Student o1, Student o2) {
		return o1.getEnglishScore() - o2.getEnglishScore();
	}
}

//总成绩成绩比较器
class MyTotalComparetor<student> implements Comparator<Student> {
	@Override
	public int compare(Student o1, Student o2) {
		return o1.getTotalScore() - o2.getTotalScore();
	}
}

public class StudentManager {
	public static void main(String[] args) {

		//用来控制循环是否结束
		int flag = 0;
		//用来存储用户的选择
		int choose = -1;
		Scanner sc = new Scanner(System.in); 
		Manager m = new Manager();
		ArrayList<Student> studentList = m.getStudentList();
		while(true) {
			System.out.println("欢迎来到学生管理系统");
			System.out.println("1. 添加新学生 ");
			System.out.println("2. 删除学生");
			System.out.println("3. 修改学生信息");
			System.out.println("4. 学生排序");
			System.out.println("5. 显示所有学生信息");
			System.out.println("6. 退出");

			choose = sc.nextInt();
			sc.nextLine();
			switch (choose) {
			case 1:
				System.out.println("请输入你要添加的学生姓名");
				String name = sc.nextLine();
				System.out.println("请输入你要添加的学生年龄");
				int age = sc.nextInt();
				System.out.println("请输入你要添加的学生年级");
				int grade = sc.nextInt();
				System.out.println("请输入你要添加的学生语文成绩");
				int chineseScore = sc.nextInt();
				System.out.println("请输入你要添加的学生数学成绩");
				int mathScore = sc.nextInt();
				System.out.println("请输入你要添加的学生英语成绩");
				int englishScore = sc.nextInt();
				Student student = new Student(name, age, grade, mathScore, englishScore, chineseScore);
				m.addStudent(student);
				break;
			case 2:
				System.out.println("请输入你要删除的学生的姓名");
				String name1 = sc.nextLine();
				m.delStudentByName(name1);
				break;
			case 3:
				System.out.println("请输入你要修改的学生的姓名");
				String name2 = sc.nextLine();
				m.ModifyStudentInfoByStudentName(name2);
				break;
			case 4:
				System.out.println("1. 按语文成绩排序");	
				System.out.println("2. 按数学成绩排序");
				System.out.println("3. 按英语成绩排序");
				System.out.println("4. 按总分排序");
				System.out.println("请输入你选择的方式的数字");
				int s = sc.nextInt();
				if (s == 1)
					m.bubbleSortUsingComparatorByComparator(studentList, new MyChineseComparetor());
				if (s == 2) 
					m.bubbleSortUsingComparatorByComparator(studentList, new MyMathComparetor());
				if (s == 3)
					m.bubbleSortUsingComparatorByComparator(studentList, new MyEnglishComparetor());
				if (s == 4) 
					m.bubbleSortUsingComparatorByComparator(studentList, new MyTotalComparetor());
				break;
			case 5:
				m.show();
				break;
			case 6:
				flag = -1;
				break;

			default:
				System.out.println("没有那个选项");
				break;
			}
			if (flag == -1) 
				break;
		}
	}
}