/**
 * 문제 : 1767. [SW Test 샘플문제] 프로세서 연결하기
 *
 * @author Hc-5514
 */

package SWEA.Mock_SW_Test;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.StringTokenizer;

public class SWEA_Sample_1767 {

	private static int N, maxCnt, minLen;
	private static final int[] dRow = {-1, 1, 0, 0}, dCol = {0, 0, -1, 1};
	private static List<int[]> cores;

	private static void dfs(int depth, int cnt, int len, int[][] board) {
		if (depth == cores.size()) {
			if (cnt > maxCnt) {
				maxCnt = cnt;
				minLen = len;
			}
			if (cnt == maxCnt) {
				minLen = Math.min(minLen, len);
			}
			return;
		}

		// 가지치기
		if (cnt + (cores.size() - depth) < maxCnt) {
			return;
		}

		int cR = cores.get(depth)[0];
		int cC = cores.get(depth)[1];

		for (int k = 0; k < 5; k++) {
			int[][] copyBoard = new int[N][N];
			for (int i = 0; i < N; i++) {
				copyBoard[i] = Arrays.copyOf(board[i], N);
			}

			if (k == 4) {
				dfs(depth + 1, cnt, len, copyBoard);
				continue;
			}
			// 상하좌우 탐색
			int r = cR;
			int c = cC;
			int curLen = 0;

			while (true) {
				r += dRow[k];
				c += dCol[k];
				// 전원이 연결됐을 경우
				if (r < 0 || c < 0 || r >= N || c >= N) {
					dfs(depth + 1, cnt + 1, len + curLen, copyBoard);
					break;
				}
				// 다른 전선 만날 경우
				if (copyBoard[r][c] == 1 || copyBoard[r][c] == 2) {
					break;
				}
				copyBoard[r][c] = 2;
				curLen++;
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine().trim());
		for (int tc = 1; tc <= T; tc++) {
			cores = new ArrayList<>();
			maxCnt = 0;
			minLen = 0;

			N = Integer.parseInt(br.readLine().trim()); // (7 <= N <= 12)
			int[][] board = new int[N][N];

			for (int i = 0; i < N; i++) {
				st = new StringTokenizer(br.readLine());
				for (int j = 0; j < N; j++) {
					board[i][j] = Integer.parseInt(st.nextToken());
					if (board[i][j] == 1) {
						if (i != 0 && j != 0) {
							cores.add(new int[] {i, j});
						}
					}
				}
			}

			// 최대한 많은 코어 연결
			// 모든 코어를 연결 못 할 수도 있다.
			// 코어 개수가 가장 많고, 전선 길이가 가장 짧은 것

			dfs(0, 0, 0, board);

			bw.write("#" + tc + " " + minLen + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
