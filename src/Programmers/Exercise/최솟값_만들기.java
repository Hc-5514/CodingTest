/**
 * 문제 : 최솟값 만들기
 *
 * @author Hc-5514
 */

package Programmers.Exercise;

import java.util.Arrays;

public class 최솟값_만들기 {

	class Solution {
		public int solution(int[] A, int[] B) {
			Arrays.sort(A);
			Arrays.sort(B);

			int answer = 0;
			for (int i = 0; i < A.length; i++) {
				answer += A[i] * B[A.length - 1 - i];
			}

			return answer;
		}
	}
}
