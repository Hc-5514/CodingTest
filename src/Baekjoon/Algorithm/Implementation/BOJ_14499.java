/**
 * 문제 : 주사위 굴리기
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.Implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_14499 {

	private static int r, c; // 현재 좌표
	private static int[] dice = {0, 0, 0, 0, 0, 0}; // (위, 북, 동, 서, 남, 아래)
	private static int[][] board;
	private static StringBuilder sb = new StringBuilder();

	private static void move(int cmd) {
		// 이동한 칸에 쓰여져 있는 수
		// == 0: 주사위 바닥면 수 -> 이동한 칸에 복사 (0에서 변경됨)
		// != 0: 칸에 쓰인 수 -> 주사위 바닥면 복사 -> 칸에 쓰인 수 0으로 변경
		// 주사위가 이동할 때마다 상단에 있는 값 구하기
		int tmp = dice[0];
		switch (cmd) {
			// 동쪽 이동
			case 1:
				c += 1;
				// 지도 범위 확인
				if (!checkRange()) {
					c -= 1;
					return;
				}
				dice[0] = dice[3];
				dice[3] = dice[5];
				dice[5] = dice[2];
				dice[2] = tmp;
				break;
			// 서쪽 이동				
			case 2:
				c -= 1;
				if (!checkRange()) {
					c += 1;
					return;
				}
				dice[0] = dice[2];
				dice[2] = dice[5];
				dice[5] = dice[3];
				dice[3] = tmp;
				break;
			// 북쪽 이동				
			case 3:
				r -= 1;
				if (!checkRange()) {
					r += 1;
					return;
				}
				dice[0] = dice[4];
				dice[4] = dice[5];
				dice[5] = dice[1];
				dice[1] = tmp;
				break;
			// 남쪽 이동
			case 4:
				r += 1;
				if (!checkRange()) {
					r -= 1;
					return;
				}
				dice[0] = dice[1];
				dice[1] = dice[5];
				dice[5] = dice[4];
				dice[4] = tmp;
				break;
		}

		// 이동 칸 숫자 확인
		if (board[r][c] == 0) {
			board[r][c] = dice[5];
		} else {
			dice[5] = board[r][c];
			board[r][c] = 0;
		}

		sb.append(dice[0]);
	}

	private static boolean checkRange() {
		return r >= 0 && c >= 0 && r < board.length && c < board[0].length;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // (1 <= N <= 20)
		int M = Integer.parseInt(st.nextToken()); // (1 <= M <= 20)
		int x = Integer.parseInt(st.nextToken()); // (0 <= x <= N-1)
		int y = Integer.parseInt(st.nextToken()); // (0 <= y <= M-1)
		int K = Integer.parseInt(st.nextToken()); // (0 <= K <= 1,000)

		// N * M 지도 입력 받기
		board = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		r = x;
		c = y;

		// K개 명령 수행
		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < K; i++) {
			int cmd = Integer.parseInt(st.nextToken());
			move(cmd);
		}

		for (int i = 0; i < sb.length(); i++) {
			bw.write(sb.charAt(i) + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
