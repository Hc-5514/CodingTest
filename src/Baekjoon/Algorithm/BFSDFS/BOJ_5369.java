/**
 * 문제 : Asteroid Field
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

public class BOJ_5369 {

	// 출발지 s부터 목적지 d까지 최단 거리 구하기
	// '*'는 통행 불가
	// 목적지에 도달 불가능할 시 -1 출력

	private static final int[] dRow = {-1, 1, 0, 0}, dCol = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int t = Integer.parseInt(br.readLine().trim());
		for (int tc = 0; tc < t; tc++) {
			int n = Integer.parseInt(br.readLine().trim());
			char[][] board = new char[n][n];
			boolean[][] visit = new boolean[n][n];
			int[] goal = new int[2];

			Queue<int[]> q = new ArrayDeque<>();

			// board 입력
			for (int i = 0; i < n; i++) {
				String info = br.readLine();
				for (int j = 0; j < n; j++) {
					board[i][j] = info.charAt(j);
					if (board[i][j] == 's') {
						q.offer(new int[] {i, j, 0});
						visit[i][j] = true;
					}
					if (board[i][j] == 'd') {
						goal[0] = i;
						goal[1] = j;
					}
				}
			}

			int distance = 0;
			while (!q.isEmpty()) {
				int[] cur = q.poll();
				// 목적지 도착
				if (cur[0] == goal[0] && cur[1] == goal[1]) {
					distance = cur[2];
				}

				for (int k = 0; k < 4; k++) {
					int r = cur[0] + dRow[k];
					int c = cur[1] + dCol[k];
					// 배열 범위 확인
					if (r < 0 || c < 0 || r >= n || c >= n) {
						continue;
					}
					// 통행 가능 여부 확인
					if (board[r][c] == '*') {
						continue;
					}
					// 방문 여부 확인
					if (visit[r][c]) {
						continue;
					}
					q.offer(new int[] {r, c, cur[2] + 1});
					visit[r][c] = true;
				}
			}

			distance = distance == 0 ? -1 : distance;
			bw.write(distance + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
