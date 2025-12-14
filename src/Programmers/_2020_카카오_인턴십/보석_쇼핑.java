/**
 * 문제: 보석 쇼핑
 * 난이도: Lv.3
 * 메모리: 93.3MB, 시간: 75.14ms
 * 풀이: 슬라이딩 윈도우
 */

package Programmers._2020_카카오_인턴십;

import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;

public class 보석_쇼핑 {

	public int[] solution(String[] gems) {
		HashSet<String> gemsSet = new HashSet<>();
		HashMap<String, Integer> gemsMap = new HashMap<>();
		int[] answer = {1, gems.length};

		// 보석 종류 개수 파악
		Collections.addAll(gemsSet, gems);
		int kindCnt = gemsSet.size();

		// 슬라이딩 윈도우: 조건을 만족하는 구간 파악
		int low = 0;
		int high = 0;
		int minLen = 100_000;
		gemsMap.put(gems[high], 1);

		while (low < gems.length) {
			int curLen = high - low + 1;
			if (kindCnt == gemsMap.size() && curLen < minLen) {
				minLen = curLen;
				answer[0] = low + 1;
				answer[1] = high + 1;
			}
			// 모든 종류의 보석을 포함하지 못한다면
			if (kindCnt > gemsMap.size()) {
				if (high == gems.length - 1) {
					break;
				}
				high++;
				if (gemsMap.containsKey(gems[high])) {
					gemsMap.put(gems[high], gemsMap.get(gems[high]) + 1);
				} else {
					gemsMap.put(gems[high], 1);
				}

			} else {
				gemsMap.put(gems[low], gemsMap.get(gems[low]) - 1);
				if (gemsMap.get(gems[low]) == 0) {
					gemsMap.remove(gems[low]);
				}
				low++;
			}
		}
		return answer;
	}
}
