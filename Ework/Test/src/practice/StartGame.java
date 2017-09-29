package practice;

import java.util.Scanner;

class BuLei {
	//��Ҫ��������Ĵ�С
	private int x;
	private int y;
	//��������
	private int[][] lei;
	//��ʾ����
	private String[][] sLei;
	private static BuLei b;
	//�в����ĵ�������
	public static BuLei getInstance(int x, int y) {
		if (null == b) {
			b = new BuLei(x,y);
		}
		return b;
	}
	//�޲����ĵ�������
	public static BuLei getInstance() {
		if (null == b) {
			b = new BuLei();
		}
		return b; 
	}
	
	public void setX(int x) {
		this.x = x;
	}

	public void setY(int y) {
		this.y = y;
	}
	
	
	public int getX() {
		return x;
	}

	public int getY() {
		return y;
	}

	public BuLei() {}
	public BuLei(int x, int y) {
		super();
		this.x = x;
		this.y = y;
	}
//���׷��� ��������Ҫ���׵ĸ���
	public void buLei(int s) {
		if (s < 0) {
			System.out.println("�����������1");
		}
		lei = new int[x][y];
		for (int i = 0; i < s; i++) {
			//������������±�
			int x1 = (int) (Math.random() * x - 1);
			int y1 = (int) (Math.random() * y - 1);
			//����
			if (lei[x1][y1] != '*') {
				lei[x1][y1] = '*';			
			} else {
				//������ɵ���������±������Ԫ������ ����i��һ��Ϊ�����׵ĸ�����s���
				i--;
			}
			
		}
		//����������ķ���
		setNum(lei, x, y);
//		toString(lei);
//		System.out.println("_____________________________________");
//		System.out.println("_____________________________________");
//		toString(lei);
	}
	//��������ķ���
	public void toString(int[][] lei) {
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				System.out.print(lei[i][j] + " ");
			}
			System.out.println();
		}
	}
	//�����Աߵİ˸��ط��������
	public void setNum(int[][] lei, int x, int y) {
		if (null == lei) {
			System.out.println("�����������2");
		}
		//�����ά����ı�Ե
		for (int i = 0; i < y; i++) {
			for (int j = 0; j < x; j++) {
				if (lei[i][j] == '*') {
//					if (i < y - 1 && i >= 1 && j < x - 1 && j >= 1) {
//						lei[i + 1][j] += 1;
//						lei[i][j + 1] += 1;
//						lei[i + 1][j + 1] += 1;
//						lei[i - 1][j] += 1;
//						lei[i][j - 1] += 1;
//						lei[i - 1][j - 1] += 1;
//						lei[i + 1][j - 1] += 1;
//						lei[i - 1][j + 1] += 1;
//					}
					//
					if (i + 1 < y && lei[i + 1][j] != '*')
						lei[i + 1][j] += 1;
					if (j + 1 < x && lei[i][j + 1] != '*')
						lei[i][j + 1] += 1;
					if (i + 1 < y && j + 1 < x && lei[i + 1][j + 1] != '*')
						lei[i + 1][j + 1] += 1;
					if (i - 1 >= 0 && lei[i - 1][j] != '*')
						lei[i - 1][j] += 1;
					if (j - 1 >= 0 && lei[i][j - 1] != '*')
						lei[i][j - 1] += 1;
					if (i - 1 >= 0 && j - 1 >=0 && lei[i - 1][j - 1] != '*')
						lei[i - 1][j - 1] += 1;
					if (i + 1 < x && j - 1 >=0 && lei[i + 1][j - 1] != '*')
						lei[i + 1][j - 1] += 1;
					if (i - 1 >= 0 && j + 1 < y && lei[i - 1][j + 1] != '*')
						lei[i - 1][j + 1] += 1;
				}
			} 
		}
		
	}
	//��ӡ��ʾ����ķ���
	public void toString(String[][] sLei) {
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				System.out.print(sLei[i][j] + " ");
			}
			System.out.println();
		}
	}

	public void saoLei() {
		//������ʾ����
		sLei = new String[x][y];
		Scanner sc = new Scanner(System.in);
		int x1,y1;
		//��ʼ������
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				sLei[i][j] = "[" + i + "," + j + "]";
			}
		}

		while (true) {
		toString(sLei);
		System.out.println("�������Ӧ�±꣬�м��ÿո����:");
		//��ʼ����
		x1 = sc.nextInt();
		y1 = sc.nextInt();
		//�������������� ����Ϸ����
		if (lei[x1][y1] == '*') {
			System.out.println("Game Over!");
			break;
		} else {
			//���û���ף���Ѳ��������Ӧ�����긳ֵ����ʾ����
			sLei[x1][y1] = "[ " + lei[x1][y1] + " ]";
		}
		}
		}	
}
	



public class StartGame {
	public static void main(String[] args) {
		BuLei b = BuLei.getInstance(7, 7);
		b.buLei(7);
		b.saoLei();
	}
}
