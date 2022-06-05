public class Text16{
	public static void main(String[] args){
		Hero hero = new Hero("刘备", 300);
		Weapon weapon = new Weapon("双股剑", 3);
		hero.setWeapon(weapon);
		weapon.setHero(hero);
		
		String name = hero.getName();
		int age = hero.getAge();
		Weapon w = hero.getWeapon();
		System.out.println("我是"+name+"我"+age+"岁"+"我的武器是"+w.getName()+"排名"+w.getGrade()+"级");
	}
}

//英雄类
class Hero{
	private String name;
	private int age;
	private Weapon weapon;
	
	public Hero(){}
	public Hero(String name, int age){
		this.name = name;
		this.age = age;
	}
	public void setWeapon(Weapon weapon){
		this.weapon = weapon;
	}
	public Weapon getWeapon(){
		return weapon;
	}
	public String getName(){
		return name;
	}
	public int getAge(){
		return age;
	}
}
//武器类
class Weapon{
	private String name;
	private int grade;
	private Hero hero;
	
	public Weapon(){}
	public Weapon(String name, int grade){
		this.name = name;
		this.grade = grade;
	}
	public void setHero(Hero hero){
		this.hero = hero;
	}
	public Hero getHero(){
		return hero;
	}
	public String getName(){
		return name;
	}
	public int getGrade(){
		return grade;
	}
}