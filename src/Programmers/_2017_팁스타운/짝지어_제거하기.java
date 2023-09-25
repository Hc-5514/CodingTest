/**
 * 문제 : 짝지어 제거하기
 *
 * @author Hc-5514
 */

package Programmers._2017_팁스타운;

import java.util.Stack;

public class 짝지어_제거하기 {

	class Solution {
		public int solution(String s) {
			Stack<Character> st = new Stack<>();
			st.push(s.charAt(0));
			for (int i = 1; i < s.length(); i++) {
				if (!st.isEmpty() && st.peek() == s.charAt(i)) {
					st.pop();
				} else {
					st.push(s.charAt(i));
				}
			}
			if (st.isEmpty()) {
				return 1;
			}
			return 0;
		}
	}
}
