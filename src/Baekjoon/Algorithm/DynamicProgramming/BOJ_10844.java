/**
 * 문제 : 쉬운 계단 수
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.DynamicProgramming;

import java.io.*;

public class BOJ_10844 {

    static final int MOD = 1000000000;

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine().trim());
        long[][] stairs = new long[N][10];

        for (int i = 1; i < 10; i++) {
            stairs[0][i] = 1;
        }

        for (int i = 1; i < N; i++) {
            stairs[i][0] = stairs[i - 1][1];
            for (int j = 1; j < 9; j++) {
                stairs[i][j] = (stairs[i - 1][j - 1] + stairs[i - 1][j + 1]) % MOD;
            }
            stairs[i][9] = stairs[i - 1][8];
        }

        long result = 0;
        for (int i = 0; i < 10; i++) {
            result += stairs[N - 1][i];
        }

        bw.write((result % MOD) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}