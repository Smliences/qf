
public class Test6 {
	public static void main(String[] args) {
		for (int i = 1; i < 6; i++) {
			for (int j = 0; j <= 5 - i; j++){
				System.out.print(" ");
			}

			for (int g = 0; g < i; g++) {
				System.out.print((char)(65+g));
			}

			for (int h = 5; h <= i +5; h--) {
				System.out.print((char)(69-h));
			}

			System.out.print("\n");
		}
		
		for (int i = 1; i < 6; i++) {
			for (int j = 0; j <= i; j++) {
				System.out.print(" ");
			}

			for (int h = 0; h < 5 - i; h++) {
				System.out.print("*");
			}
	
			for (int g = 0; g < 4 - i; g++) {
				System.out.print("*");
			}
			System.out.print("\n");
		}
	}
}
