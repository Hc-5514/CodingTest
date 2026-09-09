package Programmers._2025_카카오_하반기_1차;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class 바이러스_파이프 {

	class Solution {

		List<Edge>[] graph;
		boolean[] visit;
		int n;
		int k;
		int answer;

		// dfs
		private void dfs(int depth, int lastType) {
			answer = Math.max(answer, count());

			if (depth == k) {
				return;
			}

			for (int type = 1; type <= 3; type++) {
				if (type == lastType) {
					continue;
				}

				boolean[] backup = visit.clone();

				Queue<Integer> q = new ArrayDeque<>();
				for (int i = 0; i < visit.length; i++) {
					if (visit[i]) {
						q.offer(i);
					}
				}

				while (!q.isEmpty()) {
					int cur = q.poll();
					for (Edge edge : graph[cur]) {
						if (edge.type != type) {
							continue;
						}
						if (visit[edge.to]) {
							continue;
						}
						q.offer(edge.to);
						visit[edge.to] = true;
					}
				}

				dfs(depth + 1, type);
				visit = backup;
			}

		}

		private int count() {
			int count = 0;
			for (int i = 0; i < visit.length; i++) {
				if (visit[i]) {
					count++;
				}
			}
			return count;
		}

		public int solution(int n, int infection, int[][] edges, int k) {
			graph = new ArrayList[n + 1];
			this.n = n;
			this.k = k;
			answer = 1;

			for (int i = 1; i <= n; i++) {
				graph[i] = new ArrayList<>();
			}

			for (int[] edge : edges) {
				int a = edge[0];
				int b = edge[1];
				int type = edge[2];
				graph[a].add(new Edge(b, type));
				graph[b].add(new Edge(a, type));
			}

			visit = new boolean[n + 1];
			visit[infection] = true;

			dfs(0, 0);

			return answer;
		}

		class Edge {
			int to;
			int type;

			public Edge(int to, int type) {
				this.to = to;
				this.type = type;
			}
		}
	}
}
