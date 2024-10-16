/**
 * 문제 : 퍼즐 게임 챌린지
 * 소요 시간 : 20분
 *
 * @author Hc-5514
 */

package Programmers.PCCP_기출문제;

public class _2번_퍼즐_게임_챌린지 {

	class Solution {

		// 제한 시간 내 퍼즐을 모두 풀기 위한 숙련도 최솟값 구하기

		public int solution(int[] diffs, int[] times, long limit) {

			int s = 1;
			int e = 100_000;

			while (s < e) {
				int level = (s + e) >> 1;
				long totalTime = 0;
				for (int i = 0; i < diffs.length; i++) {
					if (diffs[i] <= level) { // 바로 해결 (times[i] 시간 사용)
						totalTime += times[i]; // 해결 (time_cur 시간 사용)
					} else { // (diffs[i] - level)번 틀림, 틀린 횟수 * (이전 퍼즐 시간 + 현재 퍼즐 시간) + 현재 퍼즐 시간
						totalTime += ((diffs[i] - level) * (times[i] + times[i - 1]) + times[i]);
					}

					if (totalTime > limit) {
						break;
					}
				}
				if (totalTime > limit) {
					s = level + 1;
				} else {
					e = level;
				}

			}

			return s;
		}
	}
}

