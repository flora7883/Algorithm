package silver3;
/*
알고리즘 코딩테스트 자바 11장
백준 14501
날짜 2024.01.16
*/
import java.io.*;
import java.util.*;
public class Beakjoon_14501 {
	static int[] dp;
	static int[] d;
	static int[] p;
	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		dp=new int[N+2];//N+1일까지 나타내야함.
		d=new int[N+1];//걸리는 날짜
		p=new int[N+1];//얻을 수 있는 포인트
		for(int i=1;i<=N;i++) {
			st=new StringTokenizer(br.readLine());
			d[i]=Integer.parseInt(st.nextToken());
			p[i]=Integer.parseInt(st.nextToken());
		}
		
		for(int i=N;i>0;i--) {
			if(i+d[i]>N+1) {//오늘 시작한 상담을 퇴직일까지 못끝냄
				dp[i]=dp[i+1];
			}
			else {
				dp[i]=Math.max(dp[i+1], p[i]+dp[i+d[i]]);
			}
		}
		System.out.println(dp[1]);
	}

}
