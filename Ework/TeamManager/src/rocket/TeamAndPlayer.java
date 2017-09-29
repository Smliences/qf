package rocket;

import java.util.Scanner;

/*
 球员的
 	信息包含：
  		姓名，年龄，性别，位置，国籍，球员号码
  	
  	能力：
  		投篮，传球，防守
 */
class Player {
	//成员变量
	private char sex;
	private int age;
	private int playerNum;
	private String name;
	private String location;
	private String country;
	
	//无参构造方法
	public Player() {}
	
	//有参构造方法
	public Player(String name, int age, char sex, String location, String country, int playNum) {
		setAge(age);
		setSex(sex);
		setName(name);
		setLocation(location);
		setCountry(country);
		setPlayerNum(playNum);
	}
	
	//一下是对应的setter和getter 方法
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
	
	public char getSex() {
		return sex;
	}
	
	public void setSex(char sex) {
		if ('M' == sex || 'm' == sex || 'F' == sex || 'f' == sex) {	
			this.sex = sex;
		} else {
			this.sex = 'M';
		} 
	}
	
	public String getLocation() {
		return location;
	}
	
	public void setLocation(String location) {
		this.location = location;
	}
	
	public String getCountry() {
		return country;
	}
	
	public void setCountry(String country) {
		this.country = country;
	}
	
	public int getPlayerNum() {
		return playerNum;
	}
	
	public void setPlayerNum(int playerNum) {
		if (playerNum < 0 || playerNum > 100) {
			this.playerNum = 1;
		} else {			
			this.playerNum = playerNum;
		}
	}
	
	//成员 方法
	public void shot() {
		System.out.println(name + "罚篮95%");
	}
	
	public void pass() {
		System.out.println("pass me the ball！");
	}
	
	public void defend() {
		System.out.println("进攻可以赢球，防守可以拿冠军");
	}
	
	
	//重写Object类里面的toString方法，来满足System.out.println 打印时的结果
	@Override
	public String toString() {
		return "[Name:" + name + " PlayerNumber:" + playerNum + " age:" + age + 
				" Sex:" + sex + " Country:" + country + " Location:" + location + "]";
	}
}

//重点重点重点！！！！！ 球员管理类
class TeamManager {
	//队名 球队主场
	private String teamName;
	private String homeCourt;
	
	//保存球员的方式，这里使用数组保存，数组里面保存的都是球员，所以这个数组的类型是Player类型
	//默认创建一个能够容纳10人的球员
	Player[] teamPlayers = new Player[10]; 
	
	//定义一个static修饰的成员变量，勇于统计当前的球队中有多少球员
	private static int count = 0;
	
	public TeamManager() {}
	
	public TeamManager(String teamName, String homeCourt) {
		this.teamName = teamName;
		this.homeCourt = homeCourt;
	}
	
	public String getTeamName() {
		return teamName;
	}
	
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	
	public String getHomeCourt() {
		return homeCourt;
	}
	
	public void setHomeCourt(String homeCourt) {
		this.homeCourt = homeCourt;
	}
	
	//对球员的操作，重点！！！！
	/*
	 *	注册球员
	 *	解雇球员
	 *  修改球员注册信息
	 *  查询球员信息
	 *  
	 *  用选择排序 升序 排列球员年龄 
	 *  用冒泡排序 降序 排列球员号码
	 *  
	 *  重点 球队的扩张
	 */
	
	/**
	 * 添加新的球员到球队中
	 * @param playToAdd 是要添加的球员类对象
	 */
	public void addPlayer(Player playToAdd) {
		//异常的处理，如果传入的playToAdd的内容为null，这里是异常现象
		if (playToAdd == null) {
			System.out.println("球员信息为空，不可添加");
			return;
		}
		//count的数值如果等于teamPlayers.length length 原本是10
		//要考虑球队的扩张
		if (count < 10) {
			teamPlayers[count++] = playToAdd;
		} else {
			//完成球队的扩张！！！
		}
	}
	
	/**
	 *	根据球员的编号来删除一个球员
	 * @param playerNumber 要删除的球员的编号
	 */
	public void layoffPlayerByPlayerNumber(int playerNumber) {
		//这个index要做一个判断，如果是-1表示没有找到，这里无法处理，如果》=0解雇该球员
		int index = findPlayerByPlayerNumber(playerNumber);
		
		if (index >= 0) {
			//这里是删除操作
			/*
			 		 0 1 2 3 4
			 5个球员  index  1     << 3
			 		 index  3     << 1
			 */
			for (int i = index; i < count - 1; i++) {
				teamPlayers[i] = teamPlayers[i + 1];
			}
			//把原本最后一个位置赋值为null
			teamPlayers[count - 1] = null;
			//球队球员个数 - 1
			count--;
			 
		} else {
			System.out.println("查无此人，无法删除");
		}
	}
	
