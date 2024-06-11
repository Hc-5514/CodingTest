/**
 * 문제 : Dynamic Grid (Small)
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

public class BOJ_12050 {

	private static int R, C;
	private static final int[] dRow = {-1, 1, 0, 0}, dCol = {0, 0, -1, 1};
	private static int[][] board;

	private static int bfs() {
		boolean[][] visit = new boolean[R][C];
		int cnt = 0;

		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (visit[i][j]) {
					continue;
				}
				if (board[i][j] == 0) {
					continue;
				}
				Queue<int[]> q = new ArrayDeque<>();
				q.offer(new int[] {i, j});
				visit[i][j] = true;
				while (!q.isEmpty()) {
					int[] cur = q.poll();
					for (int k = 0; k < 4; k++) {
						int r = cur[0] + dRow[k];
						int c = cur[1] + dCol[k];
						if (r < 0 || c < 0 || r >= R || c >= C) {
							continue;
						}
						if (visit[r][c]) {
							continue;
						}
						if (board[r][c] == 0) {
							continue;
						}
						q.offer(new int[] {r, c});
						visit[r][c] = true;
					}
				}
				cnt++;
			}
		}
		return cnt;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			R = Integer.parseInt(st.nextToken());
			C = Integer.parseInt(st.nextToken());
			board = new int[R][C];
			for (int i = 0; i < R; i++) {
				String str = br.readLine();
				for (int j = 0; j < C; j++) {
					board[i][j] = Character.getNumericValue(str.charAt(j));
				}
			}

			bw.write("Case #" + tc + ":\n");

			int N = Integer.parseInt(br.readLine().trim());
			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				char cmd = st.nextToken().charAt(0);
				switch (cmd) {
					case 'Q':
						bw.write(bfs() + "\n");
						break;
					case 'M':
						int x = Integer.parseInt(st.nextToken());
						int y = Integer.parseInt(st.nextToken());
						int z = Integer.parseInt(st.nextToken());
						board[x][y] = z;
						break;
				}
			}
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
