package gold4;
/*
알고리즘 코딩테스트 자바 6장
백준 1715
날짜 2023.11.08
*/
import java.io.*;
import java.util.*;

public class Beakjoon_1715 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int sum=0;
		PriorityQueue<Integer> pq=new PriorityQueue<>();
		for(int i=0;i<N;i++) {
			pq.add(sc.nextInt());
		}
		
		while(pq.size()!=1){
			int a=pq.poll();
			int b=pq.poll();
			sum+=a+b;
			pq.add(a+b);
		}
		System.out.println(sum);
	}

}
