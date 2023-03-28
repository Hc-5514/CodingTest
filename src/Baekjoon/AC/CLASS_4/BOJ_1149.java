/**
 * 문제 : RGB거리
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_4;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_1149 {

    static int[][] info, d;

    private static void find(int n) {
        for (int i = 1; i < n; i++) {
            int prev;
            prev = (d[i - 1][1] < d[i - 1][2]) ? d[i - 1][1] : d[i - 1][2];
            d[i][0] = info[i][0] + prev;
            prev = (d[i - 1][0] < d[i - 1][2]) ? d[i - 1][0] : d[i - 1][2];
            d[i][1] = info[i][1] + prev;
            prev = (d[i - 1][0] < d[i - 1][1]) ? d[i - 1][0] : d[i - 1][1];
            d[i][2] = info[i][2] + prev;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int n = Integer.parseInt(br.readLine().trim());
        info = new int[n][3];
        d = new int[n][3];

        for (int i = 0; i < n; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 3; j++) {
                info[i][j] = Integer.parseInt(st.nextToken());
                if (i == 0) {
                    d[0][j] = info[i][j];
                }
            }
        }

        find(n);

        int min = (d[n - 1][0] < d[n - 1][1] && d[n - 1][0] < d[n - 1][2]) ? d[n - 1][0] : ((d[n - 1][1] < d[n - 1][2]) ? d[n - 1][1] : d[n - 1][2]);

        bw.write(min + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}