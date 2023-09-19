package Graph;
/*
그래프 초기화
날짜 2023.09.07
*/
import java.util.*;
import java.io.*;

class Pair{
	Integer a;
	Integer b;
	Pair(Integer a, Integer b){
		this.a=a;
		this.b=b;
	}
}

public class Initial {

	public static void main(String[] args) {
		int n=5;
		Pair[] edges= {new Pair(0,1),new Pair(0,2),new Pair(0,3),new Pair(1,2),new Pair(1,4),new Pair(3,2),new Pair(4,3)};
		
		//2차원 리스트
        ArrayList<ArrayList<Integer>> list=new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<=n;i++){
            list.add(new ArrayList<Integer>());
        }
        for(Pair p:edges){
            list.get(p.a).add(p.b);
        } 
	}
}
