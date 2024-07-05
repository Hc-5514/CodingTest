/**
 * 문제 : 2,147,483,648 게임
 * 소요 시간 : 1시간 22분
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

public class BOJ_23796 {

	// 2048 게임
	// 8 * 8 보드에서 방향키를 한 번 눌렀을 때, 결과가 어떻게 되는가?
	// 1. 눌린 방향키와 같은 방향으로 타일을 끝까지 이동
	// 2. 같은 수가 연속으로 존재하면, 벽에 가까운 수부터 합친다.
	// 3. 한 타일은 최대 한 번만 합쳐진다.

	// 최대값이 2,147,483,648이므로 long[][] 배열 선언
	// 예외처리 꼼꼼히 하기

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		long[][] board = new long[8][8];
		boolean[][] visit = new boolean[8][8]; // true 라면 이미 합쳐진 숫자

		for (int i = 0; i < 8; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 8; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 해당 방향으로 숫자들을 모두 이동 시킨다.
		// 벽에 가까운 수부터 합친다.
		char cmd = br.readLine().charAt(0);
		switch (cmd) {
			case 'U':
				for (int i = 0; i < 8; i++) { // 열
					for (int j = 0; j < 8; j++) { // 행
						if (board[j][i] == 0) {
							continue;
						}
						// 숫자 이동
						for (int k = j - 1; k >= 0; k--) {
							// 빈 칸: 마지막 칸이 아니라면 skip
							if (board[k][i] == 0) {
								if (k == 0) {
									board[k][i] = board[j][i];
									board[j][i] = 0;
									break;
								}
								continue;
							}
							// 빈 칸x: 숫자 비교 후 합칠 수 있다면
							if (board[k][i] == board[j][i]) {
								if (!visit[k][i]) {
									board[k][i] *= 2;
									board[j][i] = 0;
									visit[k][i] = true;
									break;
								}
							}
							// 합칠 수 없다면, 다음 칸에 저장
							if ((k + 1) != j) {
								board[k + 1][i] = board[j][i];
								board[j][i] = 0;
							}
							break;
						}
					}
				}
				break;
			case 'D':
				for (int i = 0; i < 8; i++) { // 열
					for (int j = 7; j >= 0; j--) { // 행
						if (board[j][i] == 0) {
							continue;
						}
						// 숫자 이동
						for (int k = j + 1; k < 8; k++) {
							// 빈 칸: 마지막 칸이 아니라면 skip
							if (board[k][i] == 0) {
								if (k == 7) {
									board[k][i] = board[j][i];
									board[j][i] = 0;
									break;
								}
								continue;
							}
							// 빈 칸x: 숫자 비교 후 합칠 수 있다면
							if (board[k][i] == board[j][i]) {
								if (!visit[k][i]) {
									board[k][i] *= 2;
									board[j][i] = 0;
									visit[k][i] = true;
									break;
								}
							}
							// 합칠 수 없다면, 다음 칸에 저장
							if ((k - 1) != j) {
								board[k - 1][i] = board[j][i];
								board[j][i] = 0;
							}
							break;
						}
					}
				}
				break;
			case 'L':
				for (int i = 0; i < 8; i++) { // 행
					for (int j = 0; j < 8; j++) { // 열
						if (board[i][j] == 0) {
							continue;
						}
						// 숫자 이동
						for (int k = j - 1; k >= 0; k--) {
							// 빈 칸: 마지막 칸이 아니라면 skip
							if (board[i][k] == 0) {
								if (k == 0) {
									board[i][k] = board[i][j];
									board[i][j] = 0;
									break;
								}
								continue;
							}
							// 빈 칸x: 숫자 비교 후 합칠 수 있다면
							if (board[i][k] == board[i][j]) {
								if (!visit[i][k]) {
									board[i][k] *= 2;
									board[i][j] = 0;
									visit[i][k] = true;
									break;
								}
							}
							// 합칠 수 없다면, 다음 칸에 저장
							if ((k + 1) != j) {
								board[i][k + 1] = board[i][j];
								board[i][j] = 0;
							}
							break;
						}
					}
				}
				break;
			case 'R':
				for (int i = 0; i < 8; i++) { // 행
					for (int j = 7; j >= 0; j--) { // 열
						if (board[i][j] == 0) {
							continue;
						}
						// 숫자 이동
						for (int k = j + 1; k < 8; k++) {
							// 빈 칸: 마지막 칸이 아니라면 skip
							if (board[i][k] == 0) {
								if (k == 7) {
									board[i][k] = board[i][j];
									board[i][j] = 0;
									break;
								}
								continue;
							}
							// 빈 칸x: 숫자 비교 후 합칠 수 있다면
							if (board[i][k] == board[i][j]) {
								if (!visit[i][k]) {
									board[i][k] *= 2;
									board[i][j] = 0;
									visit[i][k] = true;
									break;
								}
							}
							// 합칠 수 없다면, 다음 칸에 저장
							if ((k - 1) != j) {
								board[i][k - 1] = board[i][j];
								board[i][j] = 0;
							}
							break;
						}
					}
				}
				break;
		}

		// 출력
		for (int i = 0; i < 8; i++) {
			for (int j = 0; j < 8; j++) {
				bw.write(board[i][j] + " ");
			}
			bw.write("\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
