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
	//����ѧ��
	public void addStudent(Student student) {
		studentList.add(student);
	}
	
	public ArrayList<Student> getStudentList() {
		return studentList;
	}

	//ɾ��ѧ��
	public void delStudentByName(String name) {
		Student stu = findIndexByName(name);
		if (null == null) {
			System.out.println("���޴���");
			return ;
		}
		studentList.remove(stu);
	}
	//����ѧ��
	public Student findIndexByName(String name) {
		for (Student student : studentList) {
			student.getName().equals(name);
			return student;
		}
		return null;
	}
	//�������ĳɼ�ð������
	public <E extends Comparator > void bubbleSortUsingComparatorByComparator(ArrayList list, E comp) {
		//�����Ϸ����ж�
		if (null == list || null == comp || list.size() == 0) {
			System.out.println("����������Ϸ�");
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
	 * ����ѧ����������ӡѧ������Ϣ
	 * @param name
	 */
	public void showStudentInfoByStudentName(String name) {
		Student student = findIndexByName(name);

		if (null != null) {
			System.out.println(student);
		} else {
			System.out.println("���޴���");
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
			//�޸Ĳ���
			//while  switch - case
			//��������ѭ���Ƿ����

			int flag = 0;
			//�����洢�û�����ѡ��Ĳ�������
			int choose = -1;
			Scanner sc = new Scanner(System.in); 
			Student temp = student;

			while (true) {
				System.out.println("Ҫ�޸�" +  student.getName() + "����Ϣ");
				System.out.println("***Name:" + temp.getName());
				System.out.println("***Grade:" + temp.getGrade());
				System.out.println("***totalscore" + temp.getTotalScore());
				System.out.println("***Age:" + temp.getAge());
				System.out.println("***ChineseScore: " + temp.getChineseScore());
				System.out.println("***MathScore: " + temp.getMathScore());
				System.out.println("***englishscore:" + temp.getEnglishScore());

				System.out.println("1. �޸�ѧ������");
				System.out.println("2. �޸�ѧ������");
				System.out.println("3. �޸�ѧ���꼶");
				System.out.println("4. �޸�ѧ�����ĳɼ�");
				System.out.println("5. �޸�ѧ����ѧ�ɼ�");
				System.out.println("6. �޸���ԱӢ��ɼ�");

				System.out.println("7. �˳�");

				choose = sc.nextInt();
				sc.nextLine();
				switch (choose) {
				case 1:
					System.out.println("������ѧ��������:");

					String name1 = sc.nextLine();
					((rocket.Student) temp).setName(name1);
					break;
				case 2:
					System.out.println("������ѧ��������:");
					int age = sc.nextInt();
					temp.setAge(age);
					break;
				case 3:
					System.out.println("������ѧ���İ༶:");
					int grade = sc.nextInt();
					temp.setGrade(grade);
					break;
				case 4:
					System.out.println("������ѧ�������ĳɼ�:");
					int chineseScore = sc.nextInt();
					temp.setChineseScore(chineseScore);
					break;
				case 5:
					System.out.println("������ѧ������ѧ�ɼ�");
					int mathScore = sc.nextInt();
					temp.setMathScore(mathScore);
					break;
				case 6:
					System.out.println("������ѧ����Ӣ��ɼ�");
					int englishScore = sc.nextInt();
					temp.setEnglishScore(englishScore);
					break;
				case 7:
					System.out.println("�޸���ɣ��˳�");
					flag = 1;
					break;

				default:
					System.out.println("û�����ѡ��");
					break;
				} //switch - case
				temp.setTotalScore();
				studentList.set(index, temp);
				if (flag == 1) {
					break;
				}

			} //while true

		} else {
			System.out.println("���޴��ˣ��޷��޸�");
		}
	}
	
}
//���ĳɼ��Ƚ���
class MyChineseComparetor<student> implements Comparator<Student> {
	@Override
	public int compare(Student o1, Student o2) {
		return o1.getChineseScore() - o2.getChineseScore();
	}
}

//��ѧ�ɼ��Ƚ���
class MyMathComparetor<student> implements Comparator<Student> {
	@Override
	public int compare(Student o1, Student o2) {
		return o1.getMathScore() - o2.getMathScore();
	}
}

//Ӣ��ɼ��Ƚ���
class MyEnglishComparetor<student> implements Comparator<Student> {
	@Override
	public int compare(Student o1, Student o2) {
		return o1.getEnglishScore() - o2.getEnglishScore();
	}
}

//�ܳɼ��ɼ��Ƚ���
class MyTotalComparetor<student> implements Comparator<Student> {
	@Override
	public int compare(Student o1, Student o2) {
		return o1.getTotalScore() - o2.getTotalScore();
	}
}

public class StudentManager {
	public static void main(String[] args) {

		//��������ѭ���Ƿ����
		int flag = 0;
		//�����洢�û���ѡ��
		int choose = -1;
		Scanner sc = new Scanner(System.in); 
		Manager m = new Manager();
		ArrayList<Student> studentList = m.getStudentList();
		while(true) {
			System.out.println("��ӭ����ѧ������ϵͳ");
			System.out.println("1. �����ѧ�� ");
			System.out.println("2. ɾ��ѧ��");
			System.out.println("3. �޸�ѧ����Ϣ");
			System.out.println("4. ѧ������");
			System.out.println("5. ��ʾ����ѧ����Ϣ");
			System.out.println("6. �˳�");

			choose = sc.nextInt();
			sc.nextLine();
			switch (choose) {
			case 1:
				System.out.println("��������Ҫ��ӵ�ѧ������");
				String name = sc.nextLine();
				System.out.println("��������Ҫ��ӵ�ѧ������");
				int age = sc.nextInt();
				System.out.println("��������Ҫ��ӵ�ѧ���꼶");
				int grade = sc.nextInt();
				System.out.println("��������Ҫ��ӵ�ѧ�����ĳɼ�");
				int chineseScore = sc.nextInt();
				System.out.println("��������Ҫ��ӵ�ѧ����ѧ�ɼ�");
				int mathScore = sc.nextInt();
				System.out.println("��������Ҫ��ӵ�ѧ��Ӣ��ɼ�");
				int englishScore = sc.nextInt();
				Student student = new Student(name, age, grade, mathScore, englishScore, chineseScore);
				m.addStudent(student);
				break;
			case 2:
				System.out.println("��������Ҫɾ����ѧ��������");
				String name1 = sc.nextLine();
				m.delStudentByName(name1);
				break;
			case 3:
				System.out.println("��������Ҫ�޸ĵ�ѧ��������");
				String name2 = sc.nextLine();
				m.ModifyStudentInfoByStudentName(name2);
				break;
			case 4:
				System.out.println("1. �����ĳɼ�����");	
				System.out.println("2. ����ѧ�ɼ�����");
				System.out.println("3. ��Ӣ��ɼ�����");
				System.out.println("4. ���ܷ�����");
				System.out.println("��������ѡ��ķ�ʽ������");
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
				System.out.println("û���Ǹ�ѡ��");
				break;
			}
			if (flag == -1) 
				break;
		}
	}
}