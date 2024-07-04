/**
 * 문제 : 외계 침략자 윤이
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.Implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_26123 {

	// 높이가 가장 높은 층 모두에 레이저 발사 (빌딩 수만큼 카운트)
	// 레이저를 맞으면 높이가 1 낮아지고, 모든 빌딩의 높이가 0이 되면 종료

	// 건물의 개수 (N <= 300,000) * 날의 수 (D <= 300,000) = 90,000,000,000 = 900초 -> 시간초과
	// 내림차순 정렬 후, 마지막으로 부서진 건물의 인덱스부터 탐색 -> 시간 초과

	// 각 높이의 건물 수 저장

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken());
		int D = Integer.parseInt(st.nextToken());

		int[] highs = new int[300001];
		int maxHigh = 0;

		st = new StringTokenizer(br.readLine());
		for (int i = 0; i < N; i++) {
			int high = Integer.parseInt(st.nextToken());
			highs[high]++;
			maxHigh = Math.max(maxHigh, high);
		}

		long answer = 0;
		while (D-- > 0 && maxHigh > 0) {
			answer += highs[maxHigh];
			highs[maxHigh - 1] += highs[maxHigh];
			highs[maxHigh] = 0;
			maxHigh--;
		}

		bw.write(answer + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
