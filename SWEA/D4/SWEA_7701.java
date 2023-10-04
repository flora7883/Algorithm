package D4;
/*
SWEA 7701
날짜 2023.10.04
*/
import java.util.*;
import java.io.*;

public class SWEA_7701 {

	public static void main(String[] args) throws IOException {
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		int T=Integer.parseInt(br.readLine());
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N=Integer.parseInt(br.readLine());
			HashSet<String> set=new HashSet<>();

			for(int i=0;i<N;i++) {
				String s=br.readLine();
				set.add(s);
			}
			ArrayList<String> list=new ArrayList<>(set);
			list.sort((o1,o2)->{
				int result=o1.length()-o2.length();
				if(result==0) {//길이가 같은 경우
					if(o1.compareTo(o2)<0) {//o1이 o2보다 우선순위 높음. 
						result=-1;
					}
					else {
						result=1;
					}
				}
				return result;
			});
			Collections.sort(list);
			bw.write("#"+String.valueOf(test_case)+"\n");
			for(String s:list) {
				bw.write(s+"\n");
			}
			bw.flush();
		}
	}
}
