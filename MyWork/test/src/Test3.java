
public class Test3 {
	public static void main(String[] args) {
		for (int i = 1; i < 10; i = i + 2) {
			for (int j = 1; j <= i; j = j + 1) {
				System.out.print("*");
			}
			System.out.println("\n");
		}
	}
}
