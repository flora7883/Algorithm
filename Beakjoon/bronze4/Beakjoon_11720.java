package bronze4;
/*
알고리즘 코딩테스트 자바 3장
백준 11720
날짜 2023.04.19
*/
import java.io.*;
import java.util.*;

public class Beakjoon_11720 {
	public static void main(String[]args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		String sNum=sc.next();//string 입력 받기
		char[]cNum=sNum.toCharArray();
		int sum=0;
		for(int i=0;i<cNum.length;i++) {
			sum+=cNum[i]-'0';//char를 int로 형변환해서 더해주기
		}
		System.out.print(sum);
	}
}