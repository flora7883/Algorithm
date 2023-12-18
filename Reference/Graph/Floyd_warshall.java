package Graph;

import java.io.*;
import java.util.*;
/*
플로이드 워셜 알고리즘
시간 복잡도:O(V^3)
특징: 모든 정점 사이의 거리 최솟값을 구할 수 있음.
주의점: 초기화 할 때 INF 값 주의
사용하는 경우: 
- 모든 정점 사이의 거리 최솟값
- 모든 정점 사이가 연결 되어 있는지
*/
public class Floyd_warshall {
	static int INF=100001;//적당히 큰 값. 뒤에서 덧샘 연산 해야해서 MAX_VALUE로 하면 범위 벗어남.정점 수 * 간선 수 보다 크게 설정.
	static int N;
	static int M;
	static int[][] distance;
	static public void main(String[] args) throws IOException {
		distance=new int[N+1][N+1];//도시는 1~N. 0으로 초기화. 거리는 0보다 큰 자연수.
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++){
				if(i==j)
					distance[i][j]=0;
				else
					distance[i][j]=INF;
				
			}
		}
		for(int i=0;i<M;i++) {
			int a=0;//시작점
			int b=0;//도착점
			int c=0;//값
			if(c < distance[a][b]) {//더 짧은 값으로 갱신
				distance[a][b]=c;
			}
		}
		
		//floyd-warshall 알고리즘 수행
		for(int k=1;k<=N;k++) {// 경유지
			for(int i=1;i<=N;i++) {//출발지
				for(int j=1;j<=N;j++) {//도착지
					if(distance[i][j]>distance[i][k]+distance[k][j])
						distance[i][j]=distance[i][k]+distance[k][j];
				}
			}
		}
		
	}
}
