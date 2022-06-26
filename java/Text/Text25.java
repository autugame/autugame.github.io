//import java.lang.ClassCastException;
public class Text25{
	public static void main(String[] args){
		//用父类的引用指向子类对象用大的类型表示小的类型
		Chicken hc = new HomeChicken("小白");
		//hc.eat();
		
		Chicken yc = new YeChicken("大鸡鸡");
		Chicken jjc = new JianJiaoChicken("尖椒鸡");
		//yc.eat();
		//hc = yc;
		//hc.eat();
		eat(hc);
		eat(yc);
		eat(jjc);
	}
	public static void eat(Chicken c){
		System.out.println("鸡吃饭");
		c.eat();
		if(c instanceof JianJiaoChicken){
		JianJiaoChicken jjc = (JianJiaoChicken)c;
		jjc.song();
		}
	}
}

abstract class Chicken{
	private String name;
	public Chicken(){}
	public Chicken(String name){
		this.name = name;
	}
	public void setName(String name){
		this.name = name;
	}
	public String getName(){
		return name;
	}
	public abstract void eat();
}

class HomeChicken extends Chicken{
	public HomeChicken(String name){
		super(name);
	}
	public void eat(){
		System.out.println(this.getName()+"我爱吃米");
	}
}

class YeChicken extends Chicken{
	public YeChicken(String name){
		super(name);
	}
	public void eat(){
		System.out.println(this.getName()+"我爱吃虫子");
	}
}

class JianJiaoChicken extends Chicken{
	public JianJiaoChicken(String name){
		super(name);
	}
	public void eat(){
		System.out.println(this.getName()+"我爱不吃东西");
	}
	public void song(){
		System.out.println("别看我只是一只鸡");
	}
}