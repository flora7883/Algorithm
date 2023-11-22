package D4;
/*
SWEA 1231
날짜 2023.11.22
*/
import java.util.*;
import java.io.*;


class SWEA_1231_Node{
	int num;
	String data;
	SWEA_1231_Node left;
	SWEA_1231_Node right;
	
	SWEA_1231_Node(int num, String data){//생성자
		this.num=num;
		this.data=data;
		left=null;
		right=null;
	}
}

class BinaryTree{
	private final static int MAX_NODE=1000;
	private SWEA_1231_Node[]node=new SWEA_1231_Node[MAX_NODE];
	private int nodeCnt=0;
	SWEA_1231_Node root;
	
	void init() {
		root=new SWEA_1231_Node(-1,"-1");//까먹지 말고 root 할당해주기
		nodeCnt=0;
	}
	
	public SWEA_1231_Node new_node(int num, String data) {
		node[nodeCnt]=new SWEA_1231_Node(num, data);
		return node[nodeCnt++];
	}
		
	boolean insert(int num, String data) {
		SWEA_1231_Node newNode=new_node(num, data);
		Queue<SWEA_1231_Node> q=new LinkedList<>();
		q.add(root);
		
		while(true) {
			SWEA_1231_Node tmp=q.poll();
			if(tmp.left==null) {
				tmp.left=newNode;
				break;
			}
			else {
				q.add(tmp.left);
			}
			
			if(tmp.right==null) {
				tmp.right=newNode;
				break;
			}
			else {
				q.add(tmp.right);
			}
		}
		return true;
	}
	boolean print() {
		Queue<SWEA_1231_Node> q=new LinkedList<>();
		q.add(root);
		System.out.printf("%d ", root.num);
		while(true) {
			SWEA_1231_Node tmp=q.poll();
			if(tmp.left==null) {
				break;
			}
			else {
				System.out.printf("%d ", tmp.left.num);
				q.add(tmp.left);
			}
			
			if(tmp.right==null) {
				break;
			}
			else {
				System.out.printf("%d ", tmp.right.num);
				q.add(tmp.right);
			}
		}
		return true;
	}
	void in_order(SWEA_1231_Node node){
		if(node!=null) {
			in_order(node.left);
			System.out.printf("%s",node.data);
			in_order(node.right);
		}
		
	}
}



class SWEA_1231
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		//T=sc.nextInt();
		int num;
		String data;
		int N;
		for(int test_case = 1; test_case <= 10; test_case++)
		{
			BinaryTree tree=new BinaryTree();
			tree.init();
			
			N=sc.nextInt();
			//첫째줄만 따로 처리
			num=sc.nextInt();
			data=sc.next();//문자열로 받아온다.
			sc.nextLine();//뒤의 입력내용 무시.
			tree.root.num=num;
			tree.root.data=data;

			for(int i=1;i<N;i++) {
				num=sc.nextInt();
				data=sc.next();//문자열로 받아온다.
				sc.nextLine();//뒤의 입력내용 무시.
				tree.insert(num, data);
			}
			System.out.printf("#%d ", test_case);
			tree.in_order(tree.root);
			System.out.println();
		}
	}
}