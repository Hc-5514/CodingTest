/**
 * 문제 : 괄호 회전하기
 *
 * @author Hc-5514
 */

package Programmers.월간_코드_챌린지_시즌2;

import java.util.Stack;

public class 괄호_회전하기 {

	public static int solution(String str) {
		int answer = 0;
		f1:
		for (int i = 0; i < str.length(); i++) {
			Stack<Character> s = new Stack<>();
			for (int j = 0; j < str.length(); j++) {
				char cur = str.charAt((i + j) % str.length());
				if (cur == '[') {
					s.push('[');
				} else if (cur == '{') {
					s.push('{');
				} else if (cur == '(') {
					s.push('(');
				} else if (cur == ']') {
					if (s.isEmpty() || s.pop() != '[') {
						continue f1;
					}
				} else if (cur == '}') {
					if (s.isEmpty() || s.pop() != '{') {
						continue f1;
					}
				} else if (cur == ')') {
					if (s.isEmpty() || s.pop() != '(') {
						continue f1;
					}
				}
			}
			if (s.isEmpty()) {
				answer++;
			}
		}
		return answer;
	}
}
