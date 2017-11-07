package Test;

import java.util.Scanner;

/*
 * ͼ������������ߣ��۸񣬼��
 */
class Book {
	//��Ա����
	private String name;	private String author;
	private int price;
	private String synopsis;
	private int store;
	//������set get����

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
	//�޲ι��캯��
	public Book() {
	}
	//�вι��캯��
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
 * ͼ�����⣬���⣬�޸������Ϣ����ѯ�����Ϣ��������Ŀ������
 */
class BManager {
	//ͳ��������ͼ�������
	private static int count = 0;
	//����һ�����飬�����洢ͼ��
	Book[] books = new Book[20];
	/**
	 * ͼ�����Ӳ���
	 * @param book Ҫ��ӵ�ͼ�����
	 */
	public void addBook(Book book) {
		if (null == book) {
			System.out.println("�������벻�Ϸ�");
		}
		//����һ����ǣ����ж��Ƿ���ͬһ����
		int flag = 0;
		for (int i = 0;i < count; i++) {
			String n = books[i].getName();
			//�ж��Ƿ�ͬһ���飬Ҫ�ж����������Ƿ�һ�� ����ֻ�ж�������
			if (n.equals(book.getName())) {
				//�����ͬһ���飬���������ӵ�ͼ����
				books[i].setStore(books[i].getStore() + book.getStore());
				flag = 1;
			}
		}
		//�������ͬһ���飬�����
		if (flag == 0) {
			books[count] = book;
			count++;
		}
		//����Ĵ�С��չ
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
	 * �����������ҳ������������е��±꣬�÷���ֻ�ܸ�����ʹ��
	 * @param name Ҫ��ѯ������
	 * @return int ���ͣ�����-1��ʾû���ҵ������ء�=0��ֵ����ʾ�����������е��±�
	 */
	private int findByBookName(String name) {
		//�����Ϸ����ж�
		if (null == name) {
			System.out.println("�������벻�Ϸ�");
			return -1;
		}
		//���ڱ����ҵ���ͼ�����ڵ��±�
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
	 * ����������ɾ��һ��ͼ��
	 * @param name Ҫɾ��������
	 */
	public void delBook(String name) {
		if (null == name) {
			System.out.println("������������");
		}
		//���indexҪ��һ���жϣ������-1��ʾû���ҵ��������޷����������=0��ɾ�����ͼ��
		int index = findByBookName(name);

		if (index < 0) {
			System.out.println("���޴���");
		} else {
			if (books[index].getStore() == 1) {
				//ɾ������
				for (int i = index; i < count - 1; i++) {
					books[i] = books[i + 1];
				}
				//��ԭ�����һ��λ�ø�ֵΪnull
				books[count-1] = null;
				//������ͼ�������һ
				count--;
			} else {
				books[index].setStore(books[index].getStore() - 1);
			}
		}
	}

	/**
	 * ��������������ӡͼ�����Ϣ
	 * @param name
	 */
	public void showBooktInfoByBookName(String name) {
		int index = findByBookName(name);

		if (index >= 0) {
			System.out.println(books[index]);
		} else {
			System.out.println("���޴���");
		}
	}
	/**
	 * ��ӡ����ͼ����Ϣ
	 */
	public void show() {
		for (int i = 0; i < count; i++) {
			System.out.println(books[i]);
		}
	}

	/**
	 * �����������޸�ͼ����Ϣ
	 * @param name
	 */
	public void ModifyBookInfoByBookName(String name) {
		int index = findByBookName(name);

		if (index >= 0) {
			//�޸Ĳ���
			//while  switch - case
			//��������ѭ���Ƿ����

			int flag = 0;
			//�����洢�û�����ѡ��Ĳ�������
			int choose = -1;
			Scanner sc = new Scanner(System.in); 
			Book temp = books[index]; 

			while (true) {
				System.out.println("Ҫ�޸�" + temp.getName() + "����Ϣ");
				System.out.println("***Name:" + temp.getName());
				System.out.println("***Price:" + temp.getPrice());
				System.out.println("***Author" + temp.getAuthor());
				System.out.println("***Synopsis:" + temp.getSynopsis());
				System.out.println("***Store: " + temp.getStore());

				System.out.println("1. �޸�����");
				System.out.println("2. �޸�ͼ��۸�");
				System.out.println("3. �޸�ͼ������");
				System.out.println("4. �޸�ͼ����");
				System.out.println("5. �޸�ͼ����");
				System.out.println("6. �˳�");

				choose = sc.nextInt();
				sc.nextLine();
				switch (choose) {
				case 1:
					System.out.println("����������:");

					String name1 = sc.nextLine();
					temp.setName(name1);
					break;
				case 2:
					System.out.println("������ͼ��ļ۸�:");
					int price = sc.nextInt();
					temp.setPrice(price);
					break;
				case 3:
					System.out.println("������ͼ�������:");
					String author = sc.nextLine();
					temp.setAuthor(author);
					break;
				case 4:
					System.out.println("������ͼ��Ŀ��");
					int store = sc.nextInt();
					temp.setStore(store);
				case 5:
					System.out.println("������ͼ��ļ��:");
					String synopsis = sc.nextLine();
					temp.setSynopsis(synopsis);
					break;

				case 6:
					System.out.println("�޸���ɣ��˳�");
					flag = 1;
					break;

				default:
					System.out.println("û�����ѡ��");
					break;
				} //switch - case

				books[index] = temp;
				if (flag == 1) {
					break;
				}

			} //while true

		} else {
			System.out.println("���޴��飬�޷��޸�");
		}
	}
	/**
	 * ���ݿ���С����
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
		//��������ѭ���Ƿ����
		int flag = 0;
		//�����洢�û���ѡ��
		int choose = -1;
		Scanner sc = new Scanner(System.in); 
		BManager m = new BManager();
		while(true) {
			System.out.println("��ӭ����ͼ�����ϵͳ");
			System.out.println("1. �����ͼ�� ");
			System.out.println("2. ɾ��ͼ��");
			System.out.println("3. �޸�ͼ����Ϣ");
			System.out.println("4. ͼ�鰴�������");
			System.out.println("5. ��ʾ����ͼ����Ϣ");
			System.out.println("6. �˳�");

			choose = sc.nextInt();
			sc.nextLine();
			switch (choose) {
			case 1:
				System.out.println("��������Ҫ��ӵ�ͼ����");
				String name = sc.nextLine();
				System.out.println("��������Ҫ��ӵ�ͼ��۸�");
				int price = sc.nextInt();
				System.out.println("��������Ҫ��ӵ�ͼ������");
				sc.nextLine();
				String author = sc.nextLine();
				System.out.println("��������Ҫ��ӵ�ͼ����");
				String synopsis = sc.nextLine();
				System.out.println("��������Ҫ��ӵ�ͼ����");
				int store = sc.nextInt();
				Book book = new Book(name, author, price, synopsis, store);
				m.addBook(book);
				break;
			case 2:
				System.out.println("��������Ҫɾ��������");
				String name1 = sc.nextLine();
				m.delBook(name1);
				break;
			case 3:
				System.out.println("��������Ҫ�޸ĵ�ͼ������");
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
				System.out.println("û���Ǹ�ѡ��");
				break;
			}
			if (flag == -1) 
				break;
		}
	}
}