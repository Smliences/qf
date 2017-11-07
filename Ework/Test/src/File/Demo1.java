package File;

import java.io.File;
import java.io.IOException;

public class Demo1 {
	public static void main(String[] args) throws IOException {
		File f = new File("C:/aaa/1.txt");
		f.createNewFile();
	}
}
