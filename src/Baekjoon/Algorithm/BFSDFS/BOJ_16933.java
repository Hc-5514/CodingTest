/**
 * 문제 : 벽 부수고 이동하기 3
 * 소요 시간 : 1시간 51분
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.BFSDFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_16933 {

	private static int N, M, K, distance;
	private static final int[] dRow = {-1, 1, 0, 0}, dCol = {0, 0, -1, 1};
	private static int[][] board;
	private static boolean[][][] visit;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());
		K = Integer.parseInt(st.nextToken());

		board = new int[N][M];
		visit = new boolean[K + 1][N][M];

		for (int i = 0; i < N; i++) {
			String lineInfo = br.readLine();
			for (int j = 0; j < M; j++) {
				board[i][j] = Character.getNumericValue(lineInfo.charAt(j));
			}
		}

		distance = Integer.MAX_VALUE;

		PriorityQueue<Info> q = new PriorityQueue<>();
		q.offer(new Info(0, 0, 1, 0, 1));
		visit[0][0][0] = true;

		while (!q.isEmpty()) {
			Info cur = q.poll();
			// 가지치기
			if (distance <= cur.distance) {
				continue;
			}
			// 목표 지점 도착
			if (cur.r == (N - 1) && cur.c == (M - 1)) {
				distance = Math.min(distance, cur.distance);
			}
			// 탐색
			for (int k = 0; k < 4; k++) {
				int r = cur.r + dRow[k];
				int c = cur.c + dCol[k];
				if (r < 0 || c < 0 || r >= N || c >= M) {
					continue;
				}
				// 벽 유무 확인
				if (board[r][c] == 1) {
					// 벽 부수기
					if (cur.cnt < K) {
						if (visit[cur.cnt + 1][r][c]) {
							continue;
						}
						visit[cur.cnt + 1][r][c] = true;
						// 낮에만 벽 부수기 가능
						if (cur.state == 1) {
							q.offer(new Info(r, c, cur.state * -1, cur.cnt + 1, cur.distance + 1));
						} else {
							q.offer(new Info(r, c, cur.state, cur.cnt + 1, cur.distance + 2)); // 낮밤 바꾼 후 이동
						}
					}
				} else {
					if (visit[cur.cnt][r][c]) {
						continue;
					}
					visit[cur.cnt][r][c] = true;
					q.offer(new Info(r, c, cur.state * -1, cur.cnt, cur.distance + 1));
				}
			}
		}

		distance = (distance == Integer.MAX_VALUE) ? -1 : distance;

		bw.write(distance + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

	static class Info implements Comparable<Info> {
		int r;
		int c;
		int state;
		int cnt;
		int distance;

		public Info(int r, int c, int state, int cnt, int distance) {
			this.r = r;
			this.c = c;
			this.state = state;
			this.cnt = cnt;
			this.distance = distance;
		}

		public int compareTo(Info i) {
			return this.distance - i.distance;
		}
	}
}
