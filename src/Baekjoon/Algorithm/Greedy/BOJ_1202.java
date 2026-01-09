/**
 * 문제: 보석 도둑
 * 난이도: 골드 2
 * 메모리: 129600KB, 시간: 1100ms
 * 풀이: 그리디
 */

package Baekjoon.Algorithm.Greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1202 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		// 조건1. K개의 가방 각각 하나의 보석만 넣을 수 있다.
		// 조건2. 보석 무게 <= 가방 최대 무게

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken()); // 보석 개수, 1 <= n <= 300_000
		int k = Integer.parseInt(st.nextToken()); // 가방 개수, 1 <= k <= 300,000

		PriorityQueue<Jewelry> pq1 = new PriorityQueue<>((o1, o2) -> Integer.compare(o1.m, o2.m));
		PriorityQueue<Integer> pq2 = new PriorityQueue<>((o1, o2) -> Integer.compare(o2, o1));

		// 보석 정보
		for (int i = 0; i < n; i++) {
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			pq1.offer(new Jewelry(m, v));
		}

		// 가방 정보
		int[] backpacks = new int[k];
		for (int i = 0; i < k; i++) {
			backpacks[i] = Integer.parseInt(br.readLine()); // 가방 최대 무게, 1 <= c <= 100_000_000
		}

		Arrays.sort(backpacks);

		long result = 0; // 보석 가격 합

		for (int i = 0; i < k; i++) {
			// 현재 가방의 허용 무게 보다 가벼운 보석을 pq2에 저장
			int mw = backpacks[i];
			while (!pq1.isEmpty() && pq1.peek().m <= mw) {
				pq2.offer(pq1.poll().v);
			}
			// 그 중 가장 비싼 보석을 고른다.
			if (!pq2.isEmpty()) {
				result += pq2.poll();
			}
		}

		bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

	private static class Jewelry {
		int m;
		int v;

		public Jewelry(int m, int v) {
			this.m = m;
			this.v = v;
		}
	}
}
