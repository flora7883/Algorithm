package gold3;
/*
알고리즘 코딩테스트 자바 4장
백준 11986
날짜 2023.06.30
*/
import java.util.*;
import java.io.*;

public class Beakjoon_10986_1 {
	static public void main(String []args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
	
		st=new StringTokenizer(br.readLine());
		
		long S[]=new long[N];//구간합
		long R[]=new long[M];//나머지 갯수
		long count=0;
		
		S[0]=(long) Integer.parseInt(st.nextToken());
		for(int i=1;i<N;i++) {
			S[i]=S[i-1]+Integer.parseInt(st.nextToken());
		}
		for(int i=0;i<N;i++) {
			int r=(int)(S[i]%M);
			if(r==0)
				count++;
			R[r]++;
		}
		for(int i=0;i<M;i++) {
			count+=R[i]*(R[i]-1)/2;
		}
		System.out.println(count);
	}
}
