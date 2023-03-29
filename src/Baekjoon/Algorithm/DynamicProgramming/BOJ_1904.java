/**
 * 문제 : 01타일
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.DynamicProgramming;

import java.io.*;

public class BOJ_1904 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int n = Integer.parseInt(br.readLine().trim());

        int[] d = new int[n + 1];

        d[0] = 1;
        d[1] = 1;

        for (int i = 2; i <= n; i++) {
            d[i] = (d[i-2] + d[i-1]) % 15746;
        }

        bw.write(d[n] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}