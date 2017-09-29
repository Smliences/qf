package Day08;

public class Test1 {
	public static void main(String[] args) {
		Student xiaoming = new Student("xiaoming",11);
		Dog dog = new Dog("旺财",4);
		Mouse mouse = new Mouse("杰瑞",11);
		Movie movie = new Movie("霍元甲",2016);
		Book book = new Book("新华字典",701);
		Pen pen = new Pen("黑色",15);
		Song song = new Song("吻别",1993);
		Game game = new Game("仙剑奇侠传","RPG");
		Rubber rubber = new Rubber("black",4,4);
		Keyboard keyboard = new Keyboard("machinery",86);
		Shoes shoes = new Shoes("鸿星尔克",43);
		Phone phone = new Phone("mz",2888);
	}
}

class Student {
	private String name;
	private int age;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	public Student() {
		
	}
	public Student(String name, int age) {
		this.name = name;
		this.age = age;
	}
}

class Dog {
	private String name;
	private int age;
	public Dog() {
		
	}
	public Dog(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
	
}

class Mouse {
	private String name;
	private int age;
	public Mouse() {
		
	}
	public Mouse(String name, int age) {
		this.name = name;
		this.age = age;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getAge() {
		return age;
	}
	public void setAge(int age) {
		this.age = age;
	}
}

class Movie {
	private String name;
	private int time;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}

	public Movie(String name, int time) {
		this.name = name;
		this.time = time;
	}
	public Movie() {
		
	}
}

class Book {
	private String bookName;
	private int pageNumber;
	public String getBookName() {
		return bookName;
	}
	public void setBookName(String bookName) {
		this.bookName = bookName;
	}
	public int getPageNumber() {
		return pageNumber;
	}
	public void setPageNumber(int pageNumber) {
		this.pageNumber = pageNumber;
	}
	public Book() {
		
	}
	public Book(String bookName, int pageNumber) {
		this.bookName = bookName;
		this.pageNumber = pageNumber;
	}
}

class Pen {
	private String color;
	private int price;
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Pen() {
		
	}
	public Pen(String color, int price) {
		this.color = color;
		this.price = price;
	}
}

class Song {
	private String singer;
	private int time;
	public String getSinger() {
		return singer;
	}
	public void setSinger(String singer) {
		this.singer = singer;
	}
	public int getTime() {
		return time;
	}
	public void setTime(int time) {
		this.time = time;
	}
	public Song() {
		
	}
	public Song(String singer, int time) {
		this.singer = singer;
		this.time = time;
	}
}

class Game {
	private String name;
	private String type;
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public Game() {
		
	}
	public Game(String name, String type) {
		this.name = name;
		this.type = type;
	}
	
}
//橡皮
class Rubber {
	private String color;
	private int width;
	private int length;
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public String getColor() {
		return color;
	}
	public void setColor(String color) {
		this.color = color;
	}
	public Rubber() {
		
	}
	public Rubber(String color, int width, int length) {
		super();
		this.color = color;
		this.width = width;
		this.length = length;
	}

}
class Keyboard {
	//键盘类型 机械还是薄膜
	private String type;
	//键盘按键数量
	private int count;
	public String getType() {
		return type;
	}
	public void setType(String type) {
		this.type = type;
	}
	public int getCount() {
		return count;
	}
	public void setCount(int count) {
		this.count = count;
	}
	public Keyboard() {
		
	}
	public Keyboard(String type, int count) {
		this.type = type;
		this.count = count;
	}
}

class Shoes {
	//品牌
	private String brand;
	private int size;
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getSize() {
		return size;
	}
	public void setSize(int size) {
		this.size = size;
	}
	public Shoes() {
		
	}
	public Shoes(String brand, int size) {
		this.brand = brand;
		this.size = size;
	}
}

class Phone {
	private String brand;
	private int price;
	public String getBrand() {
		return brand;
	}
	public void setBrand(String brand) {
		this.brand = brand;
	}
	public int getPrice() {
		return price;
	}
	public void setPrice(int price) {
		this.price = price;
	}
	public Phone() {
		
	}
	public Phone(String brand, int price) {
		this.brand = brand;
		this.price = price;
	}
	
}
