/**
 * 문제 : 보이저 1호
 *
 * @author Hc-5514
 */

package Baekjoon.Unclassified;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_3987 {

	static int N, M, sR, sC;
	static int maxTime;
	static int maxTimeDir;
	static char[][] board;

	private static void findSignal() {
		getTime(0); // U
		if (maxTime == -1)
			return;
		getTime(3); // R
		if (maxTime == -1)
			return;
		getTime(1); // D
		if (maxTime == -1)
			return;
		getTime(2); // L
	}

	private static void getTime(int dir) {
		int r = sR;
		int c = sC;
		int d = dir;
		int time = 0;

		boolean[][][] visit = new boolean[4][N][M];

		while (true) {
			visit[d][r][c] = true;
			// 장애물 확인 - 이동 방향 변경
			if (board[r][c] == '\\') {
				switch (d) {
					case 0: // U -> L
						d = 2;
						break;
					case 1: // D -> R
						d = 3;
						break;
					case 2: // L -> U
						d = 0;
						break;
					case 3: // R -> D
						d = 1;
						break;
				}
			}
			if (board[r][c] == '/') {
				switch (d) {
					case 0: // U -> R
						d = 3;
						break;
					case 1: // D -> L
						d = 2;
						break;
					case 2: // L -> D
						d = 1;
						break;
					case 3: // R -> U
						d = 0;
						break;
				}
			}

			// 방향 이동
			if (d == 0) {
				r--;
			} else if (d == 1) {
				r++;
			} else if (d == 2) {
				c--;
			} else {
				c++;
			}
			time++;

			// 종료 조건 확인
			if (r < 0 || c < 0 || r >= N || c >= M)
				break;
			if (board[r][c] == 'C')
				break;
			if (visit[d][r][c]) { // 무한 루프
				maxTime = -1;
				maxTimeDir = dir;
				return;
			}
		}
		if (maxTime < time) {
			maxTime = time;
			maxTimeDir = dir;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken());
		M = Integer.parseInt(st.nextToken());

		board = new char[N][M];
		for (int i = 0; i < N; i++) {
			board[i] = br.readLine().toCharArray();
		}

		st = new StringTokenizer(br.readLine());
		sR = Integer.parseInt(st.nextToken()) - 1;
		sC = Integer.parseInt(st.nextToken()) - 1;

		findSignal();

		if (maxTimeDir == 0)
			bw.write('U' + "\n");
		else if (maxTimeDir == 1)
			bw.write('D' + "\n");
		else if (maxTimeDir == 2)
			bw.write('L' + "\n");
		else
			bw.write('R' + "\n");

		if (maxTime == -1) {
			bw.write("Voyager" + "\n");
		} else
			bw.write(maxTime + "\n");

		bw.flush();
		bw.close();
		br.close();
	}
}