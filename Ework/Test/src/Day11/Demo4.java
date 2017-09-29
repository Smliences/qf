package Day11;

class Single1 {
	private int id;
	
	private static Single1 s = null;
	
	private Single1(int id) {
		this.id = id;
	}
	
	public static Single1 getInstance(int id) {
		if (null == s) {
			s = new Single1(id);
		}
		return s;
	}
	
}