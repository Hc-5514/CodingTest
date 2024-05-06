/**
 * 문제 : 상근이의 여행
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.Queue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_9372 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // 국가 수 (2 ≤ N ≤ 1 000)
			int M = Integer.parseInt(st.nextToken()); // 비행기 종류 (1 ≤ M ≤ 10 000)

			List<List<Integer>> plains = new ArrayList<>();
			for (int i = 0; i <= N; i++) {
				plains.add(new ArrayList<>());
			}

			// a, b 양방향 연결
			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int a = Integer.parseInt(st.nextToken());
				int b = Integer.parseInt(st.nextToken());
				plains.get(a).add(b);
				plains.get(b).add(a);
			}

			boolean[] visit = new boolean[N + 1];
			Queue<Integer> q = new ArrayDeque<>();
			q.offer(1);
			visit[1] = true;
			int cnt = 0;

			while (!q.isEmpty()) {
				int cur = q.poll();
				for (int i = 0; i < plains.get(cur).size(); i++) {
					int n = plains.get(cur).get(i);
					if (visit[n]) {
						continue;
					}
					q.offer(n);
					visit[n] = true;
					cnt++;
				}
			}

			bw.write(cnt + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
