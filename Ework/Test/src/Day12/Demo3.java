package Day12;
/*�ýӿ�����USB�ӿڣ�Ҫ������Ҫ�õ�USB�ӿڵ��豸ʵ������USB�ӿڵķ���
Connection() ��������*/
public class Demo3 {
	
}

interface Usb {
	public void connection();  
}

class Computer implements Usb{

	@Override
	public void connection() {
		System.out.println("USB����Ѿ�����");
	}
}