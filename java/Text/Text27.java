public class Text27{
	public static void main(String[] args){
		BaseService user = new UserService();
		user.setISave(new FileSave());
		user.add("user");
	}
}

interface ISave{
	public void save(String data);
}

class FileSave implements ISave{
	public void save(String data){
		System.out.println("把数据保存到文件中。。。"+data);
	}
}

class NetSave implements ISave{
	public void save(String data){
		System.out.println("把数据保存到网络上..."+data);
	}
}

abstract class BaseService{
	private ISave iSave;
	public void setISave(ISave iSave){
		this.iSave = iSave;
	}
	public void add(String data){
		System.out.println("检查数据合法性");
		iSave.save(data);
		System.out.println("数据保存完毕");
	}
}

class UserService extends BaseService{
	
}