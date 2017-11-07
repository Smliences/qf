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
			throw new FileNotFoundException("�ļ��Ҳ���");
		}
		FileInputStream fis = new FileInputStream(file);
		int content = fis.read();
		System.out.println(content);
		fis.close();
	}

	public static void readTest2() throws IOException {
		//1. �ҵ��ļ�
		File file = new File("D:/aaa/ccc/2.txt");

		//�ж��ļ��Ƿ���ڣ������Ƿ���һ����ͨ�ļ�
		if (!file.exists() || !file.isFile()) {
			throw new FileNotFoundException();
		}

		//2. �����ܵ�
		FileInputStream fs = new FileInputStream(file);

		//3. ��ȡ�ļ�
		//��������read���������ԣ�read�����ȡ���ļ�����󣬷���-1����ʾ�ļ���ȡ���
		//�����������д���EOF End of File
		int content = -1;
		while ((content = fs.read()) != -1) {
			System.out.println(content);
		}

		//4. �ر���Դ
		fs.close();
	}
	//int read() ���ص�int���ֽڶ�Ӧ��ascii��
	//int read(byte[] b) ���ص����ֽڵĸ���
	public static void readTest3() throws IOException {
		File file = new File("D:/aaa/ccc/2.txt");

		if (!file.exists() || !file.isFile()) {
			throw new FileNotFoundException("�ļ��Ҳ���");
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
			throw new FileNotFoundException("�ļ�δ�ҵ�");
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






