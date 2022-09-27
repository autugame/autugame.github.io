public class Text20{
	public static void main(String[] args){
		HomeDog homeDog = new HomeDog("旺财");
		homeDog.eat();
		homeDog.print();
	}
}

class Dog{
	protected String name;
	protected String sex;
	public Dog(String name){
		this.name = name;
		System.out.println("我是父类的构造方法");
	}
	public void eat(){
		System.out.println("吃饭");
	}
}
class HomeDog extends Dog{
	public HomeDog(String name){
		super(name);
		System.out.println("我是HomeDog的构造方法");
	}
	public void print(){
		System.out.println("我是一只家狗"+name);
	}
	public void eat(){
		super.eat();
		System.out.println("我是家狗我喜欢吃骨头");
	}
}
class HuskyDog extends Dog{
	public HuskyDog(String name){
		super(name);
	}
	public void show(){
		System.out.println("我是高贵的哈士奇");
	}
	public void eat(){
		System.out.println("我是哈士奇我喜欢吃鸡肝");
	}
}