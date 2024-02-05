/**
 * 문제 : 이모티콘
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
import java.util.Queue;

public class BOJ_14226 {

	private static int S, minTime;
	private static Queue<int[]> q;
	private static boolean[][] visit;

	private static void command(int cmd, int t, int s, int b) {
		if (s == S) {
			minTime = Math.min(minTime, t);
			return;
		}

		if (t >= minTime) {
			return;
		}

		switch (cmd) {
			case 0: // 화면 -> 클립보드 (덮어쓰기)
				if (s == b) {
					return;
				}
				b = s;
				break;
			case 1: // 클립보드 -> 화면 (추가)
				if (b == 0) {
					return;
				}
				s += b;
				break;
			case 2: // 화면 -1
				s--;
				if (s <= 1) {
					return;
				}
				break;
		}

		if (s >= 2 * S || b >= 2 * S) {
			return;
		}

		if (visit[s][b]) {
			return;
		}

		visit[s][b] = true;
		q.offer(new int[] {0, t + 1, s, b});
		q.offer(new int[] {1, t + 1, s, b});
		q.offer(new int[] {2, t + 1, s, b});
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		S = Integer.parseInt(br.readLine().trim()); // (2 ≤ S ≤ 1000)
		visit = new boolean[S * 2][S * 2]; // 이전에 동일한 s와 b 값으로 처리한 적이 있는지 확인

		// 화면 (1 -> S) 까지의 최소 연산 시간 구하기
		minTime = Integer.MAX_VALUE;

		q = new ArrayDeque<>();
		q.offer(new int[] {0, 0, 1, 0});
		visit[1][0] = true;

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			command(cur[0], cur[1], cur[2], cur[3]);
		}

		bw.write(minTime + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
