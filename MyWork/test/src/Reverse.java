
public class Reverse {
	public static void reverse(int number) {
		while (true) {
			int i,j;
			i = number % 10;
			System.out.println(i);
			number = number / 10;
			if (number == 0) 
				break;
		}
	}
	
	public static void main(String[] args) {
		reverse(123456);
	}
}
