/**
 * 문제 : 대소문자 바꾸기
 *
 * @author Hc-5514
 */

package Baekjoon.Unclassified;

import java.io.*;

public class BOJ_2744 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (Character.isLowerCase(ch)) {
                bw.write(Character.toUpperCase(ch));
            } else bw.write(Character.toLowerCase(ch));
        }

        bw.flush();
        bw.close();
        br.close();
    }
}