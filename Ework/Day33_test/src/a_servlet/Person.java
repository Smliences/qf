package a_servlet;

public class Person {
	private int id;
	private String name
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
//	java语言规范要求equals方法具有下面的特性：
//	(1)自反性:对于任何非空引用x,x.equals(x)应该返回true;
//	(2)对称性:对于任何引用x,和y,当且仅当,y.equals(x)返回true,x.equals(y)也应该返回true;
//	(3)传递性:对于任何引用x,y,z,如果x.equals(y)返回true,y.equals(z)返回true,那么x.equals(z)也应该返回true;
//	(4)一致性:如果x,y引用的对象没有发生变化,反复调用x.equals(y)应该返回同样的结果;
//	(5)对于任意非空引用x,x.equals(null)返回false;
	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Person other = (Person) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
}