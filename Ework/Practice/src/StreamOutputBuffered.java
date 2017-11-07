

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
		//1. 找到文件
		File srcFile = new File("C:\\《红楼梦》.txt");
		
		//判断文件是否存在，是否是一个普通文件
		if (!srcFile.exists() || !srcFile.isFile()) {
			throw new FileNotFoundException();
		}
		
		//2. 确定目标文件
		File destFile = new File("C:\\《别打脸了！！！！》.txt");
		
		//3. 创建输入字节流，和输出字节流
		FileInputStream fs = new FileInputStream(srcFile);
		FileOutputStream fos = new FileOutputStream(destFile);
		
		//4. 根据创建的输入字节流和输出字节流创建对应的缓冲流
		BufferedInputStream bis = new BufferedInputStream(fs);
		BufferedOutputStream bos = new BufferedOutputStream(fos);
		
		//5. 利用循环完成拷贝操作
		int count = -1;
		byte[] b = new byte[1024];
		while ((count = bis.read(b)) != -1) {
			bos.write(b, 0, count);
		}
		
		//6. 关闭资源，这里只要关闭缓冲流对象就OK，因为在缓冲流对象的close方法中，会关闭传入的
		//对应的字节流对象
		bos.close();
		bis.close();
		
		long end = System.currentTimeMillis();
		System.out.println("使用系统缓冲机制:" + (end - start));
	}
	
	public static void selfCopy() throws IOException {
		long start = System.currentTimeMillis();
		File srcfile = new File("C:\\《红楼梦》.txt"); 
		
		if (!srcfile.exists() || !srcfile.isFile()) {
			throw new FileNotFoundException();
		}
		
		File destFile = new File("C:\\《你比系统快一次试试！！！》.txt");
		
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
		
		System.out.println("使用自定义缓冲机制:" + (end - start));
	}
}












