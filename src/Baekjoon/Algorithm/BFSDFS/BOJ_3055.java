/**
 * 문제 : 탈출
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.BFSDFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_3055 {

	private static final int[] dRow = {-1, 1, 0, 0}, dCol = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int R = Integer.parseInt(st.nextToken());
		int C = Integer.parseInt(st.nextToken());

		char[][] board = new char[R][C];
		int[][] water = new int[R][C];
		int[] goal = new int[2];
		int[] start = new int[2];

		for (int i = 0; i < R; i++) {
			Arrays.fill(water[i], Integer.MAX_VALUE);
		}

		Queue<int[]> waterQ = new ArrayDeque<>();

		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				board[i][j] = str.charAt(j);
				// 비버
				if (board[i][j] == 'D') {
					goal[0] = i;
					goal[1] = j;
				}
				// 고슴도치
				if (board[i][j] == 'S') {
					start[0] = i;
					start[1] = j;
				}
				// 물
				if (board[i][j] == '*') {
					water[i][j] = 0;
					waterQ.offer(new int[] {i, j});
				}
			}
		}

		// 물 확장
		while (!waterQ.isEmpty()) {
			int[] cur = waterQ.poll();
			for (int k = 0; k < 4; k++) {
				int r = cur[0] + dRow[k];
				int c = cur[1] + dCol[k];
				if (r < 0 || c < 0 || r >= R || c >= C) {
					continue;
				}
				if (board[r][c] == 'X' || board[r][c] == 'D') {
					continue;
				}
				if (water[r][c] <= water[cur[0]][cur[1]] + 1) {
					continue;
				}
				waterQ.offer(new int[] {r, c});
				water[r][c] = water[cur[0]][cur[1]] + 1;
			}
		}

		boolean[][] visit = new boolean[R][C];

		boolean isPossible = false;
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {start[0], start[1], 0});
		visit[start[0]][start[1]] = true;
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			if (cur[0] == goal[0] && cur[1] == goal[1]) {
				bw.write(cur[2] + "\n");
				isPossible = true;
				break;
			}
			for (int k = 0; k < 4; k++) {
				int r = cur[0] + dRow[k];
				int c = cur[1] + dCol[k];
				if (r < 0 || c < 0 || r >= R || c >= C) {
					continue;
				}
				if (board[r][c] == 'X') {
					continue;
				}
				if (visit[r][c]) {
					continue;
				}
				if (cur[2] + 1 >= water[r][c]) {
					continue;
				}
				q.offer(new int[] {r, c, cur[2] + 1});
				visit[r][c] = true;
			}
		}

		if (!isPossible) {
			bw.write("KAKTUS\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
