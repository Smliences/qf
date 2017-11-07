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
		m.start("D:/test/平凡之路.lrc");
		//				m.getContent("D:/test/平凡之路.lrc");
		//				m.subContent();
		//				m.show();
	}
}

class Manager {
	//用来存储切读取的字符串
	ArrayList<String> arrList = new ArrayList<String>();
	//用来将时间和歌词配对
	HashMap<String, String> map = new HashMap<String, String>();
	//用来存储时间串
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
			//判断这个字符是不是数字
			if (Character.isDigit(key.charAt(0)))
				keyList.add(Long.parseLong(next.getKey()));
		}
		//排序
		keyList.sort(new myComparator());

		for (long l : keyList) {
			//如果end - start 不等于遍历的时间 就循环
			while(l != (end - start)) {
				//				sleep(1); 
				end = System.currentTimeMillis();
			}
			System.out.println(map.get(String.valueOf(l)));
		}
	}
	//读取函数
	public void getContent(String pathName) throws IOException {
		File srcFile = new File(pathName);
		if (!srcFile.exists() || !srcFile.isFile()) {
			throw new FileNotFoundException("文件找不到");
		}

		FileReader fr = new FileReader(srcFile);
		BufferedReader br = new BufferedReader(fr);

		String str = null;

		while ((str = br.readLine()) != null) {
			arrList.add(str);
		}

		br.close();
	}
	//截取字符串，放入map中
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
	//截取头
	public String subPrefixString(String str) {
		return str.substring(1, str.indexOf(":"));
	}
	//截取尾
	public String subSuffixString(String str) {
		return str.substring(str.indexOf(":") + 1, str.trim().length() - 1);
	}
	//判断是否为
	public boolean judgmentString(String str) {
		//去空格
		if (null != str.trim() && str.trim().length() != 0) {
			//判断截取的第一个不是括号的字符是否为字母
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
	//时间计算
	public void putTimeContent(String[] arr) {
		String min = arr[0].substring(arr[0].indexOf('[') + 1, arr[0].indexOf(':')); // 00
		int minInt = Integer.parseInt(min); //解析String字符串变成int数据

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
//比较器
class myComparator implements Comparator<Long> {

	@Override
	public int compare(Long o1, Long o2) {
		return (int) (o1 - o2);
	}
}
