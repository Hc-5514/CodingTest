/**
 * 문제 : 계단 오르기
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_3;

import java.io.*;

public class BOJ_2579 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine().trim());
        int[] s = new int[N];

        for (int i = 0; i < N; i++) {
            s[i] = Integer.parseInt(br.readLine().trim());
        }

        int[][] d = new int[N][2];
        d[0][0] = d[0][1] = s[0];

        if (N >= 2) {
            d[1][0] = s[1] + d[0][0];
            d[1][1] = s[1];

            for (int i = 2; i < N; i++) {
                // 1. 전 계단 선택 + 전전 계단 선택x
                d[i][0] = s[i] + d[i - 1][1];
                // 2. 전 계단 선택x + 전전 계단 선택o
                d[i][1] = s[i] + Math.max(d[i - 2][0], d[i - 2][1]);
            }
        }

        bw.write(Math.max(d[N - 1][0], d[N - 1][1]) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}