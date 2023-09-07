/**
 * 문제 : 미로 탈출
 *
 * @author Hc-5514
 */

package Programmers.Exercise;

import java.util.ArrayDeque;
import java.util.Queue;

public class 미로_탈출 {

	public static int N, M;

	public static final int[] dRow = {-1, 1, 0, 0}, dCol = {0, 0, -1, 1};

	public static int bfs(char[][] board, int sr, int sc, int gr, int gc) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {sr, sc, 0});
		boolean[][] visit = new boolean[N][M];
		visit[sr][sc] = true;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			if (cur[0] == gr && cur[1] == gc) {
				return cur[2];
			}
			for (int k = 0; k < 4; k++) {
				int r = cur[0] + dRow[k];
				int c = cur[1] + dCol[k];
				if (r < 0 || c < 0 || r >= N || c >= M)
					continue;
				if (visit[r][c])
					continue;
				if (board[r][c] == 'X')
					continue;
				q.offer(new int[] {r, c, cur[2] + 1});
				visit[r][c] = true;
			}
		}
		return -1;
	}

	public static int solution(String[] maps) {
		// S -> L -> E 이동
		// bfs 두 번 돌리기
		N = maps.length;
		M = maps[0].length();
		char[][] board = new char[N][M];
		int sr = 0, sc = 0;
		int er = 0, ec = 0;
		int lr = 0, lc = 0;
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				board[i][j] = maps[i].charAt(j);
				if (board[i][j] == 'S') {
					sr = i;
					sc = j;
				}
				if (board[i][j] == 'E') {
					er = i;
					ec = j;
				}
				if (board[i][j] == 'L') {
					lr = i;
					lc = j;
				}
			}
		}

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				System.out.print(board[i][j] + " ");
			}
			System.out.println();
		}

		// S -> L 거리 구하기
		int cnt1 = bfs(board, sr, sc, lr, lc);
		if (cnt1 == -1) {
			return -1;
		}

		// L -> E 거리 구하기
		int cnt2 = bfs(board, lr, lc, er, ec);
		if (cnt2 == -1) {
			return -1;
		}

		return cnt1 + cnt2;
	}

	public static void main(String[] args) {
		System.out.println(solution(new String[] {"SOOOL", "XXXXO", "OOOOO", "OXXXX", "OOOOE"}));
		System.out.println(solution(new String[] {"LOOXS", "OOOOX", "OOOOO", "OOOOO", "EOOOO"}));
		System.out.println(solution(new String[] {"SOOOO", "OOOOO", "OOOOO", "OOOOO", "OOOOO", "OOOLE"}));
	}
}
