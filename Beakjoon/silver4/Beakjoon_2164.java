package silver4;
/*
알고리즘 코딩테스트 자바 3장
백준 2164
날짜 2023.07.05
*/
import java.io.*;
import java.util.*;
public class Beakjoon_2164 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		Queue<Integer> q=new LinkedList<>();
		for(int i=1;i<=N;i++) {
			q.add(i);
		}
		int result=0;
		while(!q.isEmpty()) {
			result=q.poll();
			if(!q.isEmpty()) {
				result=q.poll();
				q.add(result);
			}
		}
		System.out.println(result);
	}

}
