package bronze1;
/*
알고리즘 코딩테스트 자바 7장
Beakjoon_1934
날짜 2023.11.14
*/
import java.io.*;
import java.util.*;

public class Beakjoon_1934 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int T=sc.nextInt();
		for(int t=0;t<T;t++) {
			int A=sc.nextInt();
			int B=sc.nextInt();
			int a=A;
			int b=B;
			System.out.println(A*B/GCD(A,B));
			int result=1;
			while(a%b!=0) {
				int tmp=a;
				a=b;
				b=tmp%b;//위 연산으로 A값이 변경됨. tmp에 저장해둔 값으로 연산.
				result=b;

			}
			//System.out.println(A*B/result);
		}
		
	}
	static int GCD(int a, int b) {
		if(b==0) {
			return a;//종료조건
		}
		return GCD(b,a%b);
	}

}
