package Day11;

/*
	����  �� ���� ���ӹ�ϵ 
	�̳�
	
�����еļ̳У�
	��Ϸ����������
		Ӣ������ 
		���е������ɫ������һ���࣬�������������еĹ������� Ѫ����������������~~~~~
		
		ÿһ��Ӣ�۶�����������࣬�����������Ļ���֮�ϣ���ͬ�ļ��ܣ����ܵĻ���ֵ���ͳɳ�ֵ
		
	�ü̳���ʵ�ֵ�
	
	�����֡�
		1. �����еĳ�Ա����������ͨ���̳�Ҳ����ʹ��
		
 */

class Hero {
	int blood;
	int power;
	
	public Hero() {
		System.out.println("Hero����޲ι��췽��");
	}
	
	public Hero(int blood, int power) {
		this.blood = blood;
		this.power = power;
	}
}

//extends �̳еĹؼ��֣���ʾ��ǰ��Timor�Ǽ̳���Hero������࣬Ҳ����˵Timor��Hero�������
class Timor extends Hero {
	String id;
	
	public Timor() {
		System.out.println("Timorl����޲ι��췽��~~");
	}
	
	public Timor(String id) {
		System.out.println("Timor�Ĵ���һ�������Ĺ��췽��");
		this.id = id;
	}
	
	public Timor(String id, int blood, int power) {
		//this.id ��ʹ���Լ��൱�еĳ�Ա����
		this.id = id;
		
		//blood �� power�Ǹ���Hero����ĳ�Ա����������������ڼ̳й�ϵ����ô�������Ҳ����������ʹ�ã�����
		this.blood = blood;
		this.power = power;
	}
}

public class Demo2 {
	public static void main(String[] args) {
		//�����Ǵ����������
//		Hero h = new Hero();
//		System.out.println(h);
		
		//�����������
		Timor t = new Timor();
		System.out.println(t);
	}
}




















