/**
 * 문제 : 222-풀링
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.Recursion;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_17829 {

	private static int[][] recursion(int[][] board) {
		int[][] newBoard = new int[board.length / 2][board.length / 2];
		for (int i = 0; i < board.length; i++) {
			for (int j = 0; j < board.length; j++) {
				if (i % 2 == 0 && j % 2 == 0) {
					int[] nums = new int[4];
					nums[0] = board[i][j];
					nums[1] = board[i][j + 1];
					nums[2] = board[i + 1][j];
					nums[3] = board[i + 1][j + 1];
					newBoard[i / 2][j / 2] = getNum(nums);
				}
			}
		}
		return newBoard;
	}

	private static int getNum(int[] nums) {
		Arrays.sort(nums);
		return nums[2];
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine().trim());
		int[][] board = new int[N][N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int[][] newBoard = recursion(board);
		while (newBoard.length > 1) {
			newBoard = recursion(newBoard);
		}

		bw.write(newBoard[0][0] + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
