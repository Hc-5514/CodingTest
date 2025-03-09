/**
 * 문제 : 돌 게임 6
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.DynamicProgramming;

import java.io.*;

public class BOJ_9660 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        long N = Long.parseLong(br.readLine());

        String result = "SK";
        if (N % 7 == 2 || N % 7 == 0) {
            result = "CY";
        }

        bw.write(result + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
