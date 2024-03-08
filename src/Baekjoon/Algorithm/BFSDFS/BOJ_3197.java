/**
 * 문제 : 백조의 호수
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
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_3197 {

	private static int R, C;
	private static final int[] dRow = {-1, 1, 0, 0}, dCol = {0, 0, -1, 1};
	private static char[][] board;
	private static int[][] coords;
	private static Queue<int[]> q, meltedIces;
	private static boolean[][] visit;

	private static void melt() {
		int size = meltedIces.size();
		while (size > 0) {
			int[] cur = meltedIces.poll();
			for (int k = 0; k < 4; k++) {
				int r = cur[0] + dRow[k];
				int c = cur[1] + dCol[k];
				if (r < 0 || c < 0 || r >= R || c >= C) {
					continue;
				}
				// 빙판이라면
				if (board[r][c] == 'X') {
					board[r][c] = '.';
					meltedIces.offer(new int[] {r, c});
				}
			}
			size--;
		}
	}

	private static boolean isSuccess() {
		Queue<int[]> nextQ = new ArrayDeque<>(); // 다음 날 얼음이 녹은 지점부터 탐색 시작
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			if (cur[0] == coords[1][0] && cur[1] == coords[1][1]) {
				return true;
			}
			for (int k = 0; k < 4; k++) {
				int r = cur[0] + dRow[k];
				int c = cur[1] + dCol[k];
				if (r < 0 || c < 0 || r >= R || c >= C) {
					continue;
				}
				if (visit[r][c]) {
					continue;
				}
				visit[r][c] = true;
				if (board[r][c] == 'X') {
					nextQ.offer(new int[] {r, c});
					continue;
				}
				q.offer(new int[] {r, c});
			}
		}
		q = nextQ;
		return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());

		board = new char[R][C];
		coords = new int[2][2];

		meltedIces = new ArrayDeque<>();
		q = new ArrayDeque<>();
		visit = new boolean[R][C];

		int idx = 0;

		for (int i = 0; i < R; i++) {
			String str = br.readLine();
			for (int j = 0; j < C; j++) {
				board[i][j] = str.charAt(j);
				// 백조 좌표 저장
				if (board[i][j] == 'L') {
					coords[idx][0] = i;
					coords[idx][1] = j;
					meltedIces.offer(new int[] {i, j});
					idx++;
				}
				if (board[i][j] == '.') {
					meltedIces.offer(new int[] {i, j});
				}
			}
		}

		q.offer(new int[] {coords[0][0], coords[0][1]});
		visit[coords[0][0]][coords[0][1]] = true;

		int day = 0;
		while (!isSuccess()) {
			melt();
			day++;
		}

		bw.write(day + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
