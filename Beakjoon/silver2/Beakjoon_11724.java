package silver2;
/*
알고리즘 코딩테스트 자바 5장
Beakjoon_11724
날짜 2023.10.10
*/
import java.util.*;
import java.io.*;

public class Beakjoon_11724 {
	static ArrayList<ArrayList<Integer>> list=new ArrayList<ArrayList<Integer>>();
	static boolean[]check;
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int M=sc.nextInt();
		check=new boolean[N+1];
		int count=0;
		for(int i=0;i<=N;i++) {
			list.add(new ArrayList<Integer>());
		}
		for(int i=0;i<M;i++) {
			int a=sc.nextInt();
			int b=sc.nextInt();
			list.get(a).add(b);
			list.get(b).add(a);
		}
		for(int i=1;i<=N;i++) {
			if(!check[i]) {
				count++;
				DFS(i);
			}
		}
		System.out.println(count);	
	}
	static void DFS(int now) {
		check[now]=true;
		for(int i : list.get(now)) {//now에 연결된 노드들 가져오기
			if(!check[i]) {//이미 연결되지 않은 노드만 DFS
				DFS(i);
			}
		}
	}

}
