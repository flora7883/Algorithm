package gold2;
/*
알고리즘 코딩테스트 자바 5장
백준 1167
날짜 2023.05.13
*/
import java.io.*;
import java.util.*;
class Node{
	int id;
	int dis;
	Node(int id, int dis) {
		this.id=id;
		this.dis=dis;
	}
}
public class Beakjoon_1167 {
	static boolean[] visited;
	static int[] distance;
	static ArrayList<Node>[] A;
	static public void main(String[]args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		visited=new boolean[N+1];
		distance=new int[N+1];
		A=new ArrayList[N+1];
		for(int i=1;i<=N;i++) {
			A[i]=new ArrayList<Node>();
		}
		for(int i=0;i<N;i++) {
			st=new StringTokenizer(br.readLine());
			int node=Integer.parseInt(st.nextToken());
			while(true) {
				int n=Integer.parseInt(st.nextToken());
				if(n==-1)
					break;
				int d=Integer.parseInt(st.nextToken());
				A[node].add(new Node(n,d));
				A[n].add(new Node(node,d));
			}
		}		
		BFS(1);
		
		int max=1;
		for(int i=2;i<N+1;i++) {
			if(distance[max]<distance[i])
				max=i;
		}
		for(int i=0;i<N+1;i++) {
			visited[i]=false;
			distance[i]=0;
		}
		BFS(max);
		Arrays.sort(distance);
		System.out.println(distance[N]);
	}
	static void BFS(int start) {
		Queue<Integer> q=new LinkedList<Integer>();
		q.add(start);
		visited[start]=true;
		while(!q.isEmpty()) {
			int a=q.poll();
			
			for(Node n:A[a]) {
				int id=n.id;
				int dis=n.dis;
				if(!visited[id]) {
					q.add(id);
					visited[id]=true;
					distance[id]=distance[a]+dis;
				}
			}
		}
	}
}
