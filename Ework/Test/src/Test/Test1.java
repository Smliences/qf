package Test;

class Animal {
	public void eat(Animal a) {
		System.out.println(a.getClass() + "³Ô¶«Î÷");
	}
	
	public Animal getAinmal(Animal a) {
		return a;
	}
}

class Panda extends Animal {
	
}

class Bear extends Animal {
	
}

class Snake extends Animal {
	
}

public class Test1 {
	public static void main(String[] args) {
		Animal a = new Animal();
		
		a.eat(new Panda());
		a.eat(new Bear());
		a.eat(new Snake());
		
		System.out.println(a.getAinmal(new Snake()).getClass());
		
		Panda p = new Panda();
		Animal a1 = a.getAinmal(p);
		System.out.println(a1.getClass());
	}
}