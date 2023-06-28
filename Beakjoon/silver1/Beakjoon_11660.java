package silver1;
/*
알고리즘 코딩테스트 자바 3장
백준 11660
날짜 2023.05.10
*/
import java.io.*;
import java.util.*;
public class Beakjoon_11660 {
	static public void main(String[]args) {
		Scanner sc=new Scanner(System.in);
		
		int N=sc.nextInt();
		int M=sc.nextInt();
		int[][] number=new int[N+1][N+1];
		int[][] sum=new int[N+1][N+1];
		for(int i=1;i<=N;i++) {
			for(int j=1;j<=N;j++) {
				int a=sc.nextInt();
				number[i][j]=a;
				sum[i][j]=sum[i-1][j]+sum[i][j-1]-sum[i-1][j-1]+a;
			}

		}
		for(int i=0;i<M;i++) {
			int x1=sc.nextInt();
			int y1=sc.nextInt();
			int x2=sc.nextInt();
			int y2=sc.nextInt();
		
			System.out.printf("%d\n",sum[x2][y2]-sum[x1-1][y2]-sum[x2][y1-1]+sum[x1-1][y1-1]);
		}
	}
}