/**
 * 문제 : 크냐?
 *
 * @author Hc-5514
 */

package Baekjoon.Unclassified;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_4101 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        while (true) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            if (a == 0 && b == 0) break;
            String answer = a > b ? "Yes" : "No";
            bw.write(answer + "\n");
        }

        bw.write("");
        bw.flush();
        bw.close();
        br.close();
    }
}