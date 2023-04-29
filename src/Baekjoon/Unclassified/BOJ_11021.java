/**
 * 문제 : A+B - 7
 *
 * @author Hc-5514
 */

package Baekjoon.Unclassified;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_11021 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int i = 1; i <= T; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());

            bw.write("Case #" + i + ": ");
            bw.write((a + b) + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}