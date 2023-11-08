package silver4;
/*
알고리즘 코딩테스트 자바 6장
Beakjoon_11047
날짜 2023.11.08
*/
import java.io.*;
import java.util.*;

public class Beakjoon_11047 {
	static public void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int K=sc.nextInt();
		int sum=0;
		int result=0;
		int[] coin=new int[N];
		for(int i=0;i<N;i++) {
			coin[i]=sc.nextInt();
		}
		int index=N-1;
		while(sum!=K) {
			if(sum+coin[index]<=K) {
				sum+=coin[index];
				result++;
			}
			else {
				index--;
			}
		}
		System.out.println(result);
	}
}