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
//	java���Թ淶Ҫ��equals����������������ԣ�
//	(1)�Է���:�����κηǿ�����x,x.equals(x)Ӧ�÷���true;
//	(2)�Գ���:�����κ�����x,��y,���ҽ���,y.equals(x)����true,x.equals(y)ҲӦ�÷���true;
//	(3)������:�����κ�����x,y,z,���x.equals(y)����true,y.equals(z)����true,��ôx.equals(z)ҲӦ�÷���true;
//	(4)һ����:���x,y���õĶ���û�з����仯,��������x.equals(y)Ӧ�÷���ͬ���Ľ��;
//	(5)��������ǿ�����x,x.equals(null)����false;
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