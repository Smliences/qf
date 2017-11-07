package Day19.entry;

class Outer {
	int num = 100;
	private int s = 1000;

	private static int m = 100;

	class Inner {
		int i = 10;
		int s = 200;

		public void testInner() {
			System.out.println(num);
			System.out.println("内部类:" + s);
			System.out.println("外部类");

			System.out.println(m);
			testOuter();
			outerStatic();
		}

		public void testOuter() {
			System.out.println("Outer的普通成员方法");
		}

		public void createInner() {
			Inner inner = new Inner();
			inner.testInner();
		}

	}
	private void outerStatic() {
		System.out.println("234345345");
	}
}

public class Demo2 {
	public static void main(String[] args) {
		Outer outer = new Outer();
		
		Outer.Inner inner = new Outer().new Inner();
		inner.testInner();
		
	}
}
