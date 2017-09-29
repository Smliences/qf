
public class Test4 {
	public static void main(String[] args) {
		for (int i = 1; i < 6; i++) {
			for (int j = 0; j <= 5 - i ; j++){
				System.out.print(" ");
			}
			for (int g = 1; g < i; g++) {
				System.out.print("*");
			}
			for (int h = 0; h < i; h++) {
				System.out.print("*");
			}
			System.out.print("\n");
		}
	}
}
