package 삼성SW역량테스트;
/*
삼성sw역량테스트 2023 상반기 오전 1번
날짜 2023.09.20
*/
import java.util.*;
import java.io.*;

class Boom{
	int r;
	int c;
	int p;//공격력
	int t;//가장 최근에 공격한 시간
	Boom(int r, int c,int p){
		this.r=r;
		this.c=c;
		this.p=p;
		t=0;
	}
}

public class 포탑부수기 {
	static int N;
	static int M;
	static int K;
	static Boom[][] map;
	static int count;//0이 아닌 포탄의 수
	static Boom[][] root;
	static boolean[][] revelant;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		M=sc.nextInt();
		K=sc.nextInt();
		count=N*M;
		map=new Boom[N+1][M+1];//1,1부터 시작
		for(int r=1;r<=N;r++) {
			for(int c=1;c<=M;c++) {
				int p=sc.nextInt();
				map[r][c]=new Boom(r,c,p);
				if(p==0)
					count--;
			}
		}
		simulation();
	}
	static void simulation() {
		for(int k=1;k<=K;k++) {
			//p 가장 센 포탑, 가장 작은 포탑 찾기
			if(count==1)
				break;
			Boom weak=findWeak();
			Boom strong=findStrong();
			revelant=new boolean[N+1][M+1];
			revelant[weak.r][weak.c]=true;
			revelant[strong.r][strong.c]=true;
			System.out.printf("count: %d, weak: %d, %d, strong: %d, %d\n",count,weak.r,weak.c,strong.r, strong.c);
			weak.p+=(N+M);
			weak.t=k;
			//레이저 공격 가능한지. bfs
			if(laser(weak,strong)) {
				trace(weak,strong);
			}
			//포탄 공격
			else {
				attack(weak,strong);
			}
			
			//나머지 포탑 +1
			for(int r=1;r<=N;r++) {
				for(int c=1;c<=M;c++) {
					if(map[r][c].p!=0 && !revelant[r][c])
						map[r][c].p+=1;
				}
			}
			strong.p-=weak.p;//목표물 공격.
			if(strong.p<=0) {
				strong.p=0;
				count--;
			}
			
			for(int r=1;r<=N;r++) {
				for(int c=1;c<=M;c++) {
					System.out.printf("%d ",map[r][c].p);
				}
				System.out.println();
			}
		}
		//가장 센 포탄 출력. 종료
		System.out.println(findStrong().p);
	}
	static Boom findWeak() {
		Boom weak=new Boom(0,0,5001);
		for(int r=1;r<=N;r++) {
			for(int c=1;c<=M;c++) {
				Boom now=map[r][c];
				if(now.p==0)
					continue;
				if(now.p<weak.p) {//now의 공격력이 더 약함.
					weak=now;
				}
				else if(now.p==weak.p) {
					if(weak.t<now.t) {//now가 더 최근에 공격. t가 큼
						weak=now;
					}
					else if(weak.t==now.t) {
						if(weak.r+weak.c<now.r+now.c) {//now의 행+열이 더 큼.
							weak=now;
						}
						else if(weak.r+weak.c==now.r+now.c) {
							if(weak.c<now.c) {//now의 열이 더 큼.
								weak=now;
							}
						}
					}
				}
			}
		}
		return weak;
	}
	static Boom findStrong() {
		Boom strong=new Boom(0,0,-1);
		for(int r=1;r<=N;r++) {
			for(int c=1;c<=M;c++) {
				Boom now=map[r][c];
				if(now.p>strong.p) {//now의 공격력이 더 셈.
					strong=now;
				}
				else if(now.p==strong.p) {
					if(strong.t>now.t) {//now가 더 예전에 공격. t가 작음
						strong=now;
					}
					else if(strong.t==now.t) {
						if(strong.r+strong.c>now.r+now.c) {//now의 행+열이 더 작음.
							strong=now;
						}
						else if(strong.r+strong.c==now.r+now.c) {
							if(strong.c>now.c) {//now의 열이 더 작음.
								strong=now;
							}
						}
					}
				}
			}
		}
		return strong;
	}
	
	static boolean laser(Boom weak, Boom strong) {
		int[] dr= {0,1,0,-1};
		int[] dc= {1,0,-1,0};
		boolean[][]visited=new boolean[N+1][M+1];
		root=new Boom[N+1][M+1];//다음거에 지금을 저장해줌
		Queue<Boom> q=new LinkedList<>();
		q.add(weak);
		visited[weak.r][weak.c]=true;
		while(!q.isEmpty()) {
			Boom now=q.poll();
			System.out.printf("%d %d\n",now.r, now.c);
			if(now==strong) {
				return true;
			}
			for(int i=0;i<4;i++) {
				int next_r=changeR(now.r+dr[i]);
				int next_c=changeC(now.c+dc[i]);
				if(map[next_r][next_c].p!=0 && !visited[next_r][next_c]) {
					visited[next_r][next_c]=true;
					q.add(map[next_r][next_c]);
					root[next_r][next_c]=now;
				}
			}
		}
		return false;
	}
	static void trace(Boom weak,Boom strong) {
		System.out.println("laser");
		Boom before=root[strong.r][strong.c];
		while(before!=weak) {
			before.p-=(weak.p/2);
			revelant[before.r][before.c]=true;
			if(before.p<=0) {
				before.p=0;
				count--;
			}
			System.out.printf("%d, %d :%d -> ",before.r,before.c,before.p);
			before=root[before.r][before.c];
		}
		System.out.println();
	}
	static void attack(Boom weak, Boom strong) {
		System.out.println("atack");
		int r=strong.r-1;
		int c=strong.c-1;
		for(int i=0;i<3;i++) {
			for(int j=0;j<3;j++) {
				int changed_r=changeR(r+i);
				int changed_c=changeC(c+j);
				if(map[changed_r][changed_c]!=weak && map[changed_r][changed_c]!=strong && map[changed_r][changed_c].p!=0) {
					map[changed_r][changed_c].p -= weak.p/2;
					revelant[changed_r][changed_c]=true;
					if(map[changed_r][changed_c].p<=0) {
						map[changed_r][changed_c].p=0;
						count--;
					}
				}
				System.out.printf("%d, %d :%d -> ",changed_r,changed_c,map[changed_r][changed_c].p);
			}
		}
		System.out.println();
	}
	static int changeR(int r) {
		if(r==0) 
			return N;
		else if(r==N+1)
			return 1;
		else
			return r;
	}
	static int changeC(int c) {
		if(c==0) 
			return M;
		else if(c==M+1)
			return 1;
		else
			return c;
	}
	
}

/*
 * 포탑. 공격 시기 값 가지고 있어야됨. 
 * 포탑을 priority queue로 관리? x. 계속 업데이트 해줘야됨. 그냥 격자 다 돌면서 고르기.
 * 좌우, 상하가 연결되어 있음. bfs 주의. 
 * 공격받은 칸 아닌 곳을 +1씩 해줘야함. 
 * k번 공격 후 남아있는 포탑 중 가장 강한 포탑의 공격력 출력.
 * 1개만 남으면 즉시 종료. -> count=1이면.
 */