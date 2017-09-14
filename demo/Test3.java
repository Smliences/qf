class Test3 {
	public static void main(String[] args) {
		//整型的变量定义
		byte byteNumber = 10;
		short shortNumber = 20;
		int intNumber = 30;
		long longNumber = 40;

		System.out.println("byte:" + byteNumber);
		System.out.println("short:" + shortNumber);
		System.out.println("int:" + intNumber);
		System.out.println("long:" + longNumber);
		
		//浮点型变量的定义
		float floatNumber = 3.14f;
		double doubleNumber = 3.15;
			
		System.out.println("float:" + floatNumber);
		System.out.println("double:" + doubleNumber);
		
		//布尔类型的变量定义
		boolean testTrue = true;
		boolean testFalse = false;
		
		System.out.println("boolean:" + testTrue);
		System.out.println("boolean:" + testFalse);
		
		//char类型的变量定义
		char item1 = 'a';
		char item2 = '\101'; //转义的八进制编码
		char item3 = 97; //对应ASCII码值
		char item4 = '\0'; //ASCII码表中的第一个字符，nul \0来表示
		
		System.out.println("char:" + item1);
		System.out.println("char:" + item2);
		System.out.println("char:" + item3);
		System.out.println("char:" + item4);
	}	
}