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
			System.out.println("请输入用户名：");
			String userName = sc.next();
			
			System.out.println("请输入密码：");
			String password = sc.next();

			Account account = new Account(userName, password);
			if (set.add(account)) {
				System.out.println("注册成功");
			} else {
				System.out.println("用户名已经存在，注册失败");
			}
		}
	}
}
