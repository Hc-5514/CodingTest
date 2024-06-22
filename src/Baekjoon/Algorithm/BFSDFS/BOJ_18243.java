/**
 * 문제 : Small World Network
 * 소요 시간 : 20분
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.BFSDFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_18243 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		List<List<Integer>> edges = new ArrayList<>();
		for (int i = 0; i < N; i++) {
			edges.add(new ArrayList<>());
		}

		// A,B 친구 관계 추가
		for (int i = 0; i < K; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken()) - 1;
			int B = Integer.parseInt(st.nextToken()) - 1;
			edges.get(A).add(B);
			edges.get(B).add(A);
		}

		int[][] dist = new int[N][N];
		int INF = N * N + 1;
		for (int i = 0; i < N; i++) {
			Arrays.fill(dist[i], INF);
			dist[i][i] = 0;
		}

		// 친구 거리 확인
		boolean isSmallWorld = true;
		f1:
		for (int i = 0; i < N; i++) {
			Queue<Integer> q = new ArrayDeque<>();
			q.offer(i);

			while (!q.isEmpty()) {
				int cur = q.poll();
				for (int j = 0; j < edges.get(cur).size(); j++) {
					int n = edges.get(cur).get(j);
					if (dist[i][cur] + 1 < dist[i][n]) {
						dist[i][n] = dist[i][cur] + 1;
						q.offer(n);
					}
				}
			}

			// 거리 확인
			for (int j = 0; j < N; j++) {
				if (dist[i][j] > 6) {
					isSmallWorld = false;
					break f1;
				}
			}
		}

		String result = isSmallWorld ? "Small World!" : "Big World!";
		bw.write(result);

		bw.flush();
		bw.close();
		br.close();
	}
}
