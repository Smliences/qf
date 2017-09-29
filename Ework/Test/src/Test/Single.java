package Test;

class Single {
	private int id;
	private static Single s;
	private Single (int id) {
		this.id = id;
	}
	public static Single getInstance(int id) {
		if (null == s) {
			s = new Single(id);
		}
		return s;
	}
	public static void main(String[] args) {
		Single s = Single.getInstance(1);
		System.out.println(s);
		Single s1 = Single.getInstance(2);
		System.out.println(s1);
	}
}
