/**
 * 문제 : 경사로
 * 소요 시간 : 45분
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
import java.util.stream.Stream;

public class BOJ_14890 {

	private static int n, l;
	private static int[][] board;

	private static boolean isPossible(int[] map) {
		boolean[] visit = new boolean[n]; // 경사로 설치 여부
		for (int i = 1; i < n; i++) {
			if (map[i - 1] == map[i]) {
				continue;
			}
			// 경사로 설치 조건: 높이 차이 1까지 허용
			if (Math.abs(map[i - 1] - map[i]) > 1) {
				return false;
			}
			// 경사로 설치 (우하향)
			if (map[i - 1] > map[i]) {
				// 경사로 설치 조건: 낮은 칸의 길이가 L개
				visit[i] = true;
				for (int j = 1; j < l; j++) {
					if ((i + j) >= n || map[i] != map[i + j]) {
						return false;
					}
					visit[i + j] = true;
				}
				i += (l - 1);
				continue;
			}
			// 경사로 설치 (우상향)
			if (map[i - 1] < map[i]) {
				for (int j = 0; j < l; j++) {
					if ((i - 1 - j) < 0 || visit[i - 1 - j]) {
						return false;
					}
					visit[i - 1 - j] = true;
				}
			}
		}
		return true;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken()); // 지도 길이
		l = Integer.parseInt(st.nextToken()); // 경사로 길이

		board = new int[n][n];

		for (int i = 0; i < n; i++) {
			board[i] = Stream.of(br.readLine().split(" "))
				.mapToInt(Integer::parseInt)
				.toArray();
		}

		int result = 0;

		// 가로 탐색
		for (int i = 0; i < n; i++) {
			if (isPossible(board[i])) {
				result++;
			}
		}

		// 세로 탐색
		for (int i = 0; i < n; i++) {
			int[] map = new int[n];
			for (int j = 0; j < n; j++) {
				map[j] = board[j][i];
			}
			if (isPossible(map)) {
				result++;
			}
		}

		bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
