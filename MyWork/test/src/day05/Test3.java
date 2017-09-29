package day05;

public class Test3 {
	public static int jieCheng(int i) {
		int s = 1;
		for (; i > 0; i--) {
			s = i * s;
		}
		return s;
	}
	public static void main(String[] args) {
		System.out.println(jieCheng(5));
	}
}
