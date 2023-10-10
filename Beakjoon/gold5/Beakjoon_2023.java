package gold5;
/*
알고리즘 코딩테스트 자바 5장
Beakjoon_2023
날짜 2023.10.10
*/
import java.io.*;
import java.util.*;

public class Beakjoon_2023 {
	static int N;
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		N=sc.nextInt();
		DFS(0);
	}
	static void DFS(int now) {
		if(!prime(now)) {
			return;
		}
		if(now/(int)Math.pow(10,N-1)!=0) {//찾음. 10^N-1으로 나눴을 때 몫이 0이 아니면 N자리수 이상.
			//Math.pow의 반환 타입은 double. int로 타입변환 해줘야 몫을 구할 수 있음.
			System.out.println(now);
			return;
		}
		for(int i=1;i<10;i++) {
			DFS(now*10+i);
		}
	}
	static boolean prime(int n) {
		int number=n;
		if(number==1)//1은 소수가 아니다.
			return false;
		for(int i=2;i<=Math.sqrt(n);i++) {
			if(number%i==0) {//나눠떨어짐. 다른 약수가 있음. 소수 아님.
				return false;
			}
		}
		return true;
	}

}
