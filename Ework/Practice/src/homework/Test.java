package homework;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

public class Test {
	public static void main(String[] args) throws IOException {
		pigeonhole("C:\\Users\\Administrator\\Desktop\\test");
	}
	public static void pigeonhole(String pathName) throws IOException {
		if (null == pathName) {
			throw new NullPointerException("空指针异常");
		}

		File f = new File(pathName);

		if (!f.exists() || f.isFile()) {
			throw new FileNotFoundException("找不到指定文件");
		}
		//绝对文件列表
		File[] listFiles = f.listFiles();
		//文件名列表
		String[] nameList = f.list();
		//后缀列表
		HashSet<String> suffixSet = new HashSet<String>();

		for (String string : nameList) {
			if (string.split("\\.").length > 1) 
				suffixSet.add(string.split("\\.")[1]);
		} 
		//把后缀名添加到set里面
		Iterator<String> setIterator = suffixSet.iterator();
		while (setIterator.hasNext()) {
			String suffix = setIterator.next().toUpperCase();
			File f2 = new File(pathName + "/" + suffix);
			f2.mkdir();
		}
		//遍历绝对文件列表
		for (File file : listFiles) {
			File dest1 = new File(file.getPath());
			Iterator<String> setIterator1 = suffixSet.iterator();
			File dest2 = null;
			//判断是否是文件，并且又后缀
			if (file.isFile() && file.getName().split("\\.").length > 1) {
				//编列后缀set
				while (setIterator1.hasNext()) {
					String suffix = setIterator1.next();
					String fileSuffix = null;
					//获取文件后缀名
					if (file.getName().split("\\.").length > 1) {
						fileSuffix = file.getName().split("\\.")[1];
					}
					//判断文件后缀是否和以后缀为名的文件夹相同
					if (null != fileSuffix) 
						if (fileSuffix.equalsIgnoreCase(suffix)) {
							dest2 = new File(pathName + "/" + suffix.toUpperCase()
							+ "/" + file.getName());
							dest1.renameTo(dest2);
						}
				}
				//判断是否是文件夹
			} else if (file.isDirectory()){
				File directoryFile = new File(pathName + "/File");
				directoryFile.mkdirs();
				File dest3 = new File(pathName + "/File" +"/" + file.getName());
				dest1.renameTo(dest3);
			}  
			//判断是否为文件 并且没有后缀
			if (file.getName().split("\\.").length < 2) {
				File noSuffixFile = new File(pathName + "/Other");
				noSuffixFile.mkdirs();
				File dest3 = new File(pathName + "/Other" + "/" + file.getName());
				dest1.renameTo(dest3);
			}
		}
	}
}
