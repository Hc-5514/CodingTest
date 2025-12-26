/**
 * 문제: 숨바꼭질 3
 * 난이도: 골드 5
 * 메모리: 13760KB, 시간: 92ms
 * 풀이: 0-1 BFS
 */

package Baekjoon.AC.CLASS_4;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_13549 {

	private static final int MAX = 100_000;
	private static final int INF = 1_000_000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st = new StringTokenizer(br.readLine());

		int n = Integer.parseInt(st.nextToken());
		int k = Integer.parseInt(st.nextToken());

		// n == k 가 되는 가장 빠른 시간 구하기
		// 1초: n++ | n--
		// 0초: n * 2

		int result = 0;
		if (n >= k) {
			result = n - k;
		} else {
			// 순간이동: 시간 변화 0 -> 가중치 0
			// 이동: 시간 변화 1 -> 가중치 1
			Deque<Integer> dq = new ArrayDeque<>();
			int[] dist = new int[MAX + 1]; // 0 ~ 100_000
			Arrays.fill(dist, INF);

			dq.offerFirst(n);
			dist[n] = 0;

			while (!dq.isEmpty()) {
				int cur = dq.pollFirst();
				int curT = dist[cur];
				// 도착
				if (cur == k) {
					result = curT;
					break;
				}
				// 순간이동
				int nx = cur * 2;
				if (nx <= MAX && curT < dist[nx]) {
					dq.offerFirst(nx);
					dist[nx] = curT;
				}
				// 전진
				int nt = curT + 1;
				nx = cur + 1;
				if (nx <= MAX && nt < dist[nx]) {
					dq.offerLast(nx);
					dist[nx] = nt;
				}
				// 후진
				nx = cur - 1;
				if (nx >= 0 && nt < dist[nx]) {
					dq.offerLast(nx);
					dist[nx] = nt;
				}
			}
		}

		bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
