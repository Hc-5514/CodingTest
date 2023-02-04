/**
 * 문제 : 영화감독 숌
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1436 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int N = Integer.parseInt(br.readLine());
        int cnt =0, n = 665;

        while (cnt < N) {
            // 666을 포함하고 있다면
            if (String.valueOf(++n).contains("666")) {
                cnt++;
            }
        }

        System.out.println(n);
        br.close();
    }
}
