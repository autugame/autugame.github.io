public class Text24{
	public static void main(String[] args){
		Girl girl = new Girl("小三");
		girl.eat();
		girl.sleep();
		girl.run();
		girl.print();
		System.out.println(girl.name);
	}
}

interface IEat{
	public abstract void eat();//接口中只能定义抽象方法
	void sleep();//接口中定义的方法没有声明修饰符
	public static final int NUM = 10;
	int NUMBER = 10;
	public default void print(){//新特性可以被所有实现类继承
		System.out.println("eat");
	}
}

interface IRun{
	void run();
}

interface ISleep extends IEat,IRun{
	void sleep();
}

class Girl implements ISleep,IEat{
	public String name;
	public Girl(){}
	public Girl(String name){
		this.name = name;
	}
	public void sleep(){
		System.out.println("我爱睡觉");
	}
	public void eat(){
		System.out.println("我是"+name+"我爱吃猪脚");
	}
	public void run(){
		System.out.println("吃完就跑");
	}
}
