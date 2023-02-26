/**
 * 문제 : 막대기
 *
 * @author Hc-5514
 */

package Baekjoon.Unclassified;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1094 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int X = Integer.parseInt(br.readLine());
        int len = 64, sum = 64, cnt = 1;
        while (sum != X) {
            if (sum > X) {
                len /= 2;
                if (sum - len >= X) {
                    sum -= len;
                } else cnt++;
            }
        }

        System.out.println(cnt);
        br.close();
    }
}
