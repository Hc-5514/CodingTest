/**
 * 문제 : 전쟁 - 전투
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

public class BOJ_1303 {

	// 같은 팀 병사들이 모일수록 강해진다. (N명일 경우, N^2 위력)
	// W: 아군, B: 적군 일 때, 각 나라 병사의 위력 합 구하기

	private static final int[] dRow = {-1, 1, 0, 0}, dCol = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		char[][] board = new char[n][m];
		boolean[][] visit = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			board[i] = br.readLine().toCharArray();
		}

		int bPower = 0;
		int wPower = 0;

		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (visit[i][j]) {
					continue;
				}
				Queue<int[]> q = new ArrayDeque<>();
				int cnt = 0;
				if (board[i][j] == 'W') {
					q.offer(new int[] {i, j});
					visit[i][j] = true;
					cnt++;
					while (!q.isEmpty()) {
						int[] cur = q.poll();
						for (int k = 0; k < 4; k++) {
							int r = cur[0] + dRow[k];
							int c = cur[1] + dCol[k];
							if (r < 0 || c < 0 || r >= n || c >= m) {
								continue;
							}
							if (visit[r][c]) {
								continue;
							}
							if (board[r][c] == 'B') {
								continue;
							}
							q.offer(new int[] {r, c});
							visit[r][c] = true;
							cnt++;
						}
					}
					wPower += Math.pow(cnt, 2);
				}
				if (board[i][j] == 'B') {
					q.offer(new int[] {i, j});
					visit[i][j] = true;
					cnt++;
					while (!q.isEmpty()) {
						int[] cur = q.poll();
						for (int k = 0; k < 4; k++) {
							int r = cur[0] + dRow[k];
							int c = cur[1] + dCol[k];
							if (r < 0 || c < 0 || r >= n || c >= m) {
								continue;
							}
							if (visit[r][c]) {
								continue;
							}
							if (board[r][c] == 'W') {
								continue;
							}
							q.offer(new int[] {r, c});
							visit[r][c] = true;
							cnt++;
						}
					}
					bPower += Math.pow(cnt, 2);
				}
			}
		}

		bw.write(wPower + " " + bPower + "\n");

		bw.flush();
		bw.close();
		br.close();
	}
}
