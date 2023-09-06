/**
 * 문제 : 아이템 줍기
 *
 * @author Hc-5514
 */

package Programmers.High_Score_Kit.BFSDFS;

import java.util.ArrayDeque;
import java.util.Queue;

public class 아이템_줍기 {

	public int[] dRow = {-1, 1, 0, 0}, dCol = {0, 0, -1, 1};

	public int solution(int[][] rectangle, int characterX, int characterY, int itemX, int itemY) {
		// 사각형 채우기: 테두리 1, 내부 2
		// 이미 2가 있는 경우는 그대로 (다른 사각형의 내부라면, 테두리가 될 수 없음)
		int[][] board = new int[101][101];
		for (int k = 0; k < rectangle.length; k++) {
			for (int i = rectangle[k][0] * 2; i <= rectangle[k][2] * 2; i++) {
				for (int j = rectangle[k][1] * 2; j <= rectangle[k][3] * 2; j++) {
					if (board[i][j] == 2)
						continue;
					if (i == rectangle[k][0] * 2 || i == rectangle[k][2] * 2
						|| j == rectangle[k][1] * 2 || j == rectangle[k][3] * 2) {
						board[i][j] = 1;
					} else {
						board[i][j] = 2;
					}
				}
			}
		}

		// 테두리 따라 탐색, 1
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {characterX * 2, characterY * 2, 0});
		boolean[][] visit = new boolean[101][101];
		visit[characterX * 2][characterY * 2] = true;
		while (!q.isEmpty()) {
			int[] cur = q.poll();

			if (cur[0] == itemX * 2 && cur[1] == itemY * 2) {
				return cur[2] / 2;
			}
			for (int k = 0; k < 4; k++) {
				int r = cur[0] + dRow[k];
				int c = cur[1] + dCol[k];
				if (r < 0 || c < 0 || r >= 101 || c >= 101)
					continue;
				if (visit[r][c])
					continue;
				if (board[r][c] != 1)
					continue;
				q.offer(new int[] {r, c, cur[2] + 1});
				visit[r][c] = true;
			}
		}
		return 0;
	}
}
