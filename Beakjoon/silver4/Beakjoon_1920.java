package silver4;
/*
알고리즘 코딩테스트 자바 5장
Beakjoon_1920
날짜 2023.11.07
*/
import java.io.*;
import java.util.*;
public class Beakjoon_1920 {

	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
		int N=sc.nextInt();
		ArrayList<Integer> list=new ArrayList<>();
		for(int i=0;i<N;i++) {
			list.add(sc.nextInt());
		}
		Collections.sort(list);
		int M=sc.nextInt();
		for(int i=0;i<M;i++) {
			int x=sc.nextInt();
			int start=0;
			int finish=N-1;
			boolean find=false;
			while(start<=finish) {
				int mid=(start+finish)/2;
				if(x<list.get(mid)) {
					finish=mid-1;
				}
				else if(list.get(mid)<x){
					start=mid+1;
				}
				else {
					find=true;
					break;
				}
			}
			if(find)
				System.out.println("1");
			else
				System.out.println("0");
		}
	}

}
