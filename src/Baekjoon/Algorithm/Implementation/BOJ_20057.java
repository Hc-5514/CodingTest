/**
 * 문제 : 마법사 상어와 토네이도
 * 소요 시간 : 1시간 10분
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.Implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.stream.Stream;

public class BOJ_20057 {

	// NxN 격자 밖으로 나간 모래 양 구하기
	// 격자의 가운데 칸부터 한칸씩 이동
	private static int n, d, result;
	private static int[] curCoords;
	private static final int[] dRow = {0, 1, 0, -1}, dCol = {-1, 0, 1, 0};
	private static int[][] board;

	private static void moveSandUp() {
		// 이동 할 모래 위치
		int r = curCoords[0] - 1;
		int c = curCoords[1];
		int restAmount = board[r][c]; // 현재 남은 모래 양

		// 모래 이동
		int amount = (int)Math.floor(board[r][c] * 2 / 100); // 이동할 모래 양
		restAmount -= amount * 2;

		if (isOutRange(r, c - 2)) {
			result += amount;
		} else {
			board[r][c - 2] += amount;
		}

		if (isOutRange(r, c + 2)) {
			result += amount;
		} else {
			board[r][c + 2] += amount;
		}

		amount = (int)Math.floor(board[r][c] * 10 / 100);
		restAmount -= amount * 2;

		if (isOutRange(r - 1, c - 1)) {
			result += amount;
		} else {
			board[r - 1][c - 1] += amount;
		}

		if (isOutRange(r - 1, c + 1)) {
			result += amount;
		} else {
			board[r - 1][c + 1] += amount;
		}

		amount = (int)Math.floor(board[r][c] * 7 / 100);
		restAmount -= amount * 2;

		if (isOutRange(r, c - 1)) {
			result += amount;
		} else {
			board[r][c - 1] += amount;
		}

		if (isOutRange(r, c + 1)) {
			result += amount;
		} else {
			board[r][c + 1] += amount;
		}

		amount = (int)Math.floor(board[r][c] * 1 / 100);
		restAmount -= amount * 2;

		if (isOutRange(r + 1, c - 1)) {
			result += amount;
		} else {
			board[r + 1][c - 1] += amount;
		}

		if (isOutRange(r + 1, c + 1)) {
			result += amount;
		} else {
			board[r + 1][c + 1] += amount;
		}

		amount = (int)Math.floor(board[r][c] * 5 / 100);
		restAmount -= amount;
		if (isOutRange(r - 2, c)) {
			result += amount;
		} else {
			board[r - 2][c] += amount;
		}

		if (isOutRange(r - 1, c)) {
			result += restAmount;
		} else {
			board[r - 1][c] += restAmount;
		}

		board[r][c] = 0;
	}

	private static void moveSandDown() {
		// 이동 할 모래 위치
		int r = curCoords[0] + 1;
		int c = curCoords[1];
		int restAmount = board[r][c]; // 현재 남은 모래 양

		// 모래 이동
		int amount = (int)Math.floor(board[r][c] * 2 / 100); // 이동할 모래 양
		restAmount -= amount * 2;

		if (isOutRange(r, c - 2)) {
			result += amount;
		} else {
			board[r][c - 2] += amount;
		}

		if (isOutRange(r, c + 2)) {
			result += amount;
		} else {
			board[r][c + 2] += amount;
		}

		amount = (int)Math.floor(board[r][c] * 10 / 100);
		restAmount -= amount * 2;

		if (isOutRange(r + 1, c - 1)) {
			result += amount;
		} else {
			board[r + 1][c - 1] += amount;
		}

		if (isOutRange(r + 1, c + 1)) {
			result += amount;
		} else {
			board[r + 1][c + 1] += amount;
		}

		amount = (int)Math.floor(board[r][c] * 7 / 100);
		restAmount -= amount * 2;

		if (isOutRange(r, c - 1)) {
			result += amount;
		} else {
			board[r][c - 1] += amount;
		}

		if (isOutRange(r, c + 1)) {
			result += amount;
		} else {
			board[r][c + 1] += amount;
		}

		amount = (int)Math.floor(board[r][c] * 1 / 100);
		restAmount -= amount * 2;

		if (isOutRange(r - 1, c - 1)) {
			result += amount;
		} else {
			board[r - 1][c - 1] += amount;
		}

		if (isOutRange(r - 1, c + 1)) {
			result += amount;
		} else {
			board[r - 1][c + 1] += amount;
		}

		amount = (int)Math.floor(board[r][c] * 5 / 100);
		restAmount -= amount;
		if (isOutRange(r + 2, c)) {
			result += amount;
		} else {
			board[r + 2][c] += amount;
		}

		if (isOutRange(r + 1, c)) {
			result += restAmount;
		} else {
			board[r + 1][c] += restAmount;
		}

		board[r][c] = 0;
	}

	private static void moveSandLeft() {
		// 이동 할 모래 위치
		int r = curCoords[0];
		int c = curCoords[1] - 1;
		int restAmount = board[r][c]; // 현재 남은 모래 양

		// 모래 이동
		int amount = (int)Math.floor(board[r][c] * 2 / 100); // 이동할 모래 양
		restAmount -= amount * 2;

		if (isOutRange(r - 2, c)) {
			result += amount;
		} else {
			board[r - 2][c] += amount;
		}

		if (isOutRange(r + 2, c)) {
			result += amount;
		} else {
			board[r + 2][c] += amount;
		}

		amount = (int)Math.floor(board[r][c] * 10 / 100);
		restAmount -= amount * 2;

		if (isOutRange(r - 1, c - 1)) {
			result += amount;
		} else {
			board[r - 1][c - 1] += amount;
		}

		if (isOutRange(r + 1, c - 1)) {
			result += amount;
		} else {
			board[r + 1][c - 1] += amount;
		}

		amount = (int)Math.floor(board[r][c] * 7 / 100);
		restAmount -= amount * 2;

		if (isOutRange(r - 1, c)) {
			result += amount;
		} else {
			board[r - 1][c] += amount;
		}

		if (isOutRange(r + 1, c)) {
			result += amount;
		} else {
			board[r + 1][c] += amount;
		}

		amount = (int)Math.floor(board[r][c] * 1 / 100);
		restAmount -= amount * 2;

		if (isOutRange(r - 1, c + 1)) {
			result += amount;
		} else {
			board[r - 1][c + 1] += amount;
		}

		if (isOutRange(r + 1, c + 1)) {
			result += amount;
		} else {
			board[r + 1][c + 1] += amount;
		}

		amount = (int)Math.floor(board[r][c] * 5 / 100);
		restAmount -= amount;
		if (isOutRange(r, c - 2)) {
			result += amount;
		} else {
			board[r][c - 2] += amount;
		}

		if (isOutRange(r, c - 1)) {
			result += restAmount;
		} else {
			board[r][c - 1] += restAmount;
		}

		board[r][c] = 0;
	}

	private static void moveSandRight() {
		// 이동 할 모래 위치
		int r = curCoords[0];
		int c = curCoords[1] + 1;
		int restAmount = board[r][c]; // 현재 남은 모래 양

		// 모래 이동
		int amount = (int)Math.floor(board[r][c] * 2 / 100); // 이동할 모래 양
		restAmount -= amount * 2;

		if (isOutRange(r - 2, c)) {
			result += amount;
		} else {
			board[r - 2][c] += amount;
		}

		if (isOutRange(r + 2, c)) {
			result += amount;
		} else {
			board[r + 2][c] += amount;
		}

		amount = (int)Math.floor(board[r][c] * 10 / 100);
		restAmount -= amount * 2;

		if (isOutRange(r - 1, c + 1)) {
			result += amount;
		} else {
			board[r - 1][c + 1] += amount;
		}

		if (isOutRange(r + 1, c + 1)) {
			result += amount;
		} else {
			board[r + 1][c + 1] += amount;
		}

		amount = (int)Math.floor(board[r][c] * 7 / 100);
		restAmount -= amount * 2;

		if (isOutRange(r - 1, c)) {
			result += amount;
		} else {
			board[r - 1][c] += amount;
		}

		if (isOutRange(r + 1, c)) {
			result += amount;
		} else {
			board[r + 1][c] += amount;
		}

		amount = (int)Math.floor(board[r][c] * 1 / 100);
		restAmount -= amount * 2;

		if (isOutRange(r - 1, c - 1)) {
			result += amount;
		} else {
			board[r - 1][c - 1] += amount;
		}

		if (isOutRange(r + 1, c - 1)) {
			result += amount;
		} else {
			board[r + 1][c - 1] += amount;
		}

		amount = (int)Math.floor(board[r][c] * 5 / 100);
		restAmount -= amount;
		if (isOutRange(r, c + 2)) {
			result += amount;
		} else {
			board[r][c + 2] += amount;
		}

		if (isOutRange(r, c + 1)) {
			result += restAmount;
		} else {
			board[r][c + 1] += restAmount;
		}

		board[r][c] = 0;
	}

	private static boolean isOutRange(int r, int c) {
		return (r < 0 || c < 0 || r >= n || c >= n);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// init
		n = Integer.parseInt(br.readLine().trim());
		board = new int[n][n];
		result = 0; // 격자 밖으로 나간 모래 양
		curCoords = new int[] {n / 2, n / 2}; // 현재 r,c 위치
		d = 0; // 이동방향: 좌, 하, 우, 상

		// NxN 격자 입력
		for (int i = 0; i < n; i++) {
			board[i] = Stream.of(br.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
		}

		// 토네이도 이동: (0,0)에 도달할 때까지
		int goalCnt = 1; // 현재 방향으로 이동해야 하는 칸 수
		int cnt = 0; // 현재 방향으로 이동한 칸 수
		while (curCoords[0] != 0 || curCoords[1] != 0) {
			// 이동
			if (d == 0) {
				moveSandLeft();
			} else if (d == 1) {
				moveSandDown();
			} else if (d == 2) {
				moveSandRight();
			} else {
				moveSandUp();
			}
			curCoords[0] += dRow[d];
			curCoords[1] += dCol[d];
			cnt++;

			// 이동 방향, 이동 양 업데이트
			if (goalCnt == cnt) {
				d = (d + 1) % 4;
				cnt = 0;
				if (d == 0 || d == 2) {
					goalCnt++;
				}
			}
		}

		// 출력
		bw.write(result + "\n");

		bw.flush();
		bw.close();
		br.close();
	}
}
