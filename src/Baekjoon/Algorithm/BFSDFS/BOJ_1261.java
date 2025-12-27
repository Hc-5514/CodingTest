/**
 * 문제: 알고스팟
 * 난이도: 골드 4
 * 메모리: 12236KB, 시간: 80ms
 * 풀이: 0-1 BFS
 */

package Baekjoon.Algorithm.BFSDFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.StringTokenizer;

public class BOJ_1261 {

	private static final int INF = 1_000_000_000;
	private static final int[] dRow = {-1, 1, 0, 0}, dCol = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		// (0,0) -> (n-1,m-1) 이동 시, 벽을 최소 몇 개 부숴야 하는가?

		// n x m 크기 map 입력
		st = new StringTokenizer(br.readLine());
		int m = Integer.parseInt(st.nextToken());
		int n = Integer.parseInt(st.nextToken());

		int[][] map = new int[n][m];

		for (int i = 0; i < n; i++) {
			String inputString = br.readLine();
			for (int j = 0; j < m; j++) {
				map[i][j] = inputString.charAt(j) - '0';
			}
		}

		// 0-1 BFS
		int[][] dist = new int[n][m];
		for (int i = 0; i < n; i++) {
			Arrays.fill(dist[i], INF);
		}

		Deque<Room> dq = new ArrayDeque<>();
		dist[0][0] = 0;
		dq.offerFirst(new Room(0, 0, 0));

		while (!dq.isEmpty()) {
			Room cur = dq.pollFirst();
			// 스테일 상태 스킵
			if (cur.cnt != dist[cur.r][cur.c]) {
				continue;
			}
			// 도착시 종료
			if (cur.r == n - 1 && cur.c == m - 1) {
				break;
			}
			// 탐색
			for (int k = 0; k < 4; k++) {
				int r = cur.r + dRow[k];
				int c = cur.c + dCol[k];
				if (r < 0 || r >= n || c < 0 || c >= m) {
					continue;
				}
				int w = map[r][c];
				int nd = cur.cnt + w;
				if (dist[r][c] > nd) {
					dist[r][c] = nd;
					if (w == 0) {
						dq.offerFirst(new Room(r, c, nd));
					} else {
						dq.offerLast(new Room(r, c, nd));
					}
				}
			}
		}

		bw.write(dist[n - 1][m - 1] + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

	private static class Room {
		int r;
		int c;
		int cnt;

		public Room(int r, int c, int cnt) {
			this.r = r;
			this.c = c;
			this.cnt = cnt;
		}
	}
}