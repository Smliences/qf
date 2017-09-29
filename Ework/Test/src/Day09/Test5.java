package Day09;
//µÚËÄÌâ
public class Test5 {
	public static void main(String[] args) {
		int i = 1;
		int s = 1;
		System.out.println(i);
		System.out.println(s);
		while (true) {
			s = s + i;
			i = s - i;
			if (s > 100)
				break;
			System.out.println(s);
		} 
	}
}
