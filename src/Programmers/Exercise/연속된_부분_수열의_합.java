/**
 * 문제 : 연속된 부분 수열의 합
 *
 * @author Hc-5514
 */

package Programmers.Exercise;

public class 연속된_부분_수열의_합 {
	public int[] solution(int[] sequence, int k) {
		// 비내림차순 정렬
		// 알고리즘: 슬라이딩 윈도우 (투 포인터)

		int s = 0;
		int e = sequence.length - 1;

		int sum = 0; // 현재 수열의 합
		for (int l = 0, r = 0; l < sequence.length; l++) {
			while (r < sequence.length && sum < k) {
				sum += sequence[r++];
			}
			if (sum == k) {
				if (r - l - 1 < e - s) {
					s = l;
					e = r - 1;
				}
			}
			sum -= sequence[l];
		}

		return new int[] {s, e};
	}
}
