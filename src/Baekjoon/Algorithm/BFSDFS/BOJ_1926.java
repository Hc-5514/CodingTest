/**
 * 문제 : 그림
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
import java.util.StringTokenizer;

public class BOJ_1926 {

	private static int n, m, paintCnt, maxCnt;
	private static final int[] dRow = {-1, 1, 0, 0}, dCol = {0, 0, -1, 1};

	private static int[][] board;
	private static boolean[][] visit;

	private static boolean validation(int r, int c) {
		if (r < 0 || c < 0 || r >= n || c >= m) {
			return false;
		}
		if (board[r][c] == 0) {
			return false;
		}
		if (visit[r][c]) {
			return false;
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 1 <= n <= 500
		m = Integer.parseInt(st.nextToken()); // 1 <= m <= 500

		paintCnt = 0;
		maxCnt = 0;

		board = new int[n][m];
		visit = new boolean[n][m];

		// n x m 입력 받기
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				// 그림, 확인x
				if (board[i][j] == 1 && !visit[i][j]) {
					paintCnt++;
					int cnt = 1;
					Queue<int[]> q = new ArrayDeque<>();
					q.offer(new int[] {i, j});
					visit[i][j] = true;
					while (!q.isEmpty()) {
						int[] cur = q.poll();
						for (int k = 0; k < 4; k++) {
							int r = cur[0] + dRow[k];
							int c = cur[1] + dCol[k];
							if (!validation(r, c)) {
								continue;
							}
							q.offer(new int[] {r, c});
							visit[r][c] = true;
							cnt++;
						}
					}
					maxCnt = Math.max(maxCnt, cnt);
				}
			}
		}

		bw.write(paintCnt + "\n");
		bw.write(maxCnt + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}

