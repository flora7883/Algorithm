package silver1;
/*
알고리즘 코딩테스트 자바 3장
백준 2164
날짜 2023.07.05
*/
import java.io.*;
import java.util.*;
public class Beakjoon_11286 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		PriorityQueue<Integer> pq=new PriorityQueue<>((o1,o2)->{
			int first_abs=Math.abs(o1);
			int second_abs=Math.abs(o2);
			if(first_abs==second_abs)
				return o1>o2?1:-1;//절댓값이 같으면 음수 우선 정렬
				else
					return first_abs-second_abs;//절댓값 기준으로 정렬
		});
		for(int i=0;i<N;i++) {
			int a=sc.nextInt();
			if(a==0) {//출력
				if(pq.isEmpty()) {
					System.out.println("0");
				}
				else {
					System.out.println(pq.poll());
				}
			}
			else {//추가
				pq.add(a);
			}
		}
	}

}
