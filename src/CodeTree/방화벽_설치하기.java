/**
 * 문제 : 방화벽 설치하기
 *
 * @author Hc-5514
 */

package CodeTree;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class 방화벽_설치하기 {

	static int n, m;
	static int maxArea = 0;
	static int[] dRow = {-1, 1, 0, 0}, dCol = {0, 0, -1, 1};
	static int[][] board;
	static List<int[]> fires = new ArrayList<>();

	private static void combination(int depth, int i, int j) {

		if (depth == 3) {
			bfs();
			return;
		}

		// 배열 범위 확인
		if (i >= n) {
			return;
		}

		if (j >= m) {
			combination(depth, i + 1, 0);
			return;
		}

		// 빈 영역 확인
		if (board[i][j] == 0) {
			board[i][j] = 1;
			combination(depth + 1, i, j + 1);
			board[i][j] = 0;
			combination(depth, i, j + 1);
			return;
		}

		combination(depth, i, j + 1);
	}

	private static void bfs() {
		int[][] copyBoard = new int[n][m];
		for (int i = 0; i < n; i++) {
			copyBoard[i] = Arrays.copyOf(board[i], board[0].length);
		}
		Queue<int[]> q = new ArrayDeque<>();
		for (int i = 0; i < fires.size(); i++) {
			q.offer(new int[] {fires.get(i)[0], fires.get(i)[1]});
		}
		while (!q.isEmpty()) {
			int[] cur = q.poll();
			for (int k = 0; k < 4; k++) {
				int r = cur[0] + dRow[k];
				int c = cur[1] + dCol[k];
				if (r < 0 || c < 0 || r >= n || c >= m)
					continue;
				if (copyBoard[r][c] != 0)
					continue;
				q.offer(new int[] {r, c});
				copyBoard[r][c] = 2;
			}
		}

		int area = 0;
		for (int i = 0; i < n; i++) {
			for (int j = 0; j < m; j++) {
				if (copyBoard[i][j] == 0)
					area++;
			}
		}
		maxArea = Math.max(maxArea, area);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		n = Integer.parseInt(st.nextToken());
		m = Integer.parseInt(st.nextToken());
		board = new int[n][m];

		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < m; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				if (board[i][j] == 2) {
					fires.add(new int[] {i, j});
				}
			}
		}

		combination(0, 0, 0);

		bw.write(maxArea + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
