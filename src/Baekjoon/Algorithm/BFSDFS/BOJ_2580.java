/**
 * 문제 : 스도쿠
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.BFSDFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_2580 {

	private static int[][] board;
	private static boolean isClear;

	private static void makeBoard(int r, int c) throws IOException {
		if (isClear) {
			return;
		}

		// 스도쿠 완성
		if (r >= 9) {
			isClear = true;
			printBoard();
			return;
		}

		// 다음 행 이동
		if (c >= 9) {
			makeBoard(r + 1, 0);
			return;
		}

		// 빈칸 확인
		if (board[r][c] != 0) {
			makeBoard(r, c + 1);
			return;
		}

		// 빈칸 채우기
		for (int i = 1; i <= 9; i++) {
			if (checkRow(r, i)) {
				continue;
			}
			if (checkCol(c, i)) {
				continue;
			}
			if (checkSquare(r, c, i)) {
				continue;
			}
			board[r][c] = i;
			makeBoard(r, c + 1);
			board[r][c] = 0;
		}
	}

	private static boolean checkRow(int r, int n) {
		for (int i = 0; i < 9; i++) {
			if (board[r][i] == n) {
				return true;
			}
		}
		return false;
	}

	private static boolean checkCol(int c, int n) {
		for (int i = 0; i < 9; i++) {
			if (board[i][c] == n) {
				return true;
			}
		}
		return false;
	}

	private static boolean checkSquare(int r, int c, int n) {
		int sr = r / 3;
		int sc = c / 3;
		for (int i = 0; i < 3; i++) {
			for (int j = 0; j < 3; j++) {
				if (board[sr * 3 + i][sc * 3 + j] == n) {
					return true;
				}
			}
		}
		return false;
	}

	private static void printBoard() throws IOException {
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		for (int i = 0; i < 9; i++) {
			for (int j = 0; j < 9; j++) {
				bw.write(board[i][j] + " ");
			}
			bw.write("\n");
		}

		bw.flush();
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		board = new int[9][9];
		for (int i = 0; i < 9; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 9; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		isClear = false;
		makeBoard(0, 0);

		br.close();
	}
}
