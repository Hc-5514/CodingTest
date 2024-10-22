/**
 * 문제 : 수식 복원하기
 *
 * @author Hc-5514
 */

package Programmers.PCCP_기출문제;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Queue;
import java.util.Set;
import java.util.StringTokenizer;

public class _4번_수식_복원하기 {

	class Solution {
		// 2 ~ 9 진법 계산 결과 구하는 메서드 작성
		// X가 아닐 경우, 수식 결과와 일치하는지 확인
		// X일 경우 보류: Queue?
		// Queue에 담긴 X의 값들을 구한다. HashSet 에 저장. -> 2개 이상일 경우 ?, 같을 경우 정답 입력
		// 수식 구조: n진수 (연산자) n진수 = n진수
		// -> n진수를 10진수로 변환 후 연산 -> 결과를 n진수로 변환

		// n진수로 표현된 수식이 올바른지 확인
		private boolean isCorrectExpression(String nStr1, String nStr2, String result, String op, int format) {
			// n진수의 갓 자릿수는 n보다 작아야 한다.
			for (int i = 0; i < nStr1.length(); i++) {
				if (Character.getNumericValue(nStr1.charAt(i)) >= format) {
					return false;
				}
			}
			for (int i = 0; i < nStr2.length(); i++) {
				if (Character.getNumericValue(nStr2.charAt(i)) >= format) {
					return false;
				}
			}

			if (result.equals("X")) {
				return true;
			}

			for (int i = 0; i < result.length(); i++) {
				if (Character.getNumericValue(result.charAt(i)) >= format) {
					return false;
				}
			}
			return Integer.parseInt(result) == getFormatResult(nStr1, nStr2, op, format);
		}

		// n진수로 표현된 수식의 결과 반환
		private int getFormatResult(String nStr1, String nStr2, String op, int format) {
			int result = 0;
			int d1 = convertToDecimal(nStr1, format);
			int d2 = convertToDecimal(nStr2, format);

			if (op.equals("+")) {
				result = convertToFormat(String.valueOf(d1 + d2), format);
			} else {
				result = convertToFormat(String.valueOf(d1 - d2), format);
			}

			return result;
		}

		// n진수로 표현된 수를 10진수로 반환
		private int convertToDecimal(String nStr, int format) {
			int result = 0;
			for (int i = 0; i < nStr.length(); i++) {
				result += Character.getNumericValue(nStr.charAt(nStr.length() - 1 - i)) * Math.pow(format, i);
			}
			return result;
		}

		// 10진수로 표현된 수를 n진수로 반환
		private int convertToFormat(String nStr, int format) {
			int n = Integer.parseInt(nStr);
			String result = "";

			// 최대 3자릿수
			for (int i = 2; i >= 0; i--) {
				int tmp = n / (int)Math.pow(format, i);
				if (result.equals("") && tmp == 0) {
					continue;
				}
				result += String.valueOf(tmp);
				n %= (int)Math.pow(format, i);
			}

			return result == "" ? 0 : Integer.parseInt(result);
		}

		public String[] solution(String[] expressions) {
			StringTokenizer st;

			// 2~9진법 저장
			List<Integer> nums = new ArrayList<>();
			for (int i = 2; i <= 9; i++) {
				nums.add(i);
			}

			Queue<String> q = new ArrayDeque<>();
			for (int i = 0; i < expressions.length; i++) {
				st = new StringTokenizer(expressions[i]);
				String nStr1 = st.nextToken();
				String op = st.nextToken();
				String nStr2 = st.nextToken();
				st.nextToken(); // = 버리기
				String result = st.nextToken();

				// 진법 계산
				for (int j = nums.size() - 1; j >= 0; j--) {
					if (!isCorrectExpression(nStr1, nStr2, result, op, nums.get(j))) {
						nums.remove(j);
					}
				}

				// X일 경우: 나중에 결과 계산
				if (result.equals("X")) {
					q.offer(expressions[i]);
				}
			}

			List<String> answerList = new ArrayList<>();
			// 보류한 수식 계산 (결과가 "X"인 수식)
			Set<Integer> set = new HashSet<>(); // "X"에 가능한 진법 저장
			while (!q.isEmpty()) {
				set.clear();
				st = new StringTokenizer(q.poll());
				String nStr1 = st.nextToken();
				String op = st.nextToken();
				String nStr2 = st.nextToken();
				st.nextToken(); // = 버리기
				String result = st.nextToken(); // X

				// 진법 계산
				for (int i = nums.size() - 1; i >= 0; i--) {
					int res = getFormatResult(nStr1, nStr2, op, nums.get(i));
					if (isCorrectExpression(nStr1, nStr2, String.valueOf(res), op, nums.get(i))) {
						set.add(res);
					}
				}

				// 결과 확인
				if (set.size() == 1) {
					Iterator iter = set.iterator();
					result = String.valueOf(iter.next());
				} else {
					result = "?";
				}
				// 출력
				String tmp = "";
				tmp += nStr1;
				tmp += " ";
				tmp += op;
				tmp += " ";
				tmp += nStr2;
				tmp += " ";
				tmp += "=";
				tmp += " ";
				tmp += result;

				answerList.add(tmp);
			}

			String[] answer = new String[answerList.size()];
			for (int i = 0; i < answerList.size(); i++) {
				answer[i] = answerList.get(i);
			}

			return answer;
		}
	}
}

