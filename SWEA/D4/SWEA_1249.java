package D4;
/*
SWEA 1249
날짜 2023.09.27
*/
import java.util.*;
import java.io.*;

class Node{
	int r;
	int c;
	Node(int r, int c){
		this.r=r;
		this.c=c;
	}
}

public class SWEA_1249 {
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		int[] dx= {0,0,-1,1};
		int[] dy= {-1,1,0,0};
		int INF=100000000;
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N=sc.nextInt();
			int[][] map=new int[N][N];
			int[][] min=new int[N][N];
			
			for(int i=0;i<N;i++) {
				String s=sc.next();
				for(int j=0;j<N;j++) {
					map[i][j]=(int)s.charAt(j)-'0';
					min[i][j]=INF;
				}
			}
			
			Queue<Node> q=new LinkedList<>();
			min[0][0]=0;
			q.add(new Node(0,0));
			while(!q.isEmpty()) {
				Node now=q.poll();
				for(int i=0;i<4;i++) {
					Node next=new Node(now.r+dx[i],now.c+dy[i]);
					if(0<=next.r && next.r<N && 0<=next.c && next.c<N) {
						if(min[now.r][now.c]+map[next.r][next.c] < min[next.r][next.c]) {
							min[next.r][next.c]=min[now.r][now.c]+map[next.r][next.c];
							q.add(next);
						}
					}
				}
			}
			System.out.printf("#%d %d",test_case,min[N-1][N-1]);
		}
	}
}
/*
 *이동 거리에 비해 복구 시간이 매우 크므로 이동 거리는 무시해도 됨. 최단거리 X
 *DFS? BFS?
 *지나간 길의 합의 가장 작아야함.
 *BFS. 모든 점까지의 최단 거리를 구하면서 목표지점까지 가면 될듯. 
 *방문처리?? 무한루프 조심. 
 *어떤 루트로 오는게 제일 작은지 확인해야함. 
 *아니면 pq써서 가장 작은 수가 있는 곳으로 가는거? 안됨. 전체적으로 파악해야 가장 작은 길 찾을 수 잇음.
 *내가 지나갔던 길을 또 갈 필요는 없음. 그러면 DFS? 재귀하면서 리턴하면 백트래킹으로 방문처리 복귀
 *전부 다 재귀 돈 다음에 min 값 구하면..
 *20초 지도 100*100
 *
 *
*/