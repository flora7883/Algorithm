public class UserSolution {
	int childList[][];
	int childCnt[];
	boolean visited[];
	int king=0;//왕의 능력

	public void dfs_init(int N, int[][] path) {//N 인물 수 2<=N<=40
		//배열 초기화
		childList=new int[100][5];
		childCnt=new int [100];

		int p=0;
		int c=0;
		for(int i=0;i<N-1;i++) {
			p=path[i][0];
			c=path[i][1];
			childList[p][childCnt[p]]=c;
			childCnt[p]++;
		}
	}
	
	public int dfs(int n) {
		//n 능력 1<=n<=99
		king=n;
		visited=new boolean[100];
		int result=real_dfs(n);
		return result;
	}
	
	int real_dfs(int n) {
		visited[n]=true;
		int result=-1;
		int v;
		for(int i=0;i<childCnt[n];i++) {
			v=childList[n][i];
			if(visited[v]==false) {
				if(v>king) {
					result=v;
					return result;
				}
				else {
					result=real_dfs(v);
				}
				if(result!=-1) {//여기를 놓치면 안됨. 위에서 result값이 -1이 아닌 수가 돌아오면 더이상 for문을 실행하지 않고 리턴해야함.
					return result;
				}
			}
		}
		return result;
	}
}
