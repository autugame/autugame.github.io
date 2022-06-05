import java.util.Scanner;
import java.util.Random;
public class Text11{
	public static void main(String[] args){
		int[] nums = new int[5];
		int len = nums.length;
		Random r = new Random();
		for(int i = 0; i < len; i++){
			nums[i] = r.nextInt(60);
		}
		Scanner input = new Scanner(System.in);
		System.out.println("请输入你要猜的数60以内");
		int userNum = input.nextInt();
		boolean flag = false;
		for(int x:nums){
			if(userNum == x){
				flag = true;
				break;
			}
		}
		if(flag){
			System.out.println("恭喜你猜对了");
		}else{
			System.out.println("没猜对");
		}
	}
}