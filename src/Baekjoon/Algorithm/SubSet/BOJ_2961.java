/**
 * 문제 : 도영이가 만든 맛있는 음식
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.SubSet;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2961 {

	static int N, minSub = Integer.MAX_VALUE;
	static int[][] arrN;
	static boolean[] isSelected;

	private static void SubSet(int cnt, int selectCnt) {

		// 재료가 하나 이상 선택 됐을 때 (공집합이 아닐 때)
		if (selectCnt != 0) {
			// 재료의 신맛, 쓴맛 차이 구하기
			int S = 1, M = 0;
			for (int i = 0; i < N; i++) {
				// 선택된 재료라면
				if (isSelected[i]) {
					S *= arrN[i][0];
					M += arrN[i][1];
				}
			}
			minSub = Math.min(minSub, Math.abs(S - M));
		}

		// 모든 재료를 사용했다면 return
		if (cnt == N) {
			return;
		}

		// 재료를 선택 했을 때
		isSelected[cnt] = true;
		SubSet(cnt + 1, selectCnt + 1);

		// 재료를 선택 안 했을 때
		isSelected[cnt] = false;
		SubSet(cnt + 1, selectCnt);
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st;

		// N: 재료의 개수, [0]: (S)재료의 신맛, [1]: (B)재료의 쓴맛
		N = Integer.parseInt(br.readLine());
		arrN = new int[N][2];
		isSelected = new boolean[N];

		for (int i = 0; i < N; i++) {
			st = new StringTokenizer(br.readLine());
			arrN[i][0] = Integer.parseInt(st.nextToken());
			arrN[i][1] = Integer.parseInt(st.nextToken());
		}

		// 신맛, 쓴맛 차이가 가장 적은 요리 구하기
		SubSet(0, 0);

		// 출력
		System.out.println(minSub);
		br.close();
	}

}
