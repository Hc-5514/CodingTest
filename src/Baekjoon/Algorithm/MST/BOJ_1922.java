/**
 * 문제: 네트워크 연결
 * 난이도: 골드 4
 * 메모리: 46920KB, 시간: 484ms
 * 풀이: 크루스칼
 */

package Baekjoon.Algorithm.MST;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1922 {

	private static int[] parent, rank;

	private static boolean union(int n1, int n2) {
		int p1 = find(n1);
		int p2 = find(n2);

		if (p1 == p2) {
			return false;
		}

		if (rank[p1] < rank[p2]) {
			parent[p1] = p2;
		} else {
			parent[p2] = p1;
			if (rank[p1] == rank[p2]) {
				rank[p1]++;
			}
		}

		return true;
	}

	private static int find(int n) {
		if (parent[n] != n) {
			parent[n] = find(parent[n]);
		}
		return parent[n];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		// 모든 컴퓨터를 연결시 드는 최소 비용 구하기

		int n = Integer.parseInt(br.readLine()); // 컴퓨터 수 (1 <= n <= 1,000)
		int m = Integer.parseInt(br.readLine()); // 연결선 수 (1 <= m <= 100,000)

		// 컴퓨터 연결 비용 저장
		Edge[] edges = new Edge[m];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			edges[i] = new Edge(from, to, cost);
		}

		Arrays.sort(edges);

		// union-find
		parent = new int[n + 1];
		rank = new int[n + 1];

		for (int i = 1; i <= n; i++) {
			parent[i] = i;
		}

		// Kruskal
		long result = 0; // 비용 합
		int picked = 0; // 연결된 간선 수

		for (Edge edge : edges) {
			if (union(edge.from, edge.to)) {
				result += edge.cost;
				if (++picked == n - 1) {
					break;
				}
			}
		}

		bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

	private static class Edge implements Comparable<Edge> {
		int from;
		int to;
		int cost;

		public Edge(int from, int to, int cost) {
			this.from = from;
			this.to = to;
			this.cost = cost;
		}

		public int compareTo(Edge edge) {
			return Integer.compare(this.cost, edge.cost);
		}
	}
}
