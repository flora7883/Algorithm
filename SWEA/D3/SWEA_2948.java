package D3;
/*
SWEA 2948
날짜 2023.10.04
*/
import java.util.*;
import java.io.*;

public class SWEA_2948 {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N=sc.nextInt();
			int M=sc.nextInt();
			int count=0;
			HashSet<String> set=new HashSet<>();
			for(int i=0;i<N;i++) {;
				set.add(sc.next());
			}
			for(int i=0;i<M;i++) {
				String s=sc.next();
				if(set.contains(s)) {
					count++;
				}
			}
			System.out.printf("#%d %d\n",test_case,count);
		}
	}

}
