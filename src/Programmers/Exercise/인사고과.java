/**
 * 문제 : 인사고과
 *
 * @author Hc-5514
 */

package Programmers.Exercise;

import java.util.Arrays;

public class 인사고과 {

	// 근무 태도, 동료 평가 점수 합으로 완호의 석차 구하기 (0번째 인덱스)
	// 동일 석차가 있다면, 해당 수만큼 다음 석차는 건너 뜀 (ex. 1 1 3 4)
	// 어떤 사원이 다른 임의의 사원보다 두 점수가 모두 낮은 경우는 석차 제외

	public int solution(int[][] scores) {
		int[] find = {scores[0][0], scores[0][1]}; // 완호 점수

		// 근무 태도 (내림차순), 동료 평가 (오름차순)
		Arrays.sort(scores, (o1, o2) -> {
			if (o1[0] == o2[0]) {
				return o1[1] - o2[1];
			}
			return o2[0] - o1[0];
		});

		int max = scores[0][1];

		for (int i = 1; i < scores.length; i++) {
			if (scores[i][1] < max) {
				// 완호일 경우: -1 반환
				if (scores[i][0] == find[0] && scores[i][1] == find[1]) {
					return -1;
				}
				// 석차 제외
				scores[i][0] = -1;
				scores[i][1] = -1;
			} else {
				max = scores[i][1];
			}
		}

		// 점수의 합 (내림 차순)
		Arrays.sort(scores, (o1, o2) -> (o2[0] + o2[1]) - (o1[0] + o1[1]));

		int rank = 1;
		for (int i = 0; i < scores.length; i++) {
			if (scores[i][0] + scores[i][1] > find[0] + find[1]) {
				rank++;
			} else {
				break;
			}
		}

		return rank;
	}
}
