import java.util.Scanner;
public class Test1 {
	public static void main(String[] args){
		Scanner s = new Scanner(System.in);
		String st = s.next();
		char c = st.charAt(0);
		if ((c <= 'z') && (c >= 'a')) {
			c += 32;
			System.out.println(c);
		} else if ((c <= 'Z') && (c >= 'A')) {
			c = (char) (c + 32);
			System.out.println(c);
		}
	}
}
