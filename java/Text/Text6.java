import java.util.Scanner;
public class Text6{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.println("请输入天数");
		int day = input.nextInt();
		System.out.println("一共的周数是" + (day / 7));
		System.out.println("剩余的天数是" + (day % 7));
	}	
}