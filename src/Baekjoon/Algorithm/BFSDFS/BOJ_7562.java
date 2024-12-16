/**
 * 문제 : 나이트의 이동
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
import java.util.stream.Stream;

public class BOJ_7562 {

	private static final int[] dRow = {-2, -1, 1, 2, 2, 1, -1, -2};
	private static final int[] dCol = {-1, -2, -2, -1, 1, 2, 2, 1};

	private static int simulate(int n, int[] start, int[] goal) {
		boolean[][] visit = new boolean[n][n];
		Queue<int[]> q = new ArrayDeque<>(); // r, c, cnt

		q.offer(new int[] {start[0], start[1], 0});
		visit[start[0]][start[1]] = true;

		int result = 0;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			// 목적지 도달 시, 종료
			if (goal[0] == cur[0] && goal[1] == cur[1]) {
				result = cur[2];
				break;
			}
			// 이동
			for (int k = 0; k < dRow.length; k++) {
				int r = cur[0] + dRow[k];
				int c = cur[1] + dCol[k];
				// 체스판 크기 확인
				if (r < 0 || c < 0 || r >= n || c >= n) {
					continue;
				}
				// 방문 여부 확인
				if (visit[r][c]) {
					continue;
				}
				// 이동
				q.offer(new int[] {r, c, cur[2] + 1});
				visit[r][c] = true;
			}
		}

		return result;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(br.readLine().trim()); // testcase 개수
		for (int tc = 0; tc < t; tc++) {
			int n = Integer.parseInt(br.readLine().trim());
			int[] start = Stream.of(br.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
			int[] goal = Stream.of(br.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();

			bw.write(simulate(n, start, goal) + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
