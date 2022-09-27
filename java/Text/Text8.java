import java.util.Scanner;
public class Text8{
	public static void main(String[] args){
		/*
		System.out.println("请输入一个字母");
		Scanner input = new Scanner(System.in);
		int c = input.nextInt();
		if (c >= 65 && c <= 90){
			System.out.println("大写" + (char)c);
		}
		else{
			System.out.println("小写" + (char)c);
		}
		*/
		//System.out.println("请输入年份");
		Scanner input = new Scanner(System.in);
		/*
		int year = input.nextInt();
		if ((year % 4 == 0 && year % 100 != 0) || year % 400 == 0){
			System.out.println("是闰年");
		}else{
			System.out.println("平年");
		}*/
		/*System.out.println("输入一个成绩");
		int score = input.nextInt();
		if(score >= 90){
			System.out.println("A");
		}else if (score >= 80){
			System.out.println("B");
		}else if (score >= 70){
			System.out.println("C");
		}else if (score >= 60){
			System.out.println("D");
		}else{
			System.out.println("E");
		}*/
		/*System.out.println("请输入第一个数");
		int num1 = input.nextInt();
		System.out.println("请输入第二个数");
		int num2 = input.nextInt();
		if(num1 > num2){
			System.out.println("第一个数大于第二个数");
		}else if(num1 < num2){
			System.out.println("第一个数小于第二个数");
		}else if(num1 == num2){
			System.out.println("第一个数等于第二个数");
		}
		System.out.println("请输入今天的天气(1.好, 2.霾)");
		int weather = input.nextInt();
		if(weather == 1){
			System.out.println("玩游戏");
			int flag = input.nextInt();
			if(flag == 1){
				System.out.println("逛街");
			}else{
				System.out.println("六女朋友");
			}
		}else{
			System.out.println("睡觉");
			int flag = input.nextInt();
			if(flag == 1){
				System.out.println("看电影");
			}else{
				System.out.println("抢银行");
			}
		}*/
		/*
		System.out.println("今天是星期几");
		int day = input.nextInt();
		switch(day){
			case 1:
				System.out.println("星期一");
				System.out.println("1.公交，2.地铁");
				int method = input.nextInt();
				if(method == 1){
					System.out.println("公交");
				}else{
					System.out.println("地铁");
				}
				break;
			case 2:
				System.out.println("星期一");
				break;
			case 3:
				System.out.println("星期一");
				break;
			case 4:
				System.out.println("星期一");
				break;
			case 5:
				System.out.println("星期一");
				break;
			case 6:
				System.out.println("星期一");
				break;
			case 7:
				System.out.println("星期一");
				break;
			default:
				System.out.println("您输入的不是数字或者是大写的数字请输入数字");
				break;*/
		
		//}
		/*
		System.out.println("请输入月份");
		int month = input.nextInt();
		switch(month){
			case 1:
				System.out.println("31");
				break;
			case 2:
				System.out.println("28");
				break;
			case 3:
				System.out.println("31");
				break;
			case 4:
				System.out.println("30");
				break;
			case 5:
				System.out.println("31");
				break;
			case 6:
				System.out.println("30");
				break;
			case 7:
				System.out.println("31");
				break;
			case 8:
				System.out.println("31");
				break;
			case 9:
				System.out.println("30");
				break;
			case 10:
				System.out.println("31");
				break;
			case 11:
				System.out.println("30");
				break;
			case 12:
				System.out.println("31");
				break;
			default:
			System.out.println("我不明白你说的是什么意思");
			break;
		}*/
		/*
		System.out.println("请输入第一个数");
		int num1 = input.nextInt();
		System.out.println("请输入第二个数");
		int num2 = input.nextInt();
		System.out.println("请输入操作符");
		String op = input.next();
		switch(op){
			case "加":
				System.out.println(num1 + num2);
				break;
			case "减":
				System.out.println(num1 - num2);
				break;
			case "乘":
				System.out.println(num1 * num2);
				break;
			case "除":
					System.out.println(num1 / num2);
				break;
			default:
				System.out.println("你输入的东西我不认识!!!");
				break;
		}*/
		/*
		int num = 0;
		int i = 1;
		while(i <= 100){
			num += i;
			i++;
		}
		System.out.println(num);
		*/
		/*
		int i = 1;
		int num = 1;
		while(i <= 10){
			num *= i;
			i++;
		}
		System.out.println(num);
		*/
		/*
		int i = 1;
		while(i < 100){
			if(i % 2 == 0){
				System.out.println("偶数:" + i);
			}else{
				System.out.println("奇数:" + i);
			}
			if(i % 3 == 0){
				System.out.println("3的倍数:" + i);
			}
			i++;
		}*/
		/*
		int i = 10;
		do{
			//循环体
			System.out.println(i);
			i--;
		}while(i >= 0);*/
		/*
		int num = 0;
		int i = 1;
		do{
			int j = 1;
			int jc = 1;
			while(j <= i){
				jc *= j;
				j++;
			}
			num += jc;
			i++;
		}while(i <= 10);
		System.out.println(num);
		*/
		/*
		for(int i = 0; i < 10; i++){
			if(i == 5){
				continue;
			}
			System.out.println(i);
		}*/
		/*
		for(int i = 0; i < 200; i++){
			if(i % 7 ==0 && i % 4 != 0){
				System.out.println(i);
			}
		}*/
		/*
		int n1 = 1;
		int n2 = 1;
		int next = 0;
		System.out.print(n1 + " " + n2 + " ");
		for(int i = 0; i < 8; i++){
			next = n1 + n2;
			System.out.print(next + " ");
			n1 = n2;
			n2 = next;
		}*/
		/*
		for(int i = 1; i <= 5; i++){
			for(int j = 1; j <= i; j++){
				System.out.print("*");
			}
			System.out.println();
		}
		for(int i = 1; i <= 9; i++){
			for(int j = 1; j <= i; j++){
				System.out.print(j + "*" + i + "=" + i * j + "\t");
			}
			System.out.println();
		}
		for(int i = 1; i <= 5; i++){
			for(int j = 5; j > 0; j--){
				if(j <= i){
					System.out.print("*");
				}else{
					System.out.print (" ");
				}
			}
			System.out.println();
		}
		for (int i = 1; i <= 5; i++) {//控制行数
			for (int k = i; k <= 5; k++) {//控制空格的个数
				System.out.print(" ");
			}
			for (int j = 1; j <= 2 * i - 1; j++) {//控制打印的图形
				System.out.print("*");
			}
			System.out.println();//控制换行
		}*/
	}
}