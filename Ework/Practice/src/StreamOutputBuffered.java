

import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class StreamOutputBuffered {
	public static void main(String[] args) throws IOException {
		bufferedCopy();
		selfCopy();
	}
	
	public static void bufferedCopy() throws IOException {
		long start = System.currentTimeMillis();
		//1. �ҵ��ļ�
		File srcFile = new File("C:\\����¥�Ρ�.txt");
		
		//�ж��ļ��Ƿ���ڣ��Ƿ���һ����ͨ�ļ�
		if (!srcFile.exists() || !srcFile.isFile()) {
			throw new FileNotFoundException();
		}
		
		//2. ȷ��Ŀ���ļ�
		File destFile = new File("C:\\��������ˣ���������.txt");
		
		//3. ���������ֽ�����������ֽ���
		FileInputStream fs = new FileInputStream(srcFile);
		FileOutputStream fos = new FileOutputStream(destFile);
		
		//4. ���ݴ����������ֽ���������ֽ���������Ӧ�Ļ�����
		BufferedInputStream bis = new BufferedInputStream(fs);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		
		//5. ����ѭ����ɿ�������
		int count = -1;
		byte[] b = new byte[1024];
		while ((count = bis.read(b)) != -1) {
			bos.write(b, 0, count);
		}
		
		//6. �ر���Դ������ֻҪ�رջ����������OK����Ϊ�ڻ����������close�����У���رմ����
		//��Ӧ���ֽ�������
		bos.close();
		bis.close();
		
		long end = System.currentTimeMillis();
		System.out.println("ʹ��ϵͳ�������:" + (end - start));
	}
	
	public static void selfCopy() throws IOException {
		long start = System.currentTimeMillis();
		File srcfile = new File("C:\\����¥�Ρ�.txt"); 
		
		if (!srcfile.exists() || !srcfile.isFile()) {
			throw new FileNotFoundException();
		}
		
		File destFile = new File("C:\\�����ϵͳ��һ�����ԣ�������.txt");
		
		FileInputStream fs = new FileInputStream(srcfile);
		FileOutputStream fos = new FileOutputStream(destFile);
		
		int count = -1;
		byte[] b = new byte[1024];
		
		while ((count = fs.read(b)) != -1) {
			fos.write(b, 0, count);
		}
		
		fos.close();
		fs.close();
		long end = System.currentTimeMillis();
		Integer i = 1;
		
		System.out.println("ʹ���Զ��建�����:" + (end - start));
	}
}












