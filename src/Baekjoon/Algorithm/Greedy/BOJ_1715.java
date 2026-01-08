/**
 * 문제: 카드 정렬하기
 * 난이도: 골드 4
 * 메모리: 29640KB, 시간: 456ms
 * 풀이: 그리디
 */

package Baekjoon.Algorithm.Greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class BOJ_1715 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());

		PriorityQueue<Long> pq = new PriorityQueue<>(Long::compare);

		for (int i = 0; i < n; i++) {
			pq.offer(Long.parseLong(br.readLine()));
		}

		long result = 0;
		while (pq.size() > 1) {
			long n1 = pq.poll();
			long n2 = pq.poll();
			long sum = n1 + n2;
			result += sum;
			pq.offer(sum);
		}

		bw.write(result + "");
		bw.flush();
		bw.close();
		br.close();
	}
}
