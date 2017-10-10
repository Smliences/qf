package Test;

import java.util.Scanner;


/*
 * Ա�����������䣬���ţ�ְλ�����ţ����룬����
 */
class Employee {
	//��Ա����
	private String name;
	private int age;
	private int number;
	private String department;
	private String job;
	private String password;
	private int money;
	//set get����
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
	public int getNumber() {
		return number;
	}
	public void setNumber(int number) {
		this.number = number;
	}
	public String getDepartment() {
		return department;
	}
	public void setDepartment(String department) {
		this.department = department;
	}
	public String getJob() {
		return job;
	}
	public void setJob(String job) {
		this.job = job;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getMoney() {
		return money;
	}
	public void setMoney(int money) {
		this.money = money;
	}
	//���췽��
	public Employee() {}
	public Employee(String name, int age, int number, String department, String job, String password, int money) {
		super();
		this.name = name;
		this.age = age;
		this.number = number;
		this.department = department;
		this.job = job;
		this.password = password;
		this.money = money;
	}
	//��ӡ����
	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", number=" + number + ", department=" + department
				+ ", job=" + job + ", password=" + password + ", money=" + money + "]";
	}

}
/*
 * ʵ�ֵ�¼����
 * �ϰ��ܲ������е�Ա������ƸԱ�������Ա�����޸�Ա����Ϣ����ѯԱ��������Ա�����䣬��������
 * �������ܿ��Բ��������ŵ�Ա���������޸�Ա�����ʣ��Ͳ鿴Ա��
 * Ա���Լ�ֻ�ܲ鿴�Լ�����Ϣ���޸��Լ������롣
 */
