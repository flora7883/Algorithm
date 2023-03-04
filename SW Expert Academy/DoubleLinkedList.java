class Node {
	public int data;
	public Node prev;
	public Node next;

	public Node(int data) {
		this.data = data;
		this.prev = null;
		this.next = null;
	}
}

public class UserSolution {
	
	private final static int MAX_NODE = 10000;

	private Node[] node = new Node[MAX_NODE];
	private int nodeCnt = 0;
	private Node head;
	private Node tail;
    
	public Node getNode(int data) {
		node[nodeCnt] = new Node(data);
		return node[nodeCnt++];
	}

	public void init() {//초기화
		head=new Node(-1);
		tail=new Node(-1);
		head.prev=null;
		head.next=tail;
		tail.prev=head;
		tail.next=null;
	}
	
	public void addNode2Head(int data) {//맨 앞에 노드 추가
		Node node=getNode(data);
		node.next=head.next;
		node.prev=head;
		head.next.prev=node;
		head.next=node;
	}

	public void addNode2Tail(int data) {//맨 뒤에 노드 추가. tail 사용
		Node node=getNode(data);
		node.prev=tail.prev;
		node.next=tail;
		node.prev.next=node;
		tail.prev=node;
	}

	public void addNode2Num(int data, int num) {//지정된 순서(num)에 노드 추가, num은 1이상
		Node node=getNode(data);
		Node prev=head;
		for(int i=1;i<num;i++) {
			prev=prev.next;
		}
		node.next=prev.next;
		node.prev=prev;
		prev.next.prev=node;
		prev.next=node;
	}
	
	public int findNode(int data) {//data를 가진 node의 순서 return
		Node prev=head;
		int i=1;
		while(prev.next!=tail&&prev.next.data!=data) {
			prev=prev.next;
			i++;
		}
		return i;
	}
	
	public void removeNode(int data) {//data를 가진 노드를 삭제
		Node prev=head;
		while(prev.next!=tail&&prev.next.data!=data){
			prev=prev.next;
		}
		if(prev.next!=tail) {
			prev.next=prev.next.next;
			prev.next.prev=prev;
		}
	}

	public int getList(int[] output) {//노드의 data 정보를 차례대로 output[]에 저장하고 노드 갯수를 리턴
		int i=0;
		Node prev=head;
		while(prev.next!=tail) {
			prev=prev.next;
			output[i]=prev.data;
			i++;
		}
		return i;
	}
	
	public int getReversedList(int[] output) {//노드의 data 정보를 역순으로 output에 저장하고 노드 갯수를 리턴
		int i=0;
		Node next=tail;
		while(next.prev!=head) {
			next=next.prev;
			output[i]=next.data;
			i++;
		}
		return i;
	}
}
