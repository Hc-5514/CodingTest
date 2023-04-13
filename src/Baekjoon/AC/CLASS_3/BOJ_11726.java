/**
 * 문제 : 2×n 타일링
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_3;

import java.io.*;

public class BOJ_11726 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine().trim());

        int[] d = new int[N];
        d[0] = 1;

        if (N > 1) {
            d[1] = 2;
            for (int i = 2; i < N; i++) {
                d[i] = (d[i - 2] + d[i - 1]) % 10007;
            }
        }

        bw.write(d[N - 1] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}