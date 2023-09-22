/**
 * 문제 : 피보나치 수
 *
 * @author Hc-5514
 */

package Programmers.Exercise;

public class 피보나치_수 {
	public int solution(int n) {
		long[] fibo = new long[n + 1];
		fibo[0] = 0;
		fibo[1] = 1;
		for (int i = 2; i <= n; i++) {
			fibo[i] = ((fibo[i - 2] % 1234567) + (fibo[i - 1] % 1234567)) % 1234567;
		}
		return (int)fibo[n];
	}
}
