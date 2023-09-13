/**
 * 문제 : 이진 변환 반복하기
 *
 * @author Hc-5514
 */

package Programmers.월간_코드_챌린지_시즌1;

public class 이진_변환_반복하기 {

	class Solution {
		public int[] solution(String s) {
			int cnt = 1;
			int remove = 0;
			int curLen = 0;
			for (int i = 0; i < s.length(); i++) {
				if (s.charAt(i) == '1') {
					curLen++;
				} else {
					remove++;
				}
			}
			while (curLen > 1) {
				StringBuilder sb = new StringBuilder();
				int tmp = curLen;
				while (tmp > 1) {
					sb.append(tmp % 2);
					tmp = tmp >> 1;
				}
				sb.append(tmp);
				curLen = 0;
				for (int i = 0; i < sb.length(); i++) {
					if (sb.charAt(i) == '1') {
						curLen++;
					} else {
						remove++;
					}
				}
				cnt++;
			}

			return new int[] {cnt, remove};
		}
	}
}


