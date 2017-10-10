package practic;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Iterator;

public class demo11 {
	public static void main(String[] args) {
		Collection c = new ArrayList();

		c.add("1");
		c.add("2");
		c.add("3");
		
		for (Object object : c) {
			System.out.println(object);
		}
		
		Iterator it = c.iterator();
		while (it.hasNext()) {
			System.out.println(it.next());
		}
	}
}
