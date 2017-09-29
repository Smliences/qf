package Day12;
	/*2.  抽象类练习：
	用Java描述一个员工，不同的部门的员工必须每天按时上班按时下班，完成自己
	的工作任务

	可以定义一个员工类
	不同部门的员工可以看做不同的类*/
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
		System.out.println("上班，下班 工作");
	}
	
}