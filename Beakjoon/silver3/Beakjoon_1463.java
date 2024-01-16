package silver3;
/*
알고리즘 코딩테스트 자바 11장
백준 1463
날짜 2024.01.16
*/
import java.io.*;
import java.util.*;

public class Beakjoon_1463 {
	static int dp[];
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int n=sc.nextInt();
		dp=new int[n+1];//1은 0임.
		for(int i=2;i<=n;i++) {
			dp[i]=dp[i-1]+1;
			if(i%2==0) {
				dp[i]=Math.min(dp[i], dp[i/2]+1);
			}
			if(i%3==0) {
				dp[i]=Math.min(dp[i], dp[i/3]+1);
			}
		}
		System.out.println(dp[n]);
	}

}
