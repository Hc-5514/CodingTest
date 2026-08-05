package Programmers._2025_코드챌린지_1차_예선;

import java.util.ArrayDeque;
import java.util.Queue;

public class 지게차와_크레인 {

	private int[] dRow = {-1, 1, 0, 0}, dCol = {0, 0, -1, 1};
	private char[][] board;

	private boolean validate(int r, int c) {
		if (r < 0 || c < 0 || r >= board.length || c >= board[0].length) {
			return false;
		}
		return true;
	}

	private void remove(char ch) {
		Queue<int[]> q = new ArrayDeque<>();
		Queue<int[]> rq = new ArrayDeque<>();
		boolean[][] visit = new boolean[board.length][board[0].length];
		q.offer(new int[] {0, 0});
		visit[0][0] = true;

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			for (int d = 0; d < 4; d++) {
				int r = cur[0] + dRow[d];
				int c = cur[1] + dCol[d];

				if (!validate(r, c)) {
					continue;
				}
				if (visit[r][c]) {
					continue;
				}
				if (board[r][c] == ch) {
					rq.offer(new int[] {r, c});
					visit[r][c] = true;
				}
				if (board[r][c] == '\0') {
					q.offer(new int[] {r, c});
					visit[r][c] = true;
				}
			}
		}

		while (!rq.isEmpty()) {
			int[] cur = rq.poll();
			board[cur[0]][cur[1]] = '\0';
		}
	}

	private void removeAll(char ch) {
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] == ch) {
					board[i][j] = '\0';
				}
			}
		}
	}

	public int solution(String[] storage, String[] requests) {
		board = new char[storage.length + 2][storage[0].length() + 2];
		for (int i = 0; i < storage.length; i++) {
			for (int j = 0; j < storage[0].length(); j++) {
				board[i + 1][j + 1] = storage[i].charAt(j);
			}
		}

		for (int i = 0; i < requests.length; i++) {
			String cmd = requests[i];
			if (cmd.length() == 1) {
				remove(cmd.charAt(0));
			} else {
				removeAll(cmd.charAt(0));
			}
		}

		int answer = 0;
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board[0].length; j++) {
				if (board[i][j] != '\0') {
					answer++;
				}
			}
		}

		return answer;
	}
}
