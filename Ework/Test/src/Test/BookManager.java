package Test;

import java.util.Scanner;

/*
 * 图书的书名，作者，价格，简介
 */
class Book {
	//成员变量
	private String name;	private String author;
	private int price;
	private String synopsis;
	private int store;
	//以下是set get方法

	public String getName() {
		return name;
	}
	public int getStore() {
		return store;
	}
	public void setStore(int store) {
		this.store = store;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getAuthor() {
		return author;
	}
	public void setAuthor(String author) {
		this.author = author;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public String getSynopsis() {
		return synopsis;
	}
	public void setSynopsis(String synopsis) {
		this.synopsis = synopsis;
	}
	//无参构造函数
	public Book() {
	}
	//有参构造函数
	public Book(String name, String author, int price, String synopsis, int store) {
		super();
		this.name = name;
		this.author = author;
		this.price = price;
		this.synopsis = synopsis;
		this.store = store;
	}
	@Override
	public String toString() {
		return "Book [name=" + name + ", author=" + author + ", price=" + price + ", synopsis=" + synopsis + ", store="
				+ store + "]";
	}

}
/*
 * 图书的入库，出库，修改书的信息，查询书的信息，按照书的库存排序
 */
class BManager {
	//统计数组中图书的数量
	private static int count = 0;
	//创建一个数组，用来存储图书
	Book[] books = new Book[20];
	/**
	 * 图书的添加操作
	 * @param book 要添加的图书对象
	 */
	public void addBook(Book book) {
		if (null == book) {
			System.out.println("参数输入不合法");
		}
		//定义一个标记，来判断是否是同一本书
		int flag = 0;
		for (int i = 0;i < count; i++) {
			String n = books[i].getName();
			//判断是否同一本书，要判断所有属性是否一样 这里只判断了书名
			if (n.equals(book.getName())) {
				//如果是同一本书，则库存加上添加的图书库存
				books[i].setStore(books[i].getStore() + book.getStore());
				flag = 1;
			}
		}
		//如果不是同一本书，就添加
		if (flag == 0) {
			books[count] = book;
			count++;
		}
		//数组的大小扩展
		if (count >= books.length) {
			int c = (int) (books.length * 1.5);
			Book[] temp = new Book[c];
			for (int i = 0; i <=count; i++ ) {
				temp[i] = books[i];  
			}
			books = temp;
		}
	}

	/**
	 * 根据书名，找出该书在数组中的下标，该方法只能给类内使用
	 * @param name 要查询的书名
	 * @return int 类型，返回-1表示没有找到，返回》=0的值，表示该书在数组中的下标
	 */
	private int findByBookName(String name) {
		//参数合法性判断
		if (null == name) {
			System.out.println("参数输入不合法");
			return -1;
		}
		//用于保存找到的图书所在的下标
		int index = -1;

		for (int i = 0; i < count; i++) {
			String n = books[i].getName();
			if (name.equals(n)) {
				index = i;
			}
		}
		return index;
	}
	/**
	 * 根据书名来删除一本图书
	 * @param name 要删除的书名
	 */
	public void delBook(String name) {
		if (null == name) {
			System.out.println("参数输入有误");
		}
		//这个index要做一个判断，如果是-1表示没有找到，这里无法处理，如果》=0则删除这个图书
		int index = findByBookName(name);

		if (index < 0) {
			System.out.println("查无此人");
		} else {
			if (books[index].getStore() == 1) {
				//删除操作
				for (int i = index; i < count - 1; i++) {
					books[i] = books[i + 1];
				}
				//把原本最后一个位置赋值为null
				books[count-1] = null;
				//数组中图书个数减一
				count--;
			} else {
				books[index].setStore(books[index].getStore() - 1);
			}
		}
	}

	/**
	 * 根据书名名来打印图书的信息
	 * @param name
	 */
	public void showBooktInfoByBookName(String name) {
		int index = findByBookName(name);

		if (index >= 0) {
			System.out.println(books[index]);
		} else {
			System.out.println("查无此人");
		}
	}
	/**
	 * 打印所有图书信息
	 */
	public void show() {
		for (int i = 0; i < count; i++) {
			System.out.println(books[i]);
		}
	}

	/**
	 * 根据书名来修改图书信息
	 * @param name
	 */
	public void ModifyBookInfoByBookName(String name) {
		int index = findByBookName(name);

		if (index >= 0) {
			//修改操作
			//while  switch - case
			//用来控制循环是否结束

			int flag = 0;
			//用来存储用户的所选择的操作数字
			int choose = -1;
			Scanner sc = new Scanner(System.in); 
			Book temp = books[index]; 

			while (true) {
				System.out.println("要修改" + temp.getName() + "的信息");
				System.out.println("***Name:" + temp.getName());
				System.out.println("***Price:" + temp.getPrice());
				System.out.println("***Author" + temp.getAuthor());
				System.out.println("***Synopsis:" + temp.getSynopsis());
				System.out.println("***Store: " + temp.getStore());

				System.out.println("1. 修改书名");
				System.out.println("2. 修改图书价格");
				System.out.println("3. 修改图书作者");
				System.out.println("4. 修改图书库存");
				System.out.println("5. 修改图书简介");
				System.out.println("6. 退出");

				choose = sc.nextInt();
				sc.nextLine();
				switch (choose) {
				case 1:
					System.out.println("请输入书名:");

					String name1 = sc.nextLine();
					temp.setName(name1);
					break;
				case 2:
					System.out.println("请输入图书的价格:");
					int price = sc.nextInt();
					temp.setPrice(price);
					break;
				case 3:
					System.out.println("请输入图书的作者:");
					String author = sc.nextLine();
					temp.setAuthor(author);
					break;
				case 4:
					System.out.println("请输入图书的库存");
					int store = sc.nextInt();
					temp.setStore(store);
				case 5:
					System.out.println("请输入图书的简介:");
					String synopsis = sc.nextLine();
					temp.setSynopsis(synopsis);
					break;

				case 6:
					System.out.println("修改完成，退出");
					flag = 1;
					break;

				default:
					System.out.println("没有这个选项");
					break;
				} //switch - case

				books[index] = temp;
				if (flag == 1) {
					break;
				}

			} //while true

		} else {
			System.out.println("查无此书，无法修改");
		}
	}
	/**
	 * 根据库存大小排序
	 */
	public void bookByStoreSort() {
		for (int i = 0; i < count - 1; i++) {
			for (int j = 0; j < count - i - 1; j++) {
				if (books[j].getStore() > books[j + 1].getStore()) {
					Book temp = books[j];
					books[j] = books[j + 1];
					books[j + 1] = temp;
				}
			}
		}
		show();
	}
}
public class BookManager {
	public static void main(String[] args) {
		//用来控制循环是否结束
		int flag = 0;
		//用来存储用户的选择
		int choose = -1;
		Scanner sc = new Scanner(System.in); 
		BManager m = new BManager();
		while(true) {
			System.out.println("欢迎来到图书管理系统");
			System.out.println("1. 添加新图书 ");
			System.out.println("2. 删除图书");
			System.out.println("3. 修改图书信息");
			System.out.println("4. 图书按库存排序");
			System.out.println("5. 显示所有图书信息");
			System.out.println("6. 退出");

			choose = sc.nextInt();
			sc.nextLine();
			switch (choose) {
			case 1:
				System.out.println("请输入你要添加的图书名");
				String name = sc.nextLine();
				System.out.println("请输入你要添加的图书价格");
				int price = sc.nextInt();
				System.out.println("请输入你要添加的图书作者");
				sc.nextLine();
				String author = sc.nextLine();
				System.out.println("请输入你要添加的图书简介");
				String synopsis = sc.nextLine();
				System.out.println("请输入你要添加的图书库存");
				int store = sc.nextInt();
				Book book = new Book(name, author, price, synopsis, store);
				m.addBook(book);
				break;
			case 2:
				System.out.println("请输入你要删除的书名");
				String name1 = sc.nextLine();
				m.delBook(name1);
				break;
			case 3:
				System.out.println("请输入你要修改的图书书名");
				String name2 = sc.nextLine();
				m.ModifyBookInfoByBookName(name2);
				break;
			case 4:
				m.bookByStoreSort();
				break;
			case 5:
				m.show();
				break;
			case 6:
				flag = -1;
				break;

			default:
				System.out.println("没有那个选项");
				break;
			}
			if (flag == -1) 
				break;
		}
	}
}