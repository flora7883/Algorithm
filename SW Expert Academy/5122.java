import java.util.Scanner;
import java.io.FileInputStream;
import java.util.LinkedList;

class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc = new Scanner(System.in);
		int T;
		T=sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N,M,L;
			int num;
			String order;
			int x,y;//x: 인덱스, y: data
			N=sc.nextInt();
			M=sc.nextInt();
			L=sc.nextInt();
			LinkedList list=new LinkedList<Integer>();
			for(int i=0;i<N;i++) {
				num=sc.nextInt();
				list.add(num);
			}
			for(int i=0;i<M;i++) {
				order=sc.next();
				switch(order) {
				case "I":
					x=sc.nextInt();
					y=sc.nextInt();
					list.add(x,y);
					break;
				case "D":
					x=sc.nextInt();
					list.remove(x);
					break;
				case "C":
					x=sc.nextInt();
					y=sc.nextInt();
					list.add(x,y);
					list.remove(x+1);
					break;
				}
			}
			
			if(L>=list.size()) 
				System.out.printf("#%d %d\n",test_case, -1);
			else
				System.out.printf("#%d %d\n",test_case, list.get(L));
		}
	}
}
