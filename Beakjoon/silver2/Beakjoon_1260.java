package silver2;
/*
알고리즘 코딩테스트 자바 5장
Beakjoon_1260
날짜 2023.10.10
*/
import java.io.*;
import java.util.*;

public class Beakjoon_1260 {
	static ArrayList<ArrayList<Integer>> map=new ArrayList<ArrayList<Integer>>();
	static boolean[] visited;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int M=sc.nextInt();
		int V=sc.nextInt();
		
		for(int i=0;i<=N;i++) {
			map.add(new ArrayList<Integer>());
		}
		for(int i=0;i<M;i++) {
			int a=sc.nextInt();
			int b=sc.nextInt();
			map.get(a).add(b);
			map.get(b).add(a);
		}
		for(int i=1;i<=N;i++) {
			Collections.sort(map.get(i));
		}
		visited=new boolean[N+1];
		visited[V]=true;
		DFS(V);
		System.out.println();
		visited=new boolean[N+1];
		BFS(V);
	}
	static void DFS(int now) {
		System.out.printf("%d ",now);
		for(int next:map.get(now)) {
			if(visited[next]) {//동일한 간선이 여러개 있을 수 있어서 여기서 방문 처리.
				continue;
			}
			visited[next]=true;
			DFS(next);
		}
	}
	
	static void BFS(int start) {
		Queue<Integer> q=new LinkedList<>();
		q.add(start);
		visited[start]=true;
		while(!q.isEmpty()) {
			int now=q.poll();
			System.out.printf("%d ",now);
			for(int next:map.get(now)) {
				if(visited[next]) {//동일한 간선이 여러개 있을 수 있어서 여기서 방문 처리.
					continue;
				}
				visited[next]=true;
				q.add(next);
			}
		}
	}
}
