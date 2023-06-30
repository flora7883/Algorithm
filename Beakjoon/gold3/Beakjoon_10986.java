package gold3;
/*
알고리즘 코딩테스트 자바 4장
백준 11986
날짜 2023.06.30
*/
import java.util.*;
import java.io.*;
public class Beakjoon_10986 {
	static public void main(String []args) throws IOException {
		BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		int N=Integer.parseInt(st.nextToken());
		int M=Integer.parseInt(st.nextToken());
	
		st=new StringTokenizer(br.readLine());
		
		int S[]=new int[N];//구간합을 M으로 나눈 나머지 저장.
		int R[]=new int[M];//S배열의 값중 0~M-1이 각각 몇개 있는지 세어서 저장.
		Long count=0L;//count는 int 범위를 벗어날 수 있음.
		
		S[0]=(Integer.parseInt(st.nextToken())%M);
		R[S[0]]++;
		System.out.printf("%d ",S[0]);
		for(int i=1;i<N;i++) {
			int a=Integer.parseInt(st.nextToken());
			S[i]=(S[i-1]+a%M)%M;
			R[S[i]]++;
			System.out.printf("%d ",S[i]);
		}
		System.out.println();
		count+=R[0];
		System.out.printf("0: %d, count: %d\n",R[0],count);
		for(int i=0;i<M;i++) {
			long n=R[i];//long으로 변환하는 이유는 다음줄에서 곱하기 연산을 하면 int범위를 넘어가기 때문. 
			//int끼리 연산했는데 int범위를 넘어가면 연산이 이상한 값으로 나옴.
			count+=(R[i]*(n-1))/2;
			System.out.printf("%d: %d, count: %d\n",i,R[i],count);
		}
		System.out.println(count);
	}
}
