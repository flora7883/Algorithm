package bronze1;
/*
알고리즘 코딩테스트 자바 3장
백준 1546
날짜 2023.05.10
*/
import java.io.*;
import java.util.*;

public class Beakjoon_1546 {
	public static void main(String[]args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int[] score=new int[N];
		int max=0;
		Double sum=0.0;
		for(int i=0;i<N;i++) {
			int a=sc.nextInt();
			score[i]=a;
			sum+=a;
			if(a>max)
				max=a;
		}
		System.out.println(sum/max*100/N);
	}
}
