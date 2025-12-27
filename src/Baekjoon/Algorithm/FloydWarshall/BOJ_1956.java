/**
 * 문제: 운동
 * 난이도: 골드 4
 * 메모리: 58352KB, 시간: 540ms
 * 풀이: 플로이드-워셜
 */

package Baekjoon.Algorithm.FloydWarshall;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_1956 {

	private static final int INF = 10_000_000;

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		// 방향 그래프
		// 도로 길이 합이 가장 작은 사이클 찾기 (두 마을 왕복 포함)
		// 경로를 찾지 못 하면 -1 출력

		st = new StringTokenizer(br.readLine());
		int v = Integer.parseInt(st.nextToken()); // 정점(마을) 개수
		int e = Integer.parseInt(st.nextToken()); // 간선(도로) 개수

		// 단방향 그래프 연결
		int[][] map = new int[v + 1][v + 1]; // 1 ~ v
		for (int i = 0; i <= v; i++) {
			Arrays.fill(map[i], INF);
		}

		for (int i = 0; i < e; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int cost = Integer.parseInt(st.nextToken());
			map[from][to] = Math.min(map[from][to], cost);
		}

		// 플로이드-워셜
		for (int k = 1; k <= v; k++) {
			for (int i = 1; i <= v; i++) {
				if (map[i][k] == INF) {
					continue;
				}
				for (int j = 1; j <= v; j++) {
					if (map[k][j] == INF) {
						continue;
					}
					map[i][j] = Math.min(map[i][j], map[i][k] + map[k][j]);
				}
			}
		}

		// 가장 작은 사이클 찾기
		int result = INF;
		for (int i = 1; i <= v; i++) {
			result = Math.min(result, map[i][i]);
		}
		result = result == INF ? -1 : result;

		bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
