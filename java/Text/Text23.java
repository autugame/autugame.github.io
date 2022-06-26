public class Text23{
	public static void main(String[] args){
		Man man = new Man();
		man.move();
		man.eat();
		
		Women women = new Women();
		women.move();
		women.eat();
	}
}

abstract class Animal{
	public abstract void move();//抽象类
}

abstract class Person extends Animal{
	public abstract void eat();
}

class Man extends Person{
	public void move(){
		System.out.println("我是男人我爱跑步");
	}
	public void eat(){
		System.out.println("我是男人我爱吃肉");
	}
}

class Women extends Person{
	public void move(){
		System.out.println("我是男人我爱逛街");
	}
	public void eat(){
		System.out.println("我是男人我爱吃水果");
	}
}