/**
 * 문제 : 팩토리얼 2
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.DynamicProgramming;

import java.io.*;

public class BOJ_27433 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine().trim());

        Long[] d = new Long[N + 1];
        d[0] = 1l;

        for (int i = 1; i <= N; i++) {
            d[i] = d[i - 1] * i;
        }

        bw.write(d[N] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}