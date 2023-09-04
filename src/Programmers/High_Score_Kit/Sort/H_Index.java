/**
 * 문제 : H-Index
 *
 * @author Hc-5514
 */

package Programmers.High_Score_Kit.Sort;

import java.util.Arrays;

public class H_Index {

	public int solution(int[] citations) {
		Arrays.sort(citations);

		int[] cnt = new int[1001];
		int val = 0;
		int n = citations.length;
		for (int i = 0; i < 1000; i++) {
			while (val < n && i > citations[val]) {
				val++;
			}
			cnt[i] = citations.length - val;
		}

		for (int i = 999; i >= 0; i--) {
			if (i <= cnt[i]) {
				return i;
			}
		}
		return 0;
	}
}
