public class Text15{
	public static void main(String[] args){
		
		Horse h = null;
		h = new Horse();
		h.name = "赤兔马";
		h.age = 350;
		h.run();
		/*
		h.run();
		h.eat();
		name("关羽");
		new Horse().eat();//匿名对象只能用一次
		h = null;//释放对象
		Horse h1 = null;
		Horse h2 = null;
		h1 = new Horse();
		//h2 = new Horse();
		h1.name = "小白";
		h1.age = 4;
		//h2.name = "小黑";
		//h2.age = 5;
		h2 = h1;
		*/
		Person p1 = new Person("小白", 2);
		p1.setName("小白");
		p1.setAge(18);
	}
	public static void name(String name){
		System.out.println("我是"+name);
	}
}
class Person{
	public Person(){
		System.out.println("亲爱的观众朋友们你们好");
	}
	public Person(String name){
		this.name = name;
	}
	public Person(String name, int age){
		this();//调用其他构造方法时此语句必须在第一条调用
		this.name = name;
		this.age = age;
	}
	private String name;
	private int age;
	
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}
	public void setAge(int age){
		this.age = age;
	}
	public int getAge(){
		return age;
	}
}

class Horse{
	String name;
	int age;
	
	public void run(){
		System.out.println("我是"+name+"我"+age+"岁日行千里");
		this.eat();
	}
	public void eat(){
		System.out.println("我吃仙草而且吃的多");
	}
}