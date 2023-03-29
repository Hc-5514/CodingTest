/**
 * 문제 : 카드 구매하기
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.DynamicProgramming;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_11052 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine().trim());
        int[] d = new int[N + 1];
        int[] cost = new int[N + 1];

        st = new StringTokenizer(br.readLine());
        for (int i = 1; i <= N; i++) {
            cost[i] = Integer.parseInt(st.nextToken());
        }

        for (int i = 1; i <= N; i++) {
            for (int j = 0; j < i; j++) {
                d[i] = Math.max(d[i], d[j] + cost[i - j]);
            }
        }

        bw.write(d[N] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}