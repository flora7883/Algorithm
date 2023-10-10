package gold5;
/*
알고리즘 코딩테스트 자바 5장
Beakjoon_13023
날짜 2023.10.10
*/
import java.io.*;
import java.util.*;

public class Beakjoon_13023 {
	static ArrayList<ArrayList<Integer>> map = new ArrayList<ArrayList<Integer>>();
	static boolean[] visited;
	static boolean find;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int M=sc.nextInt();
		
		for(int i=0;i<N;i++) {
			map.add(new ArrayList<Integer>());//map 초기화
		}
		visited=new boolean[N];
		for(int i=0;i<M;i++) {
			int a=sc.nextInt();
			int b=sc.nextInt();
			map.get(a).add(b);
			map.get(b).add(a);
		}
		
		for(int i=0;i<N;i++) {
			if(!visited[i]) {
				DFS(i,0);
			}
			if(find)
				break;
		}
		if(find)
			System.out.println(1);
		else
			System.out.println(0);
		
	}
	static void DFS(int now, int depth) {
		visited[now]=true;
		if(depth==4 || find) {
			find=true;
			return;
		}
		for(int next:map.get(now)) {
			if(!visited[next]) {
				DFS(next,depth+1);
			}
		}
		visited[now]=false;
	}

}
