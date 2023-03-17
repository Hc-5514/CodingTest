/**
 * 문제 : A+B - 2
 *
 * @author Hc-5514
 */

package Baekjoon.Unclassified;

import java.io.*;

public class BOJ_2558 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int a = Integer.parseInt(br.readLine().trim());
        int b = Integer.parseInt(br.readLine().trim());

        bw.write(a + b + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}