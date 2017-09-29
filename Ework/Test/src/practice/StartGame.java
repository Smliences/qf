package practice;

import java.util.Scanner;

class BuLei {
	//想要生成数组的大小
	private int x;
	private int y;
	//布雷数组
	private int[][] lei;
	//显示数组
	private String[][] sLei;
	private static BuLei b;
	//有参数的单例方法
	public static BuLei getInstance(int x, int y) {
		if (null == b) {
			b = new BuLei(x,y);
		}
		return b;
	}
	//无参数的单例方法
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
//布雷方法 参数是想要埋雷的个数
	public void buLei(int s) {
		if (s < 0) {
			System.out.println("传入参数有误1");
		}
		lei = new int[x][y];
		for (int i = 0; i < s; i++) {
			//生成数组随机下标
			int x1 = (int) (Math.random() * x - 1);
			int y1 = (int) (Math.random() * y - 1);
			//埋雷
			if (lei[x1][y1] != '*') {
				lei[x1][y1] = '*';			
			} else {
				//如果生成的随机数组下标的数组元素是雷 则让i减一，为了让雷的个数与s相等
				i--;
			}
			
		}
		//调用填充数的方法
		setNum(lei, x, y);
//		toString(lei);
//		System.out.println("_____________________________________");
//		System.out.println("_____________________________________");
//		toString(lei);
	}
	//遍历数组的方法
	public void toString(int[][] lei) {
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				System.out.print(lei[i][j] + " ");
			}
			System.out.println();
		}
	}
	//将雷旁边的八个地方填充数字
	public void setNum(int[][] lei, int x, int y) {
		if (null == lei) {
			System.out.println("传入参数有误2");
		}
		//处理二维数组的边缘
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
	//打印显示数组的方法
	public void toString(String[][] sLei) {
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				System.out.print(sLei[i][j] + " ");
			}
			System.out.println();
		}
	}

	public void saoLei() {
		//定义显示数组
		sLei = new String[x][y];
		Scanner sc = new Scanner(System.in);
		int x1,y1;
		//初始化数组
		for (int i = 0; i < x; i++) {
			for (int j = 0; j < y; j++) {
				sLei[i][j] = "[" + i + "," + j + "]";
			}
		}

		while (true) {
		toString(sLei);
		System.out.println("请输入对应下标，中间用空格隔开:");
		//开始点雷
		x1 = sc.nextInt();
		y1 = sc.nextInt();
		//如果点的坐标有雷 则游戏结束
		if (lei[x1][y1] == '*') {
			System.out.println("Game Over!");
			break;
		} else {
			//如果没有雷，则把布雷数组对应的坐标赋值给显示数组
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
