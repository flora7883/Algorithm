package silver2;
/*
알고리즘 코딩테스트 자바 3장
백준 1874
날짜 2023.07.04
*/
import java.io.*;
import java.util.*;
public class Beakjoon_1874 {

	public static void main(String[] args) {
		Stack<Integer> my_stack=new Stack<>(); 
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		StringBuffer bf=new StringBuffer();
		boolean result=true;
		int num=0;//stack에 들어간 가장 큰 수
		for(int i=0;i<N;i++) {
			int A=sc.nextInt();//pop해야하는 숫자
			if(A>num) {
				while(num!=A) {
					my_stack.push(++num);
					System.out.println(A+" + "+num);
					bf.append("+\n");
				}
				//my_stack.push(++num);
				my_stack.pop();
				//System.out.println("+ "+num);
				System.out.println(A+" - "+num);
				//bf.append("+\n");
				bf.append("-\n");
			}
			else {
				int pop=my_stack.pop();
				if(pop==A) {
					System.out.println(A+" - "+num);
					bf.append("-\n");
				}
				else {
					result=false;
					System.out.println("NO");
					break;
				}
			}
		}
		if(result)
			System.out.println(bf.toString());
	}

}
