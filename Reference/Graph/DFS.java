package Graph;
/*
그래프 DFS
날짜 2023.09.07
*/
import java.util.*;
import java.io.*;

public class DFS {
	
	static int n=5;
    static ArrayList<ArrayList<Integer>> list=new ArrayList<ArrayList<Integer>>();//인접리스트
	static boolean[] visited=new boolean[n];
	
	static void dfs1(int now) {
		if(visited[now])//이미 방문한 경우
			return;
		visited[now]=true;//방문 처리
		for(int next : list.get(now)){//now에서 갈 수 있는 곳 탐색
            dfs1(next);
        }
        return;
	}
	
	static void dfs2(int now) {
		visited[now]=true;
		for(int next : list.get(now)){//now에서 갈 수 있는 곳 탐색
			if(!visited[next])//방문하지 않았은 경우만 dfs돌리기
				dfs2(next);
        }
        return;
	}
	
	public static void main(String[] args) {
		Pair[] edges= {new Pair(0,1),new Pair(0,2),new Pair(0,3),new Pair(1,2),new Pair(1,4),new Pair(3,2),new Pair(4,3)};
		
        for(int i=0;i<=n;i++){
            list.add(new ArrayList<Integer>());
        }
        for(Pair p:edges){
            list.get(p.a).add(p.b);
        } 
	}
}
