public class Text20{
	public static void main(String[] args){
		HomeDog homeDog = new HomeDog();
		homeDog.eat();
		homeDog.print();
	}
}

class Dog{
	protected String name;
	protected String sex;
	public Dog(){
		System.out.println("我是父类的构造方法");
	}
	public void eat(){
		System.out.println("吃饭");
	}
}
class HomeDog extends Dog{
	public HomeDog(){
		System.out.println("我是HomeDog的构造方法");
	}
	public void print(){
		System.out.println("我是一只家狗");
	}
}
class HuskyDog extends Dog{
	public void show(){
		System.out.println("我是高贵的哈士奇");
	}
}