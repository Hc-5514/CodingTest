/**
 * 문제: 선수과목 (Prerequisite)
 * 난이도: 골드 5
 * 메모리: 131372KB, 시간: 516ms
 * 풀이: 위상정렬
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

public class BOJ_14567 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		// 학기 별 과목 수 제한 없음
		// 모든 과목은 항상 개설
		// 모든 과목을 이수하려면 몇 학기가 걸리는가?

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 과목 수, 1 <= n <= 1_000
		int m = Integer.parseInt(st.nextToken()); // 선수 조건 수, 0 <= m <= 500_000

		List<List<Integer>> graph = new ArrayList<>();
		for (int i = 0; i <= n; i++) {
			graph.add(new ArrayList<>());
		}

		int[] indegree = new int[n + 1];
		int[] semester = new int[n + 1];

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			graph.get(from).add(to);
			indegree[to]++;
		}

		// 전입 차수 0 노드 삽입
		Queue<Integer> q = new ArrayDeque<>();
		for (int i = 1; i <= n; i++) {
			if (indegree[i] == 0) {
				semester[i] = 1;
				q.offer(i);
			}
		}

		while (!q.isEmpty()) {
			int cur = q.poll();

			for (int next : graph.get(cur)) {
				semester[next] = Math.max(semester[next], semester[cur] + 1);
				if (--indegree[next] == 0) {
					q.offer(next);
				}
			}
		}

		for (int i = 1; i < semester.length; i++) {
			bw.write(semester[i] + " ");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
