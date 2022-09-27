import java.util.Scanner;//接受键盘输入的工具类


public class Text2{
	public static void main(String[] args){
		System.out.println("转义字符测试");
		System.out.print("我想输出一个回车符\n\r");
		int x = 1;
		int y = 2;
		y = x + y - (y++);
		System.out.println(y);
		System.out.println(1 % 2);
		System.out.println(1 / 2);
		short s = 10;
		//s = (short)(s + 1);
		//s += 1;
		System.out.println(s);
		//返回值为boolean类型
		System.out.println(x == y);
		//创建一个键盘输入的工具
		Scanner input = new Scanner(System.in);
		System.out.println("请输入一个整数");
		int x1 = input.nextInt();//从键盘接收一个整数
		System.out.println(x1);
		System.out.println("请输入一个字符串");
		String s1 = input.next();
		System.out.println(s1);
	}
}