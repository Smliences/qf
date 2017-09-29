package Day09;
//第二题第一种方法
public class Test2 {
	public static void main(String[] args) {
		int i = 29183;
		for (int j = 10; j > 0; j = j) {
			int g = i / j;
			int h = i % j;
			i = g;
			System.out.println(h);
			if (g == 0) {
				break;
			}
		}
	}
}
