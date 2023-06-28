package gold5;
/*
알고리즘 코딩테스트 자바 3장
백준 1253
날짜 2023.05.12
*/
import java.io.*;
import java.util.*;

public class Beakjoon_1253 {
	static public void main(String[]args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st=new StringTokenizer(br.readLine());
		
		int N=Integer.parseInt(st.nextToken());
		int[] A=new int[N];
		st=new StringTokenizer(br.readLine());
		for(int i=0;i<N;i++) {
			A[i]=Integer.parseInt(st.nextToken());
		}
		//정렬
		Arrays.sort(A);
		//투포인터
		int t;
		int start;
		int end;
		int count=0;
		for(int i=0;i<N;i++) {
			t=A[i];
			start=0;//시작
			end=N-1;//끝
			//**음수도 가능하므로 end를 맨 끝부터 해줘야함. 음수가 불가능하면 t-1로 해줘도 됨.
			while(start<end) {
				if(A[start]+A[end]==t) {//좋은 수5
					if(start!=i&&end!=i) {
						count++;
						break;
					}
					else if(start==i) {//자기자신은 제외
						start++;
					}
					else if(end==i) {//자기자신은 제외
						end--;
					}
				}
				else if(A[start]+A[end]<t) {
					start++;
				}
				else {
					end--;
				}
			}
		}
		System.out.println(count);
	}
}
