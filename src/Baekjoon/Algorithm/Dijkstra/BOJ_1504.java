/**
 * 문제: 특정한 최단 경로
 * 난이도: 골드 4
 * 메모리: 71036KB, 시간: 636ms
 * 풀이: 다익스트라
 */

package Baekjoon.Algorithm.Dijkstra;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1504 {

	private static final long INF = 2_000_000_000;
	private static List<List<Edge>> edges;

	private static void dijkstra(long[] dist, int start) {
		PriorityQueue<Edge> pq = new PriorityQueue<>((e1, e2) -> Long.compare(e1.cost, e2.cost));
		dist[start] = 0;
		pq.add(new Edge(start, 0));

		while (!pq.isEmpty()) {
			Edge cur = pq.poll();
			if (cur.cost > dist[cur.to]) {
				continue;
			}
			for (Edge next : edges.get(cur.to)) {
				long newCost = dist[cur.to] + next.cost;
				if (newCost < dist[next.to]) {
					dist[next.to] = newCost;
					pq.offer(new Edge(next.to, newCost));
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 정점 개수
		int e = Integer.parseInt(st.nextToken()); // 간선 개수

		// 무방향 그래프 연결
		edges = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			edges.add(new ArrayList<>());
		}

		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			edges.get(from).add(new Edge(to, cost));
			edges.get(to).add(new Edge(from, cost));
		}

		// 반드시 거쳐야 하는 정점
		st = new StringTokenizer(br.readLine());
		int v1 = Integer.parseInt(st.nextToken());
		int v2 = Integer.parseInt(st.nextToken());

		// 다익스트라 3번
		// 1 -> v1 -> v2 -> n
		// 1 -> v2 -> v1 -> n

		long[] dist1 = new long[n + 1]; // start: 1번 노드
		long[] dist2 = new long[n + 1]; // start: v1 노드
		long[] dist3 = new long[n + 1]; // start: v2 노드

		Arrays.fill(dist1, INF);
		Arrays.fill(dist2, INF);
		Arrays.fill(dist3, INF);

		dijkstra(dist1, 1);
		dijkstra(dist2, v1);
		dijkstra(dist3, v2);

		long totalCost1 =
			dist1[v1] >= INF || dist2[v2] >= INF || dist3[n] >= INF ? -1 : dist1[v1] + dist2[v2] + dist3[n];
		long totalCost2 =
			dist1[v2] >= INF || dist3[v1] >= INF || dist2[n] >= INF ? -1 : dist1[v2] + dist3[v1] + dist2[n];

		long result = Math.min(totalCost1, totalCost2);
		bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

	public static class Edge {
		int to;
		long cost;

		public Edge(int to, long cost) {
			this.to = to;
			this.cost = cost;
		}
	}
}
