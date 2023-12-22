package Graph;

import java.util.PriorityQueue;
import java.util.StringTokenizer;


class Edge_MinimumSpanningTree{
	int s;
	int e;
	int w;
	Edge_MinimumSpanningTree(int s, int e, int w){
		this.s=s;
		this.e=e;
		this.w=w;
	}
}
public class MinimumSpanningTree {
	static int N;
	static PriorityQueue<Edge_MinimumSpanningTree> pq;
	static int[] parent;
	public static void main(String[] args) {
		pq=new PriorityQueue<>((o1,o2)->{
			return o1.w-o2.w;
		});
		parent=new int[N+1];	
		for(int i=1;i<=N;i++) {
			parent[i]=i;
		}
		for(int i=0;i<N;i++) {
			for(int j=0;j<N;j++) {
				int w=0;
				pq.add(new Edge_MinimumSpanningTree(i,j,w));
			}
		}
	}
	static int minimum_spanning_tree1() {
		int count=0;
		int result=0;
		while(!pq.isEmpty()) {
			Edge_MinimumSpanningTree edge=pq.poll();
			if(find(edge.s)!=find(edge.e)) {
				union(edge.s,edge.e);
				result+=edge.w;
				count++;
			}
			if(count==N-1)
				return result;
		}
		return -1;
	}
	static int minimum_spanning_tree2() {
		int count=0;
		int result=0;
		while(count<=N-1) {
			Edge_MinimumSpanningTree edge=pq.poll();
			if(find(edge.s)!=find(edge.e)) {
				union(edge.s,edge.e);
				result+=edge.w;
				count++;
			}
		}
		return result;
	}
	public static void union(int a, int b) {
		int parent_a=find(a);
		int parent_b=find(b);
		parent[parent_a]=parent_b;
	}
	public static int find(int a) {
		if(parent[a]==a)
			return a;
		return parent[a]=find(parent[a]);
	}
}
