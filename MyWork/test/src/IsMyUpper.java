
public class IsMyUpper {
	public static int isMyUpper(char c) {
//		if ('a' <= c && 'z' >= c) {
//			return 0;
//		} else {
//			return 1;
//		}
		return ('A' <= c && 'Z' >= c) ? 1 : 0;
	}
}
