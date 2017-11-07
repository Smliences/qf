package Test;

public class Trim {
	public static void main(String[] args) {
//		Student2 s = new Student2("1", 1); 
//		System.out.println(s);
		String str = "asdf!adfeeeee";
		String str1 = new String();
		String str2 = new String("123");
		byte[] bytes = "123".getBytes();
		String str3 = new String("byte");
		String str4 = new String(bytes, 0, 2);
		String[] split = str.split("a");
		System.out.println(split[0]);
		System.out.println(split[1]);
		System.out.println(str4);
	}
}

class Student2 {
	private String name;
	private int id;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public Student2(String name, int id) {
		super();
		this.name = name;
		this.id = id;
	}
	@Override
	public String toString() {
		return "Student2 [name=" + name + ", id=" + id + "]";
	}
	
	
}