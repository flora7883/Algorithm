package platinum5;
/*
알고리즘 코딩테스트 자바 3장
백준 2891
날짜 2023.07.01
*/
import java.io.*;
import java.util.*;

class Node{
	int index;
	int data;
	Node(int index, int data){
		this.index=index;
		this.data=data;
	}
}


public class Beakjoon_11003 {
	
	static public void main(String[]args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int L=Integer.parseInt(st.nextToken());
		st=new StringTokenizer(br.readLine());
		
		Deque<Node> dq=new LinkedList<>();
		
		//Node new_node=new Node(1,Integer.parseInt(st.nextToken()));
		//dq.addLast(new_node);
		
		//System.out.printf("%d ",dq.getFirst().data);
		//bw.write(dq.getFirst().data+"");
		
		for(int i=1;i<=N;i++) {
			Node node=new Node(i,Integer.parseInt(st.nextToken()));
			int real=i-L+1;

			while(!dq.isEmpty()) {
				if(dq.getLast().data>node.data) {
					dq.removeLast();
				}
				else {
					break;
				}
			}
			
			dq.addLast(node);
			
			if(dq.getFirst().index<real) {
				dq.removeFirst();
			}
			//System.out.printf("%d ",dq.getFirst().data);
			bw.write(dq.getFirst().data+" ");
		}
		bw.flush();
		bw.close();
	}
}
