package D3;
/*
SWEA 3304
날짜 2023.09.25
*/
import java.util.*;
import java.io.*;
public class SWEA_3304 {
	public static void main(String[]args) {
		Scanner sc=new Scanner(System.in);
		int test_case=sc.nextInt();
		for(int tc=1;tc<=test_case;tc++) {
			String X=sc.next();
			String Y=sc.next();
			int x=X.length();
			int y=Y.length();
			int LCS[][]=new int[x+1][y+1];
			for(int i=0;i<=x;i++) {
				for(int j=0;j<=y;j++) {
					if(i==0 || j==0) {
						LCS[i][j]=0;
						continue;
					}
					if(X.charAt(i-1)==Y.charAt(j-1)) {
						LCS[i][j]=LCS[i-1][j-1]+1;
						continue;
					}
					LCS[i][j]=Math.max(LCS[i-1][j], LCS[i][j-1]);
				}
			}
			System.out.printf("#%d %d",tc,LCS[x][y]);
		}
	}
}
