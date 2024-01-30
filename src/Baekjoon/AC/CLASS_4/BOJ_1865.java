/**
 * 문제 : 웜홀
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_1865 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int TC = Integer.parseInt(br.readLine().trim()); // 1 <= TC <= 5
		f1:
		for (int i = 0; i < TC; i++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 1 <= N <= 500
			int M = Integer.parseInt(st.nextToken()); // 1 <= M <= 2,500
			int W = Integer.parseInt(st.nextToken()); // 1 <= W <= 200

			int[] dist = new int[N + 1]; // 1 ~ N
			int INF = 100000;
			Arrays.fill(dist, INF);
			dist[1] = 0;

			List<Edge> edgeList = new ArrayList<>();

			// 도로 정보 입력
			for (int j = 0; j < M; j++) {
				st = new StringTokenizer(br.readLine());
				int S = Integer.parseInt(st.nextToken()); // 도로 시작 지점
				int E = Integer.parseInt(st.nextToken()); // 도로 도착 지점
				int T = Integer.parseInt(st.nextToken()); // 이동 시간 0 <= T <= 10,000
				edgeList.add(new Edge(S, E, T));
				edgeList.add(new Edge(E, S, T));
			}

			// 웜홀 정보 입력
			for (int j = 0; j < W; j++) {
				st = new StringTokenizer(br.readLine());
				int S = Integer.parseInt(st.nextToken()); // 웜홀 시작 지점
				int E = Integer.parseInt(st.nextToken()); // 웜홀 도착 지점
				int T = Integer.parseInt(st.nextToken()); // 줄어드는 시간 0 <= T <= 10,000
				edgeList.add(new Edge(S, E, T * -1));
			}

			// 벨만포드 알고리즘
			// N-1 만큼 반복
			for (int j = 0; j < N - 1; j++) {
				// 모든 간선 확인 (최단거리 갱신)
				for (int k = edgeList.size() - 1; k >= 0; k--) {
					Edge cur = edgeList.get(k);
					int cost = dist[cur.from] + cur.weight;
					if (cost < dist[cur.to]) {
						dist[cur.to] = cost;
					}
				}
			}

			// 음수 사이클 확인
			for (int k = edgeList.size() - 1; k >= 0; k--) {
				Edge cur = edgeList.get(k);
				int cost = dist[cur.from] + cur.weight;
				if (cost < dist[cur.to]) {
					bw.write("YES\n");
					continue f1;
				}
			}

			bw.write("NO\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}

	private static class Edge {
		int from;
		int to;
		int weight;

		public Edge(int from, int to, int weight) {
			this.from = from;
			this.to = to;
			this.weight = weight;
		}
	}
}
