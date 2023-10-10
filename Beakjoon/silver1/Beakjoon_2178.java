package silver1;
/*
알고리즘 코딩테스트 자바 5장
Beakjoon_2178
날짜 2023.10.10
*/
import java.io.*;
import java.util.*;
class Node{
	int x;
	int y;
	Node(int x, int y){
		this.x=x;
		this.y=y;
	}
}
public class Beakjoon_2178 {
	static int[][]map;
	static int[][] visited;
	static int N;
	static int M;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		N=Integer.parseInt(st.nextToken());
		M=Integer.parseInt(st.nextToken());
		map=new int[N+1][M+1];
		visited=new int[N+1][M+1];
		for(int i=1;i<=N;i++) {
			st=new StringTokenizer(br.readLine());
			String s=st.nextToken();
			for(int j=1;j<=M;j++) {
				map[i][j]=(int)s.charAt(j-1)-'0';
			}
		}
		BFS();
		
		System.out.println(visited[N][M]);
		
	}
	static void BFS() {
		int[] dx= {-1,1,0,0};
		int[] dy= {0,0,-1,1};
		Queue<Node> q=new LinkedList<>();
		q.add(new Node(1,1));
		visited[1][1]=1;
		while(!q.isEmpty()) {
			Node now=q.poll();
			if(now.x==N && now.y==M) {
				return;
			}
			for(int i=0;i<4;i++) {
				int next_x=now.x+dx[i];
				int next_y=now.y+dy[i];
				if(next_x>0 && next_x<=N && next_y>0 && next_y<=M) {
					if(map[next_x][next_y]==1 && visited[next_x][next_y]==0) {
						q.add(new Node(next_x,next_y));
						visited[next_x][next_y]=visited[now.x][now.y]+1;
					}
				}
			}
		}
	}

}
