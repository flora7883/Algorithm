package LinkedList;

/*
Double Linked List 기본 틀
날짜 2023.08.16
*/
import java.util.*;
import java.io.*;

class DoubleNode{
	int data;
	DoubleNode prev;
	DoubleNode next;
	DoubleNode(int data){
		this.data=data;
		this.prev=null;
		this.next=null;
	}
}
public class DoubldLinkedList {
	int MAX=10000;
	DoubleNode[] poll=new DoubleNode[MAX];
	int node_count=0;
	DoubleNode head;
	DoubleNode tail;
	
	DoubleNode getNode(int data) {
		poll[node_count]=new DoubleNode(data);
		return poll[node_count++];
	}
	
	void init() {
		head=new DoubleNode(-1);
		tail=new DoubleNode(-1);
		head.next=tail;
		tail.prev=head;
	}
	
	void insertFront(int data) {
		DoubleNode node=getNode(data);
		node.next=head.next;
		node.prev=head;
		head.next.prev=node;
		head.next=node;
	}
	
	void insertLast(int data) {
		DoubleNode node=getNode(data);
		node.prev=tail.prev;
		node.next=tail;
		tail.prev.next=node;
		tail.prev=node;
	}
	
	void removeFront() {
		if(head.next==tail) {//빈 리스트
			return;
		}
		head.next.next.prev=head;
		head.next=head.next.next;
	}
	
	void removeLast() {
		if(head.next==tail) {
			return;
		}
		tail.prev.prev.next=tail;
		tail.prev=tail.prev.prev;
	}
	
	void remove(int data) {
		DoubleNode prev_node=head;//prev_node.next가 지울 노드
		while(prev_node.next!=tail && prev_node.next.data!=data) {
			prev_node=prev_node.next;
		}
		if(prev_node.next!=tail) {
			prev_node.next.next.prev=prev_node;
			prev_node.next=prev_node.next.next;
		}
	}
	
	void removeReverse(int data) {
		DoubleNode next_node=tail;//next_node.prev가 지운 노드
		while(next_node.prev!=head && next_node.prev.data!=data) {
			next_node=next_node.prev;
		}
		if(next_node.prev!=head) {
			next_node.prev.prev.next=next_node;
			next_node.prev=next_node.prev.prev;
		}
	}
	
	boolean find(int data) {
		DoubleNode node=head.next;
		while(node!=tail && node.data!=data) {
			node=node.next;
		}
		return node!=tail;
	}
	
	boolean findReverse(int data) {
		DoubleNode node=tail.prev;
		while(node!=head && node.data!=data) {
			node=node.prev;
		}
		return node!=head;
	}
	
	void print() {
		DoubleNode node=head.next;
		while(node!=tail) {
			System.out.printf("%d ",node.data);
			node=node.next;
		}
		System.out.println();
	}
	
	void printReverse() {
		DoubleNode node=tail.prev;
		while(node!=head) {
			System.out.printf("%d ",node.data);
			node=node.prev;
		}
		System.out.println();
	}
	
}
