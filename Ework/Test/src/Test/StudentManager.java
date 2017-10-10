package Test;

import java.util.Scanner;

import com.sun.swing.internal.plaf.metal.resources.metal;
/*
 * ѧ����Ϣ������
 * 			���֣����䣬�༶����ѧ�ɼ�
 * 				���ĳɼ���Ӣ��ɼ����ܷ�
 */

class Student {
	//��Ա����
	private String name;
	private int age;
	private int grade;
	private int mathScore;
	private int englishScore;
	private int totalScore;
	private int chineseScore;
	private static Student s;

	//�޲ι��췽��
	public Student() {
	}


	//�вι��췽��
	public Student(String name, int age, int grade, int mathScore, int englishScore, int chineseScore) {
		setName(name);
		setAge(age);
		setGrade(grade);
		setMathScore(mathScore);
		setEnglishScore(englishScore);
		setChineseScore(chineseScore);
		setTotalScore();
	}


	//�����Ƕ�Ӧ��setter��getter ����
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
	//��дObject�������toString������������System.out.println ��ӡʱ�Ľ��
	@Override
	public String toString() {
		return "Student [name=" + name + ", age=" + age + ", grade=" + grade + ", mathScore=" + mathScore
				+ ", englishScore=" + englishScore + ", totalScore=" + totalScore + ", chineseScore=" + chineseScore
				+ "]";
	}
}
//ѧ��������
class Manager {
	//����ͳ�������е�ѧ������
	private static int count = 0;
	//����ѧ���ķ�ʽ������ʹ�����鱣�棬�����ﱣ��Ķ���ѧ����������������student���͵�
	//Ĭ�ϴ���һ��������20�˵�����
	Student[] students = new Student[20];
	//���ѧ�����Լ��������չ
	/**
	 * ����µ�ѧ��
	 * @param student ��Ҫ��ӵ�ѧ�������
	 */
	public void addStudent(Student student) {
		//�����ж�
		if (null == student) {
			System.out.println("������������");
		}
		//���
		students[count] = student;
		count++;
		//���������ѧ���ĸ������ڵ�������ĳ��ȣ��ͽ�������չ��֮ǰ��1.5��
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
	 * ����ѧ����������ɾ��һ��ѧ��
	 * @param name Ҫɾ����ѧ��������
	 */
	public void delStudent(String name) {
		if (null == name) {
			System.out.println("������������");
		}
		//���indexҪ��һ���жϣ������-1��ʾû���ҵ��������޷����������=0��ɾ�����ѧ��
		int index = findByStudentName(name);

		if (index < 0) {
			System.out.println("���޴���");
		} else {
			//ɾ������
			for (int i = index; i < count - 1; i++) {
				students[i] = students[i + 1];
			}
			//��ԭ�����һ��λ�ø�ֵΪnull
			students[count-1] = null;
			//������ѧ��������һ
			count--;
		}
	}
	/**
	 * ����ѧ�����������ҳ�ѧ���������е��±꣬�÷���ֻ�ܸ�����ʹ��
	 * @param name Ҫ��ѯ��ѧ������
	 * @return int���ͣ�����-1��ʾû���ҵ������ء�=0��ֵ����ʾ��ѧ���������е��±�
	 */
	private int findByStudentName(String name) {
		//�����Ϸ����ж�
		if (null == name) {
			System.out.println("�������벻�Ϸ�");
			return -1;
		}
		//���ڱ����ҵ�����Ա���ڵ��±�
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
	 * ����ѧ����������ӡѧ������Ϣ
	 * @param name
	 */
	public void showStudentInfoByStudentName(String name) {
		int index = findByStudentName(name);

		if (index >= 0) {
			System.err.println(students[index]);
		} else {
			System.out.println("���޴���");
		}
	}
	/**
	 * ��ӡ����ѧ����Ϣ
	 */
	public void show() {
		for (int i = 0; i < count; i++) {
			System.out.println(students[i]);
		}
	}
	/**
	 * �����û���������֣����ж���ʲô�ɼ���������
	 * @param s �û����������
	 */
	public void sort(int s) {
		//����һ��������
		int[] temp = new int[count];
		//����û������������1��������� ѧ�������ĳɼ�����temp����
		if (s == 1)
			for (int i = 0; i < count; i++) {
				temp[i] = students[i].getChineseScore();
			}
		//����û������������2��������� ѧ����Ӣ��ɼ�����temp����
		if (s == 2)
			for (int i = 0; i < count; i++) {
				temp[i] = students[i].getEnglishScore();			}
		//����û������������1��������� ѧ������ѧ�ɼ�����temp����
		if (s == 3)
			for (int i = 0; i < count; i++) {
				temp[i] = students[i].getMathScore();
			}
		//����û������������1��������� ѧ�����ֳܷɼ�����temp����
		if (s == 4)
			for (int i = 0; i < count; i++) {
				temp[i] = students[i].getTotalScore();
			}
		//Ȼ���temp�����������
		for (int i = 0; i < count - 1; i++) {
			for (int j = 0; j < count - i - 1; j++) {
				if (temp[j] > temp[j + 1]) {
					//��temp������н�����ʱ�򣬰Ѷ�Ӧ�±��ѧ��λ��Ҳ���н���
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
	 * ����ѧ���������޸�ѧ����Ϣ
	 * @param name
	 */
	public void ModifyStudentInfoByStudentName(String name) {
		int index = findByStudentName(name);

		if (index >= 0) {
			//�޸Ĳ���
			//while  switch - case
			//��������ѭ���Ƿ����

			int flag = 0;
			//�����洢�û�����ѡ��Ĳ�������
			int choose = -1;
			Scanner sc = new Scanner(System.in); 
			Student temp = students[index]; 

			while (true) {
				System.out.println("Ҫ�޸�" + temp.getName() + "����Ϣ");
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
					temp.setName(name1);
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
					temp.setTotalScore();
					break;
				case 5:
					System.out.println("������ѧ������ѧ�ɼ�");
					int mathScore = sc.nextInt();
					temp.setMathScore(mathScore);
					temp.setTotalScore();
					break;
				case 6:
					System.out.println("������ѧ����Ӣ��ɼ�");
					int englishScore = sc.nextInt();
					temp.setMathScore(englishScore);
					temp.setTotalScore();
					break;
				case 7:
					System.out.println("�޸���ɣ��˳�");
					flag = 1;
					break;

				default:
					System.out.println("û�����ѡ��");
					break;
				} //switch - case

				students[index] = temp;
				if (flag == 1) {
					break;
				}

			} //while true

		} else {
			System.out.println("���޴��ˣ��޷��޸�");
		}
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
				m.delStudent(name1);
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
				m.sort(s);
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
