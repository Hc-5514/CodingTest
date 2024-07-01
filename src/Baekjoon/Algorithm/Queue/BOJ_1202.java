/**
 * 문제 : 보석 도둑
 * 소요 시간 : 47분
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.Queue;

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

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int K = Integer.parseInt(st.nextToken());

		int[] backpacks = new int[K];
		int[] values = new int[K];

		PriorityQueue<Jewelry> pq1 = new PriorityQueue<>((o1, o2) -> o1.m - o2.m);
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			int m = Integer.parseInt(st.nextToken());
			int v = Integer.parseInt(st.nextToken());
			pq1.offer(new Jewelry(m, v));
		}

		for (int i = 0; i < K; i++) {
			backpacks[i] = Integer.parseInt(br.readLine().trim());
		}

		// 무게 허용치가 작은 가방부터, 담을 수 있는 가장 가치가 큰 보석을 담는다.
		Arrays.sort(backpacks);

		PriorityQueue<Jewelry> pq2 = new PriorityQueue<>((o1, o2) -> o2.v - o1.v);
		for (int i = 0; i < K; i++) {
			// 가방 최대 무게가 더 크다면
			while (!pq1.isEmpty() && backpacks[i] >= pq1.peek().m) {
				pq2.offer(pq1.poll());
			}
			if (!pq2.isEmpty()) {
				values[i] = pq2.poll().v;
			}
		}

		long result = 0; // (각 가방의 최대 무게 <= 100,000,000) * (K <= 300,000)
		for (int i = 0; i < K; i++) {
			result += values[i];
		}

		bw.write(result + "\n");
		bw.flush();
		bw.close();
		br.close();
	}

	static class Jewelry {
		int m;
		int v;

		public Jewelry(int m, int v) {
			this.m = m;
			this.v = v;
		}
	}
}
