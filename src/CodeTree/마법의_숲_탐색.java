/**
 * 문제 : 마법의 숲 탐색
 *
 * @author Hc-5514
 */

package CodeTree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class 마법의_숲_탐색 {

	private static int n, m, result;
	private static final int[] dRow = {-1, 1, 0, 0}, dCol = {0, 0, -1, 1};
	private static int[][] board;

	private static void simulation(int r, int c, int d) {
		// 남쪽 이동 가능 여부 확인
		while (downGolem(r, c)) {
			r++;
		}

		// 서쪽 이동 가능 여부 확인
		if (leftGolem(r, c) && downGolem(r, c - 1)) {
			r++;
			c--; // 골렘 위치 수정
			d = (d == 0) ? 3 : d - 1; // 골렘 출구: 반시계 방향 회전
			simulation(r, c, d);
			return;
		}

		// 동쪽 이동 가능 여부 확인
		if (rightGolem(r, c) && downGolem(r, c + 1)) {
			r++;
			c++; // 골렘 위치 수정
			d = (d == 3) ? 0 : d + 1; // 골렘 출구: 시계 방향 회전
			simulation(r, c, d);
			return;
		}

		// 골렘이 숲 범위 벗어났는지 확인
		if (checkRange(r)) {
			saveGolem(r, c, d); // 골렘 위치 저장
			result += (moveFairy(r, c) + 1); // 정령 이동
		} else {
			board = new int[n][m]; // 초기화
		}
	}

	private static boolean downGolem(int r, int c) {
		// 골렘이 숲 밖일 때
		if (r == -2 && board[0][c] == 0) {
			return true;
		}
		// 중
		if (r + 2 >= n || board[r + 2][c] != 0) {
			return false;
		}
		// 좌
		if (c - 1 < 0 || board[r + 1][c - 1] != 0) {
			return false;
		}
		// 우
		if (c + 1 >= m || board[r + 1][c + 1] != 0) {
			return false;
		}
		return true;
	}

	private static boolean leftGolem(int r, int c) {
		// 골렘이 숲 밖일 때
		if (r == -2) {
			return true;
		}
		if (r == -1) {
			return c >= 1 && board[0][c - 1] == 0;
		}
		// 중
		if (c - 2 < 0 || board[r][c - 2] != 0) {
			return false;
		}
		// 상
		if (r >= 1) {
			if (board[r - 1][c - 1] != 0) {
				return false;
			}
		}
		// 하
		return board[r + 1][c - 1] == 0;
	}

	private static boolean rightGolem(int r, int c) {
		// 골렘이 숲 밖일 때
		if (r == -2) {
			return true;
		}
		if (r == -1) {
			return c < m - 1 && board[0][c + 1] == 0;
		}
		// 중
		if (c + 2 >= m || board[r][c + 2] != 0) {
			return false;
		}
		// 상
		if (r >= 1) {
			if (board[r - 1][c + 1] != 0) {
				return false;
			}
		}
		// 하
		return board[r + 1][c + 1] == 0;
	}

	private static int moveFairy(int sR, int sC) {
		int res = 1;
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {sR, sC});
		boolean[][] visit = new boolean[n][m];
		visit[sR][sC] = true;

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			if (board[cur[0]][cur[1]] == 3) { // 골렘의 중심: 출구로 이동
				// res = Math.max(res, cur[0] + 1);
				if (res < cur[0] + 1) {
					res = cur[0] + 1;
					// System.out.println("r: " + cur[0] + ", c: " + cur[1]);
				}
				for (int k = 0; k < 4; k++) {
					int r = cur[0] + dRow[k];
					int c = cur[1] + dCol[k];
					if (r < 0 || c < 0 || r >= n || c >= m) {
						continue;
					}
					if (visit[r][c]) {
						continue;
					}
					if (board[r][c] == 2) {
						q.offer(new int[] {r, c});
						visit[r][c] = true;
					}
				}
			} else if (board[cur[0]][cur[1]] == 2) { // 골렘의 출구: 다른 칸으로 이동
				for (int k = 0; k < 4; k++) {
					int r = cur[0] + dRow[k];
					int c = cur[1] + dCol[k];
					if (r < 0 || c < 0 || r >= n || c >= m) {
						continue;
					}
					if (visit[r][c]) {
						continue;
					}
					if (board[r][c] != 0) {
						q.offer(new int[] {r, c});
						visit[r][c] = true;
					}
				}
			} else if (board[cur[0]][cur[1]] == 1) { // 골렘 중심으로 이동
				for (int k = 0; k < 4; k++) {
					int r = cur[0] + dRow[k];
					int c = cur[1] + dCol[k];
					if (r < 0 || c < 0 || r >= n || c >= m) {
						continue;
					}
					if (visit[r][c]) {
						continue;
					}
					if (board[r][c] == 3) {
						q.offer(new int[] {r, c});
						visit[r][c] = true;
					}
				}
			}
		}
		// System.out.println(res);
		return res;
	}

	private static boolean checkRange(int r) {
		return (r > 0);
	}

	private static void saveGolem(int r, int c, int d) {
		board[r][c] = 3;
		board[r - 1][c] = (d == 0) ? 2 : 1;
		board[r + 1][c] = (d == 2) ? 2 : 1;
		board[r][c - 1] = (d == 3) ? 2 : 1;
		board[r][c + 1] = (d == 1) ? 2 : 1;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 5 <= r <= 70
		m = Integer.parseInt(st.nextToken()); // 5 <= c <= 70
		int k = Integer.parseInt(st.nextToken()); // 정령 수 (1 <= k <= 1,000)
		result = 0;

		board = new int[n][m];

		for (int i = 0; i < k; i++) {
			st = new StringTokenizer(br.readLine());
			int s = Integer.parseInt(st.nextToken());
			int d = Integer.parseInt(st.nextToken()); // 0~3: 북동남서
			simulation(-2, s - 1, d);
		}

		bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
