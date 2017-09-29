
public class ToMyLower {
	public static char toMyLower(char c) {
		return ('A' <= c && 'Z' >= c) ? (char)(c + 32) : c;
	}
	
	public static void main(String[] args) {
		System.out.println(toMyLower('a'));
	}
}
