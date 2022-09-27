public class Text34{
	public static void main(String[] args){
		NodeManager nm = new NodeManager();
		nm.add(5);
		nm.add(4);
		nm.add(3);
		nm.add(2);
		nm.add(1);
		nm.print();
		nm.del(5);
		nm.update(4,10);
		nm.print();
		nm.insert(1,100);
		nm.print();
	}
}

class NodeManager{
	private Node root;
	private int currentIndex = 0;//½ÚµãµÄÐòºÅ
	
	public void add(int data){
		if(root==null){
			root = new Node(data);
		}else{
			root.addNode(data);
		}
	}
	public void del(int data){
		if(root==null)return;
		if(root.getData()==data){
			root = root.next;
		}else{
			root.delNode(data);
		}
	}
	public void print(){
		if(root!=null){
			System.out.print(root.getData()+">");
			root.printNode();
			System.out.println();
		}
	}
	public boolean find(int data){
		if(root==null)return false;
		if(root.getData()==data){
			return true;
		}else{
			return root.findNode(data);
		}
	}
	public void update(int oldData,int newData){
		if(root==null)return;
		if(root.getData()==oldData){
			root.setData(newData);
			return;
		}else{
			root.updateNode(oldData,newData);
		}
	}
	public void insert(int index,int data){
		if(index<0)return;
		if(root==null)return;
		currentIndex = 0;
		if(index==currentIndex){
			Node newNode = new Node(data);
			newNode.next = root;
			root = newNode;
		}else{
			root.insertNode(index,data);
		}
	}
	
	private class Node{
		private int data;
		private Node next;
		public Node(int data){
			this.data = data;
		}
		public void setData(int data){
			this.data = data;
		}
		public int getData(){
			return data;
		}
		public void addNode(int data){
			if(this.next==null){
				this.next = new Node(data);
			}else{
				this.next.addNode(data);
			}
		}
		public void delNode(int data){
			if(this.next!=null){
				if(this.next.data==data){
					this.next = this.next.next;
				}else{
					this.next.delNode(data);
				}
			}
		}
		public void printNode(){
			if(this.next!=null){
				System.out.print(this.next.data+"->");
				this.next.printNode();
			}
		}
		public boolean findNode(int data){
			if(this.next!=null){
				if(this.next.data==data){
					return true;
				}else{
					return this.next.findNode(data);
				}
			}
			return false;
		}
		public void updateNode(int oldData,int newData){
			if(this.next!=null){
				if(this.next.data==oldData){
					this.next.data = newData;
					return;
				}else{
					this.next.updateNode(oldData,newData);
				}
			}
			return;
		}
		public void insertNode(int index,int data){
			currentIndex++;
			if(index==currentIndex){
				Node newNode = new Node(data);
				newNode.next = this.next;
				this.next = newNode;
			}else{
				this.next.insertNode(index,data);
			}
		}
	}
}