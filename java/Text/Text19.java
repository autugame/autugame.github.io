import java.util.Arrays;

public class Text19{
	public static void main(String[] args){
		ChickenManager cm = new ChickenManager(5);
		cm.add(new Chicken("小小",1,10));
		cm.add(new Chicken("小二",2,8));
		cm.add(new Chicken("小三",3,5));
		cm.add(new Chicken("小四",4,4));
		cm.add(new Chicken("小五",5,10));
		
		cm.add(new Chicken("小斗",6,10));
		System.out.println(cm.length());
		System.out.println("----------------------------------------");
		cm.printAll();
		cm.delete(3);
		System.out.println("----------------------------------------");
		Chicken c = cm.find(6);
		c.print();
		System.out.println("----------------------------------------");
		cm.update(new Chicken("下蛋公鸡", 1, 20));
		cm.printAll();
	}
}

//管理类
class ChickenManager{
	private Chicken[] cs = null;
	private int count = 0;//记录当前数组的元素个数(下标)
	public ChickenManager(int size){
		if(size > 0){
			cs = new Chicken[size];
		}else{
			cs = new Chicken[5];
		}
	}
	//添加:实现动态数组
	public void add(Chicken c){
		if(count >= cs.length){
			//算法1扩充原来数组的一半左右
			//算法2扩充原来数组的一倍
			int newLen = cs.length*3/2+1;
			cs = Arrays.copyOf(cs, newLen);
			
		}
		cs[count++] = c;//先做运算后加加
	}
	public int length(){
		return cs.length;
	}
	//删除
	public void delete(int id){
		for(int i = 0; i < count; i++){
			if(cs[i].getId() == id){
				for(int j = i; j < count-1; j++){
					cs[j] = cs[j+1];
				}
				cs[count-1] = null;
				count--;
				break;
			}
		}
	}
	//更新
	public void update(Chicken c){
		Chicken temp = find(c.getId());
		if(temp != null){
			temp.setName(c.getName());
			temp.setAge(c.getAge());
		}
	}
	//查找
	public Chicken find(int id){
		for(int i = 0; i < count; i++){
			if(cs[i].getId() == id){
				return cs[i];
			}
		}
		return null;
	}
	//输出所有
	public void printAll(){
		for(int i = 0; i < count; i++){
			cs[i].print();
		}
	}
}

//小鸡类
class Chicken{
	private int id;
	private String name;
	private int age;
	public Chicken(){}
	public Chicken(String name, int id, int age){
		this.name = name;
		this.id = id;
		this.age = age;
	}
	public void setId(int id){
		this.id = id;
	}
	public int getId(){
		return id;
	}
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
	public void print(){
		System.out.println("id="+id+"name="+name+"age="+age);
	}
}