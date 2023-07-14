/**
 * 문제 : 귤 고르기
 *
 * @author Hc-5514
 */

package Programmers.Exercise;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class 귤_고르기 {

	public int solution(int k, int[] tangerine) {
		// 중복 숫자가 가장 많은 수 기준으로 정렬
		// k개에 도달할 때까지 귤 고르기
		Map<Integer, Integer> map = new HashMap<>();
		for (int i = 0; i < tangerine.length; i++) {
			int n = tangerine[i];
			if (map.containsKey(n)) {
				map.put(n, map.get(n) + 1);
			} else {
				map.put(n, 1);
			}
		}

		List<Integer> list = new ArrayList<>(map.values());
		Collections.sort(list, Collections.reverseOrder());

		int cnt = 0;
		int answer = 0;
		for (int i = 0; i < list.size(); i++) {
			cnt += list.get(i);
			if (cnt >= k) {
				answer = i;
				break;
			}
		}
		return answer;

		// List<Map.Entry<Integer, Integer>> entryList = new LinkedList<>(map.entrySet());
		// entryList.sort(new Comparator<Map.Entry<Integer, Integer>>() {
		// 	@Override
		// 	public int compare(Map.Entry<Integer, Integer> o1, Map.Entry<Integer, Integer> o2) {
		// 		return o2.getValue() - o1.getValue();
		// 	}
		// });
		//
		// int answer = 0;
		// int cnt = 0;
		// for (Map.Entry<Integer, Integer> entry : entryList) {
		// 	answer++;
		// 	cnt += entry.getValue();
		// 	if (cnt >= k)
		// 		break;
		// }
		//
		// return answer;
	}
}
