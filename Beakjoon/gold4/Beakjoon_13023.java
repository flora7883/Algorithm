package gold4;
/*
알고리즘 코딩테스트 자바 5장
백준 13023
날짜 2023.05.13
*/
import java.io.*;
import java.util.*;
public class Beakjoon_13023 {
	static ArrayList<Integer>[] A;
	static boolean[] visited;
	static boolean flag=false;
	public static void main(String[]args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int M=sc.nextInt();
		
		A=new ArrayList[N];
		for(int i=0;i<N;i++) {
			A[i]=new ArrayList<Integer>();
			//배열 안에 arratList가 들어가야하므로 배열 한칸마다 객체 할당
		}
		visited=new boolean[N];
		
		for(int i=0;i<M;i++) {
			int a=sc.nextInt();
			int b=sc.nextInt();
			A[a].add(b);
			A[b].add(a);
		}
		for(int i=0;i<N;i++) {
			DFS(i,0);
			visited[i]=false;//i방문도 flase처리 해줘야 함.
			if(flag)
				break;
		}
		if(flag)
			System.out.println("1");
		else
			System.out.println("0");
	}
	static void DFS(int n,int depth) {
		if(depth==4||flag) {
			flag=true;
			return;
		}
		visited[n]=true;
		for(int i:A[n]) {//i는 n의 친구
			if(!visited[i]) {
				DFS(i,depth+1);
				visited[i]=false;
			}
		}
	}
}
