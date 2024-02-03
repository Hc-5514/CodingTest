/**
 * 문제 : 오목
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.BruteForce;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2615 {

	private static final int size = 19;
	private static final int[] dRow = {1, 1, 1, 0}, dCol = {-1, 0, 1, 1};

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		Queue<int[]> q = new ArrayDeque<>();

		// 19 * 19 바둑판
		int[][] board = new int[size][size];
		boolean[][][] visit = new boolean[4][size][size]; // 왼쪽 아래, 아래, 오른쪽 아래, 오른쪽

		for (int i = 0; i < size; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < size; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				// 모든 바둑알 탐색
				if (board[i][j] != 0) {
					q.offer(new int[] {i, j});
				}
			}
		}

		int bCnt = 0;
		int wCnt = 0;
		int rCoords = 0;
		int cCoords = 0;

		w1:
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			int color = board[cur[0]][cur[1]]; // 검은색(1), 흰색(2)
			for (int k = 0; k < 4; k++) {
				int cnt = 1; // 바둑알 연속 5개 확인
				int r = cur[0];
				int c = cur[1];
				visit[k][r][c] = true;
				// 승부가 났을 경우, 가장 왼쪽 상단에 있는 바둑알 좌표 출력
				rCoords = r;
				cCoords = c;
				while (true) {
					r += dRow[k];
					c += dCol[k];
					// board 범위 확인
					if (r < 0 || c < 0 || r >= size || c >= size) {
						break;
					}
					// 같은색 확인
					if (board[r][c] != color) {
						break;
					}
					// 방문 확인
					if (visit[k][r][c]) {
						break;
					}
					visit[k][r][c] = true;
					cnt++;

					if (c < cCoords) {
						rCoords = r;
						cCoords = c;
					}
				}
				// 승부가 났을 경우
				if (cnt == 5) {
					if (color == 1) {
						bCnt++;
					} else {
						wCnt++;
					}
					break w1;
				}
			}
		}

		if (bCnt > wCnt) {
			bw.write("1\n");
			bw.write((rCoords + 1) + " " + (cCoords + 1) + "\n");
		} else if (bCnt == wCnt) {
			bw.write("0\n");
		} else {
			bw.write("2\n");
			bw.write((rCoords + 1) + " " + (cCoords + 1) + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
