public class Text12{
	public static void main(String[] args){
		/*
		char[] cs = {'A', 'B', 'C', 'D', 'E', 'F', 'G'};
		int len = cs.length;
		for(int i = 1; i <= len; i++){
			for(int j = i; j < len; j++){
				System.out.print(" ");
			}
			for(int j = 1; j <= i * 2 -1; j++){
				System.out.print(cs[i-1]);
			}
			System.out.println();
		}*/
		/*
		int[][] scores = {{78, 98, 88}, {60, 90, 30}, {10, 40, 100}};
		int classlen = scores.length;
		for(int i = 0; i < classlen; i++){
			int sum = 0;
			int count = scores[i].length;
			for(int j = 0; j < count; j++){
				sum += scores[i][j];
			}
			System.out.println("第" + (i+1) + "平均成绩" + sum/3);
		}*/
		/*
		int[] num = {12, 3, 54, 67, 88, 34};
		int max = max(num);
		System.out.println(max);
		*/
		int[] nums = {34, 4, 56, 17, 90, 65, 80, 88};
		int len = nums.length;
		/*
		for(int i = 0; i < len; i++){
			for(int j = 0; j < len - i; j++){
				if(nums[j] > nums[j+1]){
					nums[j] = nums[j]+nums[j+1];
					nums[j+1] = nums[j]-nums[j+1];
					nums[j] = nums[j]-nums[j+1];
				}
			}
		}*/
		/*
		int minIndex = 0;//用于记录每次比较最小值下标
		for(int i = 0; i < len - 1; i++){
			minIndex = i;
			for(int j = i+1; j < len; j++){
				if(nums[minIndex] > nums[j]){
					minIndex = j;
				}
			}
			if(minIndex != i){
				nums[minIndex] = nums[minIndex]+nums[i];
				nums[i] = nums[minIndex]-nums[i];
				nums[minIndex] = nums[minIndex]-nums[i];
			}
		}
		for(int x:nums){
			System.out.println(x);
		}*/
		for(int i = 1; i < nums.length; i++){
			int temp = nums[i];
			int j = 0;
			for(j = i-1; j >= 0; j--){
				if(nums[j] > temp){
					nums[j+1] = nums[j]; 
				}else{
					break;
				}
			}
			if(nums[j+1] != temp){
				nums[j+1] = temp;
			}
		}
		for(int x:nums){
			System.out.println(x);
		}
	}
	public static int max(int[] num){
		int max = num[0];
		int len = num.length;
		for(int i = 0; i < len; i++){
			if(num[i] > max){
							//1+2
				num[i] = num[i] + max;
				//1		3		2
				max = num[i] - max;
				num[i] = num[i] - max;
			}
		}
		return max;
	}
	public static int min(int[] num){
		int min = num[0];
		int len = num.length;
		for(int i = 0; i < len; i++){
			if(num[i] < min){
							//1+2
				num[i] = num[i] + min;
				//1		3		2
				min = num[i] - min;
				num[i] = num[i] - min;
			}
		}
		return min;
	}
}