/**
 * 문제 : 점프와 순간 이동
 *
 * @author Hc-5514
 */

package Programmers.SummerWinter_Coding_2018;

public class 점프와_순간_이동 {
	public int solution(int n) {
		int ans = 0;
		while (n > 0) {
			if (n % 2 == 0) {
				n /= 2;
			} else {
				n -= 1;
				ans++;
			}
		}
		return ans;
	}
}
