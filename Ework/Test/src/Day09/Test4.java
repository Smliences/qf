package Day09;
//µÚÈıÌâ
public class Test4 {
	public static void main(String[] args) {
		int g = 0;
		int h = 0;
		for (int i = 0; i <= 100; i += 2) {
			g = i + g;
		}
		for (int i = 1; i < 100; i += 2) {
			h = h + i;
		}
		if (h > g) {
			System.out.println(h - g);
		} else {
			System.out.println(g - h);
		}
	}
}
