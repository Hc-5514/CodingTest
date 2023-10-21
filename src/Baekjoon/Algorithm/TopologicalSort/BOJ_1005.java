/**
 * 문제 : ACM Craft
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.TopologicalSort;

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

/**
 * 순서가 정해진 작업을 처리 -> 위상 정렬 문제 (비순환 유향 그래프)
 */
public class BOJ_1005 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine().trim()); // T: 테케 수
		for (int tc = 0; tc < T; tc++) {
			st = new StringTokenizer(br.readLine());
			int N = Integer.parseInt(st.nextToken()); // N: 건물 개수 (1~N)
			int K = Integer.parseInt(st.nextToken()); // K: 건설 순서 규칙

			// 건물당 건설 소요 시간
			int[] work_time = new int[N + 1];
			st = new StringTokenizer(br.readLine());
			for (int i = 1; i <= N; i++) {
				work_time[i] = Integer.parseInt(st.nextToken());
			}

			// 건물 순서
			List<List<Integer>> buildings = new ArrayList<>();
			for (int i = 0; i <= N; i++) {
				buildings.add(new ArrayList<>());
			}

			// 전입 차수
			int[] edgeCnt = new int[N + 1];

			// 양방향 연결
			for (int i = 0; i < K; i++) {
				st = new StringTokenizer(br.readLine());
				int from = Integer.parseInt(st.nextToken());
				int to = Integer.parseInt(st.nextToken());
				buildings.get(from).add(to);
				edgeCnt[to]++;
			}

			int W = Integer.parseInt(br.readLine().trim()); // 목표 건설 건물 번호

			int[] building_time = new int[N + 1]; // 건물 건설 소요 시간

			// 건설의 기본 소요 시간은 work_time[i]
			Queue<Integer> q = new ArrayDeque<>();
			for (int i = 1; i <= N; i++) {
				building_time[i] = work_time[i];
				if (edgeCnt[i] == 0) {
					q.offer(i);
				}
			}

			// 건설 총 소요 시간 = 현재 건물 건설 소요 시간 + 이전 건물 건설 소요 시간
			while (!q.isEmpty()) {
				int cur = q.poll();
				for (int n : buildings.get(cur)) {
					building_time[n] = Math.max(building_time[n], work_time[n] + building_time[cur]);
					edgeCnt[n]--;
					if (edgeCnt[n] == 0) {
						q.offer(n);
					}
				}
			}

			bw.write(building_time[W] + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}