/**
 * 문제 : 재미있는 오셀로 게임
 *
 * @author Hc-5514
 */

package SWEA.Difficulty_3;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class SWEA_D3_4615 {

	private static int N, bCnt, wCnt;
	private static final int[] dRow = {-1, 1, 0, 0, -1, 1, 1, -1}, dCol = {0, 0, -1, 1, -1, -1, 1, 1};
	private static int[][] board;

	private static void init() {
		board = new int[N][N];
		bCnt = 2;
		wCnt = 2;

		board[N / 2 - 1][N / 2 - 1] = 2;
		board[N / 2 - 1][N / 2] = 1;
		board[N / 2][N / 2 - 1] = 1;
		board[N / 2][N / 2] = 2;
	}

	private static void play(int sr, int sc, int color) {
		// 8방향 탐색
		for (int k = 0; k < 8; k++) {
			int r = sr;
			int c = sc;

			Queue<int[]> q = new ArrayDeque<>();
			boolean isPossible = false;

			// 뒤집을 돌이 있는지 확인
			while (true) {
				r += dRow[k];
				c += dCol[k];

				if (r < 0 || c < 0 || r >= N || c >= N) {
					break;
				}

				if (board[r][c] == 0) {
					break;
				}

				if (board[r][c] == color) {
					isPossible = true;
					break;
				}

				q.offer(new int[] {r, c, board[r][c]});
			}

			// 돌 뒤집기
			if (isPossible) {
				while (!q.isEmpty()) {
					int[] cur = q.poll();

					if (cur[2] == 1) {
						board[cur[0]][cur[1]] = 2;
						wCnt++;
						bCnt--;
					} else {
						board[cur[0]][cur[1]] = 1;
						wCnt--;
						bCnt++;
					}
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			st = new StringTokenizer(br.readLine());
			N = Integer.parseInt(st.nextToken()); // 4, 6, 8
			int M = Integer.parseInt(st.nextToken());

			init();

			for (int i = 0; i < M; i++) {
				st = new StringTokenizer(br.readLine());
				int c = Integer.parseInt(st.nextToken()) - 1;
				int r = Integer.parseInt(st.nextToken()) - 1;
				int color = Integer.parseInt(st.nextToken());

				board[r][c] = color;
				if (color == 1) {
					bCnt++;
				} else {
					wCnt++;
				}

				play(r, c, color);
			}

			bw.write("#" + tc + " " + bCnt + " " + wCnt + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
