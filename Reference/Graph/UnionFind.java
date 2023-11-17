package Graph;

public class UnionFind {
	static int n;
	static int[] set;
	public static void main(String[] args) {
		n=10;
		set=new int[n+1];
		for(int i=0;i<=n;i++) {
			set[i]=i;
		}
		union(1,3);//3이 있는 집합을 1이 있는 집합에 포함시키기.
		find(3);//3이 포함된 집합의 대표원소 찾기.
	}
	static void union(int a, int b) {
		int a_parent=find(a);
		int b_parent=find(b);
		set[b_parent]=a_parent;
	}
	static int find(int a) {
		if(set[a]==a) {
			return a;
		}
		return set[a]=find(set[a]);
	}

}