class EManager {
	//�����洢��¼ �˺� ����
	private int userNum;
	private String passWord;
	//�����洢Ա��
	Employee[] employees = new Employee[20];
	//�����洢Ա������
	private static int count = 1;
	//��ʼ����ʱ�� Ϊϵͳ���һ��BOSS����Ա
	{
		Employee employee1 = new Employee("BOSS", 66, 1, "BOSS" , "BOSS", "1", 1);
		employees[0] = employee1;
	}
	public int getUserNum() {
		return userNum;
	}
	public void setUserNum(int userNum) {
		this.userNum = userNum;
	}
	public String getPassWord() {
		return passWord;
	}
	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	/**
	 * ���Ա������
	 * @param employee �������Ա����ӵ���������
	 */
	public void addEmployee(Employee employee) {
		//�ж��Ƿ��¼
		if (userNum == 0) {
			System.out.println("���ȵ�¼");
			return;
		}
		if (null == employee) {
			System.out.println("�������벻��ȷ");
		}
		//���Ա��
		employees[count] = employee;
		count++;
		//������չ
		if (count >= employees.length) {
			Employee[] temp = new Employee[(int) (employees.length * 1.5)];
			for (int i = 0; i < count; i++) {
				temp[i] = employees[i];
			}
			employees = temp;
		}
	}
	/**
	 * �ҵ���Ӧ���ŵ�Ա�������±�
	 * @param num ����Ҫ�ҵ�Ա����
	 * @return ����ҵ��� ����Ա���ţ��Ҳ��� �Ͳ������Ϸ��򷵻�-1
	 */
	public int findEmployeeByEmployeeNum(int number) {
		if (number < 0) {
			System.out.println("�������Ϸ�");
			return -1;
		}
		//����ָ�����ŵ���
		int index = -1;
		for (int i = 0; i < count; i++) {
			if (employees[i].getNumber() == number) {
				index = i;
			} 
		}

		if (index == -1) {
			System.out.println("���޴���");
			return -1;
		}
		return index;
	}
	/**
	 * 
	 * @param num
	 */
	public void delEmployee(int number) {
		if (userNum == 0) {
			System.out.println("���ȵ�¼");
			return;
		}
		if (number < 0) {
			System.out.println("�������Ϸ�");
		}
		//ɾ����ʱ���ж��Ѿ���¼���û���ְλ�Ƿ�Ϊboss,�������boss����ֹ����
		int userIndex = findEmployeeByEmployeeNum(userNum);
		if (!employees[userIndex].getJob().equals("BOSS")) {
			System.out.println("�㲻��BOSS");
			return;
		}
		//ɾ������
		int index = findEmployeeByEmployeeNum(number);
		if (number != -1) {
			for (int i = index; i < count - 1; i++) {
				employees[index] = employees[index + 1];
			}
			employees[count - 1] = null;
			count--;
		} else {
			System.out.println("���޴���");
		}
	}
	/**
	 *  ��¼����
	 * @return int �����¼�û���ְλ��BOSS���򷵻�1������ǡ�****Manager��,����****�ò��ŵ����ܣ������employee��˵����Ա��
	 */
	public int login() {
		//��¼
		System.out.println("���¼");
		System.out.println("������Ĺ���:");
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		System.out.println("�����������:");
		sc.nextLine();
		String password = sc.nextLine();
		//�ж��˺������Ƿ�ƥ�����ȷ
		int index = findEmployeeByEmployeeNum(number);
		if (employees[index].getPassword().equals(password)) {
			userNum = number;
			passWord = password;
			//����ǵ�¼�û�ְλ��BOSS,�򷵻�1
			if (employees[index].getJob().equals("BOSS")) {
				return 1;
				//�����*****Manager������*****���ŵ�����
			} else if (employees[index].getJob().equals("departmentManager")) {
				return 2;
				//�����Ա���򷵻�3
			} else {
				return 3;
			}
		} else {
			System.out.println("���벻��ȷ");
			return -1;
		}
	}
	/**
	 *  ���ݴ����Ա���ţ����޸�ָ��Ա������Ϣ
	 * @param number
	 */
	public void ModifyEmployeeInfoByEmployeeNum(int number) {
		//�ж��Ƿ��¼
		if (userNum == 0) {
			System.out.println("���ȵ�¼");
			return;
		}
		int index = findEmployeeByEmployeeNum(number);
		int userIndex = findEmployeeByEmployeeNum(userNum);
		if (index >= 0) {
			//�޸Ĳ���
			//while  switch - case
			//��������ѭ���Ƿ����

			int flag = 0;
			//�����洢�û�����ѡ��Ĳ�������
			int choose = -1;
			Scanner sc = new Scanner(System.in); 
			Employee temp = employees[index]; 
			//�жϵ�¼�û���ְλ�������BOSS�������Ƹ����͵Ȳ���
			if (employees[userIndex].getJob().equals("BOSS")) {
				while (true) {
					System.out.println("Ҫ�޸�" + temp.getName() + "����Ϣ");
					System.out.println("***Name:" + temp.getName());
					System.out.println("***Age:" + temp.getAge());
					System.out.println("***Numer" + temp.getNumber());
					System.out.println("***Job:" + temp.getJob());
					System.out.println("***Department: " + temp.getDepartment());
					System.out.println("***money:" + temp.getMoney());
					System.out.println("***Password:" + temp.getPassword());

					System.out.println("1. �޸�Ա������");
					System.out.println("2. �޸�Ա������");
					System.out.println("3. �޸�Ա����");
					System.out.println("4. �޸�Ա��ְҵ");
					System.out.println("5. �޸�Ա������");
					System.out.println("6. �޸�Ա������");
					System.out.println("7. �޸�Ա������");
					System.out.println("8. �˳�");

					choose = sc.nextInt();
					sc.nextLine();
					switch (choose) {
					case 1:
						System.out.println("������Ա������:");
						String name1 = sc.nextLine();
						temp.setName(name1);
						break;
					case 2:
						System.out.println("������Ա������:");
						int age = sc.nextInt();
						temp.setAge(age);
						break;
					case 3:
						System.out.println("������Ա����:");
						int number1 = sc.nextInt();
						temp.setNumber(number1);
						break;
					case 4:
						System.out.println("������Ա��ְҵ");
						String job = sc.nextLine();
						temp.setJob(job);
					case 5:
						System.out.println("������Ա������:");
						String department = sc.nextLine();
						temp.setDepartment(department);
						break;
					case 6:
						System.out.println("������Ա������:");
						int money = sc.nextInt();
						temp.setMoney(money);
						break;
					case 7:
						System.out.println("������Ա������:");
						String password = sc.nextLine();
						temp.setPassword(password);
						break;
					case 8:
						System.out.println("�޸���ɣ��˳�");
						flag = 1;
						break;

					default:
						System.out.println("û�����ѡ��");
						break;
					} //switch - case

					employees[index] = temp;
					if (flag == 1) {
						break;
					}
				}
				//�жϵ�¼�û���ְλ�Ƿ�Ϊ�������ܣ���Ҫ�޸���ϢԱ���Ƿ�͵�¼�û��Ĳ�����ͬ,
				//����departmentManagerд���ˣ�û���޸�
			} else if(employees[userIndex].getJob().equals("departmentManager") 
					&& employees[userIndex].getDepartment().equals(employees[index].getDepartment())
					) {
				while (true) {
					System.out.println("1. �޸�Ա������");
					System.out.println("2. �˳�");
					int i = sc.nextInt();
					if (i == 1) {
						System.out.println("������Ա������");
						int money = sc.nextInt();
						temp.setMoney(money);
					} else if (i == 2) {
						break;
					} else {
						System.out.println("û�д�ѡ��");
					}
				}
				//�ж��Ƿ�ΪԱ��
			} else if (employees[userIndex].getJob().equals("employee")) {
				while (true) {
					System.out.println("1. �޸��Լ�������");
					System.out.println("2. �˳�");
					int i = sc.nextInt();
					if (i == 1) {
						System.out.println("����������:");
						String password = sc.nextLine();
						temp.setPassword(password);
					} else {
						break;
					}
				}
			}
		} else {
			System.out.println("���޴��飬�޷��޸�");
		}
	}
	//��ӡ��Ϣ
	public void show() {
		if (userNum == 0) {
			System.out.println("���ȵ�¼");
			return;
		}
		//�����¼�û���ְλΪBOSS�����ӡ����Ա����Ϣ
		int index = findEmployeeByEmployeeNum(userNum);
		if (employees[index].getJob().equals("BOSS")) {
			for (int i = 0; i < count; i++) {
				System.out.println(employees[i]);
			}
			//�����¼�û���ְλΪ�������ܣ����ӡ�ò������е�Ա��
		}else if (employees[index].getJob().equals("departmentManager")) {
			for (int i = 0; i < count; i++) {
				if (employees[index].getDepartment().equals(employees[i].getDepartment())) 
					System.out.println(employees[i]);
			}
			//�����¼�û�ΪԱ�������ӡ�Լ�����Ϣ
		} else {
			System.out.println(employees[index]);
		}
	}
	/**
	 * 	����
	 * @param s ����������s = 1�Ļ��Ͱ��������򣬵���2 �Ļ� �Ͱ���������
	 */
	public void sort(int s) {
		if (s == 1) {
			for (int i = 0; i < count - 1; i++) {
				for (int j = 0; j < count - i - 1; i++) {
					if (employees[j].getAge() > employees[j + 1].getAge()) {
						Employee temp = new Employee();
						temp = employees[j];
						employees[j] = employees[j + 1];
						employees[j + 1] = temp;
					}
				}
			}
			show();
		} else if (s == 2){
			for (int i = 0; i < count - 1; i++) {
				for (int j = 0; j < count - i - 1; i++) {
					if (employees[j].getMoney() > employees[j + 1].getMoney()) {
						Employee temp = new Employee();
						temp = employees[j];
						employees[j] = employees[j + 1];
						employees[j + 1] = temp;
					}
				}
			}
			show();
		}
	}
	//��ӡָ��Ա���ŵ�Ա����Ϣ
	public void showByNumber(int number) {
		int index = findEmployeeByEmployeeNum(number);
		System.out.println(employees[index]);
	}
}

