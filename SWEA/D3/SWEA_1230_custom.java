package D3;

/*
SWEA 1230 암호문
Linked List
날짜 2023.08.16
*/
import java.util.*;
import java.io.*;

class SWEA_1230_Node{
	int data;
	SWEA_1230_Node next;
	SWEA_1230_Node prev;
	SWEA_1230_Node(int data){
		this.data=data;
		this.next=null;
		this.prev=null;
	}
}

class SWEA_1230_LinkedList{
	SWEA_1230_Node head;
	SWEA_1230_Node tail;
	SWEA_1230_LinkedList() {
		head=new SWEA_1230_Node(-1);
		tail=new SWEA_1230_Node(-1);
		head.next=tail;
		tail.prev=head;
	}
	
	void insertFront(int data) {
		SWEA_1230_Node node=new SWEA_1230_Node(data);
		head.next.prev=node;
		node.next=head.next;
		node.prev=head;
		head.next=node;
	}
	
	void insertLast(int data) {
		SWEA_1230_Node node=new SWEA_1230_Node(data);
		tail.prev.next=node;
		node.prev=tail.prev;
		node.next=tail;
		tail.prev=node;
	}
	
	void insertNumNode(int num, SWEA_1230_Node first, SWEA_1230_Node last) {
		SWEA_1230_Node prev_node=head;
		for(int i=0;i<num;i++) {
			prev_node=prev_node.next;
		}
		prev_node.next.prev=last;
		last.next=prev_node.next;
		prev_node.next=first;
		first.prev=prev_node;
	}
	
	void insertLastNode(SWEA_1230_Node first, SWEA_1230_Node last) {
		SWEA_1230_Node prev_node=tail.prev;
		prev_node.next.prev=last;
		last.next=prev_node.next;
		prev_node.next=first;
		first.prev=prev_node;
	}
	void removeNum(int x, int y) {
		SWEA_1230_Node prev_node=head;
		SWEA_1230_Node next_node;
		for(int i=0;i<x;i++) {
			prev_node=prev_node.next;
		}
		next_node=prev_node.next;
		for(int i=0;i<y;i++) {
			next_node=next_node.next;
		}
		prev_node.next=next_node;
		next_node.prev=prev_node;
	}
	
	SWEA_1230_Node getFrontNode() {
		if(head.next==tail)
			return null;
		return head.next;
	}
	
	SWEA_1230_Node getLastNode() {
		if(tail.prev==head)
			return null;
		return tail.prev;
	}
	void print10() {
		SWEA_1230_Node node=head.next;
		for(int i=0;i<10;i++) {
			System.out.printf("%d ",node.data);
			node=node.next;
		}
		System.out.println();
	}
}

public class SWEA_1230_custom {
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int T = 10;
		for(int test_case = 1; test_case <= T; test_case++)
		{
			st=new StringTokenizer(br.readLine());
			SWEA_1230_LinkedList list=new SWEA_1230_LinkedList();
			
			int N=Integer.parseInt(st.nextToken());
			st=new StringTokenizer(br.readLine());
			for(int i=0;i<N;i++) {
				list.insertLast(Integer.parseInt(st.nextToken()));
			}
			st=new StringTokenizer(br.readLine());
			int M=Integer.parseInt(st.nextToken());
			
			st=new StringTokenizer(br.readLine());
			String D;
			SWEA_1230_LinkedList l;
			SWEA_1230_Node front;
			SWEA_1230_Node last;
			int x;
			int y;
			for(int i=0;i<M;i++) {
				D=st.nextToken();
				switch (D) {
				case "I": 
					l=new SWEA_1230_LinkedList();
					x=Integer.parseInt(st.nextToken());
					y=Integer.parseInt(st.nextToken());
					for(int j=0;j<y;j++) {
						l.insertLast(Integer.parseInt(st.nextToken()));
					}
					front=l.getFrontNode();
					last=l.getLastNode();
					list.insertNumNode(x,front,last);
					break;
					
				case "D":
					x=Integer.parseInt(st.nextToken());
					y=Integer.parseInt(st.nextToken());
					list.removeNum(x,y);
					break;
					
				case "A":
					y=Integer.parseInt(st.nextToken());
					for(int j=0;j<y;j++) {
						list.insertLast(Integer.parseInt(st.nextToken()));
					}
					break;
				}
			}
			System.out.printf("#%d ",test_case);
			list.print10();	
		}
	}

}
