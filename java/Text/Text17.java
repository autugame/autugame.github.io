public class Text17{
	public static void main(String[] args){
		Role beibei = new Role("刘备");
		Role yunchang = new Role("关羽");
		Role feifei = new Role("张飞");
		Role.country = "魏";
		System.out.println(beibei.getInfo());
		System.out.println(yunchang.getInfo());
		System.out.println(feifei.getInfo());
	}
}

class Role{
	private String name;
	static String country = "蜀国";//静态变量全局变量
	public Role(){};
	public Role(String name/*, String country*/){
		this.name = name;
	}
	public String getName(){
		return name;
	}
	/*
	public String getCountry(){
		return country;
	}*/
	public static void setCountry(String country){
		Role.country = country;
	}
	public String getInfo(){
		return "名字"+name+"国家"+country;
	}
}