public class EmployeeManager {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		EManager m = new EManager();
		//��������ѭ���Ƿ����
		int flag = 0;
		//�����洢�û���ѡ��
		int choose = -1;
		int index = m.findEmployeeByEmployeeNum(m.getUserNum());
		//�û���¼�����ݷ���ֵ�жϵ�¼�û�ְλ
		int i = m.login();

		if (i != 1 && i != 2 && i != 3) {
			return;
		}
		//�����¼�û���ְλΪBOSS
		if (i == 1)
			while(true) {
				System.out.println("��ӭ����Ա���������ϵͳ");
				System.out.println("1. ���Ա�� ");
				System.out.println("2. ɾ��Ա��");
				System.out.println("3. �޸�Ա����Ϣ");
				System.out.println("4. Ա������");
				System.out.println("5. ��ʾ����Ա����Ϣ");
				System.out.println("6. �л��˺�");
				System.out.println("7. �˳�");

				choose = sc.nextInt();
				sc.nextLine();
				switch (choose) {
				case 1:
					System.out.println("��������Ҫ��ӵ�Ա������");
					String name = sc.nextLine();
					System.out.println("��������Ҫ��ӵ�Ա������");
					int number = sc.nextInt();
					System.out.println("��������Ҫ��ӵ�Ա������");
					int age = sc.nextInt();
					System.out.println("��������Ҫ��ӵ�Ա��ְλ");
					sc.nextLine();
					String job = sc.nextLine();
					System.out.println("��������Ҫ��ӵ�Ա������");
					String department = sc.nextLine();
					System.out.println("��������Ҫ��ӵ�Ա������");
					int money = sc.nextInt();
					System.out.println("��������Ҫ��ӵ�Ա������");
					sc.nextLine();
					String password = sc.nextLine();
					Employee employee = new Employee(name, age, number, department, job, password, money);
					m.addEmployee(employee);
					break;
				case 2:
					System.out.println("��������Ҫɾ����Ա����");
					int number1 = sc.nextInt();
					m.delEmployee(number1);
					break;
				case 3:
					System.out.println("��������Ҫ�޸ĵ�Ա����");
					int number2 = sc.nextInt();
					m.ModifyEmployeeInfoByEmployeeNum(number2);
					break;
				case 4:
					System.out.println("1. �������� ����");
					System.out.println("2. ���չ�������");
					System.out.println("��ѡ����Ҫ������");
					int s = sc.nextInt();
					m.sort(s);
					break;
				case 5:
					m.show();
					break;
				case 6:
					i = m.login();
					flag = -1;
					break;
				case 7:
					flag = -1;
					break;

				default:
					System.out.println("û���Ǹ�ѡ��");
					break;
				}
				if (flag == -1) 
					break;
			}
		//�����¼�û�ְλΪ��������
		if (i == 2) {
			while (true) {
				System.out.println("1. �޸�Ա����Ϣ");
				System.out.println("2. �鿴Ա��");
				System.out.println("3. �˳�");
				int s = sc.nextInt();
				if (s == 1) {
					System.out.println("������Ҫ�޸ĵ�Ա����");
					int number = sc.nextInt();
					m.ModifyEmployeeInfoByEmployeeNum(number);
				} else if (s == 2) {
					m.show();
				} else {
					break;
				}
			}
		}
		//�����¼�û���ְλΪԱ��
		if (i == 3) {
			while (true) {
				System.out.println("1. �޸��Լ�������");
				System.out.println("2. �鿴�Լ�����Ϣ");
				System.out.println("3. �˳�");
				int s = sc.nextInt();
				if (s == 1) {
					m.ModifyEmployeeInfoByEmployeeNum(m.getUserNum());
				} else if (s == 2) {
					m.showByNumber(m.getUserNum());
				} else {
					break;
				}
			}
		}
	}
}