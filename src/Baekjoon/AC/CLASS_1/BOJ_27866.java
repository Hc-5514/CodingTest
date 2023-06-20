/**
 * 문제 : 문자와 문자열
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_1;

import java.io.*;

public class BOJ_27866 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        int n = Integer.parseInt(br.readLine().trim());

        bw.write(str.charAt(n-1) + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}