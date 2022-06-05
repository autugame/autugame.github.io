public class Text10{
	public static void main(String[] args){
		int[] nums = new int[50];
		int len = nums.length;
		for(int i = 0; i < len; i++){
			nums[i] = i+1;
		}
		int[] nums2;
		nums2 = new int[5];
		int[] nums3 = new int[]{1, 2, 3, 4, 5};
		int[] nums4 = {1, 2, 3, 4, 5};
		System.out.println(nums4.length);
		for(int i = 0; i < len; i++){
			int score = nums[i];
			System.out.println(score);
		}
		for(int i = 0; i < 5; i++){
			System.out.println(i);
		}
		for(int x:nums){
			System.out.println(x);
		}
		print(nums);
		print2(1, 2, 3, 4, 5);
	}
	public static void print(int[] x){
		int len = x.length;
		for(int i = 0; i < len; i++){
			int y = x[i];
			System.out.print(y);
		}
	}
	public static void print2(int... x){
		int len = x.length;
		for(int i = 0; i < len; i++){
			int y = x[i];
			System.out.print(y);
		}
	}
}