/**
 * 문제 : 멀리 뛰기
 *
 * @author Hc-5514
 */

package Programmers.Exercise;

public class 멀리_뛰기 {

    public long solution(int n) {
        int[] fibo = new int[n];
        fibo[0] = 1;
        if (n > 1) {
            fibo[1] = 2;
            for (int i = 2; i < n; i++) {
                fibo[i] = ((fibo[i - 2] % 1234567) + (fibo[i - 1] % 1234567)) % 1234567;
            }
        }
        return fibo[n - 1];
    }
}
