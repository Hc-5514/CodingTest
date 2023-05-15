/**
 * 문제 : 셀프 넘버
 *
 * @author Hc-5514
 */

package Baekjoon.Unclassified;

import java.io.*;

public class BOJ_4673 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean[] selfNumber = new boolean[10001];
        for (int i = 1; i <= 10000; i++) {
            if (!selfNumber[i]) {
                bw.write(i + "\n");
            }

            int n = i;
            int tmp = i;
            while (tmp > 0) {
                n += tmp % 10;
                tmp /= 10;
            }

            if (n <= 10000) {
                selfNumber[n] = true;
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}