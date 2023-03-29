/**
 * 문제 : 이친수
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.DynamicProgramming;

import java.io.*;

public class BOJ_2193 {

    static long[] d = new long[91];

    static long dp(int n) {
        if (n <= 1) return 1;
        else if (d[n] != 0) return d[n];
        else {
            d[n] = dp(n - 2) + dp(n - 1);
            return d[n];
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine().trim());
        d[0] = 1;
        d[1] = 1;

        dp(N - 1);

        bw.write(d[N-1] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}