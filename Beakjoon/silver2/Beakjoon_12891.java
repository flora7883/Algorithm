package silver2;
/*
알고리즘 코딩테스트 자바 3장
백준 2891
날짜 2023.07.01
*/
import java.io.*;
import java.util.*;

public class Beakjoon_12891 {
	static public void main(String[]args) throws IOException {
		Scanner sc=new Scanner(System.in);
		int S=sc.nextInt();
		int P=sc.nextInt();
		int count=0;
		
		String DNA=sc.next();
		
		int A=sc.nextInt();
		int C=sc.nextInt();
		int G=sc.nextInt();
		int T=sc.nextInt();
		
		int A_count=0;
		int C_count=0;
		int G_count=0;
		int T_count=0;
		
		for(int i=0;i<P-1;i++) {//초기 세팅
			switch(DNA.charAt(i)){
			case 'A': A_count++;break;
			case 'C': C_count++;break;
			case 'G': G_count++;break;
			case 'T': T_count++;break;
			}
		}
		
		int start=0;
		int end=P-1;
		
		while(end<S) {
			switch(DNA.charAt(end)){
			case 'A': A_count++;break;
			case 'C': C_count++;break;
			case 'G': G_count++;break;
			case 'T': T_count++;break;
			}
			System.out.println("A: "+A_count+" C:"+C_count+" G:"+G_count+" T:"+T_count);

			if(A_count>=A&&C_count>=C&&G_count>=G&&T_count>=T) {
				count++;
				System.out.println(DNA.substring(start,end+1));
			}
			switch(DNA.charAt(start)){
			case 'A': A_count--;break;
			case 'C': C_count--;break;
			case 'G': G_count--;break;
			case 'T': T_count--;break;
			}
			start++;
			end++;
		}
		System.out.println(count);
	}
}
