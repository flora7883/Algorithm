class SegmentTreeSum {
	static long[]a;//리프노드
	static long[]tree;//세그먼트 트리를 구현할 배열. binary tree이므로 배열로 나타낼 수 있음. 최상위 노드 1부터 시작. 
	static long[]lazy;
	
	static long init(int node, int start,int end) {
		//start, end는 해당 노드가 담당하는 영역. 같으면 리프노드임
		//node는 tree에서 사용할 index
		if(start==end) {//리프노드인 경우 리프노드의 값이 저장된 a배열을 값을 tree배열에 저장해줌.
			return tree[node]=a[start];
		}
		else {//리프노드가 아닌 경우 왼쪽 자식과 오른쪽 자식을 재귀호출함. 왼쪽 자식: node*2, 오른쪽 자식: node*2+1
			return tree[node]=init(node*2,start,(start+end)/2)+init(node*2+1,(start+end)/2+1,end);
		}
	}
	static long sum(int node, int start, int end, int left, int right) {
		//start, end: 해당 노드가 담당하는 영역
		//left, right: 구해야하는 영역
		if(left>end||right<start) {//구해야하는 영역이 해당 영역 밖인 경우
			return 0;
		}
		if(left<=start&&end<=right) {//구해야하는 영역이 해당 영역과 완전히 일치하는 경우
			return tree[node];
		}
		return sum(node*2,start,(start+end)/2,left, right)+sum(node*2+1,(start+end)/2+1,end,left,right);
	}
	
	static void update(int node, int start, int end, int index, int diff ){
		//index: 배열 a에서 변경하는 리프노드의 인덱스
		if(index<start||index>end)	return;
		tree[node]=tree[node]+diff;
		if(start!=end) {
			update(node*2, start, (start+end)/2, index, diff);
			update(node*2+1, (start+end)/2+1, end, index, diff);
		}
	}
	
	public static void main(String[]args)throws Exception{
		int n=0;
		a=new long[n];
		int h=(int) Math.ceil(Math.log(n)/Math.log(2));//log2(n)
		int size=(int)Math.pow(2,h+1);//1부터 시작하므로 -1 안해줌
		tree=new long [size];
		//a 완성
		init(1,0,n-1);//node index가 1인 루트노드부터 srart=0, end=n-1 즉 전체를 초기화해줌.
		//diff=새로운 값-원래 값, 원래 값은 a배열에 저장되어있음. a[k]값을 val로 변경하고 싶으면 
		//diff=val-a[k];
		//a[k]=val;
		//update(1,0,n-1,k,diff)
		
		//a[k1]부터 a[k2]까지의 합을 구하고 싶으면
		//sum(1,0,n-1,k1, k2)
	}
}
