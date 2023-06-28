package silver3;
/*
알고리즘 코딩테스트 자바 3장
백준 11659
날짜 2023.05.10
*/
import java.io.*;
import java.util.*;

public class Beakjoon_11659 {
	public static void main(String[]args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int M=sc.nextInt();
		int[] num=new int[N+1];
		int[] sum=new int[N+1];//1~i sum
		for(int i=1;i<=N;i++) {
			num[i]=sc.nextInt();
			sum[i]=sum[i-1]+num[i];
		}
		for(int i=0;i<M;i++) {
			int a=sc.nextInt();
			int b=sc.nextInt();
			System.out.println(sum[b]-sum[a-1]);
		}
	}
}