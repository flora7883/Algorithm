package silver2;
/*
알고리즘 코딩테스트 자바 9장
백준 11725
날짜 2023.12.22
*/
import java.io.*;
import java.util.*;

public class Beakjoon_11725 {
	static ArrayList<ArrayList<Integer>> tree;
	static int[] parent;
	static boolean [] visited;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int N=Integer.parseInt(st.nextToken());
		tree=new ArrayList<ArrayList<Integer>>();
		for(int i=0;i<=N;i++) {
			tree.add(new ArrayList<Integer>());
		}
		parent=new int[N+1];
		visited=new boolean[N+1];
		for(int i=0;i<N-1;i++) {
			st=new StringTokenizer(br.readLine());
			int a=Integer.parseInt(st.nextToken());
			int b=Integer.parseInt(st.nextToken());
			tree.get(a).add(b);
			tree.get(b).add(a);
		}
		DFS(1);
		for(int i=2;i<=N;i++) {
			System.out.println(parent[i]);
		}
	}
	public static void DFS(int now) {
		
		for(int next:tree.get(now)) {
			if(!visited[next]) {
				visited[next]=true;
				parent[next]=now;
				DFS(next);
			}
		}
	}
}
