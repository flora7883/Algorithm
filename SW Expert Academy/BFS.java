class Node{
	int x=0;
	int y=0;
	
	Node(int x,int y){
		this.x=x;
		this.y=y;
	}
}

class MyQueue {
    int length;
    int front = 0;
    int rear = 0;
    Node[] queue;

    public MyQueue(int length) {
        this.length = length;
        this.queue = new Node[length];
    }

    public boolean isFull(){
        return front == rear && queue[front] != null;
    }

    public boolean Empty(){
        return front == rear && queue[front] == null;
    }

    public void enqueue(int x, int y){
        if(isFull()) {
            return;
        }
        queue[rear]=new Node(x,y);
        rear++;
        rear = rear % queue.length;
    }

    public Node dequeue(){
        if(Empty()){
            throw new ArrayIndexOutOfBoundsException();
        }
        Node dequeuedData = queue[front];
        queue[front++] = null;
        front = front % queue.length;

        return dequeuedData;
    }

    public Node peek(){
        return queue[front];
    }
}

class UserSolution {
	int tree[][];
	boolean visited [][];
	int[] dx= {-1,1,0,0};
	int[] dy= {0,0,-1,1};
	int size=0;
    void bfs_init(int map_size, int map[][]) {
    	tree=new int [map_size][map_size];
       	size=map_size;
    	for(int i=0;i<map_size;i++) {
    		for(int j=0;j<map_size;j++) {
    			if(map[i][j]==0)
    				tree[i][j]=1;
    			else
    				tree[i][j]=0;
    			System.out.printf("%d ",tree[i][j]);
    		}
    		System.out.println();
    	}
    }

    int bfs(int x1, int y1, int x2, int y2) {
    	int real_x1=--y1;
    	int real_y1=--x1;
    	int real_x2=--y2;
    	int real_y2=--x2;
    	System.out.printf("%d %d %d %d\n",real_x1,real_y1,real_x2,real_y2);
    	visited =new boolean [10][10];
    	visited[real_x1][real_y1]=true;
    	MyQueue q=new MyQueue(10000);
    	q.enqueue(real_x1, real_y1);
    	int x,y;
    	while(!q.Empty()) {
    		x=q.peek().x;
    		y=q.peek().y;
    		System.out.printf("%d %d\n",x,y);
    		q.dequeue();
    		if(x==real_x2&&y==real_y2) {
    			System.out.printf("finish %d\n",tree[x][y]);
    			return tree[x][y]-1;
    		}
    		for(int i=0;i<4;i++) {
    			int nextX=x+dx[i];
    			int nextY=y+dy[i];
    			System.out.printf("nextX: %d nextY: %d \n",nextX, nextY);
    			if(nextX<0||nextY<0||nextX>=size||nextY>=size) {
    				System.out.printf("범위 아웃\n");
    				continue;
    			}
    			if(visited[nextX][nextY]||tree[nextX][nextY]==0)
    			{
    				System.out.printf("이미 방문 또는 벽\n");
    				System.out.printf("%b %d\n",visited[nextX][nextY], tree[nextX][nextY]);
    				continue;
    			}
    			q.enqueue(nextX,nextY);
    			System.out.printf("큐에 추가\n");
    			tree[nextX][nextY]=tree[x][y]+1;
    			visited[nextX][nextY]=true;
    		}
    	}
    	return -1;
    }	
	
}
