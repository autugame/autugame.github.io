public class Text32{
	public static void main(String[] args){
		Outer outer = new Outer();
		outer.innerPrint();
		outer.show();
		Outer.Inner3 inner3 = new Outer.Inner3();
		inner3.print();
		new Outer().innerPrint();
		new Outer().print1();
		outer.print2();
		outer.print3(new Eat(){
			public void eat(){
				System.out.println("参数式匿名内部内");
			}
		});
	}
}

class Outer{
	//成员内部内
	private String name;
	public void innerPrint(){
		Inner inner = new Inner();
		inner.print();
	}
	private class Inner{
		public void print(){
			System.out.println("Inner");
		}
	}
	//----------------
	public void show(){
		final int x = 10;
		class Inner2{
			public void print(){
				System.out.println("方法内部内"+x);
			}
		}
		Inner2 inner2 = new Inner2();
		inner2.print();
	}
	
	static class Inner3{
		public void print(){
			System.out.println("静态类部类");
		}
	}
	
	public void print1(){
		Cat cat = new Cat(){
			public void eat(){
				System.out.println("继承式匿名内部内");
			}
		};
		cat.eat();
	}
	public void print2(){
		Eat eat = new Eat(){
			public void eat(){
				System.out.println("接口式匿名类部类");
			}
		};
		eat.eat();
	}
	public void print3(Eat eat){
		eat.eat();
	}
}

abstract class Cat{
	public abstract void eat();
}

interface Eat{
	public abstract void eat();
}
/**
class A extends B{
	class c extends D{
		
	}
}
*/