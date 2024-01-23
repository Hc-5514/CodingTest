/**
 * 문제 : 성곽
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
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2234 {

	private static int N, M, idx, maxRoomCnt, maxRoomCnt2;
	private static final int[] dRow = {-1, 1, 0, 0}, dCol = {0, 0, -1, 1};
	private static int[][] board, boardIdx;
	private static Map<Integer, Integer> map;

	private static void getRoomInfo() {
		boolean[][] visit = new boolean[N][M];
		Queue<int[]> q = new ArrayDeque<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visit[i][j]) {
					q.offer(new int[] {i, j});
					visit[i][j] = true;
					boardIdx[i][j] = idx;
					int cnt = 1;

					while (!q.isEmpty()) {
						int[] cur = q.poll();
						for (int k = 0; k < 4; k++) {
							int r = cur[0] + dRow[k];
							int c = cur[1] + dCol[k];

							if (r < 0 || c < 0 || r >= N || c >= M) {
								continue;
							}

							if (visit[r][c]) {
								continue;
							}

							// 벽 유무 확인
							// (벽 정보) 1: 서쪽, 2: 북쪽, 4: 동쪽, 8: 남쪽
							switch (k) {
								// 북
								case 0:
									if ((board[r][c] & 8) == 8) {
										continue;
									}
									break;
								// 남
								case 1:
									if ((board[r][c] & 2) == 2) {
										continue;
									}
									break;
								// 서
								case 2:
									if ((board[r][c] & 4) == 4) {
										continue;
									}
									break;
								// 동
								case 3:
									if ((board[r][c] & 1) == 1) {
										continue;
									}
									break;
							}

							q.offer(new int[] {r, c});
							visit[r][c] = true;
							boardIdx[r][c] = idx;
							cnt++;
						}
					}
					map.put(idx++, cnt);
					maxRoomCnt = Math.max(maxRoomCnt, cnt);
				}
			}
		}
	}

	private static void getMaxRoom() {
		boolean[][] visit = new boolean[N][M];
		Queue<int[]> q = new ArrayDeque<>();

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (!visit[i][j]) {
					q.offer(new int[] {i, j});
					visit[i][j] = true;

					while (!q.isEmpty()) {
						int[] cur = q.poll();
						for (int k = 0; k < 4; k++) {
							int r = cur[0] + dRow[k];
							int c = cur[1] + dCol[k];

							if (r < 0 || c < 0 || r >= N || c >= M) {
								continue;
							}

							if (visit[r][c]) {
								continue;
							}

							if (boardIdx[cur[0]][cur[1]] != boardIdx[r][c]) {
								maxRoomCnt2 = Math.max(maxRoomCnt2,
									map.get(boardIdx[cur[0]][cur[1]]) + map.get(boardIdx[r][c]));
								continue;
							}
							q.offer(new int[] {r, c});
							visit[r][c] = true;
						}
					}
				}
			}
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		M = Integer.parseInt(st.nextToken()); // (1 <= M <= 50)
		N = Integer.parseInt(st.nextToken()); // (1 <= N <= 50)

		// N x M 벽 정보 입력 받기
		board = new int[N][M];
		boardIdx = new int[N][M];
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 방 정보 얻기 (방이 몇 개인지, 크기가 몇 인지)
		map = new HashMap<>();
		idx = 0;
		maxRoomCnt = 0;
		getRoomInfo();

		// 인접한 벽 정보 얻기
		maxRoomCnt2 = 0;
		getMaxRoom();

		bw.write(idx + "\n"); // 이 성에 있는 방의 개수
		bw.write(maxRoomCnt + "\n"); // 가장 넓은 방의 넓이
		bw.write(maxRoomCnt2 + "\n"); // 하나의 벽을 제거하여 얻을 수 있는 가장 넓은 방의 크기
		bw.flush();
		bw.close();
		br.close();
	}
}
