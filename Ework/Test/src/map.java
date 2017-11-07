import java.util.HashMap;
import java.util.Set;

public class map {
	public static void main(String[] args) {
		HashMap<String, String> hashMap = new HashMap<String,String>();
		hashMap.put("12", "123");
		hashMap.put("12", "1233");
		Set<String> keySet = hashMap.keySet();
		for (String string : keySet) {
			System.out.println(string);
			System.out.println(hashMap.get(string));
		}
	}
}
