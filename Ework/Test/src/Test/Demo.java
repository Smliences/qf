package Test;

import java.util.HashSet;
import java.util.Scanner;

class Account {
	String userName;
	String password;
	
	public Account(String name, String password) {
		this.userName = userName;
		this.password = password;
	}

	@Override
	public String toString() {
		return "Account [userName=" + userName + ", password=" + password + "]";
	}
	
	public boolean equals(Object obj) {
		Account a = (Account) obj;
		return this.userName.equals(a.userName);
	}
	
	public int hashCode() {
		return this.userName.hashCode();
	}
}

public class Demo {
	public static void main(String[] args) {
		HashSet set = new HashSet();
		
		Scanner sc = new Scanner(System.in);
		
		while (true) {
			System.out.println("�������û�����");
			String userName = sc.next();
			
			System.out.println("���������룺");
			String password = sc.next();

			Account account = new Account(userName, password);
			if (set.add(account)) {
				System.out.println("ע��ɹ�");
			} else {
				System.out.println("�û����Ѿ����ڣ�ע��ʧ��");
			}
		}
	}
}
