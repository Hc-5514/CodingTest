/**
 * 문제 : 파티
 *
 * @author Hc-5514
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

public class BOJ_1238 {

	private static int X;

	private static int[] dijkstra(List<List<Road>> roads) {
		int[] distance = new int[roads.size()];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[X] = 0;

		PriorityQueue<Road> pq = new PriorityQueue<>();
		pq.offer(new Road(X, 0));

		while (!pq.isEmpty()) {
			Road cur = pq.poll();
			if (distance[cur.to] < cur.var) {
				continue;
			}
			for (Road road : roads.get(cur.to)) {
				int cost = road.var + distance[cur.to];
				if (cost < distance[road.to]) {
					distance[road.to] = cost;
					pq.offer(new Road(road.to, distance[road.to]));
				}
			}
		}

		return distance;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 1 <= N <= 1,000
		int M = Integer.parseInt(st.nextToken()); // 1 <= M <= 10,000
		X = Integer.parseInt(st.nextToken()); // 1 <= X <= N

		List<List<Road>> roads = new ArrayList<>();
		List<List<Road>> reverse_roads = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			roads.add(new ArrayList<>());
			reverse_roads.add(new ArrayList<>());
		}

		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int var = Integer.parseInt(st.nextToken());
			roads.get(from).add(new Road(to, var));
			reverse_roads.get(to).add(new Road(from, var));
		}

		int[] distance = dijkstra(roads);
		int[] reverse_distance = dijkstra(reverse_roads);

		int max = 0;
		for (int i = 1; i <= N; i++) {
			max = Math.max(max, distance[i] + reverse_distance[i]);
		}

		bw.write(max + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

	static class Road implements Comparable<Road> {
		int to;
		int var;

		public Road(int to, int var) {
			this.to = to;
			this.var = var;
		}

		@Override
		public int compareTo(Road o) {
			return this.var - o.var;
		}
	}
}


