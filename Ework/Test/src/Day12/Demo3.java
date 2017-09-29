package Day12;
/*用接口描述USB接口，要求所有要用到USB接口的设备实现连接USB接口的方法
Connection() 内容随意*/
public class Demo3 {
	
}

interface Usb {
	public void connection();  
}

class Computer implements Usb{

	@Override
	public void connection() {
		System.out.println("USB借口已经链接");
	}
}