package D3;
/*
SWEA 2930
날짜 2023.09.27
*/
import java.util.*;
import java.io.*;

public class SWEA_2930 {

	public static void main(String[] args) throws IOException {
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		Scanner sc=new Scanner(System.in);
		int test_case=sc.nextInt();
		
		for(int tc=1;tc<=test_case;tc++) {
			int N=sc.nextInt();
			PriorityQueue<Integer> pq=new PriorityQueue<>(Collections.reverseOrder());
			bw.write("#"+ String.valueOf(tc)+" ");
			
			for(int i=0;i<N;i++) {
				int info=sc.nextInt();
				
				switch(info) {
				case 1://삽입
					int x=sc.nextInt();
					pq.add(x);
					break;
				case 2://최대값 출력
					if(pq.isEmpty())
						bw.write(String.valueOf(-1)+" ");
					else {
						bw.write(String.valueOf(pq.poll())+" ");
					}
					break;
				}	
			}
			bw.write("\n");
		}
		bw.flush();
	}

}
