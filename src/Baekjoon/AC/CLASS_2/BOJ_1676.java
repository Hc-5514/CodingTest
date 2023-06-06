/**
 * 문제 : 팩토리얼 0의 개수
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_2;

import java.io.*;

public class BOJ_1676 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine().trim());
        int cnt = 0;
        while (N >= 5) {
            cnt += N / 5;
            N /= 5;
        }

        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}