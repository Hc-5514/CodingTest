/**
 * 문제 : 메이플스토리
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.DynamicProgramming;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_20925 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int N = Integer.parseInt(st.nextToken()); // 사냥터 수 (1 <= N <= 200)
		int T = Integer.parseInt(st.nextToken()); // 방학 기간 (1 <= T <= 1,000)

		int[] enter = new int[N]; // 사냥터 입장 요구 경험치
		int[] exp = new int[N]; // 분당 경험치 획득량
		int[][] distance = new int[N][N]; // 이동 소요 시간
		int[][] total = new int[T + 1][N]; // 시간에 따란 경험치 총합

		// 사냥터 정보
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			enter[i] = Integer.parseInt(st.nextToken());
			exp[i] = Integer.parseInt(st.nextToken());
			// 요구 경험치가 0인 사냥터의 1분 사냥 경험치를 저장 (초기값 설정)
			if (enter[i] == 0) {
				total[1][i] = exp[i];
			}
		}

		// 사냥터 이동 시간
		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			for (int j = 0; j < N; j++) {
				distance[i][j] = Integer.parseInt(st.nextToken());
			}
		}

		int maxExp = 0;
		for (int t = 1; t <= T; t++) { // 1000
			for (int i = 0; i < N; i++) { // 현재 사냥터
				// 현재 사냥터의 누적 경험치량이 0이라면, 아직 올 수 없는 사냥터
				if (total[t - 1][i] != 0) {
					total[t][i] = Math.max(total[t][i], total[t - 1][i] + exp[i]); // 경험치 획득
				}
				maxExp = Math.max(maxExp, total[t][i]);
				for (int j = 0; j < N; j++) {
					if (i == j) {
						continue;
					}
					// 요구 경험치 확인
					if (total[t][i] < enter[j]) {
						continue;
					}
					// 방학 기간 확인
					int time = t + distance[i][j];
					if (time > T) {
						continue;
					}
					total[time][j] = Math.max(total[time][j], total[t][i]);
				}
			}
		}

		bw.write(maxExp + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
