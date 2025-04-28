/**
 * 문제: 틱택토
 * 난이도: 골드 5
 * 메모리: 11544KB, 시간: 68ms
 * 풀이: 구현
 */

package Baekjoon.Algorithm.Implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_7682 {

	// 3x3 격자판
	// 첫 사람 X로 시작
	// 가로, 세로, 대각선 방향 중 3칸을 이으면 종료

	private static int xCnt, oCnt, bCnt;
	private static char[][] board;

	private static void init(String input) {
		xCnt = oCnt = bCnt = 0;
		board = new char[3][3];
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				board[i][j] = input.charAt(i * 3 + j);
				if (board[i][j] == 'X') {
					xCnt++;
				} else if (board[i][j] == 'O') {
					oCnt++;
				} else {
					bCnt++;
				}
			}
		}
	}

	/**
	 * 빙고 완성 여부 확인
	 * @return -1(에러), 0(없음), 1(X 빙고), 2(O 빙고)
	 */
	private static int checkBingo() {
		int result = 0;
		// 가로 빙고
		for (int i = 0; i < 3; i++) {
			if (board[i][0] == board[i][1] && board[i][1] == board[i][2]) {
				if (board[i][0] == 'X') {
					if (result == 2) { // X, O 모두 빙고
						return -1;
					}
					result = 1;
				} else if (board[i][0] == 'O') {
					if (result == 1) { // X, O 모두 빙고
						return -1;
					}
					result = 2;
				}
			}
		}
		// 세로 빙고
		for (int i = 0; i < 3; i++) {
			if (board[0][i] == board[1][i] && board[1][i] == board[2][i]) {
				if (board[0][i] == 'X') {
					if (result == 2) { // X, O 모두 빙고
						return -1;
					}
					result = 1;
				} else if (board[0][i] == 'O') {
					if (result == 1) { // X, O 모두 빙고
						return -1;
					}
					result = 2;
				}
			}
		}
		// 대각선 빙고
		if (board[0][0] == board[1][1] && board[1][1] == board[2][2]) {
			if (board[0][0] == 'X') {
				if (result == 2) { // X, O 모두 빙고
					return -1;
				}
				result = 1;
			} else if (board[0][0] == 'O') {
				if (result == 1) { // X, O 모두 빙고
					return -1;
				}
				result = 2;
			}
		}

		if (board[0][2] == board[1][1] && board[1][1] == board[2][0]) {
			if (board[0][2] == 'X') {
				if (result == 2) { // X, O 모두 빙고
					return -1;
				}
				result = 1;
			} else if (board[0][2] == 'O') {
				if (result == 1) { // X, O 모두 빙고
					return -1;
				}
				result = 2;
			}
		}
		return result;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		while (true) {
			String input = br.readLine();
			if (input.equals("end")) {
				break;
			}

			init(input);

			// 1. x의 개수는 o의 개수와 같거나 1개 더 많다.
			if (!(xCnt == oCnt || xCnt == (oCnt + 1))) {
				bw.write("invalid\n");
				continue;
			}

			// 2. 빙고 여부 확인
			int resultBingo = checkBingo();
			if (resultBingo == 1) { // X 빙고
				if (xCnt == (oCnt + 1)) {
					bw.write("valid\n");
				} else {
					bw.write("invalid\n");
				}
			} else if (resultBingo == 2) { // O 빙고
				if (xCnt == oCnt) {
					bw.write("valid\n");
				} else {
					bw.write("invalid\n");
				}
			} else if (resultBingo == -1) { // 두 줄 이상 빙고
				bw.write("invalid\n");
			} else { // 빙고 없음
				// 3. 추가 진행 가능 여부 확인
				if (bCnt > 0) {
					bw.write("invalid\n");
				} else {
					bw.write("valid\n");
				}
			}
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
