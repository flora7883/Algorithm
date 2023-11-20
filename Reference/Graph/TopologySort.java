package Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

public class TopologySort {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();//노드 수
		int M=sc.nextInt();//노드 비교 횟수
		int[] degree=new int[N+1];//노드로 들어오는 간선 갯수
		ArrayList<ArrayList<Integer>> list=new ArrayList<>();//노드에서 나가는 간선 정보
		for(int i=0;i<=N;i++) {//노드는 1부터 N까지
			list.add(new ArrayList<Integer>());
		}
		for(int i=0;i<M;i++) {//a->b
			int a=sc.nextInt();
			int b=sc.nextInt();
			list.get(a).add(b);
			degree[b]++;
		}
		Queue<Integer> q=new LinkedList<>();//노드로 들어오는 간선 수가 0이 되는 노드를 저장해둠.
		for(int i=1;i<=N;i++) {//시작 노드 찾기
			if(degree[i]==0) {
				q.add(i);
			}
		}
		while(!q.isEmpty()) {
			int now=q.poll();
			System.out.print(now+" ");
			for(int next : list.get(now)) {//연결된 노드
				degree[next]--;
				if(degree[next]==0) {
					q.add(next);
				}
			}
		}
	}

}
