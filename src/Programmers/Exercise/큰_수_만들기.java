package Programmers.Exercise;

import java.util.ArrayDeque;
import java.util.Deque;

public class 큰_수_만들기 {

	public String solution(String number, int k) {
		Deque<Character> st = new ArrayDeque<>();

		for (char n : number.toCharArray()) {
			while (!st.isEmpty() && k > 0 && st.peekLast() < n) {
				st.pollLast();
				k--;
			}
			st.offerLast(n);
		}

		while (k > 0) {
			st.pollLast();
			k--;
		}

		StringBuilder sb = new StringBuilder();
		for (char n : st) {
			sb.append(n);
		}
		return sb.toString();
	}
}
