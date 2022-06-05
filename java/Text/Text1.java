public class Text1{
	public static void main(String[] args){
		int num = 10;//局部变量
		//数值类型
		byte b = 10;//占用一个字节，取值范围-128~127
		short s = 10;//占用两个字节，取值范围-32768~32767，在实际开发中使用较少
		int i = 10;//占用四个字节，
		long lon = 100L;//占用8个字节
		float f = 10.98F;//占用4个字节
		double d = 10.1341234D;//占用8个字节
		
		char c = 'A';//占用两个字节范围：0~65535
		boolean bool = true;//占用字节数不确定
	}
}