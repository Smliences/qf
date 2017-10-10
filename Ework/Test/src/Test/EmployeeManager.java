package Test;

import java.util.Scanner;


/*
 * 员工姓名，年龄，工号，职位，部门，密码，工资
 */
class Employee {
	//成员属性
	private String name;
	private int age;
	private int number;
	private String department;
	private String job;
	private String password;
	private int money;
	//set get方法
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
	//构造方法
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
	//打印方法
	@Override
	public String toString() {
		return "Employee [name=" + name + ", age=" + age + ", number=" + number + ", department=" + department
				+ ", job=" + job + ", password=" + password + ", money=" + money + "]";
	}

}
/*
 * 实现登录功能
 * 老板能操作所有的员工，招聘员工，解雇员工，修改员工信息，查询员工，按照员工年龄，工资排序
 * 部门主管可以操作本部门的员工，可以修改员工工资，和查看员工
 * 员工自己只能查看自己的信息，修改自己的密码。
 */
class EManager {
	//用来存储登录 账号 密码
	private int userNum;
	private String passWord;
	//用来存储员工
	Employee[] employees = new Employee[20];
	//用来存储员工个数
	private static int count = 1;
	//初始化的时候 为系统添加一个BOSS管理员
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
	 * 添加员工操作
	 * @param employee 将传入的员工添加到数组里面
	 */
	public void addEmployee(Employee employee) {
		//判断是否登录
		if (userNum == 0) {
			System.out.println("请先登录");
			return;
		}
		if (null == employee) {
			System.out.println("参数输入不正确");
		}
		//添加员工
		employees[count] = employee;
		count++;
		//数组扩展
		if (count >= employees.length) {
			Employee[] temp = new Employee[(int) (employees.length * 1.5)];
			for (int i = 0; i < count; i++) {
				temp[i] = employees[i];
			}
			employees = temp;
		}
	}
	/**
	 * 找到对应工号的员工数组下标
	 * @param num 传入要找的员工号
	 * @return 如果找到了 返回员工号，找不到 和参数不合法则返回-1
	 */
	public int findEmployeeByEmployeeNum(int number) {
		if (number < 0) {
			System.out.println("参数不合法");
			return -1;
		}
		//查找指定工号的人
		int index = -1;
		for (int i = 0; i < count; i++) {
			if (employees[i].getNumber() == number) {
				index = i;
			} 
		}

		if (index == -1) {
			System.out.println("查无此人");
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
			System.out.println("请先登录");
			return;
		}
		if (number < 0) {
			System.out.println("参数不合法");
		}
		//删除的时候判断已经登录的用户的职位是否为boss,如果不是boss则终止函数
		int userIndex = findEmployeeByEmployeeNum(userNum);
		if (!employees[userIndex].getJob().equals("BOSS")) {
			System.out.println("你不是BOSS");
			return;
		}
		//删除操作
		int index = findEmployeeByEmployeeNum(number);
		if (number != -1) {
			for (int i = index; i < count - 1; i++) {
				employees[index] = employees[index + 1];
			}
			employees[count - 1] = null;
			count--;
		} else {
			System.out.println("查无此人");
		}
	}
	/**
	 *  登录操作
	 * @return int 如果登录用户的职位是BOSS，则返回1，如果是“****Manager”,则是****该部门的主管，如果是employee，说明是员工
	 */
	public int login() {
		//登录
		System.out.println("请登录");
		System.out.println("输入你的工号:");
		Scanner sc = new Scanner(System.in);
		int number = sc.nextInt();
		System.out.println("输入你的密码:");
		sc.nextLine();
		String password = sc.nextLine();
		//判断账号密码是否匹配和正确
		int index = findEmployeeByEmployeeNum(number);
		if (employees[index].getPassword().equals(password)) {
			userNum = number;
			passWord = password;
			//如果是登录用户职位是BOSS,则返回1
			if (employees[index].getJob().equals("BOSS")) {
				return 1;
				//如果是*****Manager，则是*****部门的主管
			} else if (employees[index].getJob().equals("departmentManager")) {
				return 2;
				//如果是员工则返回3
			} else {
				return 3;
			}
		} else {
			System.out.println("密码不正确");
			return -1;
		}
	}
	/**
	 *  根据传入的员工号，来修改指定员工的信息
	 * @param number
	 */
	public void ModifyEmployeeInfoByEmployeeNum(int number) {
		//判断是否登录
		if (userNum == 0) {
			System.out.println("请先登录");
			return;
		}
		int index = findEmployeeByEmployeeNum(number);
		int userIndex = findEmployeeByEmployeeNum(userNum);
		if (index >= 0) {
			//修改操作
			//while  switch - case
			//用来控制循环是否结束

			int flag = 0;
			//用来存储用户的所选择的操作数字
			int choose = -1;
			Scanner sc = new Scanner(System.in); 
			Employee temp = employees[index]; 
			//判断登录用户的职位，如果是BOSS则可以招聘，解雇等操作
			if (employees[userIndex].getJob().equals("BOSS")) {
				while (true) {
					System.out.println("要修改" + temp.getName() + "的信息");
					System.out.println("***Name:" + temp.getName());
					System.out.println("***Age:" + temp.getAge());
					System.out.println("***Numer" + temp.getNumber());
					System.out.println("***Job:" + temp.getJob());
					System.out.println("***Department: " + temp.getDepartment());
					System.out.println("***money:" + temp.getMoney());
					System.out.println("***Password:" + temp.getPassword());

					System.out.println("1. 修改员工名字");
					System.out.println("2. 修改员工年龄");
					System.out.println("3. 修改员工号");
					System.out.println("4. 修改员工职业");
					System.out.println("5. 修改员工部门");
					System.out.println("6. 修改员工工资");
					System.out.println("7. 修改员工密码");
					System.out.println("8. 退出");

					choose = sc.nextInt();
					sc.nextLine();
					switch (choose) {
					case 1:
						System.out.println("请输入员工姓名:");
						String name1 = sc.nextLine();
						temp.setName(name1);
						break;
					case 2:
						System.out.println("请输入员工年龄:");
						int age = sc.nextInt();
						temp.setAge(age);
						break;
					case 3:
						System.out.println("请输入员工号:");
						int number1 = sc.nextInt();
						temp.setNumber(number1);
						break;
					case 4:
						System.out.println("请输入员工职业");
						String job = sc.nextLine();
						temp.setJob(job);
					case 5:
						System.out.println("请输入员工部门:");
						String department = sc.nextLine();
						temp.setDepartment(department);
						break;
					case 6:
						System.out.println("请输入员工工资:");
						int money = sc.nextInt();
						temp.setMoney(money);
						break;
					case 7:
						System.out.println("请输入员工密码:");
						String password = sc.nextLine();
						temp.setPassword(password);
						break;
					case 8:
						System.out.println("修改完成，退出");
						flag = 1;
						break;

					default:
						System.out.println("没有这个选项");
						break;
					} //switch - case

					employees[index] = temp;
					if (flag == 1) {
						break;
					}
				}
				//判断登录用户的职位是否为部门主管，和要修改信息员工是否和登录用户的部门相同,
				//这里departmentManager写死了，没有修改
			} else if(employees[userIndex].getJob().equals("departmentManager") 
					&& employees[userIndex].getDepartment().equals(employees[index].getDepartment())
					) {
				while (true) {
					System.out.println("1. 修改员工工资");
					System.out.println("2. 退出");
					int i = sc.nextInt();
					if (i == 1) {
						System.out.println("请输入员工工资");
						int money = sc.nextInt();
						temp.setMoney(money);
					} else if (i == 2) {
						break;
					} else {
						System.out.println("没有此选项");
					}
				}
				//判断是否为员工
			} else if (employees[userIndex].getJob().equals("employee")) {
				while (true) {
					System.out.println("1. 修改自己的密码");
					System.out.println("2. 退出");
					int i = sc.nextInt();
					if (i == 1) {
						System.out.println("请输入密码:");
						String password = sc.nextLine();
						temp.setPassword(password);
					} else {
						break;
					}
				}
			}
		} else {
			System.out.println("查无此书，无法修改");
		}
	}
	//打印信息
	public void show() {
		if (userNum == 0) {
			System.out.println("请先登录");
			return;
		}
		//如果登录用户的职位为BOSS，则打印所有员工信息
		int index = findEmployeeByEmployeeNum(userNum);
		if (employees[index].getJob().equals("BOSS")) {
			for (int i = 0; i < count; i++) {
				System.out.println(employees[i]);
			}
			//如果登录用户的职位为部门主管，则打印该部门所有的员工
		}else if (employees[index].getJob().equals("departmentManager")) {
			for (int i = 0; i < count; i++) {
				if (employees[index].getDepartment().equals(employees[i].getDepartment())) 
					System.out.println(employees[i]);
			}
			//如果登录用户为员工，则打印自己的信息
		} else {
			System.out.println(employees[index]);
		}
	}
	/**
	 * 	排序
	 * @param s 如果传入参数s = 1的话就按年龄排序，等于2 的话 就按工资排序
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
	//打印指定员工号的员工信息
	public void showByNumber(int number) {
		int index = findEmployeeByEmployeeNum(number);
		System.out.println(employees[index]);
	}
}

public class EmployeeManager {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in); 
		EManager m = new EManager();
		//用来控制循环是否结束
		int flag = 0;
		//用来存储用户的选择
		int choose = -1;
		int index = m.findEmployeeByEmployeeNum(m.getUserNum());
		//用户登录，根据返回值判断登录用户职位
		int i = m.login();

		if (i != 1 && i != 2 && i != 3) {
			return;
		}
		//如果登录用户的职位为BOSS
		if (i == 1)
			while(true) {
				System.out.println("欢迎来到员工管理管理系统");
				System.out.println("1. 添加员工 ");
				System.out.println("2. 删除员工");
				System.out.println("3. 修改员工信息");
				System.out.println("4. 员工排序");
				System.out.println("5. 显示所有员工信息");
				System.out.println("6. 切换账号");
				System.out.println("7. 退出");

				choose = sc.nextInt();
				sc.nextLine();
				switch (choose) {
				case 1:
					System.out.println("请输入你要添加的员工姓名");
					String name = sc.nextLine();
					System.out.println("请输入你要添加的员工工号");
					int number = sc.nextInt();
					System.out.println("请输入你要添加的员工年龄");
					int age = sc.nextInt();
					System.out.println("请输入你要添加的员工职位");
					sc.nextLine();
					String job = sc.nextLine();
					System.out.println("请输入你要添加的员工部门");
					String department = sc.nextLine();
					System.out.println("请输入你要添加的员工工资");
					int money = sc.nextInt();
					System.out.println("请输入你要添加的员工密码");
					sc.nextLine();
					String password = sc.nextLine();
					Employee employee = new Employee(name, age, number, department, job, password, money);
					m.addEmployee(employee);
					break;
				case 2:
					System.out.println("请输入你要删除的员工号");
					int number1 = sc.nextInt();
					m.delEmployee(number1);
					break;
				case 3:
					System.out.println("请输入你要修改的员工号");
					int number2 = sc.nextInt();
					m.ModifyEmployeeInfoByEmployeeNum(number2);
					break;
				case 4:
					System.out.println("1. 按照年龄 排序");
					System.out.println("2. 按照工资排序");
					System.out.println("请选择你要的排序");
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
					System.out.println("没有那个选项");
					break;
				}
				if (flag == -1) 
					break;
			}
		//如果登录用户职位为部门主管
		if (i == 2) {
			while (true) {
				System.out.println("1. 修改员工信息");
				System.out.println("2. 查看员工");
				System.out.println("3. 退出");
				int s = sc.nextInt();
				if (s == 1) {
					System.out.println("请输入要修改的员工号");
					int number = sc.nextInt();
					m.ModifyEmployeeInfoByEmployeeNum(number);
				} else if (s == 2) {
					m.show();
				} else {
					break;
				}
			}
		}
		//如果登录用户的职位为员工
		if (i == 3) {
			while (true) {
				System.out.println("1. 修改自己的密码");
				System.out.println("2. 查看自己的信息");
				System.out.println("3. 退出");
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