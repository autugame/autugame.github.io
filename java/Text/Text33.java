public class Text33{
	public static void main(String[] args){
		int result = jiecheng2(10);
		System.out.println(result);
	}
	
	public static int jiecheng2(int num){
		if(num==1)return 1;
		return num*jiecheng2(num-1);
	}
	
	public static int jiecheng1(int num){
		int result = num;
		int i = num-1;
		do{
			result = result * i;
			i--;
		}while(i>1);
		return result;
	}
}