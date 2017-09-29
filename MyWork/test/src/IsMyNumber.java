
public class IsMyNumber {
	public static int IsMyNumber(char c) {
		if ('0' <= c && '9' >= c) {
			return 1;
		} else {
			return 0;
		}
	}
	public static void main(String[] args) {
		System.out.println(IsMyNumber('i'));
	}
}
