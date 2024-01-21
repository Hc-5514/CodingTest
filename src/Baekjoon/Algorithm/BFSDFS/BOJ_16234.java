/**
 * 문제 : 인구 이동
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
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16234 {

	private static int N, L, R;
	private static final int[] dRow = {-1, 1, 0, 0}, dCol = {0, 0, -1, 1};
	private static int[][] country;

	private static boolean move() {
		boolean isMove = false;
		boolean[][] visit = new boolean[N][N];

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < N; j++) {
				if (visit[i][j]) {
					continue;
				}

				// bfs 를 통해 연합 가능 여부 확인, list 에 연합 정보 저장
				Queue<int[]> q = new ArrayDeque<>();
				q.offer(new int[] {i, j});

				List<int[]> list = new ArrayList<>();
				list.add(new int[] {i, j});

				visit[i][j] = true;

				int total = country[i][j];

				while (!q.isEmpty()) {
					int[] cur = q.poll();
					for (int k = 0; k < 4; k++) {
						int r = cur[0] + dRow[k];
						int c = cur[1] + dCol[k];
						if (r < 0 || c < 0 || r >= N || c >= N) {
							continue;
						}
						if (visit[r][c]) {
							continue;
						}
						int sub = Math.abs(country[cur[0]][cur[1]] - country[r][c]);
						// 연합 생성
						if (sub >= L && sub <= R) {
							q.offer(new int[] {r, c});
							list.add(new int[] {r, c});
							visit[r][c] = true;
							total += country[r][c];
						}
					}
				}

				// 인구 이동: (연합 내의 총 인구수) / (나라 개수) 만큼 인구수 이동 [소수 자리 버림]
				if (list.size() > 1) {
					isMove = true;
				}

				int n = total / list.size();

				for (int[] cur : list) {
					country[cur[0]][cur[1]] = n;
				}
			}
		}
		return isMove;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // (1 <= N <= 50)
		L = Integer.parseInt(st.nextToken()); // (1 <= L <= 100)
		R = Integer.parseInt(st.nextToken()); // (1 <= R <= 100)

		// N * N 나라 인구수 입력 받기
		country = new int[N][N];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				country[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 연합 할 수 있는 나라가 없을 때까지 사이클 반복
		int answer = 0;
		while (move()) {
			answer++;
		}

		bw.write(answer + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
