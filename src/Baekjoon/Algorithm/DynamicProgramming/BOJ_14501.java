/**
 * 문제 : 퇴사
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.DynamicProgramming;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_14501 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine().trim());

        int[] d = new int[N];
        int[][] info = new int[N][2];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            info[i][0] = Integer.parseInt(st.nextToken());
            info[i][1] = Integer.parseInt(st.nextToken());
        }

        if (info[N - 1][0] == 1) d[N - 1] = info[N - 1][1];

        for (int i = N - 2; i >= 0; i--) {
            int var = 0;

            if (i + info[i][0] < N) {
                var = info[i][1] + d[i + info[i][0]];
            } else if (i + info[i][0] == N) {
                var = info[i][1];
            }

            d[i] = Math.max(var, d[i + 1]);
        }

        bw.write(d[0] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}