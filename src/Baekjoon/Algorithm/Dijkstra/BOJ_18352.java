/**
 * 문제 : 특정 거리의 도시 찾기
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.Dijkstra;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_18352 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 도시 개수, (2 <= N <= 300,000)
		int M = Integer.parseInt(st.nextToken()); // 도로 개수, (1 <= M <= 1,000,000)
		int K = Integer.parseInt(st.nextToken()); // 거리 정보, (1 <= K <= 300,000)
		int X = Integer.parseInt(st.nextToken()); // 출발 도시 번호, (1 <= X <= N)

		// 1 ~ N번 도시
		List<List<Integer>> cityList = new ArrayList<>();
		for (int i = 0; i <= N; i++) {
			cityList.add(new ArrayList<>());
		}

		// 도로 정보, 단방향 연결
		for (int i = 0; i < M; i++) {
			st = new StringTokenizer(br.readLine());
			int A = Integer.parseInt(st.nextToken());
			int B = Integer.parseInt(st.nextToken());
			cityList.get(A).add(B);
		}

		// 출발 도시에서 모든 도시까지의 거리를 구한다.
		int[] distance = new int[N + 1];
		Arrays.fill(distance, N * 10);
		distance[X] = 0;

		// 모든 도시 간의 거리가 1이기 때문에, PriorityQueue 를 사용할 필요가 없다.
		Queue<Integer> q = new ArrayDeque<>();
		q.offer(X);

		while (!q.isEmpty()) {
			int cur = q.poll();

			for (int i = 0; i < cityList.get(cur).size(); i++) {
				int city = cityList.get(cur).get(i);
				// 최단 거리 갱신
				int dist = distance[cur] + 1;
				if (dist < distance[city]) {
					distance[city] = dist;
					q.offer(city);
				}
			}
		}

		// 거리가 K인 도시 찾기
		List<Integer> result = new ArrayList<>();
		for (int i = 1; i <= N; i++) {
			if (distance[i] == K) {
				result.add(i);
			}
		}

		// 오름차순 정렬
		Collections.sort(result);

		if (result.isEmpty()) {
			bw.write(-1 + "\n");
		} else {
			for (Integer n : result) {
				bw.write(n + "\n");
			}
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
