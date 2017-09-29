
public class isMyEnglish {
	public static int isMyEnglist(char c) {
		if (('a' <= c && 'z' >= c) || ('A' <= c && 'Z' >= c) ) {
			return 1;
		} else {
			return 0;
		}
	}
}
