package Day09;
//��һ��
public class Test {
	public static void main(String[] args) {
		for (int i = 1; i < 10; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(i + "*" + j + "=" + i*j + "\40");
			}
			System.out.println();
		}
	}
}
