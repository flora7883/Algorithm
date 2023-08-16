package LinkedList;

/*
Single Linked List 기본 틀
날짜 2023.08.16
*/
import java.util.*;
import java.io.*;

class SingleNode{
	int data;
	SingleNode next;
	
	SingleNode(int data){
		this.data=data;
		this.next=null;
	}
}

public class SingleLinkedList {
	
	int MAX=100000;
	SingleNode[] poll=new SingleNode[MAX];
	int node_count=0;
	SingleNode head;
	
	SingleNode getNode(int data) {
		poll[node_count]=new SingleNode(data);
		return poll[node_count++];
	}
	
	void init() {
		head=new SingleNode(-1);
	}
	
	void insertFront(int data) {
		SingleNode node=getNode(data);
		node.next=head.next;
		head.next=node;
	}
	
	void insertLast(int data) {
		SingleNode node=getNode(data);
		SingleNode pre_node=head;
		while(pre_node.next!=null) {
			pre_node=pre_node.next;
		}
		pre_node.next=node;
	}
	
	void removeFront() {
		if(head.next!=null) {
			head.next=head.next.next;
		}
	}
	
	void removeLast() {
		SingleNode pre_node=head;//pre_node.next가 지울 노드
		if(pre_node.next==null){//아무것도 없는 리스트
			return;
		}
		while(pre_node.next.next!=null) {
			pre_node=pre_node.next;
		}
		pre_node.next=pre_node.next.next;
		
	}
	void remove(int data) {
		SingleNode pre_node=head;//pre_node.next가 지운 노드
		while(pre_node.next!=null && pre_node.next.data!=data) {
			pre_node=pre_node.next;
		}
		if(pre_node.next!=null) {
			pre_node.next=pre_node.next.next;
		}
	}
	
	boolean find(int data) {
		SingleNode node=head.next;//node가 찾는 노드
		while(node!=null && node.data!=data) {
			node=node.next;
		}
		return node!=null;//node가 null이면 못찾음.
	}
	
	void print() {
		SingleNode node=head.next;
		while(node!=null) {
			System.out.printf("%d ",node.data);
			node=node.next;
		}
		System.out.println();
	}
}
