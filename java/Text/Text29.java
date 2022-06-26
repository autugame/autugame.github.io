public class Text29{
	public static void main(String[] args){
		Product phone = ProductFactory.getProduct("phone");
		if(null != phone){
			phone.work();
		}
	}
}

class ProductFactory{
	public static Product getProduct(String name){
		if("phone".equals(name)){
			return new Phone();
		}else if("computer".equals(name)){
			return new Computer();
		}else{
			return null;
		}
	}
}

interface Product{
	public void work();
}

class Phone implements Product{
	public void work(){
		System.out.println("手机开始工作");
	}
}

class Computer implements Product{
	public void work(){
		System.out.println("电脑开始工作");
	}
}