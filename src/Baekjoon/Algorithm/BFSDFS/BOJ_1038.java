/**
 * 문제: 감소하는 수
 * 난이도: 골드 5
 * 메모리: 11780KB, 시간: 64ms
 * 풀이: BFS
 */

package Baekjoon.Algorithm.BFSDFS;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class BOJ_1038 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		int N = Integer.parseInt(br.readLine().trim()); // 0 <= N <= 1_000_000

		List<Long> nums = new ArrayList<>(); // 감소하는 수

		Queue<Long> q = new ArrayDeque<>();
		for (long i = 0; i < 10; i++) {
			nums.add(i);
			q.offer(i);
		}

		while (!q.isEmpty()) {
			// cur 마지막 값보다 작은 수 추가
			long cur = q.poll();
			long last = cur % 10;
			for (long i = 0; i < last; i++) {
				long next = cur * 10 + i;
				nums.add(next);
				q.offer(next);
			}
		}

		long result = N <= (nums.size() - 1) ? nums.get(N) : -1;

		bw.write(String.valueOf(result));
		bw.flush();
		bw.close();
		br.close();
	}
}
