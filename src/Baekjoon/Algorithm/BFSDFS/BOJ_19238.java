/**
 * 문제 : 스타트 택시
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
import java.util.Arrays;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_19238 {

	private static int N, M, e, startR, startC;
	private static final int INF = 401;
	private static final int[] dRow = {-1, 1, 0, 0}, dCol = {0, 0, -1, 1};
	private static int[][] board, distance;

	private static List<Person> people;

	private static void bfs(int sr, int sc) {
		Queue<int[]> q = new ArrayDeque<>();
		q.offer(new int[] {sr, sc});

		distance = new int[N][N];
		for (int i = 0; i < N; i++) {
			Arrays.fill(distance[i], INF);
		}
		distance[sr][sc] = 0;

		while (!q.isEmpty()) {
			int[] cur = q.poll();
			for (int k = 0; k < 4; k++) {
				int r = cur[0] + dRow[k];
				int c = cur[1] + dCol[k];
				// 배열 범위 확인
				if (r < 0 || c < 0 || r >= N || c >= N) {
					continue;
				}
				// 벽 확인
				if (board[r][c] == 1) {
					continue;
				}
				// 방문 확인
				if (distance[r][c] <= distance[cur[0]][cur[1]] + 1) {
					continue;
				}
				distance[r][c] = distance[cur[0]][cur[1]] + 1;
				q.offer(new int[] {r, c});
			}
		}
	}

	private static void simulation() {
		bfs(startR, startC);

		int minDist = INF;
		int minIdx = 0;
		for (int i = 0; i < people.size(); i++) {
			int r = people.get(i).sr;
			int c = people.get(i).sc;
			// 최단 거리 손님 갱신
			if (distance[r][c] < minDist) {
				minDist = distance[r][c];
				minIdx = i;
				continue;
			}
			// 최단 거리가 같을 경우, 행열 비교
			if (distance[r][c] == minDist) {
				if (r < people.get(minIdx).sr) {
					minDist = distance[r][c];
					minIdx = i;
					continue;
				}
				if (r == people.get(minIdx).sr) {
					if (c < people.get(minIdx).sc) {
						minDist = distance[r][c];
						minIdx = i;
					}
				}
			}
		}

		// 이동 가능한 손님 존재 여부 확인
		if (minDist == INF) {
			e = -1;
			return;
		}

		// 최단 거리 손님 운행 가능 여부 확인
		e -= (minDist + people.get(minIdx).sub);

		// 운행 불가능
		if (e < 0) {
			return;
		}

		// 목적지 도착 시, 출발지 -> 목적지 거리 2배의 연료 획득
		e += people.get(minIdx).sub * 2;

		// 시작 위치 갱신
		startR = people.get(minIdx).er;
		startC = people.get(minIdx).ec;

		people.remove(minIdx);
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // (2 ≤ N ≤ 20)
		M = Integer.parseInt(st.nextToken()); // (1 ≤ M ≤ N^2)
		e = Integer.parseInt(st.nextToken()); // (1 ≤ 초기 연료 ≤ 500,000)

		board = new int[N][N]; // 0: 빈칸, 1: 벽
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				board[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 출발 좌표 (sr,sc)
		st = new StringTokenizer(br.readLine());
		startR = Integer.parseInt(st.nextToken()) - 1;
		startC = Integer.parseInt(st.nextToken()) - 1;

		// 손님 출발지, 목적지 좌표
		people = new ArrayList<>();
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int sr = Integer.parseInt(st.nextToken()) - 1;
			int sc = Integer.parseInt(st.nextToken()) - 1;
			int er = Integer.parseInt(st.nextToken()) - 1;
			int ec = Integer.parseInt(st.nextToken()) - 1;
			bfs(sr, sc);
			people.add(new Person(sr, sc, er, ec, distance[er][ec]));
			// 손님이 갈 수 없는 목적지
			if (distance[er][ec] == INF) {
				e = -1;
				break;
			}
		}

		// 모든 승객을 목적지에 데려다 준 후 남은 연료 양 출력
		// 불가능 할 경우 -1 출력
		while (people.size() > 0 && e >= 0) {
			simulation();
		}

		if (e < 0) {
			bw.write("-1\n");
		} else {
			bw.write(e + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}

	private static class Person {
		int sr;
		int sc;
		int er;
		int ec;
		int sub;

		public Person(int sr, int sc, int er, int ec, int sub) {
			this.sr = sr;
			this.sc = sc;
			this.er = er;
			this.ec = ec;
			this.sub = sub;
		}
	}
}
