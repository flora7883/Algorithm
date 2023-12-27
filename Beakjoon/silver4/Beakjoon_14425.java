package silver4;
/*
알고리즘 코딩테스트 자바 9장
백준 14425
날짜 2023.12.26
*/
import java.io.*;
import java.util.*;

public class Beakjoon_14425 {

	public static void main(String[] args) {
		Scanner sc=new Scanner (System.in);
		int N=sc.nextInt();
		int M=sc.nextInt();
		HashSet<String> set=new HashSet<>();
		for(int i=0;i<N;i++) {
			set.add(sc.next());
		}
		int count=0;
		for(int i=0;i<M;i++) {
			String s=sc.next();
			if(set.contains(s))
				count++;
		}
		System.out.println(count);
	}

}
