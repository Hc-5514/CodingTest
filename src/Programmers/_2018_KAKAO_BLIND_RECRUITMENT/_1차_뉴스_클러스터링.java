/**
 * 문제 : [1차] 뉴스 클러스터링
 *
 * @author Hc-5514
 */

package Programmers._2018_KAKAO_BLIND_RECRUITMENT;

import java.util.ArrayList;
import java.util.List;

public class _1차_뉴스_클러스터링 {

	class Solution {
		public int solution(String str1, String str2) {
			// 문자를 2개씩 끊어서 저장
			// 알파벳이 아닌 다른 문자가 들어오면 버린다. 65~90
			List<String> list1 = new ArrayList<>();
			List<String> list2 = new ArrayList<>();
			str1 = str1.toUpperCase();
			str2 = str2.toUpperCase();

			for (int i = 0; i < str1.length() - 1; i++) {
				char ch1 = str1.charAt(i);
				char ch2 = str1.charAt(i + 1);
				if ((ch1 >= 65 && ch1 <= 90) && (ch2 >= 65 && ch2 <= 90)) {
					list1.add(str1.substring(i, i + 2));
				}
			}

			for (int i = 0; i < str2.length() - 1; i++) {
				char ch1 = str2.charAt(i);
				char ch2 = str2.charAt(i + 1);
				if ((ch1 >= 65 && ch1 <= 90) && (ch2 >= 65 && ch2 <= 90)) {
					list2.add(str2.substring(i, i + 2));
				}
			}
			System.out.println(list1);
			System.out.println(list2);
			for (int i = 0; i < list1.size(); i++) {
				for (int j = 0; j < list2.size(); j++) {
					if (list1.get(i).equals(list2.get(j))) {
						list1.set(i, "0");
						list2.set(j, "0");
					}
				}

			}
			// 교집합을 만들고, 교집합이 되는 애들을 제거한다
			// 합집합 = 교집합 + 나머지1 + 나머지2
			int cnt1 = 0;
			int cnt2 = 0;
			for (int i = 0; i < list1.size(); i++) {
				if (list1.get(i).equals("0")) {
					cnt1++;
				} else {
					cnt2++;
				}
			}
			for (int i = 0; i < list2.size(); i++) {
				if (!list2.get(i).equals("0")) {
					cnt2++;
				}
			}
			cnt2 += cnt1;

			if (cnt2 == 0) {
				return 65536;
			}

			int answer = (int)Math.floor(cnt1 * 65536.0 / cnt2);
			return answer;
		}
	}
}
