package Programmers.PCCP_기출문제;

public class _4번_수레_움직이기 {

	int answer;
	int[] dRow = {-1, 1, 0, 0}, dCol = {0, 0, -1, 1};
	int[][] board;
	boolean[][] rVisit, bVisit;

	private void move(int rr, int rc, int br, int bc, boolean isRGoal, boolean isBGoal, int round) {
		if (isRGoal && isBGoal) {
			answer = Math.min(answer, round);
			return;
		}
		if (answer <= round) {
			return;
		}
		for (int i = 0; i < 4; i++) {
			int nrr = 0, nrc = 0;
			if (isRGoal) {
				nrr = rr;
				nrc = rc;
			} else {
				nrr = rr + dRow[i];
				nrc = rc + dCol[i];
			}
			for (int j = 0; j < 4; j++) {
				int nbr = 0, nbc = 0;
				if (isBGoal) {
					nbr = br;
					nbc = bc;
				} else {
					nbr = br + dRow[j];
					nbc = bc + dCol[j];
				}
				if (!isValidatate(nrr, nrc, nbr, nbc)) {
					continue;
				}
				// 욌던 곳 재방문 x
				if (!isRGoal && rVisit[nrr][nrc]) {
					continue;
				}
				if (!isBGoal && bVisit[nbr][nbc]) {
					continue;
				}
				// 서로 자리 바꾸기 x
				if (nrr == br && nrc == bc && nbr == rr && nbc == rc) {
					continue;
				}
				// 같은 지점 방문 x
				if (nrr == nbr && nrc == nbc) {
					continue;
				}
				// 목표 지점 도달 확인
				boolean nextRGoal = (board[nrr][nrc] == 3);
				boolean nextBGoal = (board[nbr][nbc] == 4);

				rVisit[nrr][nrc] = true;
				bVisit[nbr][nbc] = true;
				move(nrr, nrc, nbr, nbc, nextRGoal, nextBGoal, round + 1);
				if (!isRGoal)
					rVisit[nrr][nrc] = false;
				if (!isBGoal)
					bVisit[nbr][nbc] = false;
			}
		}
	}

	private boolean isValidatate(int rr, int rc, int br, int bc) {
		// 퍼즐판 크기 확인
		if (rr < 0 || rc < 0 || br < 0 || bc < 0 ||
			rr >= board.length || rc >= board[0].length || br >= board.length || bc >= board[0].length) {
			return false;
		}
		// 벽 이동 x
		if (board[rr][rc] == 5 || board[br][bc] == 5) {
			return false;
		}
		return true;
	}

	public int solution(int[][] maze) {
		// 시작 칸 확인
		int rr = 0, rc = 0, br = 0, bc = 0;
		for (int i = 0; i < maze.length; i++) {
			for (int j = 0; j < maze[0].length; j++) {
				if (maze[i][j] == 1) {
					rr = i;
					rc = j;
				}
				if (maze[i][j] == 2) {
					br = i;
					bc = j;
				}
			}
		}

		answer = Integer.MAX_VALUE;
		rVisit = new boolean[maze.length][maze[0].length];
		bVisit = new boolean[maze.length][maze[0].length];
		rVisit[rr][rc] = true;
		bVisit[br][bc] = true;
		board = maze;

		move(rr, rc, br, bc, false, false, 0);

		// 못 풀 경우 0 반환
		return (answer == Integer.MAX_VALUE) ? 0 : answer;
	}
}
