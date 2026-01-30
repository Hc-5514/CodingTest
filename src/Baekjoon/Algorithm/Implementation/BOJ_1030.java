/**
 * 문제: 프렉탈 평면
 * 난이도: 골드 3
 * 메모리: 11592KB, 시간: 72ms
 * 풀이: 분할 정복
 */

package Baekjoon.Algorithm.Implementation;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1030 {

	private static int s, N, K;

	private static boolean isBlack(long r, long c) {
		long len = (long)Math.pow(N, s);
		long start = (N - K) / 2;
		long end = start + K - 1;

		// (r, c)가 검정이면 true
		while (len > 1) {
			long blockSize = len / N;
			long blockRow = r / blockSize;
			long blockCol = c / blockSize;

			// K * K 영역 확인
			if (blockRow >= start && blockCol >= start && blockRow <= end && blockCol <= end) {
				return true;
			}

			r %= blockSize;
			c %= blockSize;
			len = blockSize;
		}

		return false;
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		s = Integer.parseInt(st.nextToken()); // 단위 시간, 0 <= s <= 10
		N = Integer.parseInt(st.nextToken()); // 시간 0일 때 한 변의 길이, 3 <= N <= 8
		K = Integer.parseInt(st.nextToken()); // 시간 0일 때 검정 한 변의 길이, 1 <= K <= N-2
		int R1 = Integer.parseInt(st.nextToken());
		int R2 = Integer.parseInt(st.nextToken()); // R1 <= R2 <= R1 + 49
		int C1 = Integer.parseInt(st.nextToken());
		int C2 = Integer.parseInt(st.nextToken()); // C1 <= C2 <= C1 + 49

		for (long i = R1; i <= R2; i++) {
			for (long j = C1; j <= C2; j++) {
				sb.append(isBlack(i, j) ? '1' : '0');
			}
			sb.append("\n");
		}

		System.out.println(sb);
		br.close();
	}
}
