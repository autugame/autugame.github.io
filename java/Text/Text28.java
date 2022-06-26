public class Text28{
	public static void main(String[] args){
		Student s = new Student(1,"·Æ·Æ",18);
		System.out.println(s.toString());
		Student s1 = new Student(1,"·Æ·Æ",18);
		boolean b = s.equals(s);
		System.out.println(b);
		
		String str1 = new String("beibei");
		String str2 = new String("beibei");
		System.out.println(str1==str2);
		System.out.println(str1.equals(str2));
		System.out.println(1);
		System.out.println(s.getClass());
		System.out.println(s1.getClass());
	}
}

class Student{
	private String name;
	private int sid;
	private int age;
	public Student(){}
	public Student(int sid,String name,int age){
		this.sid = sid;
		this.name = name;
		this.age = age;
	}
	public String toString(){
		return "sid="+sid+"name="+name+"age"+age;
	}
	//??equals????????
	public boolean equals(Object obj){
		if(this == obj){
			return true;
		}
		if(obj instanceof Student){
			Student s = (Student)obj;
			if(!this.name.equals(s.name)){
				return false;
			}
			if(this.sid != s.sid){
				return false;
			}
			if(this.age != s.age){
				return false;
			}
			return true;
		}
		return false;
	}
}