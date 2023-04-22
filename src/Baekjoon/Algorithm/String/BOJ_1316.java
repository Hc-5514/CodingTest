/**
 * 문제 : 그룹 단어 체커
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.String;

import java.io.*;
import java.util.HashSet;
import java.util.Set;

public class BOJ_1316 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine().trim());
        int cnt = 0;

        f1:
        for (int i = 0; i < N; i++) {
            char[] chars = br.readLine().toCharArray();
            Set<Character> set = new HashSet<>();
            set.add(chars[0]);
            for (int j = 1; j < chars.length; j++) {
                if (chars[j] != chars[j - 1]) {
                    if (set.contains(chars[j]))
                        continue f1;
                    set.add(chars[j]);
                }
            }
            cnt++;
        }

        bw.write(cnt + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}