package HSAT_6;
/*
Softeer HSAT 6회 출퇴근길
날짜 2023.08.11
*/
import java.util.*;
import java.io.*;
public class NO_2 {

	public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int m=sc.nextInt();
        ArrayList<ArrayList<Integer>> list=new ArrayList<ArrayList<Integer>>();//내가 갈 수 있는 노드
        ArrayList<ArrayList<Integer>> listR=new ArrayList<ArrayList<Integer>>();//나로 올 수 있는 노드

        for(int i=0;i<=n;i++){
             list.add(new ArrayList<Integer>());
             listR.add(new ArrayList<Integer>());
        }
        for(int i=0;i<m;i++){
            int a=sc.nextInt();
            int b=sc.nextInt();
            list.get(a).add(b);
            listR.get(b).add(a);
        }
        int S=sc.nextInt();
        int T=sc.nextInt();
        
        boolean[] fromS=new boolean[n+1];//S에서 출발해서 갈 수 있는 노드들 저장.
        boolean[] fromT=new boolean[n+1];
        boolean[] toS=new boolean[n+1];//S로 올 수 있는 노드들 저장.
        boolean[] toT=new boolean[n+1];

        fromS[T]=true;//S에서 T로 갈 때 T에 도착하면 끝임. 따라서 T를 true처리해서 여기로 가지 못하게 함.
        fromT[S]=true;

        int count=0;
        DFS(S,list,fromS);
        DFS(S,listR,toS);
        DFS(T,list,fromT);
        DFS(T,listR,toT);

        for(int i=1;i<=n;i++){
            if(fromS[i]&&fromT[i]&&toS[i]&&toT[i]){
                count++;
            }
        }
        System.out.println(count-2);

    }
    static void DFS(int now, ArrayList<ArrayList<Integer>> list, boolean[] visited){
        if(visited[now]==true)//방문한 경우
            return;
        visited[now]=true;
        for(int next : list.get(now)){
            DFS(next, list, visited);
        }

        return;
    }

}
