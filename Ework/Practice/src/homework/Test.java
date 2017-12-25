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
			throw new NullPointerException("��ָ���쳣");
		}

		File f = new File(pathName);

		if (!f.exists() || f.isFile()) {
			throw new FileNotFoundException("�Ҳ���ָ���ļ�");
		}
		//�����ļ��б�
		File[] listFiles = f.listFiles();
		//�ļ����б�
		String[] nameList = f.list();
		//��׺�б�
		HashSet<String> suffixSet = new HashSet<String>();

		for (String string : nameList) {
			if (string.split("\\.").length > 1) 
				suffixSet.add(string.split("\\.")[1]);
		} 
		//�Ѻ�׺����ӵ�set����
		Iterator<String> setIterator = suffixSet.iterator();
		while (setIterator.hasNext()) {
			String suffix = setIterator.next().toUpperCase();
			File f2 = new File(pathName + "/" + suffix);
			f2.mkdir();
		}
		//���������ļ��б�
		for (File file : listFiles) {
			File dest1 = new File(file.getPath());
			Iterator<String> setIterator1 = suffixSet.iterator();
			File dest2 = null;
			//�ж��Ƿ����ļ��������ֺ�׺
			if (file.isFile() && file.getName().split("\\.").length > 1) {
				//���к�׺set
				while (setIterator1.hasNext()) {
					String suffix = setIterator1.next();
					String fileSuffix = null;
					//��ȡ�ļ���׺��
					if (file.getName().split("\\.").length > 1) {
						fileSuffix = file.getName().split("\\.")[1];
					}
					//�ж��ļ���׺�Ƿ���Ժ�׺Ϊ�����ļ�����ͬ
					if (null != fileSuffix) 
						if (fileSuffix.equalsIgnoreCase(suffix)) {
							dest2 = new File(pathName + "/" + suffix.toUpperCase()
							+ "/" + file.getName());
							dest1.renameTo(dest2);
						}
				}
				//�ж��Ƿ����ļ���
			} else if (file.isDirectory()){
				File directoryFile = new File(pathName + "/File");
				directoryFile.mkdirs();
				File dest3 = new File(pathName + "/File" +"/" + file.getName());
				dest1.renameTo(dest3);
			}  
			//�ж��Ƿ�Ϊ�ļ� ����û�к�׺
			if (file.getName().split("\\.").length < 2) {
				File noSuffixFile = new File(pathName + "/Other");
				noSuffixFile.mkdirs();
				File dest3 = new File(pathName + "/Other" + "/" + file.getName());
				dest1.renameTo(dest3);
			}
		}
	}
}
