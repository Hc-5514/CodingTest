/**
 * 문제 : 2×n 타일링 2
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_3;

import java.io.*;

public class BOJ_11727 {

    static int[] d = new int[1001];

    private static int dp(int n) {
        if (d[n] > 0) {
            return d[n];
        } else {
            for (int i = 2; i <= n; i++) {
                d[i] = d[i - 1] + d[i - 2] * 2;
                d[i] %= 10007;
            }
            return d[n];
        }

    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine().trim());

        d[0] = d[1] = 1;

        bw.write(dp(n) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}