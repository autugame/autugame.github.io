import java.util.Arrays;
public class Text14{
	public static void main(String[] args){
		int[] num = {10, 20, 30, 40, 50, 60};
		int index = Arrays.binarySearch(num, 60);
		System.out.println(index);
		System.out.println(Arrays.toString(num));
		int[] nums = {100, 99, 30, 80, 50, 60};
		Arrays.sort(nums);
		System.out.println(Arrays.toString(nums));
		nums = Arrays.copyOf(nums, 10);
		System.out.println(Arrays.toString(nums));
		int[] nums1 = Arrays.copyOf(nums, 10);
		System.out.println(Arrays.toString(nums1));
		System.out.println(Arrays.equals(nums, nums1));
		Arrays.fill(nums, 0);
		System.out.println(Arrays.toString(nums));
	}
}