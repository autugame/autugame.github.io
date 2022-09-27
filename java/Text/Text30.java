public class Text30{
	public static void main(String[] args){
		Action UserAction = new UserAction();
		ActionProxy  proxy = new ActionProxy(UserAction);
		proxy.doAction();
	}
}

class ActionProxy implements Action{
	
	private Action target;
	
	public ActionProxy(Action target){
		this.target = target;
	}
	
	public void doAction(){
		long startTime = System.currentTimeMillis();
		target.doAction();
		long endTime = System.currentTimeMillis();
		System.out.println(endTime-startTime);
	}
}
interface Action{
	public void doAction();
}

class UserAction implements Action{
	public void doAction(){
		for(int i = 0; i < 100; i++){
			System.out.println("用户开始工作");
		}
	}
}