package Test;

import java.util.Scanner;

import com.sun.swing.internal.plaf.metal.resources.metal;
/*
 * 学生信息包括：
 * 			名字，年龄，班级，数学成绩
 * 				语文成绩，英语成绩，总分
 */

class Student {
	//成员变量
	private String name;
	private int age;
	private int grade;
	private int mathScore;
	private int englishScore;
	private int totalScore;
	private int chineseScore;
	private static Student s;

	//无参构造方法
	public Student() {
	}


	//有参构造方法
	public Student(String name, int age, int grade, int mathScore, int englishScore, int chineseScore) {
		setName(name);
		setAge(age);
		setGrade(grade);
		setMathScore(mathScore);
		setEnglishScore(englishScore);
		setChineseScore(chineseScore);
		setTotalScore();
	}


	//以下是对应的setter和getter 方法
	public int getChineseScore() {
		return chineseScore;
	}

	public void setChineseScore(int chineseScore) {
		if (chineseScore <= 0 || chineseScore >150) {
			this.chineseScore = 0;
		} else {
			this.chineseScore = chineseScore;
		}
	}

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
		if (age <= 0 || age >= 45) {			
			this.age = 19;
		} else {
			this.age = age;
		}
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
		if (mathScore <= 0 || mathScore >150) {
			this.mathScore = 0;
		} else {
			this.mathScore = mathScore;
		}
	}

	public int getEnglishScore() {
		return englishScore;
	}

	public void setEnglishScore(int englishScore) {
		if (englishScore <= 0 || englishScore >150) {
			this.englishScore = 0;
		} else {
			this.englishScore = englishScore;
		}
	}

	public int getTotalScore() {
		return totalScore;
	}

	public void setTotalScore() {
		this.totalScore = mathScore + englishScore + chineseScore;
	}
	//重写Object类里面的toString方法，来满足System.out.println 打印时的结果
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", grade=" + grade + ", mathScore=" + mathScore
				+ ", englishScore=" + englishScore + ", totalScore=" + totalScore + ", chineseScore=" + chineseScore
				+ "]";
	}
}
//学生管理类
class Manager {
	//用于统计数组中的学生个数
	private static int count = 0;
	//保存学生的方式，这里使用数组保存，数组里保存的都是学生，所以这个数组的student类型的
	//默认创建一个能容纳20人的数组
	Student[] students = new Student[20];
	//添加学生，以及数组的扩展
	/**
	 * 添加新的学生
	 * @param student 是要添加的学生类对象
	 */
	public void addStudent(Student student) {
		//参数判断
		if (null == student) {
			System.out.println("参数输入有误");
		}
		//添加
		students[count] = student;
		count++;
		//如果数组中学生的个数大于等于数组的长度，就将数组扩展到之前的1.5倍
		if (count >= students.length) {
			int c = (int) (students.length * 1.5);
			Student[] temp = new Student[c];
			for (int i = 0; i < count; i++ ) {
				temp[i] = students[i];  
			}
			students = temp;
		}
	}
	/**
	 * 根据学生的姓名来删除一个学生
	 * @param name 要删除的学生的姓名
	 */
	public void delStudent(String name) {
		if (null == name) {
			System.out.println("参数输入有误");
		}
		//这个index要做一个判断，如果是-1表示没有找到，这里无法处理，如果》=0则删除这个学生
		int index = findByStudentName(name);

		if (index < 0) {
			System.out.println("查无此人");
		} else {
			//删除操作
			for (int i = index; i < count - 1; i++) {
				students[i] = students[i + 1];
			}
			//把原本最后一个位置赋值为null
			students[count-1] = null;
			//数组中学生个数减一
			count--;
		}
	}
	/**
	 * 根据学生的姓名，找出学生在数组中的下标，该方法只能给类内使用
	 * @param name 要查询的学生姓名
	 * @return int类型，返回-1表示没有找到，返回》=0的值，表示该学生在数组中的下标
	 */
	private int findByStudentName(String name) {
		//参数合法性判断
		if (null == name) {
			System.out.println("参数输入不合法");
			return -1;
		}
		//用于保存找到的球员所在的下标
		int index = -1;

		for (int i = 0; i < count; i++) {
			String n = students[i].getName();
			if (name.equals(n)) {
				index = i;
			}
		}
		return index;
	}
	/**
	 * 根据学生姓名来打印学生的信息
	 * @param name
	 */
	public void showStudentInfoByStudentName(String name) {
		int index = findByStudentName(name);

		if (index >= 0) {
			System.err.println(students[index]);
		} else {
			System.out.println("查无此人");
		}
	}
	/**
	 * 打印所有学生信息
	 */
	public void show() {
		for (int i = 0; i < count; i++) {
			System.out.println(students[i]);
		}
	}
	/**
	 * 根据用户输入的数字，来判断用什么成绩进行排序
	 * @param s 用户输入的数字
	 */
	public void sort(int s) {
		//建立一个新数组
		int[] temp = new int[count];
		//如果用户输入的数字是1，则把所有 学生的语文成绩放入temp数组
		if (s == 1)
			for (int i = 0; i < count; i++) {
				temp[i] = students[i].getChineseScore();
			}
		//如果用户输入的数字是2，则把所有 学生的英语成绩放入temp数组
		if (s == 2)
			for (int i = 0; i < count; i++) {
				temp[i] = students[i].getEnglishScore();			}
		//如果用户输入的数字是1，则把所有 学生的数学成绩放入temp数组
		if (s == 3)
			for (int i = 0; i < count; i++) {
				temp[i] = students[i].getMathScore();
			}
		//如果用户输入的数字是1，则把所有 学生的总分成绩放入temp数组
		if (s == 4)
			for (int i = 0; i < count; i++) {
				temp[i] = students[i].getTotalScore();
			}
		//然后对temp数组进行排序
		for (int i = 0; i < count - 1; i++) {
			for (int j = 0; j < count - i - 1; j++) {
				if (temp[j] > temp[j + 1]) {
					//在temp数组进行交换的时候，把对应下标的学生位置也进行交换
					int t = temp[j];
					temp[j] = temp[j + 1];
					temp[j + 1] = t;
					Student g = students[j];
					students[j] = students[j + 1];
					students[j + 1] = g;
				}
			}
		}
		show();
	}
	/**
	 * 根据学生姓名来修改学生信息
	 * @param name
	 */
	public void ModifyStudentInfoByStudentName(String name) {
		int index = findByStudentName(name);

		if (index >= 0) {
			//修改操作
			//while  switch - case
			//用来控制循环是否结束

			int flag = 0;
			//用来存储用户的所选择的操作数字
			int choose = -1;
			Scanner sc = new Scanner(System.in); 
			Student temp = students[index]; 

			while (true) {
				System.out.println("要修改" + temp.getName() + "的信息");
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
					temp.setName(name1);
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
					temp.setTotalScore();
					break;
				case 5:
					System.out.println("请输入学生的数学成绩");
					int mathScore = sc.nextInt();
					temp.setMathScore(mathScore);
					temp.setTotalScore();
					break;
				case 6:
					System.out.println("请输入学生的英语成绩");
					int englishScore = sc.nextInt();
					temp.setMathScore(englishScore);
					temp.setTotalScore();
					break;
				case 7:
					System.out.println("修改完成，退出");
					flag = 1;
					break;

				default:
					System.out.println("没有这个选项");
					break;
				} //switch - case

				students[index] = temp;
				if (flag == 1) {
					break;
				}

			} //while true

		} else {
			System.out.println("查无此人，无法修改");
		}
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
				m.delStudent(name1);
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
				m.sort(s);
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
