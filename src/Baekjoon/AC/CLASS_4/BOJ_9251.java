/**
 * 문제 : LCS
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_4;

import java.io.*;

public class BOJ_9251 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str1 = br.readLine();
        String str2 = br.readLine();

        int[][] d = new int[str1.length() + 1][str2.length() + 1];

        for (int i = 1; i <= str1.length(); i++) {
            for (int j = 1; j <= str2.length(); j++) {
                if (str1.charAt(i - 1) == str2.charAt(j - 1)) {
                    d[i][j] = d[i - 1][j - 1] + 1;
                } else {
                    d[i][j] = Math.max(d[i - 1][j], d[i][j - 1]);
                }
            }
        }

        bw.write(d[str1.length()][str2.length()] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}