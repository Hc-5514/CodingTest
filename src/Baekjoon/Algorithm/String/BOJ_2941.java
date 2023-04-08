/**
 * 문제 : 크로아티아 알파벳
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.String;

import java.io.*;

public class BOJ_2941 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        String str = br.readLine();
        int cnt = 0;
        for (int i = 0; i < str.length(); i++) {
            cnt++;
            switch (str.charAt(i)) {
                case 'c':
                    if (i + 1 >= str.length()) continue;
                    if (str.charAt(i + 1) == '=' || str.charAt(i + 1) == '-') i++;
                    break;
                case 'd':
                    if (i + 1 >= str.length()) continue;
                    if (str.charAt(i + 1) == '-') i++;
                    else if (str.charAt(i + 1) == 'z') {
                        if (i + 2 >= str.length()) continue;
                        if (str.charAt(i + 2) == '=')
                            i += 2;
                    }
                    break;
                case 'l':
                case 'n':
                    if (i + 1 >= str.length()) continue;
                    if (str.charAt(i + 1) == 'j') i++;
                    break;
                case 's':
                case 'z':
                    if (i + 1 >= str.length()) continue;
                    if (str.charAt(i + 1) == '=') i++;
                    break;
            }
        }

        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}