package gold4;
/*
알고리즘 코딩테스트 자바 3장
백준 17298
날짜 2023.07.05
*/
import java.io.*;
import java.util.*;
class Node_Beakjoon_17298{
	int index;
	int data;
	Node_Beakjoon_17298(int index, int data){
		this.index=index;
		this.data=data;
	}
}

public class Beakjoon_17298 {

	public static void main(String[] args) throws IOException {
		BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw=new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st=new StringTokenizer(bf.readLine());
		int N=Integer.parseInt(st.nextToken());
		int[] list=new int[N];
		int[] result=new int[N];
		st=new StringTokenizer(bf.readLine());
		Stack<Node_Beakjoon_17298> myStack=new Stack<>();
		for(int i=0;i<N;i++) {
			list[i]=Integer.parseInt(st.nextToken());
		}
		
		myStack.push(new Node_Beakjoon_17298(0,list[0]));
		for(int i=1;i<N;i++) {
			int now=list[i];
			while(!myStack.empty()&&now>myStack.peek().data) {
				Node_Beakjoon_17298 node=myStack.pop();
				result[node.index]=now;
			}
			myStack.push(new Node_Beakjoon_17298(i,now));
		}
		while(!myStack.empty()) {
			Node_Beakjoon_17298 node=myStack.pop();
			result[node.index]=-1;
		}
		for(int i=0;i<N;i++) {
			bw.write(result[i]+" ");
		}
		bw.write("\n");
		bw.flush();
	}

}
