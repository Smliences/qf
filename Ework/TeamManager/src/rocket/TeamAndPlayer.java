package rocket;

import java.util.Scanner;

/*
 ��Ա��
 	��Ϣ������
  		���������䣬�Ա�λ�ã���������Ա����
  	
  	������
  		Ͷ�������򣬷���
 */
class Player {
	//��Ա����
	private char sex;
	private int age;
	private int playerNum;
	private String name;
	private String location;
	private String country;
	
	//�޲ι��췽��
	public Player() {}
	
	//�вι��췽��
	public Player(String name, int age, char sex, String location, String country, int playNum) {
		setAge(age);
		setSex(sex);
		setName(name);
		setLocation(location);
		setCountry(country);
		setPlayerNum(playNum);
	}
	
	//һ���Ƕ�Ӧ��setter��getter ����
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
	
	//��Ա ����
	public void shot() {
		System.out.println(name + "����95%");
	}
	
	public void pass() {
		System.out.println("pass me the ball��");
	}
	
	public void defend() {
		System.out.println("��������Ӯ�򣬷��ؿ����ùھ�");
	}
	
	
	//��дObject�������toString������������System.out.println ��ӡʱ�Ľ��
	@Override
	public String toString() {
		return "[Name:" + name + " PlayerNumber:" + playerNum + " age:" + age + 
				" Sex:" + sex + " Country:" + country + " Location:" + location + "]";
	}
}

//�ص��ص��ص㣡�������� ��Ա������
class TeamManager {
	//���� �������
	private String teamName;
	private String homeCourt;
	
	//������Ա�ķ�ʽ������ʹ�����鱣�棬�������汣��Ķ�����Ա��������������������Player����
	//Ĭ�ϴ���һ���ܹ�����10�˵���Ա
	Player[] teamPlayers = new Player[10]; 
	
	//����һ��static���εĳ�Ա����������ͳ�Ƶ�ǰ��������ж�����Ա
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
	
	//����Ա�Ĳ������ص㣡������
	/*
	 *	ע����Ա
	 *	�����Ա
	 *  �޸���Աע����Ϣ
	 *  ��ѯ��Ա��Ϣ
	 *  
	 *  ��ѡ������ ���� ������Ա���� 
	 *  ��ð������ ���� ������Ա����
	 *  
	 *  �ص� ��ӵ�����
	 */
	
	/**
	 * ����µ���Ա�������
	 * @param playToAdd ��Ҫ��ӵ���Ա�����
	 */
	public void addPlayer(Player playToAdd) {
		//�쳣�Ĵ�����������playToAdd������Ϊnull���������쳣����
		if (playToAdd == null) {
			System.out.println("��Ա��ϢΪ�գ��������");
			return;
		}
		//count����ֵ�������teamPlayers.length length ԭ����10
		//Ҫ������ӵ�����
		if (count < 10) {
			teamPlayers[count++] = playToAdd;
		} else {
			//�����ӵ����ţ�����
		}
	}
	
	/**
	 *	������Ա�ı����ɾ��һ����Ա
	 * @param playerNumber Ҫɾ������Ա�ı��
	 */
	public void layoffPlayerByPlayerNumber(int playerNumber) {
		//���indexҪ��һ���жϣ������-1��ʾû���ҵ��������޷����������=0��͸���Ա
		int index = findPlayerByPlayerNumber(playerNumber);
		
		if (index >= 0) {
			//������ɾ������
			/*
			 		 0 1 2 3 4
			 5����Ա  index  1     << 3
			 		 index  3     << 1
			 */
			for (int i = index; i < count - 1; i++) {
				teamPlayers[i] = teamPlayers[i + 1];
			}
			//��ԭ�����һ��λ�ø�ֵΪnull
			teamPlayers[count - 1] = null;
			//�����Ա���� - 1
			count--;
			 
		} else {
			System.out.println("���޴��ˣ��޷�ɾ��");
		}
	}
	
	/**
	 * ������Ա�ı����չʾ��Ա��Ϣ
	 * @param playerNumber Ҫչʾ��Ա���
	 */
	public void showPlayerInfoByPlayerNumber(int playerNumber) {
		int index = findPlayerByPlayerNumber(playerNumber);
		
		if (index >= 0) {
			System.out.println(teamPlayers[index]);
		} else {
			System.out.println("���޴���");
		}
	} 
	
	/**
	 * ������Ա�ı�����޸���Ա����Ϣ
	 * @param playerNumber
	 */
	public void ModifyPlayerInfoByPlayerNumber(int playerNumber) {
		int index = findPlayerByPlayerNumber(playerNumber);
		
		if (index >= 0) {
			//�޸Ĳ���
			//while  switch - case
			
			int flag = 0;
			int choose = -1;
			Scanner sc = new Scanner(System.in); 
			Player temp = teamPlayers[index]; 
			
			while (true) {
				System.out.println("Ҫ�޸�" + temp.getName() + "����Ϣ");
				System.out.println("***Name:" + temp.getName() + " PlayerNumber:" + temp.getPlayerNum());
				System.out.println("***Age:" + temp.getAge() + " Sex:" + temp.getSex());
				System.out.println("***Country:" + temp.getCountry() + " Location:" + temp.getLocation());
				
				System.out.println("1. �޸���Ա����");
				System.out.println("2. �޸���Ա����");
				System.out.println("3. �޸���Ա�Ա�");
				System.out.println("4. �޸���Ա����");
				System.out.println("5. �޸���Աλ��");
				System.out.println("6. �˳�");
				
				choose = sc.nextInt();
				sc.nextLine();
				switch (choose) {
					case 1:
						System.out.println("��������Ա������:");
						
						String name = sc.nextLine();
						temp.setName(name);
						break;
					case 2:
						System.out.println("��������Ա������:");
						int age = sc.nextInt();
						temp.setAge(age);
						break;
					case 3:
						System.out.println("��������Ա���Ա�:");
						char sex = sc.nextLine().charAt(0);
						temp.setSex(sex);
						break;
					case 4:
						System.out.println("��������Ա�Ĺ���:");
						String country = sc.nextLine();
						temp.setCountry(country);
						break;
					case 5:
						System.out.println("��������Ա��λ��:");
						String location = sc.nextLine();
						temp.setLocation(location);
						break;
					case 6:
						System.out.println("�޸���ɣ��˳�");
						flag = 1;
						break;
	
					default:
						System.out.println("û�����ѡ��");
						break;
				} //switch - case
				
				teamPlayers[index] = temp;
				if (flag == 1) {
					break;
				}
				
			} //while true
			
		} else {
			System.out.println("���޴��ˣ��޷��޸�");
		}
	}
	
	/**
	 * 
	 * ������Ա�ı�ţ��ҳ�����Ա�������е��±꣬�÷���ֻ������ʹ��
	 * @param playerNumber Ҫ��ѯ����Ա���
	 * @return int ���ͣ�����-1��ʾû���ҵ�������>=0��ֵ����ʾ����Ա�������е��±�
	 */
	private int findPlayerByPlayerNumber(int playerNumber) {
		//�����Ϸ����ж�
		if (playerNumber < 0 || playerNumber > 100) {
			System.out.println("�������Ա��Ų��Ϸ�");
			return -1;
		}
		
		//���ڱ����ҵ�����Ա�����±�
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
		TeamManager tm = new TeamManager("��˹�ٻ����", "��������");
		
		for (int i = 0; i < 5; i++) {
			int playNum = i;
			String name = "Player" + i;
			//Math.random() ������� ��Χ�Ǵ� 0 <= ����� < 1 С��
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




























