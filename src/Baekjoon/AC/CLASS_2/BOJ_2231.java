/**
 * 문제 : 분해합
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_2231 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        int M;

        // N(1 ≤ N ≤ 1,000,000)
        // 9+9+9+9+9+9 = 54
        if (N > 54) {
            M = N - 54;
        } else {
            M = 1;
        }

        int sum = 0;
        M--;
        while (sum != N && M < N) {
            String numStr = String.valueOf(++M);
            sum = M;
            for (int i = 0; i < numStr.length(); i++) {
                sum += Character.getNumericValue(numStr.charAt(i));
            }

        }

        if (M == N) M = 0;
        System.out.println(M);
    }
}
