/**
 * 문제 : 가운데를 말해요
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.Queue;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.PriorityQueue;

public class BOJ_1655 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// 2개의 pq에 번갈아가면서 숫자 삽입
		PriorityQueue<Integer> pq1 = new PriorityQueue<>((o1, o2) -> o2 - o1);
		PriorityQueue<Integer> pq2 = new PriorityQueue<>((o1, o2) -> o1 - o2);

		// N개의 수 입력 받기, 초기값 넣기
		int N = Integer.parseInt(br.readLine().trim());
		int n = Integer.parseInt(br.readLine().trim());
		pq1.offer(n);
		bw.write(n + "\n");

		for (int i = 1; i < N; i++) {
			n = Integer.parseInt(br.readLine().trim());
			if (i % 2 == 0) {
				pq1.offer(n);
			} else {
				pq2.offer(n);
			}
			// 1번 pq 의 최댓값 < 2번 pq 의 최솟값 유지
			if (pq1.peek() > pq2.peek()) {
				int n1 = pq1.poll();
				int n2 = pq2.poll();
				pq1.offer(n2);
				pq2.offer(n1);
			}
			// 중간 값 출력
			bw.write(pq1.peek() + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
