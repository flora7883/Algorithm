package silver1;

/*
알고리즘 코딩테스트 자바 3장
백준 11660
날짜 2023.05.10
*/
import java.io.*;
import java.util.*;
public class Beakjoon_11660_1 {
	static public void main(String[]args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
		int[][] number=new int[N+1][N+1];
		int[][] sum=new int[N+1][N+1];
		for(int i=1;i<=N;i++) {
			st=new StringTokenizer(br.readLine());
			for(int j=1;j<=N;j++) {
				int a=Integer.parseInt(st.nextToken());
				number[i][j]=a;
				sum[i][j]=sum[i-1][j]+sum[i][j-1]-sum[i-1][j-1]+a;
			}

		}
		for(int i=0;i<M;i++) {
			st=new StringTokenizer(br.readLine());
			int x1=Integer.parseInt(st.nextToken());
			int y1=Integer.parseInt(st.nextToken());
			int x2=Integer.parseInt(st.nextToken());
			int y2=Integer.parseInt(st.nextToken());
			int result=sum[x2][y2]-sum[x1-1][y2]-sum[x2][y1-1]+sum[x1-1][y1-1];
			System.out.println(result);
		}
	}
}