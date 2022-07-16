package com.autuo;

import java.util.Arrays;
import java.util.Comparator;

public class LambdaDemo {

	public static void main(String[] args) {
//		IEat ieat = new IEatImpl();
//		ieat.eat();
//		
//		IEat ieat2 = new IEat() {
//			public void eat() {
//				System.out.println("eat bnana");
//			}
//		};
//		ieat2.eat();

		// Lambda表达式没有参数时使用
//		IEat ieat3 = ()->{System.out.println("eat apple bnana");};
//		ieat3.eat();
//		IEat ieat3 = (thing, name) -> System.out.println("eat..." + thing + "..." + name);
//		ieat3.eat("apple", "小小");
//		IEat ieat4 = (thing, name) -> {
//			System.out.println(1);
//			while (true) {
//				System.out.println(1);
//			}
//		};

		// 带返回值的方法
//		IEat ieat3 = (thing, name) -> {
//			System.out.println(name + "eat" + thing);
//			return name;
//		};
//		System.out.println(ieat3.eat("apple", "小小"));
		IEat ieat3 = (final String thing, final String name) -> name == null ? "1" : "0";
		ieat3.eat("apple", "小小");
		ieat3.print();
		IEat.method();
		Student[] students = { new Student("张三", 18), new Student("李四", 22), new Student("王五", 30) };
		Arrays.sort(students, new Comparator<Student>() {
			public int compare(Student o1, Student o2) {
				return o1.getAge() - o2.getAge();
			}
		});
		
		//Comparator<Student> c = (o1, o2) -> o1.getAge() - o2.getAge(); 
		Arrays.sort(students, (o1, o2) -> o1.getAge() - o2.getAge());
		System.out.println(Arrays.toString(students));
	}

}
