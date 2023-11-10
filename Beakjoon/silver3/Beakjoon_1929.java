package silver3;
/*
알고리즘 코딩테스트 자바 7장
백준 1929
날짜 2023.11.10
*/
import java.io.*;
import java.util.*;

public class Beakjoon_1929 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int M=sc.nextInt();
		int N=sc.nextInt();
		int[] check=new int[N+1];
		for(int i=0;i<=N;i++) {
			check[i]=i;
		}
		check[0]=0;
		check[1]=0;
		for(int i=2;i<=Math.sqrt(N+1);i++) {
			if(check[i]==0)
				continue;
			for(int j=i+i;j<=N;j=j+i) {//i의 배수 찾기
				check[j]=0;
			}
		}
		for(int i=M;i<=N;i++) {
			if(check[i]!=0)
				System.out.println(i);
		}
	}

}