	/**
	 * 根据球员的编号来展示球员信息
	 * @param playerNumber 要展示球员编号
	 */
	public void showPlayerInfoByPlayerNumber(int playerNumber) {
		int index = findPlayerByPlayerNumber(playerNumber);
		
		if (index >= 0) {
			System.out.println(teamPlayers[index]);
		} else {
			System.out.println("查无此人");
		}
	} 
	
	/**
	 * 根据球员的编号来修改球员的信息
	 * @param playerNumber
	 */
	public void ModifyPlayerInfoByPlayerNumber(int playerNumber) {
		int index = findPlayerByPlayerNumber(playerNumber);
		
		if (index >= 0) {
			//修改操作
			//while  switch - case
			
			int flag = 0;
			int choose = -1;
			Scanner sc = new Scanner(System.in); 
			Player temp = teamPlayers[index]; 
			
			while (true) {
				System.out.println("要修改" + temp.getName() + "的信息");
				System.out.println("***Name:" + temp.getName() + " PlayerNumber:" + temp.getPlayerNum());
				System.out.println("***Age:" + temp.getAge() + " Sex:" + temp.getSex());
				System.out.println("***Country:" + temp.getCountry() + " Location:" + temp.getLocation());
				
				System.out.println("1. 修改球员姓名");
				System.out.println("2. 修改球员年龄");
				System.out.println("3. 修改球员性别");
				System.out.println("4. 修改球员国籍");
				System.out.println("5. 修改球员位置");
				System.out.println("6. 退出");
				
				choose = sc.nextInt();
				sc.nextLine();
				switch (choose) {
					case 1:
						System.out.println("请输入球员的姓名:");
						
						String name = sc.nextLine();
						temp.setName(name);
						break;
					case 2:
						System.out.println("请输入球员的年龄:");
						int age = sc.nextInt();
						temp.setAge(age);
						break;
					case 3:
						System.out.println("请输入球员的性别:");
						char sex = sc.nextLine().charAt(0);
						temp.setSex(sex);
						break;
					case 4:
						System.out.println("请输入球员的国籍:");
						String country = sc.nextLine();
						temp.setCountry(country);
						break;
					case 5:
						System.out.println("请输入球员的位置:");
						String location = sc.nextLine();
						temp.setLocation(location);
						break;
					case 6:
						System.out.println("修改完成，退出");
						flag = 1;
						break;
	
					default:
						System.out.println("没有这个选项");
						break;
				} //switch - case
				
				teamPlayers[index] = temp;
				if (flag == 1) {
					break;
				}
				
			} //while true
			
		} else {
			System.out.println("查无此人，无法修改");
		}
	}
	
	/**
	 * 
	 * 根据球员的编号，找出改球员在数组中的下标，该方法只给类内使用
	 * @param playerNumber 要查询的球员编号
	 * @return int 类型，返回-1表示没有找到，返回>=0的值，表示该球员在数组中的下标
	 */
	private int findPlayerByPlayerNumber(int playerNumber) {
		//参数合法性判断
		if (playerNumber < 0 || playerNumber > 100) {
			System.out.println("传入的球员编号不合法");
			return -1;
		}
		
		//用于保存找到的球员所在下标
		int index = -1;
		
		for (int i = 0; i < count; i++) {
			if (playerNumber == teamPlayers[i].getPlayerNum()) {
				index = i;
				break;
			}
		}
		
		return index;
	}
	
	public void show() {
		for (int i = 0; i < count; i++) {
			System.out.println(teamPlayers[i]);
		}
	}
}

public class TeamAndPlayer {
	public static void main(String[] args) {
		TeamManager tm = new TeamManager("休斯顿火箭队", "丰田中心");
		
		for (int i = 0; i < 5; i++) {
			int playNum = i;
			String name = "Player" + i;
			//Math.random() 随机数， 范围是从 0 <= 随机数 < 1 小数
			int age = (int) (Math.random() * 30 + 1);
			char sex = 'M';
			String country = "PRC";
			String location = "C/PF";
			
			Player playToAdd = new Player(name, age, sex, location, country, playNum);
			
			tm.addPlayer(playToAdd);
		}
		
		tm.show();
		
		tm.layoffPlayerByPlayerNumber(1);
		System.out.println("--------------------------------------------");
		
		tm.show();
		System.out.println("--------------------------------------------");
		
		tm.showPlayerInfoByPlayerNumber(3);
		System.out.println("--------------------------------------------");
		
		tm.ModifyPlayerInfoByPlayerNumber(3);
		
		tm.show();
		
	}
}




























