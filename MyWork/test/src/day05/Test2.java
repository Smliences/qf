package day05;

public class Test2 {
	public static void main(String[] args) {
		int i = 1;
		int s = 1;
		System.out.println(i);
		System.out.println(s);
		while (true) {
			s = i + s;
			i = s - i;
			System.out.println(s);
			if (s > 100)
				break;
		}
	}
}
