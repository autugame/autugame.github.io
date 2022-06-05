public class Text18{
	public static void main(String[] args){
		Singleton2 s = Singleton2.getInstance();
		s.print();
	}
}

class Singleton1{
	private Singleton1(){}
	private static Singleton1 s = new Singleton1();
	public static Singleton1 getInstance(){
		return s;
	}
	public void print(){
		System.out.println("测试方法");
	}
}

class Singleton2{
	private Singleton2(){}
	private static Singleton2 s;
	
	public static Singleton2 getInstance(){
		if(s==null)
		{
			s = new Singleton2();
		}
		return s;
	}
	public void print(){
		System.out.println("测试方法");
	}
}