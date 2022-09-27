import java.util.Scanner;
public class Text7{
	public static void main(String[] args){
		System.out.println("请输入成绩");
		Scanner input = new Scanner(System.in);
		int score = input.nextInt();
		String a = score >= 60 ? "及格" : "不及格";
		System.out.println(a);
	}
}