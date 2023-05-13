/**
 * 문제 : 뒤집기
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.Greedy;

import java.io.*;

public class BOJ_1439 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();

        boolean isZero;
        if (str.charAt(0) == '0') isZero = true;
        else isZero = false;

        int cnt = 0;
        for (int i = 1; i < str.length(); i++) {
            if (str.charAt(i) == '1') {
                if (isZero) {
                    cnt++;
                    isZero = false;
                }
            } else {
                if (!isZero) {
                    cnt++;
                    isZero = true;
                }
            }
        }

        if (cnt % 2 == 0) {
            cnt /= 2;
        } else {
            cnt = cnt / 2 + 1;
        }

        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}