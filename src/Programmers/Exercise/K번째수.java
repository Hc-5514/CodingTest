/**
 * 문제 : K번째수
 *
 * @author Hc-5514
 */

package Programmers.Exercise;

import java.util.Arrays;

public class K번째수 {
	class Solution {
		public int[] solution(int[] array, int[][] commands) {
			int[] answer = new int[commands.length];
			for (int i = 0; i < commands.length; i++) {
				int[] copyArr;
				copyArr = Arrays.copyOfRange(array, commands[i][0] - 1, commands[i][1]);
				Arrays.sort(copyArr);
				answer[i] = copyArr[commands[i][2] - 1];
			}

			return answer;
		}
	}
}
