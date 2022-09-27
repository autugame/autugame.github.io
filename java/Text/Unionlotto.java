import java.util.Scanner;
import java.util.Random;
import java.util.Arrays;

public class Unionlotto{
	public static void main(String[] args){
		//定义相关的变量
		int[] userRedBall = new int[6];//用户选择的红球号码
		int[] sysRedBall = new int[6];//系统生成的红球号码
		int userBlueBall = 0;//用户选择的蓝球
		int sysBlueBall = 0;//系统生成的蓝球
		int redCount = 0;//记录用户选择正确的红球数
		int blueCount = 0;//记录用户选择正确的蓝球数
		int[] redBall = new int[33];//用于存储1-33的红球号码
		//需要随机生成6个在1-33之间不重复的数(算法)
		for(int i = 0; i < redBall.length; i++){
			redBall[i] = i+1;
		}
		
		//游戏开始系统提示
		System.out.println("双色球游戏开始,good luck!!");
		System.out.println("请问你是要机选或手选：1：机选，2：手选");
		Scanner input = new Scanner(System.in);
		Random r = new Random();
		boolean flag = true;
		while(flag){
			int isAuto = input.nextInt();
			switch(isAuto){
				case 1:
				//机选
					computerSelection(redBall, userRedBall);//红球
					userBlueBall = r.nextInt(16)+1;
					flag = false;
					break;
				case 2:
				//手选
					System.out.println("请选择6个红球号码(1-33)");
					for(int i = 0; i < userRedBall.length; i++){
						userRedBall[i] = input.nextInt();
					}
					System.out.println("请选择1-16之间的蓝球号码");
					userBlueBall = input.nextInt();
					flag = false;
					break;
				default:
					System.out.println("请问你是要机选或手选：1：机选，2：手选");
					break;
			}
		}
		//系统随机生成号码
		//红球
		computerSelection(redBall, sysRedBall);
		sysBlueBall = r.nextInt(16)+1;
		//统计结果
		//统计红球
		for(int i = 0; i < userRedBall.length; i++){
			for(int j = 0; j < sysRedBall.length-redCount; j++){
				if(userRedBall[i] == sysRedBall[j]){
					int temp = sysRedBall[j];
					sysRedBall[j] = sysRedBall[sysRedBall.length-1-redCount];
					sysRedBall[sysRedBall.length-1-redCount] = temp;
					redCount++;
					break;
				}
			}
		}
		//统计蓝球
		if(userBlueBall == sysBlueBall){
			blueCount = 1;
		}
		//验证是否中奖
		if(blueCount == 0 && redCount <= 3){
			System.out.println("很遗憾与百万大奖错失良缘");
		}else if(blueCount == 1 && redCount < 3){
			System.out.println("恭喜你！中了六等奖5元");
		}else if((blueCount == 1 && redCount == 3) || (blueCount == 0 && redCount == 4)){
			System.out.println("恭喜你！中了五等将10元");
		}else if((blueCount == 1 && redCount == 4) || (blueCount == 0 && redCount == 5)){
			System.out.println("恭喜你！中了四等奖200元");
		}else if((blueCount == 1 && redCount == 5)){
			System.out.println("恭喜你！中了三等奖1000元");
		}else if((blueCount == 0 && redCount == 6)){
			System.out.println("恭喜你！中了三等奖1500000元");
		}else if((blueCount == 1 && redCount == 6)){
			System.out.println("恭喜你！中了三等奖5000000元");
		}else{
			System.out.println("系统有误，中奖无效!!!");
		}
		//公布系统号码
		System.out.println("本期中奖红球号码");
		sort(sysRedBall);
		System.out.println(Arrays.toString(sysRedBall));
		System.out.println("本期中奖蓝球号码" + sysBlueBall);
		
		//公布用户号码
		System.out.println("本期你选择的红球号码");
		sort(userRedBall);
		System.out.println(Arrays.toString(userRedBall));
		System.out.println("本期你选择的蓝球号码" + userBlueBall);
	}
	public static void sort(int[] ball){
		for(int i = 0; i < ball.length-1; i++){
			for(int j = 0; j < ball.length-1-i; j++){
				if(ball[j] > ball[j+1]){
					ball[j] = ball[j]+ball[j+1];
					ball[j+1] = ball[j] - ball[j+1];
					ball[j] = ball[j] - ball[j+1];
				}	
			}
		}
	}
	//用于在指定数列中，随机生成多个不重复的数
	public static void computerSelection(int[] redBall, int[] userRedBall){
		Random r = new Random();
		int index = -1;
		for(int i = 0; i < userRedBall.length; i++){
			index = r.nextInt(redBall.length-i);
			userRedBall[i] = redBall[index];
			
			int temp = redBall[index];
			redBall[index] = redBall[redBall.length-1-i];
			redBall[redBall.length-1-i] = temp;
		}
	}
}