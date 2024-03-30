/**
 * 문제 : 주차 요금 계산
 *
 * @author Hc-5514
 */

package Programmers._2022_KAKAO_BLIND_RECRUITMENT;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class 주차_요금_계산 {

	class Solution {
		public int[] solution(int[] fees, String[] records) {
			// records 는 "시각 차량번호 내역" 공백 구분 << StringTokenizer 사용
			// "HH:MM", "0~9 4자리", "IN or OUT"

			// HH*60 + MM 으로 시간 관리
			// IN/OUT 은 어떻게 관리? Map(key: 번호, value: 시간)?
			// IN은 -, OUT은 +
			Map<String, Integer> map = new HashMap<>();
			StringTokenizer st;
			for (int i = 0; i < records.length; i++) {
				st = new StringTokenizer(records[i]);
				String timeStr = st.nextToken();
				int time = Integer.parseInt(timeStr.substring(0, 2)) * 60 + Integer.parseInt(timeStr.substring(3, 5));
				String number = st.nextToken();
				String status = st.nextToken();
				if (status.equals("IN")) { // "IN" 이라면 - 연산
					if (!map.containsKey(number)) {
						map.put(number, time * -1);
					} else {
						map.put(number, map.get(number) - time);
					}
				} else { // "OUT" 이라면 + 연산
					map.put(number, map.get(number) + time);
				}
			}

			// Map 을 순회 하면서 요금 계산
			List<String> list = new ArrayList<>(map.keySet());
			int[] answer = new int[list.size()];

			// 차량 번호가 작은 차부터 출력
			Collections.sort(list);

			int idx = 0;
			for (String key : list) {
				int time = map.get(key);
				System.out.println(key + ", " + time);
				// 시간이 - 라면, OUT 이 안된 차이므로, 23*60 + 59; 를 더해준다.
				if (time <= 0) {
					time += 23 * 60 + 59;
				}
				int cost = fees[1];
				// fees[0]분 초과: fees[1]원 + fees[2]분당 fees[3]원
				if (time > fees[0]) {
					time -= fees[0];
					// -> 나머지는 올림 처리
					int rest = (int)Math.ceil(time * 1.0 / fees[2]);
					cost += rest * fees[3];
				}
				answer[idx++] = cost;
			}
			return answer;
		}
	}
}

