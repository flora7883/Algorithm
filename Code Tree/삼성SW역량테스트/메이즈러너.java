package 삼성SW역량테스트;

/*
삼성sw역량테스트 2023 상반기 오후 1번
날짜 2023.09.19
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

public class 메이즈러너 {
	static int map[][];//나중에 N으로 할당
	static int N;//map 크기
	static int M;//player수
	static int K;//초
	static int dis=0;//player가 움직인 거리
	static Node exit;//출구
	static int count;//남아있는 player 수
	static Node start;
	static Node end;
	static int length;
	static ArrayList<Node> player=new ArrayList<>();
	
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		M=sc.nextInt();
		K=sc.nextInt();
		count=M;
		map=new int[N+1][N+1];//1,1부터 시작
		for(int r=1;r<=N;r++) {
			for(int c=1;c<=N;c++) {
				map[r][c]=sc.nextInt();
			}
		}
		
		for(int p=0;p<M;p++) {
			int r=sc.nextInt();
			int c=sc.nextInt();
			player.add(new Node(r,c));
		}
		int r=sc.nextInt();
		int c=sc.nextInt();
		
		exit=new Node(r,c);
		map[r][c]=-1;
		simulation();
		
	}
	static void simulation() {
		for(int i=0;i<K;i++) {
			for(Iterator<Node> iterator = player.iterator(); iterator.hasNext();) {
				Node p= iterator.next();
				move(p,iterator);
				}
			if(count==0) {//다 탈출함
				break;
			}
			rotation();
		}
		System.out.println(dis);
		System.out.printf("%d %d\n", exit.r, exit.c);
		
	}
	static void move(Node p,Iterator<Node> iterator) {//player 상하좌우로 움직임.탈출한지 확인.
		int[] dr= {-1,1,0,0};
		int[] dc= {0,0,-1,1};
		for(int i=0;i<4;i++) {
			if(canGo(p.r+dr[i],p.c+dc[i])) {
				if(fast(p.r,p.c,p.r+dr[i],p.c+dc[i])) {
					p.r+=dr[i];
					p.c+=dc[i];
					dis++;
					if(p.r==exit.r && p.c==exit.c) {//탈출
						iterator.remove();
						count--;
					}
					break;
				}
			}
		}
	}
	
	static boolean fast(int r1, int c1, int r2, int c2) {
		if(Math.abs(r2-exit.r)+Math.abs(c2-exit.c)<Math.abs(r1-exit.r)+Math.abs(c1-exit.c)) {
			return true;
		}
		return false;
	}
	static boolean canGo(int r, int c) {
		if(1<=r && r<=N && 1<=c && c<=N && map[r][c]<=0) {
			return true;
		}
		return false;
	}
	
	static void rotation() {//90도 돌림.
		
		square();
		//map update, player update
		//복사본 만들기
		int[][] copy=new int[length][length];
		for(int i=0;i<length;i++) {
			for(int j=0;j<length;j++) {
				if(map[start.r+i][start.c+j]>0) {
					copy[i][j]=map[start.r+i][start.c+j]-1;
				}
				else {
					copy[i][j]=map[start.r+i][start.c+j];
				}
			}
		}
		
		for(int i=0;i<length;i++) {
			for(int j=0;j<length;j++) {
				map[start.r+j][end.c-i]=copy[i][j];
				if(copy[i][j]==-1) {
					exit.r=start.r+j;
					exit.c=end.c-i;
				}
			}
		}
		for(Node n:player) {
			if(start.r<=n.r && n.r<=end.r && start.c<=n.c && n.c<=end.c) {
				int r=n.r;
				int c=n.c;
				n.r=start.r+c-start.c;
				n.c=end.c-r+start.r;
			}
		}
	}
	static void square() {

		for(int i=2;i<=N;i++) {
			for(int r1=1;r1<=N-i+1;r1++) {
				for(int c1=1;c1<=N-i+1;c1++) {
					int r2=r1+i-1;
					int c2=c1+i-1;
					
					if(!(r1<=exit.r && exit.r<=r2 && c1<=exit.c && exit.c<=c2)) {//출구가 박스 사각형 안에 없으면
						continue;
					}
					
					for(Node p:player) {
						if(r1<=p.r && p.r<=r2 && c1<=p.c && p.c<=c2) {
							System.out.println("find square");
							length=i;
							start=new Node(r1,c1);
							end=new Node(r2,c2);
							return;
						}
					}

				}

			}

		}
	}
	static Node find() {
		int min=20;
		int r=10;
		int c=10;
		for(Node p:player) {
			int a=Math.max(Math.abs(p.r-exit.r),Math.abs(p.c-exit.c));
			if(a<min) {
				min=a;
				r=p.r;
				c=p.c;
			}
			else if(a==min){
				if(p.r<r) {
					r=p.r;
					c=p.c;
				}
				else if(p.r==r) {
					if(p.c<c) {
						r=p.r;
						c=p.c;
					}
				}
			}
		}
		return new Node(r,c);
	}

}
/* class Node (r,c)
 * 
 * N*N 격자 int [][]
 * 참가자 set  Node set. 출구 도착하면 지우기.
 * 
 * 상하좌우 갈 수 있는지 확인해서 이동하는 함수.
 * 90도 회전 함수. 격자, 참가자 r, c 변경
 * 
 */