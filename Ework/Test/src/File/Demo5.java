package File;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.IOException;

public class Demo5 {
	public static void main(String[] args) throws IOException {
		//		File f = new File("D:/aaa/ccc/2.txt");
		//		File outFile = new File("D:/aaa/ccc/3.txt");
		//		FileInputStream fis = new FileInputStream(f);
		//		FileOutputStream fos = new FileOutputStream(outFile);
		//		int length = -1;
		//		byte[] b = new byte[64];
		//		while ((length = fis.read(b)) != -1)
		//			fos.write(b, 0, length);
		//		fis.close();
		//		fos.close();
		//		readTest1();
		//		readTest2();
		readTest3();
	}

	public static void readTest1() throws IOException {
		File file = new File("D:/aaa/ccc/2.txt");

		if (!file.exists() || !file.isFile()) {
			throw new FileNotFoundException("文件找不到");
		}
		FileInputStream fis = new FileInputStream(file);
		int content = fis.read();
		System.out.println(content);
		fis.close();
	}

	public static void readTest2() throws IOException {
		//1. 找到文件
		File file = new File("D:/aaa/ccc/2.txt");

		//判断文件是否存在，或者是否是一个普通文件
		if (!file.exists() || !file.isFile()) {
			throw new FileNotFoundException();
		}

		//2. 建立管道
		FileInputStream fs = new FileInputStream(file);

		//3. 读取文件
		//这里利用read方法的特性，read如果读取到文件的最后，返回-1，表示文件读取完成
		//在其他语言中存在EOF End of File
		int content = -1;
		while ((content = fs.read()) != -1) {
			System.out.println(content);
		}

		//4. 关闭资源
		fs.close();
	}
	//int read() 返回的int是字节对应的ascii码
	//int read(byte[] b) 返回的是字节的个数
	public static void readTest3() throws IOException {
		File file = new File("D:/aaa/ccc/2.txt");

		if (!file.exists() || !file.isFile()) {
			throw new FileNotFoundException("文件找不到");
		}
		
		FileInputStream fis = new FileInputStream(file);
		byte[] b = new byte[1];
		int length = -1;
		//		while ((length = fis.read(b)) != -1) {
		System.out.println(fis.read(b));
		//		}
		fis.close();
	}
}

class FileOuter {
	public static void testWrite1() throws IOException {
		File file = new File("D:/aaa/ccc/2.txt");
		if (!file.exists() || !file.isFile()) {
			throw new FileNotFoundException("文件未找到");
		}
		FileOutputStream fos = new FileOutputStream(file,true);
		String s = "123123";
		fos.write(s.getBytes());
		fos.write('1');
		fos.write('1');
		fos.close();
	}
	
	public static void testReader() throws IOException {
		File file = new File("D:/aaa/ccc/2.text");
		if (!file.exists() || !file.isFile()) {
			throw new FileNotFoundException("");
		}
		FileReader fr = new FileReader(file);
		
		char[] cbuf = new char[64];
		int length = -1;
		while((length = fr.read(cbuf)) != -1) {
			fr.read(cbuf , 0, length);
			System.out.println(new String(cbuf, 0, length));
		}
	}
}






