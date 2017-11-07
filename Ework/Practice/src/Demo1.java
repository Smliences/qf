import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map.Entry;
import java.util.Set;

public class Demo1 {
	public static void main(String[] args) throws IOException, InterruptedException  {
		Manager m = new Manager();
		m.start("D:/test/ƽ��֮·.lrc");
		//				m.getContent("D:/test/ƽ��֮·.lrc");
		//				m.subContent();
		//				m.show();
	}
}

class Manager {
	//�����洢�ж�ȡ���ַ���
	ArrayList<String> arrList = new ArrayList<String>();
	//������ʱ��͸�����
	HashMap<String, String> map = new HashMap<String, String>();
	//�����洢ʱ�䴮
	ArrayList<Long> keyList = new ArrayList<Long>(); 

	public void start(String pathName) throws IOException, InterruptedException {
		getContent(pathName);
		subContent();
		Set<Entry<String, String>> entrySet = map.entrySet();
		Iterator<Entry<String, String>> iterator = entrySet.iterator();
		long start = System.currentTimeMillis();
		long end = start;

		while (iterator.hasNext()) {
			Entry<String, String> next = iterator.next();
			String key = next.getKey();
			//�ж�����ַ��ǲ�������
			if (Character.isDigit(key.charAt(0)))
				keyList.add(Long.parseLong(next.getKey()));
		}
		//����
		keyList.sort(new myComparator());

		for (long l : keyList) {
			//���end - start �����ڱ�����ʱ�� ��ѭ��
			while(l != (end - start)) {
				//				sleep(1); 
				end = System.currentTimeMillis();
			}
			System.out.println(map.get(String.valueOf(l)));
		}
	}
	//��ȡ����
	public void getContent(String pathName) throws IOException {
		File srcFile = new File(pathName);
		if (!srcFile.exists() || !srcFile.isFile()) {
			throw new FileNotFoundException("�ļ��Ҳ���");
		}

		FileReader fr = new FileReader(srcFile);
		BufferedReader br = new BufferedReader(fr);

		String str = null;

		while ((str = br.readLine()) != null) {
			arrList.add(str);
		}

		br.close();
	}
	//��ȡ�ַ���������map��
	public void subContent() {
		for (String str : arrList) {
			if (judgmentString(str)) {
				map.put(subPrefixString(str),subSuffixString(str));
			} else {
				String[] arr = str.split("]");
				if (arr.length > 1)
					putTimeContent(arr);
			}
		}
	}
	//��ȡͷ
	public String subPrefixString(String str) {
		return str.substring(1, str.indexOf(":"));
	}
	//��ȡβ
	public String subSuffixString(String str) {
		return str.substring(str.indexOf(":") + 1, str.trim().length() - 1);
	}
	//�ж��Ƿ�Ϊ
	public boolean judgmentString(String str) {
		//ȥ�ո�
		if (null != str.trim() && str.trim().length() != 0) {
			//�жϽ�ȡ�ĵ�һ���������ŵ��ַ��Ƿ�Ϊ��ĸ
			char split = str.split(":")[0].charAt(1);
			if (('a' <= split && split <= 'z') || 'A' <= split && split <= 'z') {
				return true;
			} else {
				return false;
			}
		} else {
			return false;
		}
	}
	//ʱ�����
	public void putTimeContent(String[] arr) {
		String min = arr[0].substring(arr[0].indexOf('[') + 1, arr[0].indexOf(':')); // 00
		int minInt = Integer.parseInt(min); //����String�ַ������int����

		String sec = arr[0].substring(arr[0].indexOf(':') + 1, arr[0].indexOf('.')); //00
		int secInt = Integer.parseInt(sec);

		String pointSec = arr[0].substring(arr[0].indexOf('.') + 1);
		int pointSecInt = Integer.parseInt(pointSec);

		int time = minInt * 60 * 1000 + secInt * 1000 + pointSecInt * 10
				+ (minInt * 60 + secInt) * 1000 + pointSecInt * 10;

		String timeValue = String.valueOf(time);

		map.put(timeValue, arr[1]);
	}
}
//�Ƚ���
class myComparator implements Comparator<Long> {

	@Override
	public int compare(Long o1, Long o2) {
		return (int) (o1 - o2);
	}
}
