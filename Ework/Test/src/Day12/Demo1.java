package Day12;
	/*2.  ��������ϰ��
	��Java����һ��Ա������ͬ�Ĳ��ŵ�Ա������ÿ�찴ʱ�ϰఴʱ�°࣬����Լ�
	�Ĺ�������

	���Զ���һ��Ա����
	��ͬ���ŵ�Ա�����Կ�����ͬ����*/
public class Demo1 {

}

abstract class employee {
	public String departmentName;
	public employee(String departmentName) {
		this.departmentName = departmentName;
	}		 
	abstract public void work(); 
}

class department extends employee{
	public department(String departmentName) {
		super(departmentName);
	}
	@Override
	public void work() {
		System.out.println("�ϰ࣬�°� ����");
	}
	
}