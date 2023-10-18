/**
 * 문제 : 불!
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

public class BOJ_4179 {

	private static final int[] dRow = {-1, 1, 0, 0}, dCol = {0, 0, -1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		// h x w 범위의 board 입력 받기
		st = new StringTokenizer(br.readLine());
		int w = Integer.parseInt(st.nextToken());
		int h = Integer.parseInt(st.nextToken());
		char[][] board = new char[w][h]; // 건물 정보
		boolean[][] visit = new boolean[w][h]; // 상근이 방문 정보
		boolean[][] visitFire = new boolean[w][h]; // 불 방문 정보
		Queue<int[]> q = new ArrayDeque<>();
		Queue<int[]> fires = new ArrayDeque<>(); // 번질 불의 위치
		for (int i = 0; i < w; i++) {
			String str = br.readLine();
			for (int j = 0; j < h; j++) {
				board[i][j] = str.charAt(j);
				// 상근이 위치
				if (board[i][j] == 'J') {
					q.offer(new int[] {i, j});
					visit[i][j] = true;
					board[i][j] = '.';
				}
				// 불의 위치
				if (board[i][j] == 'F') {
					fires.offer(new int[] {i, j});
					visitFire[i][j] = true;
				}
			}
		}
		// bfs 시작
		int minCnt = -1;
		int cnt = 0;
		w1:
		while (!q.isEmpty()) {
			// 불 퍼뜨리기
			int size = fires.size();
			for (int i = 0; i < size; i++) {
				int[] fire = fires.poll();
				for (int k = 0; k < 4; k++) {
					int r = fire[0] + dRow[k];
					int c = fire[1] + dCol[k];
					if (r < 0 || c < 0 || r >= w || c >= h) {
						continue;
					}
					if (visitFire[r][c]) {
						continue;
					}
					// 벽이 아니면 불이 번짐
					if (board[r][c] != '#') {
						board[r][c] = 'F';
						visitFire[r][c] = true;
						fires.add(new int[] {r, c});
					}
				}
			}
			int qSize = q.size();
			for (int i = 0; i < qSize; i++) {
				int[] cur = q.poll();
				// 상근이 이동
				for (int k = 0; k < 4; k++) {
					int r = cur[0] + dRow[k];
					int c = cur[1] + dCol[k];
					// 탈출 성공
					if (r < 0 || c < 0 || r > w - 1 || c > h - 1) {
						minCnt = cnt + 1;
						break w1;
					}
					// 중복 방문x
					if (visit[r][c]) {
						continue;
					}
					// 벽, 불이 있는 곳 방문x
					if (board[r][c] == '.') {
						q.offer(new int[] {r, c});
						visit[r][c] = true;
					}
				}
			}
			cnt++;
		}

		if (minCnt != -1) {
			bw.write(minCnt + "\n");
		} else {
			bw.write("IMPOSSIBLE" + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
