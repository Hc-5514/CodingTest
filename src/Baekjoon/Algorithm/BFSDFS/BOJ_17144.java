/**
 * 문제 : 미세먼지 안녕!
 * 소요 시간 : 2시간 7분
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
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17144 {

	// 공기청정기는 항상 1번 열에 설치되어 있고, 두 행을 차지
	// 1초 동안 (미세먼지 확산) -> (공기청정기 작동)
	// T초가 지난 후 남아있는 미세먼지 양 구하기

	// BFS

	private static int R, C, T;
	private static final int[] dRow = {-1, 1, 0, 0}, dCol = {0, 0, -1, 1};
	private static final int[] dir1 = {0, 3, 1, 2}, dir2 = {1, 3, 0, 2}; // 공기청정기 바람 순환 방향 역추적
	private static int[] airCleaner1, airCleaner2;
	private static int[][] board;

	private static void init() {
		airCleaner1 = new int[2];
		airCleaner2 = new int[2];
		board = new int[R][C];
	}

	private static void spreadDust() {
		// 모든 칸에서 4방향으로 '동시에' 미세먼지 확장
		Queue<Dust> q = new ArrayDeque<>();
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				if (board[i][j] == 0 || board[i][j] == -1) {
					continue;
				}
				// 확산 양: Math.floor(미세먼지 양/5)
				int volume = (int)Math.floor(board[i][j] / 5);
				if (volume == 0) {
					continue;
				}
				int cnt = 0; // 확산 방향 개수
				for (int k = 0; k < 4; k++) {
					int r = i + dRow[k];
					int c = j + dCol[k];
					// board 범위 밖 또는 공기청정기가 있다면 확산x
					if (r < 0 || c < 0 || r >= R || c >= C) {
						continue;
					}
					if (board[r][c] == -1) {
						continue;
					}
					// 먼지 확산
					cnt++;
					q.offer(new Dust(r, c, volume));
				}
				// 남아 있는 미세먼지 양: 기존 양 - 확산 양 * 확산 방향 개수
				q.offer(new Dust(i, j, volume * cnt * -1));
			}
		}
		// 미세먼지 변화량 적용
		while (!q.isEmpty()) {
			Dust cur = q.poll();
			board[cur.r][cur.c] += cur.volume;
		}
	}

	private static void operationAirCleaner(int goalR, int goalC, int[] cur, int[] dir) {
		// 미세먼지는 바람의 방향대로 1칸씩 이동
		// 공기청정기로 들어간 미세먼지는 삭제
		int direct = 0;
		while (cur[0] != goalR || cur[1] != goalC) {
			switch (dir[direct]) {
				// 미세먼지 바람 이동 경로 역추적, 역추적 방향 <-> 미세먼지 이동 방향
				case 0: // 미세먼지: 아래로 이동
					if ((cur[0] + 1) != goalR || cur[1] != goalC) {
						board[cur[0] + 1][cur[1]] = board[cur[0]][cur[1]];
					}
					break;
				case 1: // 위로 이동
					if ((cur[0] - 1) != goalR || cur[1] != goalC) {
						board[cur[0] - 1][cur[1]] = board[cur[0]][cur[1]];
					}
					break;
				case 2: // 오른쪽으로 이동
					board[cur[0]][cur[1] + 1] = board[cur[0]][cur[1]];
					break;
				case 3: // 왼쪽으로 이동
					board[cur[0]][cur[1] - 1] = board[cur[0]][cur[1]];
					break;
			}
			board[cur[0]][cur[1]] = 0;
			// 방향 전환
			if ((cur[0] == 0 && cur[1] == 0) || (cur[0] == 0 && cur[1] == C - 1) || (cur[0] == goalR && cur[1] == C - 1)
				|| (cur[0] == R - 1 && cur[1] == C - 1) || (cur[0] == R - 1 && cur[1] == 0)) {
				direct++;
			}
			// 위치 이동
			cur[0] += dRow[dir[direct]];
			cur[1] += dCol[dir[direct]];
		}

	}

	private static int restDustCount() {
		int result = 0;
		for (int i = 0; i < R; i++) {
			for (int j = 0; j < C; j++) {
				result += board[i][j];
			}
		}
		result += 2;
		return result;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		R = Integer.parseInt(st.nextToken());
		C = Integer.parseInt(st.nextToken());
		T = Integer.parseInt(st.nextToken());

		init();

		// board, 공기청정기 및 먼지 위치 입력
		for (int i = 0; i < R; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < C; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
				// 공기청정기 위치: 저장이 두 번되므로 아랫칸 위치가 저장된다.
				if (board[i][j] == -1) {
					airCleaner2[0] = i;
					airCleaner2[1] = j;
				}
			}
		}

		airCleaner1[0] = airCleaner2[0] - 1;
		airCleaner1[1] = airCleaner2[1];

		for (int time = 1; time <= T; time++) {
			// 1. 미세먼지 확산
			spreadDust();
			// 2. 공기청정기 작동
			// 위쪽 공기청정기 바람: 반시계 방향 순환
			int[] cur = new int[] {airCleaner1[0] + dRow[dir1[0]], airCleaner1[1] + dCol[dir1[0]]};
			operationAirCleaner(airCleaner1[0], airCleaner1[1], cur, dir1);
			// 아래쪽 공기청정기 바람: 시계 방향 순환
			cur = new int[] {airCleaner2[0] + dRow[dir2[0]], airCleaner2[1] + dCol[dir2[0]]};
			operationAirCleaner(airCleaner2[0], airCleaner2[1], cur, dir2);
		}

		// 남아있는 미세먼지 양 구하기
		bw.write(restDustCount() + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

	private static class Dust {
		int r;
		int c;
		int volume;

		public Dust(int r, int c, int volume) {
			this.r = r;
			this.c = c;
			this.volume = volume;
		}
	}
}
