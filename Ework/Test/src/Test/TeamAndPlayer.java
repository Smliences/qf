package Test;
/*
��Ա��
	��Ϣ������
 		���������䣬�Ա�λ�ã���������Ա����
 	
 	������
 		Ͷ�������򣬷���
*/
class Player {
	private String name;
	private int age;
	private char sex;
	private String location;
	private int playerNum;
	private String country;

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

	public char getSex() {
		return sex;
	}

	public void setSex(char sex) {
		this.sex = sex;
	}

	public String getLocation() {
		return location;
	}

	public void setLocation(String location) {
		this.location = location;
	}

	public int getPlayerNum() {
		return playerNum;
	}

	public void setPlayerNum(int playerNum) {
		this.playerNum = playerNum;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public Player(String name, int age, char sex, String location, int playerNum, String country) {
		super();
		this.name = name;
		this.age = age;
		this.sex = sex;
		this.location = location;
		this.playerNum = playerNum;
		this.country = country;
	}

	@Override
	public String toString() {
		return "Player [name=" + name + ", age=" + age + ", sex=" + sex + ", location=" + location + ", playerNum="
				+ playerNum + ", country=" + country + "]";
	}
	
	public void shot() {
		System.out.println(name + "Ͷ��");
	}
	
	public void defend() {
		System.out.println("����");
	}
	
	public void pass() {
		System.out.println("pass the ball!!");
	}
	
	
}

class TeamManager {
	private String teamName;
	private String homeCourt;

	private static int count = 0;
	
	Player[] teamPlayers = new Player[10];
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

	public TeamManager(String teamName, String homeCourt) {
		super();
		this.teamName = teamName;
		this.homeCourt = homeCourt;
	}

	@Override
	public String toString() {
		return "TeamManager [teamName=" + teamName + ", homeCourt=" + homeCourt + "]";
	}
	private void addPlayer(Player player) {
		if (null == player) {
			System.out.println("����������Ϸ�");
		}
		if (count < 10) {
		teamPlayers[count++] = player;
		} else {
			
		}
	}
	
	private void  layoffPlayerByPlayerNumber(int playerNum) {
		if (playerNum < 0 || playerNum > 100) {
			System.out.println("����������Ϸ�");
		}
		int index = findPlayByPlayNum(playerNum);
		if (index < 0) {
			for (int i = index; i < count - 1; i++) {
				teamPlayers[i] = teamPlayers[i + 1];
			}
			teamPlayers[count - 1] = null;
			count--; 
		} else {
			System.out.println("���޴���");
		}
		
	}
	
	private int findPlayByPlayNum(int playNum) {
		if (playNum < 0 || playNum > 100) {
			System.out.println("�������벻�Ϸ�");
			return -1;
		}
		int index = -1;
		for (int i = 0; i < count; i++) {
			if (playNum == teamPlayers[i].getPlayerNum()) {
				index = i;
				break;
			}
		}
		return index;
	}
	
}
public class TeamAndPlayer {
	
}
