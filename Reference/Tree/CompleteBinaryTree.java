package Tree;

/*
Complete Binary Tree(완전 이진 트리)
날짜 2023.09.06
*/
import java.util.*;
import java.io.*;
class Node{
	int key;
	Node left;
	Node right;
}
public class CompleteBinaryTree {
	
	int MAX=10000;
	Node[] poll=new Node[MAX];
	int node_count=0;
	Node root;
	
	Node newNode(int x) {
		poll[node_count].key=x;
		poll[node_count].left=null;
		poll[node_count].right=null;
		
		return poll[node_count];
	}
	
	void init() {
		root=null;
		node_count=0;
	}
	
	void insert(int x) {
		root=insertRec(root,x);
	}
	
	Node insertRec(Node node, int x) {
		if(node==null) {
			return newNode(x);
		}
		if(x<node.key) {
			node.left=insertRec(node.left,x);
		}
		else if(x>node.key){
			node.right=insertRec(node.right,x);
		}
		return node;
	}
	
	void remove(int x) {
		root=removeRec(root,x);
	}
	
	Node removeRec(Node node,int x) {
		if(node==null) {//빈 트리
			return node;
		}
		if(x<node.key) {//왼쪽 서브트리 탐색
			node.left=removeRec(node.left,x);
		}
		else if(x>node.key) {//오른쪽 서브트리 탐색
			node.right=removeRec(node.right,x);
		}
		else {//찾은 경우. 서브트리 어떻게 처리할지 결정
			if(node.left==null) {//왼쪽 서브트리가 null이면 오른쪽 노드를 현재 노드에 붙여넣음 
				return node.right;
			}
			else if(node.right==null) {//오른쪽 서브트리가 null이면 왼쪽 노드를 현재 노드에 붙여넣음
				return node.left;
			}
			//왼쪽 오른쪽이 다 있는 경우
			//오른쪽 서브트리에서 가장 작은 값은 왼쪽 서브트리의 어떤 값보다 큰게 보장됨.이 값을 삭제하는 노드에 넣어줌.
			int tmp=findMinKey(node.right);
			node.key=tmp;
			node.right=removeRec(node.right,tmp);
		}
		return node;
	}
	
	int findMinKey(Node node) {
		while(node.left!=null) {//완전 이진 트리에서 가장 왼쪽에 있는 값이 최솟값
			node=node.left;
		}
		return node.key;
	}
	
	boolean find(int x) {
		Node node=root;
		while(node!=null) {
			if(node.key==x) {
				return true;
			}
			node=x<node.key ? node.left:node.right;
		}
		return false;
	}
	
	void preOrder() {
		Stack<Node> st=new Stack<>();
		st.push(root);
		while(!st.isEmpty()) {
			Node node=st.peek();
			st.pop();
			System.out.printf("%d ",node.key);
			if(node.right!=null) st.push(node.right);
			if(node.left!=null) st.push(node.left);
		}
		System.out.println();
	}
	
	
}
