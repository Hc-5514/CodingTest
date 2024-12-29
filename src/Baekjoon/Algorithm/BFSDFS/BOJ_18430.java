/**
 * 문제 : 무기 공학
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
import java.util.stream.Stream;

public class BOJ_18430 {

	private static int n, m, maxStrength;
	private static int[][] board;
	private static boolean[][] visit;

	private static void simulate(int r, int c, int prevStrength) {
		if (r == n - 1 && c == m) {
			maxStrength = Math.max(maxStrength, prevStrength);
			return;
		}

		if (c == m) {
			r += 1;
			c = 0;
		}

		if (visit[r][c]) {
			simulate(r, c + 1, prevStrength);
			return;
		}

		// 해당 칸을 중심으로 4가지 경우의 수 탐색
		makeBoomerang1(r, c, prevStrength);
		makeBoomerang2(r, c, prevStrength);
		makeBoomerang3(r, c, prevStrength);
		makeBoomerang4(r, c, prevStrength);
		simulate(r, c + 1, prevStrength);
	}

	private static void makeBoomerang1(int i, int j, int prevStrength) {
		if (j - 1 < 0 || i + 1 >= n) {
			return;
		}
		if (visit[i][j - 1] || visit[i + 1][j]) {
			return;
		}
		visit[i][j - 1] = visit[i][j] = visit[i + 1][j] = true;
		int strength = (board[i][j - 1] + board[i][j] * 2 + board[i + 1][j]);
		simulate(i, j + 1, prevStrength + strength);
		visit[i][j - 1] = visit[i][j] = visit[i + 1][j] = false;
	}

	private static void makeBoomerang2(int i, int j, int prevStrength) {
		if (j - 1 < 0 || i - 1 < 0) {
			return;
		}
		if (visit[i][j - 1] || visit[i - 1][j]) {
			return;
		}
		visit[i][j - 1] = visit[i][j] = visit[i - 1][j] = true;
		int strength = (board[i][j - 1] + board[i][j] * 2 + board[i - 1][j]);
		simulate(i, j + 1, prevStrength + strength);
		visit[i][j - 1] = visit[i][j] = visit[i - 1][j] = false;
	}

	private static void makeBoomerang3(int i, int j, int prevStrength) {
		if (i - 1 < 0 || j + 1 >= m) {
			return;
		}
		if (visit[i - 1][j] || visit[i][j + 1]) {
			return;
		}
		visit[i - 1][j] = visit[i][j] = visit[i][j + 1] = true;
		int strength = (board[i - 1][j] + board[i][j] * 2 + board[i][j + 1]);
		simulate(i, j + 1, prevStrength + strength);
		visit[i - 1][j] = visit[i][j] = visit[i][j + 1] = false;
	}

	private static void makeBoomerang4(int i, int j, int prevStrength) {
		if (j + 1 >= m || i + 1 >= n) {
			return;
		}
		if (visit[i][j + 1] || visit[i + 1][j]) {
			return;
		}
		visit[i][j + 1] = visit[i][j] = visit[i + 1][j] = true;
		int strength = (board[i][j + 1] + board[i][j] * 2 + board[i + 1][j]);
		simulate(i, j + 1, prevStrength + strength);
		visit[i][j + 1] = visit[i][j] = visit[i + 1][j] = false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		// init
		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		board = new int[n][m];
		visit = new boolean[n][m];

		for (int i = 0; i < n; i++) {
			board[i] = Stream.of(br.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
		}

		// simulation
		simulate(0, 0, 0);

		bw.write(maxStrength + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
