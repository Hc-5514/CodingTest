/**
 * 문제 : 택배 배송
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

public class BOJ_5972 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int M = Integer.parseInt(st.nextToken());

		// N개의 헛간
		List<List<Road>> roads = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			roads.add(new ArrayList<>());
		}

		// M개의 양방향 길
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int weight = Integer.parseInt(st.nextToken());
			roads.get(from).add(new Road(to, weight));
			roads.get(to).add(new Road(from, weight));
		}

		// 최단거리 구하기
		int[] distance = new int[N + 1];
		Arrays.fill(distance, Integer.MAX_VALUE);
		distance[1] = 0;

		PriorityQueue<Road> pq = new PriorityQueue<>();
		pq.offer(new Road(1, 0));
		while (!pq.isEmpty()) {
			Road cur = pq.poll();
			// 현재 노드가 이미 처리된 노드라면
			if (distance[cur.to] < cur.var) {
				continue;
			}
			// 현재 노드와 인접한 다른 노드 확인
			for (Road road : roads.get(cur.to)) {
				int cost = distance[cur.to] + road.var;
				if (cost < distance[road.to]) {
					distance[road.to] = cost;
					pq.offer(new Road(road.to, distance[road.to]));
				}
			}

		}

		bw.write(distance[N] + "\n");
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

