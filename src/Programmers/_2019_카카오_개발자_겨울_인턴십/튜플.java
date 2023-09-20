package Programmers._2019_카카오_개발자_겨울_인턴십;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;

public class 튜플 {
	class Solution {

		public int[] solution(String s) {
			// 각 숫자가 나온 횟수 저장
			Map<Integer, Integer> map = new HashMap<>();
			StringTokenizer st = new StringTokenizer(s, "{},");
			while (st.hasMoreTokens()) {
				int n = Integer.parseInt(st.nextToken());
				if (map.containsKey(n)) {
					map.put(n, map.get(n) + 1);
				} else {
					map.put(n, 1);
				}
			}

			// map 의 value 값으로 내림차순 정렬
			List<Integer> keySet = new ArrayList<>(map.keySet());
			keySet.sort((n1, n2) -> map.get(n2).compareTo(map.get(n1)));

			int[] answer = new int[keySet.size()];
			int idx = 0;
			for (Integer key : keySet) {
				answer[idx++] = key;
			}

			return answer;
		}
	}
}

