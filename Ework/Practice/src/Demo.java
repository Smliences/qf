import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Demo {
	public static void main(String[] args) throws IOException {
//		fileStreamCopy();
//		filerCopy();
		bufferCopy();
//		bufferStreamCopy();
	}
	
	public static void fileStreamCopy() throws IOException {
		File file = new File("D:/test/aaa/1.txt");
		if (!file.exists() || !file.isFile()) {
			throw new FileNotFoundException("文件未找到");
		}
		
		FileInputStream fis = new FileInputStream(file);
		File destFile = new File("D:/test/aaa/5.txt");
		FileOutputStream fos = new FileOutputStream(destFile);
		byte[] b = new byte[1024];
		int length = -1;
		while ((length = fis.read(b)) != -1) {
			fos.write(b, 0, length);
		}
		fos.close();
		fis.close();
	}
	
	public static void filerCopy() throws IOException {
		File file = new File("D:/test/aaa/1.txt");
		if (!file.exists() || !file.isFile()) {
			throw new FileNotFoundException("文件找不到");
		}
		
		FileReader fr = new FileReader(file);
		File destFile = new File("D:/test/aaa/2.txt");
		FileWriter fw = new FileWriter(destFile);
		char[] c = new char[1024];
		int length = -1;
		while ((length = fr.read(c)) != -1) {
			fw.write(new String(c, 0, length));
		}
		fw.close();
		fr.close();
	}
	
	public static void bufferCopy() throws IOException {
		File file = new File("D:/test/平凡之路.txt");
		if (!file.exists() || !file.isFile()) {
			throw new FileNotFoundException("文件找不到");
		}
		
		File file2 = new File("D:/test/3.txt");
		FileWriter fw = new FileWriter(file2);
		BufferedWriter bw = new BufferedWriter(fw);
		FileReader fr = new FileReader(file);
		BufferedReader br = new BufferedReader(fr);
		
		char[] c = new char[1024];
		int length = -1;
		while ((length = br.read(c)) != -1) {
			bw.write(new String(c, 0, length));
			
		}

		br.close();
		bw.close();
	}
	
	public static void bufferStreamCopy() throws IOException {
		File file = new File("D:/test/aaa/1.txt");
		if (!file.exists() || !file.isFile()) {
			throw new FileNotFoundException("文件找不到");
		}
		File file2 = new File("D:/test/aaa/4.txt");
		FileInputStream fis = new FileInputStream(file);
		FileOutputStream fow = new FileOutputStream(file2);
		BufferedInputStream bis = new BufferedInputStream(fis);
		BufferedOutputStream bos = new BufferedOutputStream(fow);
		
		byte[] b = new byte[1024];
		int length = -1;
		while ((length = bis.read(b)) != -1) {
			bos.write(b, 0, length);
		}
		bos.close();
		bis.close();
	}
}
