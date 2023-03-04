class Node {
	public int data;
	public Node next;//다음 노드를 가르키 레퍼런스 변수

	public Node(int data) {//생성자
		this.data = data;
		this.next = null;
	}
}

public class UserSolution {

	private final static int MAX_NODE = 10000;

	private Node[] node = new Node[MAX_NODE];
	private int nodeCnt = 0;
	private Node head;
    
	public Node getNode(int data) {
		node[nodeCnt] = new Node(data);
		return node[nodeCnt++];
	}

	public void init() {//처음 초기화
		//head null연결
		head=new Node(-1);//위에서 head의 변수만 만들었지 객체를 할당하지 않아서 여기서 해줘야햠.
		head.next=null;
	}

	public void addNode2Head(int data) {//맨 앞에 노드 추가
		//새 노드 생성(data)
		//노드의 next에 head.next값 대입
		//head.next가 노드를 가리키도록함.
		Node node=getNode(data);
		node.next=head.next;
		head.next=node;
	}

	public void addNode2Tail(int data) {//맨 뒤에 노드 추가
		//새 노드 생성(data)
		//맨 뒤 노드를 찾음 while
		//맨 뒤 노드.next가 node를 가리키도록 함.
		Node node=getNode(data);
		Node prev=head;
		while(prev.next!=null) {
			prev=prev.next;
		}
		prev.next=node;
	}

	public void addNode2Num(int data, int num) {//지정된 순서(num)에 노드 추가
		//새 노드 생성 data
		//넣어야 할 위치 앞 노드를 찾음.
		Node node=getNode(data);
		Node prev=head;
		for(int i=1;i<num;i++) {
			prev=prev.next;
		}
		node.next=prev.next;
		prev.next=node;

	}

	public void removeNode(int data) {//주어진 data값을 가진 노드 삭제
		//주어진 data 값을 가진 노드 앞 노드를 찾음. 
		//prev.next가 지워야하는 노드임.
		//** data가 없는 경우 주의. 없으면 아무일도 일어나지 않아야함. 데이터 접근 주의
		Node prev=head;
		while(prev.next!=null&&prev.next.data!=data) {
			prev=prev.next;
		}
		if(prev.next!=null) {
			prev.next=prev.next.next;
		}
		
	}

	public int getList(int[] output) {//output[]배열에 리스트 노드의 data를 차례로 넣고, 총 노드 갯수를 리턴
		Node tmp=head;
		int i=0;
		while(tmp.next!=null) {
			tmp=tmp.next;
			output[i]=tmp.data;
			i++;
		}
		return i;
	}
}
