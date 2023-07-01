package silver4;
/*
알고리즘 코딩테스트 자바 3장
백준 1940
날짜 2023.07.01
*/
import java.io.*;
import java.util.*;
public class Beakjoon_1940 {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int M=sc.nextInt();
		int count=0;
		int [] list=new int[N];
		for(int i=0;i<N;i++) {
			list[i]=sc.nextInt();
		}
		Arrays.sort(list);
		int start=0;
		int end=N-1;
		while(start!=end) {
			if(list[start]+list[end]>M) {
				end--;
			}
			else if(list[start]+list[end]<M) {
				start++;
			}
			else {
				count++;
				start++;
			}
		}
		System.out.println(count);
	}
}
