/**
 * 문제 : 서강그라운드
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

public class BOJ_14938 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());
		int r = Integer.parseInt(st.nextToken());

		int[] t = new int[n + 1];

		List<List<Road>> roads = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			roads.add(new ArrayList<>());
		}

		st = new StringTokenizer(br.readLine());
		for (int i = 1; i <= n; i++) {
			t[i] = Integer.parseInt(st.nextToken());
		}

		// 길 양방향 연결
		for (int i = 0; i < r; i++) {
			st = new StringTokenizer(br.readLine());
			int a = Integer.parseInt(st.nextToken());
			int b = Integer.parseInt(st.nextToken());
			int l = Integer.parseInt(st.nextToken());
			roads.get(a).add(new Road(b, l));
			roads.get(b).add(new Road(a, l));
		}

		int maxCnt = 0;

		// 1번 ~ n번 모든 지역에 대해 수색
		for (int i = 1; i <= n; i++) {
			int[] dist = new int[n + 1];
			Arrays.fill(dist, Integer.MAX_VALUE);
			dist[i] = 0;

			PriorityQueue<Road> pq = new PriorityQueue<>();
			pq.offer(new Road(i, 0));
			while (!pq.isEmpty()) {
				Road cur = pq.poll();
				for (int j = 0; j < roads.get(cur.to).size(); j++) {
					int to = roads.get(cur.to).get(j).to;
					int len = cur.len + roads.get(cur.to).get(j).len;
					if (dist[to] <= len) {
						continue;
					}
					dist[to] = len;
					pq.offer(new Road(to, len));
				}
			}

			int cnt = 0;
			for (int j = 1; j <= n; j++) {
				if (dist[j] <= m) {
					cnt += t[j];
				}
			}
			maxCnt = Math.max(maxCnt, cnt);
		}

		bw.write(maxCnt + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

	private static class Road implements Comparable<Road> {
		int to;
		int len;

		public Road(int to, int len) {
			this.to = to;
			this.len = len;
		}

		@Override
		public int compareTo(Road r) {
			return this.len - r.len;
		}
	}
}
