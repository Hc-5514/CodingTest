/**
 * 문제 : Cross Country Skiing
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.BinarySearch;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_9879 {

	private static int N, M;
	private static final int[] dRow = {-1, 1, 0, 0}, dCol = {0, 0, -1, 1};
	private static int[][] board;
	private static List<int[]> waypoints;
	private static boolean[][] visit;

	private static void bfs(int d) {
		Queue<int[]> q = new ArrayDeque<>();
		visit = new boolean[N][M];
		q.offer(new int[] {waypoints.get(0)[0], waypoints.get(0)[1]});
		visit[waypoints.get(0)[0]][waypoints.get(0)[1]] = true;

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			for (int k = 0; k < 4; k++) {
				int r = cur[0] + dRow[k];
				int c = cur[1] + dCol[k];
				if (r < 0 || c < 0 || r >= N || c >= M) {
					continue;
				}
				if (visit[r][c]) {
					continue;
				}
				if (d < Math.abs(board[cur[0]][cur[1]] - board[r][c])) {
					continue;
				}
				q.offer(new int[] {r, c});
				visit[r][c] = true;
			}
		}
	}

	private static boolean isPossible() {
		for (int[] cur : waypoints) {
			if (!visit[cur[0]][cur[1]]) {
				return false;
			}
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		board = new int[N][M];
		waypoints = new ArrayList<>();
		int maxHigh = 0;

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				maxHigh = Math.max(maxHigh, board[i][j]);
			}
		}

		// waypoints 추가
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				int n = Integer.parseInt(st.nextToken());
				if (n == 1) {
					waypoints.add(new int[] {i, j});
				}
			}
		}

		int s = 0;
		int e = maxHigh;
		int m = (s + e) >> 1;
		while (s < e) {
			m = (s + e) >> 1;
			bfs(m);
			if (isPossible()) {
				e = m;
			} else {
				s = m + 1;
			}
		}

		bw.write(s + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
