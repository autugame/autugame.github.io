import java.util.Scanner;
public class Text4{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		System.out.println("请输入圆柱体的高:");
		int h = input.nextInt();
		System.out.println("请输入圆柱体的底面半径:");
		int r = input.nextInt();
		double result = 3.14 * r * r * h;
		System.out.println(result);
	}
}