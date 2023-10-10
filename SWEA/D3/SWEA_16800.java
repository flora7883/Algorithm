package D3;
/*
SWEA 16800
날짜 2023.10.06
*/
import java.util.*;
import java.io.*;
public class SWEA_16800 {
	public static void main(String[]atgs) {
		Scanner sc=new Scanner (System.in);
		int tc=sc.nextInt();
		for(int test_case=1;test_case<=tc;test_case++) {
			long N=sc.nextLong();
			long a=1;
			long b=1;
			for(long i=1;i<=Math.sqrt(N);i++) {
				if(N%i==0) {
					a=i;
					b=N/i;
				}
			}
			System.out.printf("#%d %d",test_case,a+b-2);
		}
		
	}
}
//소인수 분해 해서 합이 가장 작은 수 2개의 곱으로 표현하면 됨. N<10^12
//20=2*10==4*5, 100=5*20=25*4=10*10, 최대한 루트에 가까운 수로 선택.
//테스 뭐시기 채.