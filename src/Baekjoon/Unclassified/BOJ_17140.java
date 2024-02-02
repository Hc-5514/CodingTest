/**
 * 문제 : 이차원 배열과 연산
 *
 * @author Hc-5514
 */

package Baekjoon.Unclassified;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_17140 {

	private static int rLen, cLen;
	private static int[][] board;

	private static void command() {
		int maxLen = 0;
		if (rLen >= cLen) { // R 연산
			for (int i = 0; i < rLen; i++) {
				int[][] cntArr = new int[101][2];
				for (int j = 0; j < cLen; j++) {
					cntArr[board[i][j]][0] = board[i][j];
					cntArr[board[i][j]][1]++;
				}

				// 정렬
				Arrays.sort(cntArr, (int[] o1, int[] o2) -> {
					// 0은 무시
					if (o1[0] != 0 && o2[0] != 0) {
						// n의 개수 cnt 우선 정렬
						if (o1[1] == o2[1]) {
							return o1[0] - o2[0];
						}
						// n 정렬
						return o1[1] - o2[1];
					}
					return o2[0] - o1[0];
				});

				// board[i] 결과 채우기
				Arrays.fill(board[i], 0);
				int len = 0;
				while (cntArr[len][0] != 0) {
					board[i][len * 2] = cntArr[len][0];
					board[i][len * 2 + 1] = cntArr[len][1];
					len++;
				}

				maxLen = Math.max(maxLen, len * 2);
			}
			// cLen 갱신
			cLen = maxLen;
		} else { // C 연산
			for (int j = 0; j < cLen; j++) {
				int[][] cntArr = new int[101][2];
				for (int i = 0; i < rLen; i++) {
					cntArr[board[i][j]][0] = board[i][j];
					cntArr[board[i][j]][1]++;
				}

				// 정렬
				Arrays.sort(cntArr, (int[] o1, int[] o2) -> {
					// 0은 무시
					if (o1[0] != 0 && o2[0] != 0) {
						// n의 개수 cnt 우선 정렬
						if (o1[1] == o2[1]) {
							return o1[0] - o2[0];
						}
						// n 정렬
						return o1[1] - o2[1];
					}
					return o2[0] - o1[0];
				});

				// board 결과 채우기
				for (int i = 0; i < rLen; i++) {
					board[i][j] = 0;
				}

				int len = 0;
				while (cntArr[len][0] != 0) {
					board[len * 2][j] = cntArr[len][0];
					board[len * 2 + 1][j] = cntArr[len][1];
					len++;
				}

				maxLen = Math.max(maxLen, len * 2);
			}
			// rLen 갱신
			rLen = maxLen;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int r = Integer.parseInt(st.nextToken()) - 1; // (1 <= r <= 100)
		int c = Integer.parseInt(st.nextToken()) - 1; // (1 <= c <= 100)
		int k = Integer.parseInt(st.nextToken()); // (1 <= k <= 100)

		// 0은 무시하고 정렬, 모든 행,열의 크기는 가장 큰 행,열의 크기를 기준으로 0으로 채워야 한다.
		// 따라서 100 x 100 배열을 만든다.
		board = new int[100][100]; // 최대 크기 (100 x 100)
		for (int i = 0; i < 3; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < 3; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// board[r][c] == k 가 되기까지 소요시간 t 구하기
		int t = 0;
		rLen = 3; // 가장 긴 행의 길이
		cLen = 3; // 가장 긴 열의 길이
		while (t <= 100) {
			if (board[r][c] == k) {
				break;
			}
			command();
			t++;
		}

		if (t > 100) {
			bw.write("-1\n");
		} else {
			bw.write(t + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
