package Day09;
//第二题 第二种方法
public class Test3 {
	public static void main(String[] args) {
		int i = 29183;
		int j = 10;
		while (true) {
			int g = i / j;
			int h = i % j;
			i = g;
			System.out.println(h);
			if (g == 0) 
				break;
		}
	}
}
