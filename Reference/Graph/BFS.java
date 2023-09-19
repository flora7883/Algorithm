package Graph;
/*
그래프 BFS
날짜 2023.09.07
*/
import java.util.*;
import java.io.*;

public class BFS {
	static int n=5;
    static ArrayList<ArrayList<Integer>> list=new ArrayList<ArrayList<Integer>>();//인접리스트
	static boolean[] visited=new boolean[n];

    static void bfs1(int start) {
    	Queue<Integer> q=new LinkedList<>();
    	q.add(start);
    	visited[start]=true;

    	while(!q.isEmpty()) {
    		int now=q.poll();
    		for(int next:list.get(now)) {//now와 연결되어 있는 애들
    			if(!visited[next]) {//방문하지 않았으면 & 이동 가능하면
    				q.add(next);//큐에 추가
    				visited[next]=true;
    			}
    		}
    	}
    }

    static void bfs2(int start) {
    	PriorityQueue<Integer> pq=new PriorityQueue<>((o1,o2)->{//우선순위 큐 정렬 방법 지정.
			//리턴값이 양수면 두번째 매개변수의 우선순위가 더 높다.
    		//리턴값이 음수면 첫번째 매개변수의 우선순위가 더 높다.
    		return 0;
		});
    	pq.add(start);
    	visited[start]=true;
	
    	while(!pq.isEmpty()) {
    		int now=pq.poll();
    		for(int next:list.get(now)) {//now와 연결되어 있는 애들
    			if(!visited[next]) {//방문하지 않았으면 & 이동 가능하면
    				pq.add(next);//큐에 추가
    				visited[next]=true;
    			}
    		}
    	}
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
