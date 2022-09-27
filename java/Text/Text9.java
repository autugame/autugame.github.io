import java.util.Scanner;
public class Text9{
	public static void main(String[] args){
		Scanner input = new Scanner(System.in);
		/*
		Scanner input = new Scanner(System.in);
		System.out.println("请输入要打印的行数：");
		int line = input.nextInt();
		printStar(line);*/
		/*
		System.out.println("请输入年份：");
		int year = input.nextInt();
		boolean bool = isRunNian(year);
		if(bool){
			System.out.println("闰年");
		}else{
			System.out.println("平年");
		}
		*/
		int result = add(10, 20);
		System.out.println(result);
	}
	/*
	public static void printStar(int line){
		for (int i = 1; i <= line; i++) {//控制行数
			for (int k = i; k <= line; k++) {//控制空格的个数
				System.out.print(" ");
			}
			for (int j = 1; j <= 2 * i - 1; j++) {//控制打印的图形
				System.out.print("*");
			}
			System.out.println();//控制换行
		}
	}*/
	public static boolean isRunNian(int year){
		if (year % 4 == 0 && year % 100 != 0 || year % 400 ==0){
			return true;
		}else{
			return false;
		}
	}
	public static int add(int a, int b){
		return a+b;
	}
	public static float add(float a, float b){
		return a+b;
	}
}