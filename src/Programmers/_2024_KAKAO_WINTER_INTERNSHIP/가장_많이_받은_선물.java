package Programmers._2024_KAKAO_WINTER_INTERNSHIP;

import java.util.HashMap;
import java.util.Map;
import java.util.StringTokenizer;

public class 가장_많이_받은_선물 {

	class Solution {

		// 다음 달에 누가 선물을 가장 많이 받을지 예측
		// 선물 주고 받은 기록이 있다면, 더 많은 선물을 준 사람이 +1
		// 기록이 없거나 개수가 같다면, 선물 지수가 큰 사람이 +1 (선물 지수가 같다면 skip)
		// 선물 지수: 모든 친구에게 준 선물의 수 - 받은 선물의 수

		// gifts 2번 순회?
		// 1번: 주고 받은 선물 정리(int[][]), 선물 지수 계산 (int[][3] 배열)
		// 2번: 다음 달에 받을 선물 개수 파악

		public int solution(String[] friends, String[] gifts) {
			Map<String, Integer> nameMap = new HashMap<>();
			int[][] giftCnt = new int[friends.length][friends.length];
			int[][] point = new int[friends.length][3]; // 준 선물, 받은 선물, 선물 지수
			int[] result = new int[friends.length]; // 다음 달에 받을 선물 수

			for (int i = 0; i < friends.length; i++) {
				nameMap.put(friends[i], i);
			}

			StringTokenizer st;
			// 1순회
			for (String str : gifts) {
				st = new StringTokenizer(str);
				int no1 = nameMap.get(st.nextToken());
				int no2 = nameMap.get(st.nextToken());
				// 서로 주고 받은 선물 기록
				giftCnt[no1][no2]++; // 1개 선물 (no1 -> no2)
				// 누적 기록 관리
				point[no1][0]++;
				point[no1][2]++;
				point[no2][1]++;
				point[no2][2]--;
			}

			// 2순회
			for (int i = 0; i < friends.length - 1; i++) {
				for (int j = i + 1; j < friends.length; j++) {
					int cnt1 = giftCnt[i][j];
					int cnt2 = giftCnt[j][i];
					// 선물 주고 받은 기록이 있다면, 더 많은 선물을 준 사람이 +1
					if (cnt1 > cnt2) {
						result[i]++;
					} else if (cnt1 < cnt2) {
						result[j]++;
					} else { // 기록이 없거나 개수가 같다면
						// 선물 지수가 큰 사람이 +1 (선물 지수가 같다면 skip)
						if (point[i][2] > point[j][2]) {
							result[i]++;
						} else if (point[i][2] < point[j][2]) {
							result[j]++;
						}
					}
				}
			}

			// 출력
			int answer = 0;
			for (int n : result) {
				answer = Math.max(answer, n);
			}
			return answer;
		}
	}
}
