package File;

import java.io.File;
import java.io.FileNotFoundException;

public class Demo2 {
	public static void main(String[] args) {
		try {
			myJavaFiles("D:\\git\\qf\\demo");
		} catch (NullPointerException | FileNotFoundException e) {
			e.printStackTrace();
		}
	}

	public static void myJavaFiles(String pathName) throws NullPointerException, FileNotFoundException {
		if (null == pathName) {
			throw new NullPointerException("传入参数为空");
		}

		File f = new File(pathName);
		if (!f.exists()) {
			throw new FileNotFoundException();
		} else {
			File[] listFiles = f.listFiles();
			for (File file : listFiles) {
				if (file.getName().endsWith(".java")) {
					System.out.println(file.getName());
				}
			}
		}
	}
} 
