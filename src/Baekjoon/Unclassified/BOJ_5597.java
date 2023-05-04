/**
 * 문제 : 과제 안 내신 분..?
 *
 * @author Hc-5514
 */

package Baekjoon.Unclassified;

import java.io.*;

public class BOJ_5597 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        boolean[] isSubmit = new boolean[31];
        for (int i = 0; i < 28; i++) {
            isSubmit[Integer.parseInt(br.readLine().trim())] = true;
        }

        for (int i = 1; i < 31; i++) {
            if (!isSubmit[i]) bw.write(i + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}