package Day19.entry;

import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class Demo1 {
	public static void main(String[] args) {
		
		Map<String, Integer> map = new HashMap<String, Integer>();
		
		map.put("iphone8", 7288);
		map.put("iphone8p", 7988);
		map.put("iphonex", 9288);
		
		System.out.println(map);
		Set<String> set = map.keySet();
		
		Iterator<String> it = set.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
		
		Set<Entry<String, Integer>> entrySet = map.entrySet();
		Iterator<Entry<String, Integer>> it1 = entrySet.iterator();
		while (it1.hasNext()) {
			System.out.println(it1.next());
		}
		
		Collection<Integer> values = map.values();
		Iterator<Integer> iterator = values.iterator();
		while (iterator.hasNext()) {
			System.out.println(iterator.next());
		}

	}
}
