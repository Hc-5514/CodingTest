/**
 * 문제 : 충돌위험 찾기
 *
 * @author Hc-5514
 */

package Programmers.PCCP_기출문제;

import java.util.ArrayList;
import java.util.List;

public class _3번_충돌위험_찾기 {

	// List로 로봇의 현재 위치 관리
	// int[][] board 좌표에 현재 로봇 개수 저장

	private final int boardSize = 100;
	private int[][] board;

	private int checkBoard() {
		int cnt = 0;
		for (int i = 0; i < boardSize; i++) {
			for (int j = 0; j < boardSize; j++) {
				if (board[i][j] >= 2) {
					cnt++;
				}
			}
		}
		return cnt;
	}

	public int solution(int[][] points, int[][] routes) {
		int answer = 0;
		board = new int[boardSize][boardSize]; // 0 ~ 99

		// 로봇 위치 관리
		List<int[]> coords = new ArrayList<>();
		for (int i = 0; i < routes.length; i++) {
			int route = routes[i][0] - 1;
			int r = points[route][0] - 1;
			int c = points[route][1] - 1;
			coords.add(new int[] {r, c, i, 1}); // r좌표, c좌표, route번호, route의 목표 번호
			board[r][c]++;
		}

		answer += checkBoard(); // 로봇 충돌 여부 확인

		// 로봇 이동
		while (!coords.isEmpty()) {
			for (int i = coords.size() - 1; i >= 0; i--) {
				int[] cur = coords.get(i);
				int[] goal = new int[2];
				int route = routes[cur[2]][cur[3]] - 1;
				goal[0] = points[route][0] - 1;
				goal[1] = points[route][1] - 1;

				int r = cur[0];
				int c = cur[1];
				board[r][c]--;

				// 로봇 탈출 or 라우터 번호 갱신
				if (r == goal[0] && c == goal[1]) {
					if (cur[3] == routes[0].length - 1) { // 이미 모든 목표 포인트 도달 시
						coords.remove(i);
						continue;
					} else { // 다음 포인트로 목표 변경
						coords.get(i)[3]++;
						route = routes[cur[2]][cur[3]] - 1;
						goal[0] = points[route][0] - 1;
						goal[1] = points[route][1] - 1;
					}
				}

				// 로봇 이동 (r우선)
				if (r > goal[0]) {
					r--;
				} else if (r < goal[0]) {
					r++;
				} else {
					if (c > goal[1]) {
						c--;
					} else {
						c++;
					}
				}

				// 로봇 위치 갱신
				coords.get(i)[0] = r;
				coords.get(i)[1] = c;
				board[r][c]++;
			}
			answer += checkBoard(); // 로봇 충돌 여부 확인
		}
		return answer;
	}
}
