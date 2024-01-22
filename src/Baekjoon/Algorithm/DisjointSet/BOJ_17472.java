/**
 * 문제 : 다리 만들기 2
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.DisjointSet;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17472 {

	private static int N, M, idx;
	private static int[] parent;
	private static final int[] dRow = {-1, 1, 0, 0}, dCol = {0, 0, -1, 1};
	private static int[][] map;

	private static PriorityQueue<Bridge> pq;

	private static void makeIndex() {
		Queue<int[]> q = new ArrayDeque<>();
		boolean[][] visit = new boolean[N][M];
		idx = 1;

		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 1 && !visit[i][j]) {
					q.offer(new int[] {i, j});
					visit[i][j] = true;
					map[i][j] = idx;
					while (!q.isEmpty()) {
						int[] cur = q.poll();
						for (int k = 0; k < 4; k++) {
							int r = cur[0] + dRow[k];
							int c = cur[1] + dCol[k];
							if (r < 0 || c < 0 || r >= N || c >= M) {
								continue;
							}
							if (map[r][c] == 0) {
								continue;
							}
							if (visit[r][c]) {
								continue;
							}
							q.offer(new int[] {r, c});
							visit[r][c] = true;
							map[r][c] = idx;
						}
					}
					idx++;
				}
			}
		}
	}

	private static void makeBridge() {
		for (int i = 0; i < N; i++) {
			for (int j = 0; j < M; j++) {
				if (map[i][j] == 0) {
					continue;
				}
				makeRowBridge(i, j); // 좌->우 연결
				makeColBridge(i, j); // 상->하 연결
			}
		}
	}

	private static void makeRowBridge(int i, int j) {
		int len = 0;
		int c = j;
		while (c < M - 1) {
			c++;
			if (map[i][c] == 0) {
				len++;
			} else {
				if (len < 2) {
					return;
				}
				pq.offer(new Bridge(map[i][j], map[i][c], len));
				return;
			}
		}
	}

	private static void makeColBridge(int i, int j) {
		int len = 0;
		int r = i;
		while (r < N - 1) {
			r++;
			if (map[r][j] == 0) {
				len++;
			} else {
				if (len < 2) {
					return;
				}
				pq.offer(new Bridge(map[i][j], map[r][j], len));
				return;
			}
		}
	}

	private static int find(int n) {
		if (parent[n] == n) {
			return n;
		}

		return parent[n] = find(parent[n]);
	}

	private static void union(int n1, int n2) {
		int p1 = find(n1);
		int p2 = find(n2);

		if (p1 < p2) {
			parent[p2] = p1;
		} else {
			parent[p1] = p2;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		N = Integer.parseInt(st.nextToken()); // 1 <= N <= 10
		M = Integer.parseInt(st.nextToken()); // 1 <= M <= 10

		// N * M 지도 입력 받기
		map = new int[N][M];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < M; j++) {
				map[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		// 0: 바다, 1: 땅
		// 다리 조건: 한 방향(가로 or 세로), 길이는 2이상
		// 다리가 크로스 되는 경우, 각각 카운트
		// 모든 섬을 연결하는 다리 길이의 최솟값 구하기

		// 섬에 1 대신 인덱스 번호 저장 (BFS)
		makeIndex();
		parent = new int[idx];
		for (int i = 0; i < parent.length; i++) {
			parent[i] = i;
		}

		// 모든 섬에 대하여 다른 섬까지 이을 수 있는 다리 만들기
		pq = new PriorityQueue<>();
		makeBridge();

		// MST 만들기
		int minLen = 0;

		while (!pq.isEmpty()) {
			Bridge cur = pq.poll();
			int n1 = find(cur.from);
			int n2 = find(cur.to);
			if (n1 != n2) {
				union(n1, n2);
				minLen += cur.len;
			}
		}

		for (int i = 1; i < parent.length; i++) {
			find(i);
			if (parent[i] != 1) {
				minLen = -1;
				break;
			}
		}

		bw.write(minLen + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

	static class Bridge implements Comparable<Bridge> {
		int from;
		int to;
		int len;

		public Bridge(int from, int to, int len) {
			this.from = from;
			this.to = to;
			this.len = len;
		}

		@Override
		public int compareTo(Bridge b) {
			return this.len - b.len;
		}
	}
}
