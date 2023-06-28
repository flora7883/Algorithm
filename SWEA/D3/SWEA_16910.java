package D3;
/*
SWEA 16910
날짜 2023.05.21
*/
import java.util.*;
import java.io.*;
public class SWEA_16910 {
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int r=sc.nextInt();
			int r2=(int) Math.pow(r, 2);
			int start=0;
			int end=1;
			int same=0;
			int diff=0;
			int diff_zero=0;
			while(start<=r) {
				if((int) Math.pow(start, 2)+(int) Math.pow(end, 2)<=r2) {
					if(end==start) {
						same++;
					}
					else {
						if(start==0)
							diff_zero++;
						else
							diff++;
					}
					end++;
				}
				else {
					start++;
					end=start;
				}
			}
			int answer=same*4+diff*8+diff_zero*4+1;
			System.out.printf("#%d %d\n",test_case,answer);
		}
	}
}
