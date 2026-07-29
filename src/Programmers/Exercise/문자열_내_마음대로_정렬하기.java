package Programmers.Exercise;

import java.util.Arrays;

public class 문자열_내_마음대로_정렬하기 {
	public String[] solution(String[] strings, int n) {
		Arrays.sort(strings, (s1, s2) -> {
			if (s1.charAt(n) == s2.charAt(n)) {
				return s1.compareTo(s2);
			}
			return Character.compare(s1.charAt(n), s2.charAt(n));
		});
		return strings;
	}
}
