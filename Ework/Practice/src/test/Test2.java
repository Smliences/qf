package test;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;

public class Test2 {
	public static void main(String[] args) throws IOException {
		test1();
		test2();
		test3();
	}

	public static void test1() throws IOException {
		File file = new File("D:/myFiles/txt");
		file.mkdirs();
		File f1 = new File("D:/myFiles");
		File f2 = new File(f1, "info1.txt");
		f2.createNewFile();
		File f3 = new File(f1, "info2.txt");
		f3.createNewFile();
		File f4 = new File(f1, "info3.txt");
		f4.createNewFile();
	}

	public static void test2() throws IOException {
		File f1 = new File("D:/myFiles/info1.txt");
		File f2 = new File("D:/myFiles/info2.txt");
		File f3 = new File("D:/myFiles/info3.txt");
		write(f1, "第一个文件内容，千锋欢迎你");
		write(f2, "第二个文件内容，中国移动培训专家");
		write(f3, "第三个文件内容，千锋助你高薪就业");
	}

	public static void write(File f, String str) throws IOException {
		if (!f.exists() || f.isDirectory()) {
			throw new NullPointerException("文件找不到");
		} 

		FileWriter fw = new FileWriter(f);
		fw.write(str);
		fw.close();
	}
	public static void test3() throws IOException {
		File f1 = new File("D:/myFiles/info1.txt");
		File f2 = new File("D:/myFiles/info2.txt");
		File f3 = new File("D:/myFiles/info3.txt");
		File destFile1 = new File("D:/myFiles/INFO1.txt");
		File destFile2 = new File("D:/myFiles/INFO2.txt");
		File destFile3 = new File("D:/myFiles/INFO3.txt"); 
		f1.renameTo(destFile1);
		f2.renameTo(destFile2);
		f3.renameTo(destFile3);
		File toFile1 = new File("D:/myFiles/txt/INFO1.txt");
		File toFile2 = new File("D:/myFiles/txt/INFO2.txt");
		File toFile3 = new File("D:/myFiles/txt/INFO3.txt");
		copyTo(f1, toFile1);
		copyTo(f2, toFile2);
		copyTo(f3, toFile3);
		}

	public static void copyTo(File file, File toFile) throws IOException {
		FileInputStream fis = new FileInputStream(file);
		FileOutputStream fos = new FileOutputStream(toFile);
		byte[] b = new byte[1024];
		int length = -1;
		while ((length = fis.read(b)) != -1) {
			fos.write(b, 0, length);
		}
		fos.close();
		fis.close();
	}	

	public static void findByString(String str) {
		File file = new File("D:/myFiles");
		File[] listFiles = file.listFiles();
		
		for (File file2 : listFiles) {
			if (file2.getName().contains("千锋")) {
				System.out.println(file2);
			}
		}
	}
	
}