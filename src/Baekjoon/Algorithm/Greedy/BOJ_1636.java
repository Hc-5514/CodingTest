/**
 * 문제 : 한번 열면 멈출 수 없어
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.Greedy;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_1636 {

	// 스트레스의 시작값을 중독 스트레스 조절 범위의 교집합에서 설정한다.

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		int N = Integer.parseInt(br.readLine().trim());
		int[][] range = new int[N][2];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			range[i][0] = Integer.parseInt(st.nextToken());
			range[i][1] = Integer.parseInt(st.nextToken());
		}

		// 스트레스 시작값 설정
		int[] lastRange = new int[2];
		lastRange[0] = range[0][0];
		lastRange[1] = range[0][1];
		int stress = range[0][0];

		for (int i = 1; i < N; i++) {
			if (lastRange[1] <= range[i][0]) {
				stress = lastRange[1];
				break;
			} else if (lastRange[0] >= range[i][1]) {
				stress = lastRange[0];
				break;
			} else {
				lastRange[0] = Math.max(lastRange[0], range[i][0]);
				lastRange[1] = Math.min(lastRange[1], range[i][1]);
			}
		}

		// 예상 수명 값 구하기
		sb.append(stress).append("\n");
		int sum = 0;
		for (int i = 1; i < N; i++) {
			if (stress < range[i][0]) {
				sum += (range[i][0] - stress);
				stress = range[i][0];
			} else if (stress > range[i][1]) {
				sum += (stress - range[i][1]);
				stress = range[i][1];
			}
			sb.append(stress).append("\n");
		}

		bw.write(sum + "\n");
		bw.write(sb.toString());

		bw.flush();
		bw.close();
		br.close();
	}
}
