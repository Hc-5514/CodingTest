/**
 * 문제 : 연속 부분 수열 합의 개수
 *
 * @author Hc-5514
 */

package Programmers.Exercise;

import java.util.HashSet;
import java.util.Set;

public class 연속_부분_수열_합의_개수 {

	public int solution(int[] elements) {
		Set<Integer> set = new HashSet<>(); // 부분 수열의 합 경우의 수 (중복x) -> HashSet 사용

		int[][] dp = new int[elements.length][elements.length];

		// init
		for (int i = 0; i < elements.length; i++) {
			dp[0][i] = elements[i];
			set.add(dp[0][i]);
		}

		// 길이 2 ~ elements.length 부분 수열 경우의 수 구하기
		for (int i = 1; i < elements.length; i++) {
			for (int j = 0; j < elements.length; j++) {
				dp[i][j] = dp[i - 1][j] + dp[0][(j + i) % elements.length];
				set.add(dp[i][j]);
			}
		}
		return set.size();
	}
}
