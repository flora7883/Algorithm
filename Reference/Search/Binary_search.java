package Search;

import java.util.ArrayList;
import java.util.Collections;

public class Binary_search {
	public static void main(String[] args) {
		int N;
		ArrayList<Integer> list=new ArrayList<>();
		for(int i=0;i<N;i++) {
			list.add(0);
		}
		Collections.sort(list);
		int M;
		for(int i=0;i<M;i++) {
			int x=0;
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
}
