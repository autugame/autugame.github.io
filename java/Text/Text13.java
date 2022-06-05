public class Text13{
	public static void main(String[] args){
		int[] nums = {34, 4, 56, 17, 90, 65};
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
		for(int n:nums){
			System.out.println(n);
		}
		int[] num = {10, 20, 30, 40, 50, 60};
		int index = binarySearch(num, 10);
		System.out.println(index);
	}
	public static int binarySearch(int[] nums, int key){
		int start = 0;
		int end = nums.length-1;
		
		while(start <= end){
			int middle = (start+end)/2;
			if(nums[middle] > key){
				end = middle-1;
			}else if(nums[middle] < key){
				start = middle+1;
			}else{
				return middle;
			}
		}
		
		return -1;
	}
}