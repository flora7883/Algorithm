package silver4;
/*
알고리즘 코딩테스트 자바 3장
백준 2018
날짜 2023.05.12
*/
import java.io.*;
import java.util.*;
public class Beakjoon_2018 {
	static public void main(String[]args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		int count=1;
		int sum=1;
		int start=1;
		int end=1;
		if(N==1) {
			System.out.println(count);
		}
		else {
			while(end!=Math.ceil(N/2.0)+1) {//합 원소는 N/2+1보다 클 수 없음. N 본인 제외
				if(sum<N) {
					end++;
					sum+=end;
				}
				else if(sum>N) {
					sum-=start;
					start++;
				}
				else {
					System.out.printf("%d %d\n",start,end);
					count++;
					end++;
					sum+=end;
				}
			}
			System.out.println(count);
		}
	}
}
