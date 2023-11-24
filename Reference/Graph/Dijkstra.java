package Graph;

import java.io.*;
import java.util.*;

class Dijkstra_Node {
	int edge;
	int weight;

	Dijkstra_Node(int edge, int weight) {
		this.edge = edge;
		this.weight = weight;
	}
}

public class Dijkstra {
	static int N;
	static int M;
	static ArrayList<ArrayList<Dijkstra_Node>> graph;
	static int[] distance;
	static boolean[] visited;
	static int INF = 999999999;
	static int start;
	static int end;

	public static void main(String[] args) {
		graph = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			graph.add(new ArrayList<>());
		}
		distance = new int[N + 1];
		visited = new boolean[N + 1];
		for (int i = 0; i < M; i++) {
			int s = 0;
			int e = 0;
			int w = 0;
			graph.get(s).add(new Dijkstra_Node(e, w));
		}
	}

	static void dijkstra() {
		// 다익스트라 실행
		for (int i = 1; i <= N; i++) {// 거리는 inf로 초기화. 갈 수 없음을 의미
			distance[i] = INF;
		}
		distance[start] = 0;// 시작 지점은 0으로 초기화
		PriorityQueue<Dijkstra_Node> pq = new PriorityQueue<>((o1, o2) -> {// node의 weight로 우선순위 설정
			return o1.weight - o2.weight;
		});
		pq.add(new Dijkstra_Node(start, 0));
		while (!pq.isEmpty()) {
			Dijkstra_Node now = pq.poll();
			if (visited[now.edge])// 이미 확인한 노드이면 건너뛰기
				continue;
			visited[now.edge] = true;
			for (Dijkstra_Node next : graph.get(now.edge)) {
				// next를 갈 때 now를 거쳐서 가는게 더 빠른지 확인. 초기 distance를 INF로 설정한 이유.
				if ((!visited[next.edge]) && next.weight + distance[now.edge] < distance[next.edge]) {
					distance[next.edge] = next.weight + distance[now.edge];
					pq.add(new Dijkstra_Node(next.edge, distance[next.edge]));
				}
			}
		}
	}
}
