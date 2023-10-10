package D4;
/*
SWEA 13736
날짜 2023.10.05
*/
import java.util.*;
import java.io.*;

public class SWEA_13736 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();

		for(int test_case = 1; test_case <= T; test_case++)
		{
			int A=sc.nextInt();
			int B=sc.nextInt();
			int K=sc.nextInt();
			for(int i=0;i<K;i++) {
				if(A<B) {
					B=B-A;
					A=2*A;
				}
				else if(A>B) {
					A=A-B;
					B=2*B;
				}
				else {
					B=B-A;
					A=2*A;
				}
			}
			System.out.printf("#%d %d\n",test_case,Math.min(A,B));
		}
	}

}
