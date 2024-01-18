package DP;
/*
 * LCA: 최장 증가 부분 수열
 * 시간 복잡도: O(N*M), N, M: 문자열 길이
 * 특징: 어떤 두 수열의 최고 길이의 증가 부분 수열을 구하는 알고리즘
 * 각 문자열을 행, 열로 하는 2차원 배열로 해서 DP로 채움.
 * DP[i][j]는 A[i], B[j] 문자열의 LCA를 저장한 값임.
 * if(A[i]==B[j]) DP[i][j]=DP[i-1][j-1]+1 //두 문자가 같은 경우에는 새로 추가한 문자는 반드시 LCA에 추가됨.
 * else DP[i][j]=Math.max(DP[i-1][j], DP[i][j-1)) //두 문자가 다른 경우에는 새로 추가한 문자는 LCA에 추가되지 않음.
 * */
import java.io.*;
import java.util.*;

public class LCA {
	static long[][] dp;
	static char[] A;
	static char[] B;
	static char[] result;
	public static void main(String[] args) {
		dp=new long[A.length+1][B.length+1];
		long lcs_length=LCA();
		getResult(A.length, B.length);
	}
	static long LCA() {
		for(int i=1;i<=A.length;i++) {
			for(int j=1;j<=B.length;j++) {
				if(A[i-1]==B[j-1]) {//문자 같으면 LCA에 추가됨.
					dp[i][j]=dp[i-1][j-1]+1;
				}
				else {//다르면 LCA에 추가되지 않음. 그 전까지의 최대값으로 저장.
					dp[i][j]=Math.max(dp[i-1][j], dp[i][j-1]);
				}
			}
		}
		long result=dp[A.length][B.length];
		return result;
	}
	
	static void getResult(int i, int j) {
		int index=0;
		while(i>0 && j>0) {
			if(dp[i][j]==dp[i][j-1]) {
				j--;
			}
			else if(dp[i][j]==dp[i-1][j]){
				i--;
			}
			else {//dp[i][j]==dp[i-1][j-1]인 경우를 찾음. 즉 A[i]==B[j]인 경우가 LCA에 저장됨.
				result[index]=A[i-1];
				i--;
				j--;
				index++;
			}
		}
	}

}
