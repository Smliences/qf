package Day11;

/*
 	���  ��  ��Ա  ������ϵ
 	��Ա���Կ���һ����
 	���Ҳ���Կ���һ����
 		��� �� ��Ա��ɵ�
 */
class Player {
	private int num;
	private String name;
	
	public Player(int num, String name) {
		this.num = num;
		this.name = name;
	}
	
	public void setNum(int num) {
		if (num < 0 || num > 100) {		
			this.num = 1;
		} else {
			this.num = num;
		}
	}
	
	public int getNum() {
		return num;
	}
	
	public void setName(String name) {
		this.name = name;
	}
	
	public String getName() {
		return name;
	}
}

class Team {
	private String teamName;
	//һ��������ɺܶ���Ա���
	Player p1;
	Player p2;
	Player p3;
	
	//������ӵ�ʱ��Ҫ���Ƕ������ж�Ӧ��������Ա
	public Team(String teamName, Player p1, Player p2, Player p3) {
		this.teamName = teamName;
		this.p1 = p1;
		this.p2 = p2;
		this.p3 = p3; 
	}
	
	public void setTeamName(String teamName) {
		this.teamName = teamName;
	}
	
	public String getTeamName() {
		return teamName;
	}
	
	public void game() {
		System.out.println("������ Τ�� ͻ�Ƹ��˿��� ~~~~");
	}
}

public class Demo3 {
	public static void main(String[] args) {
		Player p1 = new Player(3, "Wade");
		Player p2 = new Player(23, "James");
		Player p3 = new Player(21, "�˿�");
		
		Team BigThree = new Team("DreamTeam", p1, p2, p3);
		
		System.out.println(p1);
		System.out.println(p2);
		System.out.println(p3);
		
		System.out.println("----------------------------------");
		System.out.println(BigThree.p1);
		System.out.println(BigThree.p2);
		System.out.println(BigThree.p3);
		
		BigThree.game();
	}
}








