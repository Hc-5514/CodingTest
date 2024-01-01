/**
 * 문제 : 알고스팟
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
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_1261 {

	private static final int[] dRow = {-1, 1, 0, 0}, dCol = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int M = Integer.parseInt(st.nextToken()); // 1 <= N <= 100
		int N = Integer.parseInt(st.nextToken()); // 1 <= M <= 100

		// 출발: (0,0), 도착: (N-1, M-1)
		char[][] board = new char[N][M];
		int[][] visit = new int[N][M]; // 해당 방으로 이동하기 위해 벽을 최소 몇 개를 부숴야 하는지 저장

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			for (int j = 0; j < M; j++) {
				board[i][j] = str.charAt(j);
			}
		}

		for (int i = 0; i < N; i++) {
			Arrays.fill(visit[i], N * M);
		}

		visit[0][0] = 0;

		Deque<Room> q = new ArrayDeque<>();
		q.offer(new Room(0, 0, 0));

		while (!q.isEmpty()) {
			Room cur = q.poll();

			// 목적지 도착
			if (cur.r == N - 1 && cur.c == M - 1) {
				if (cur.cnt < visit[N - 1][M - 1]) {
					visit[N - 1][M - 1] = cur.cnt;
					break;
				}
			}

			// board 4방향 탐색. 0이라면 현재 cnt 그대로, 1이라면 cnt+1
			// visit 의 값과 cnt 값을 비교하여 이동
			for (int k = 0; k < 4; k++) {
				int r = cur.r + dRow[k];
				int c = cur.c + dCol[k];

				if (r < 0 || c < 0 || r >= N || c >= M) {
					continue;
				}

				if (board[r][c] == '0') {
					if (cur.cnt >= visit[r][c]) {
						continue;
					}
					visit[r][c] = cur.cnt;
					q.addFirst(new Room(r, c, cur.cnt));
				} else {
					if (cur.cnt + 1 >= visit[r][c]) {
						continue;
					}
					visit[r][c] = cur.cnt + 1;
					q.offer(new Room(r, c, cur.cnt + 1));
				}
			}
		}

		bw.write(visit[N - 1][M - 1] + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

	static class Room {
		int r;
		int c;
		int cnt;

		public Room(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}
}