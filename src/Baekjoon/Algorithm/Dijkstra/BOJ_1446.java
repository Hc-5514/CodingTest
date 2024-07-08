/**
 * 문제 : 지름길
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

public class BOJ_1446 {

	// D 킬로미터 고속도로, 역주행 불가능
	// 모든 지름길은 일방통행, 음이 아닌 정수 (0 <= len <= 10,000)
	// 운전길이 최솟값 구하기

	// 모든 경로에 대한 최단 거리 구하기 -> 음이 아닌 정수: 다익스트라

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());

		List<List<Road>> roads = new ArrayList<>();
		for (int i = 0; i < 10001; i++) {
			roads.add(new ArrayList<>());
		}

		for (int i = 0; i < 10000; i++) {
			roads.get(i).add(new Road(i, i + 1, 1));
		}

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int e = Integer.parseInt(st.nextToken());
			int len = Integer.parseInt(st.nextToken());
			roads.get(s).add(new Road(s, e, len));
		}

		int[] distance = new int[10001];
		Arrays.fill(distance, 100_000);
		distance[0] = 0;

		PriorityQueue<Road> pq = new PriorityQueue<>();
		for (int i = 0; i < roads.get(0).size(); i++) {
			pq.offer(roads.get(0).get(i));
		}

		while (!pq.isEmpty()) {
			Road cur = pq.poll();
			int len = distance[cur.s] + cur.len;
			if (len < distance[cur.e]) {
				distance[cur.e] = len;
				for (int i = 0; i < roads.get(cur.e).size(); i++) {
					pq.offer(roads.get(cur.e).get(i));
				}
			}
		}

		bw.write(distance[D] + "\n");

		bw.flush();
		bw.close();
		br.close();
	}

	private static class Road implements Comparable<Road> {
		int s;
		int e;
		int len;

		public Road(int s, int e, int len) {
			this.s = s;
			this.e = e;
			this.len = len;
		}

		public int compareTo(Road r) {
			if (this.e == r.e) {
				return this.len - r.len;
			}
			return this.e - r.e;
		}
	}
}
