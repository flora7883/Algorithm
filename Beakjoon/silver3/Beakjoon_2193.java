package silver3;
/*
알고리즘 코딩테스트 자바 11장
백준 2193
날짜 2024.01.16
*/
import java.io.*;
import java.util.*;
public class Beakjoon_2193 {
	static long[][] dp;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		
		dp=new long[N+1][2]; //[][0]은 0으로 끝나는 이친수의 수, [][1]은 1로 끝나는 이친수의 수]
		dp[1][0]=0;
		dp[1][1]=1;
		for(int i=2;i<=N;i++) {
			dp[i][0]=dp[i-1][0]+dp[i-1][1];
			dp[i][1]=dp[i-1][0];
		}
		System.out.println(dp[N][0]+dp[N][1]);
	}

}
