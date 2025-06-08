/**
 * 문제: 단축키 지정
 * 난이도: 실버 1
 * 메모리: 18636KB, 시간: 192ms
 * 풀이: 문자열
 */

package Baekjoon.Algorithm.String;

import java.io.*;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Stream;

public class BOJ_1283 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        Set<Character> set = new HashSet<>();

        int N = Integer.parseInt(br.readLine());
        for (int i = 0; i < N; i++) {
            String line = br.readLine();
            String[] words = Stream.of(line.split(" "))
                    .toArray(String[]::new);
            boolean flag = false;

            // 1. 첫 글자가 단축키로 지정되었는지 확인
            for (int j = 0; j < words.length; j++) {
                String word = words[j].toLowerCase();
                char ch = word.charAt(0);
                if (set.contains(ch)) {
                    continue;
                }
                set.add(ch);
                flag = true;
                int idx = 0;
                for (int k = 0; k < j; k++) {
                    idx += words[k].length() + 1;
                }
                bw.write(line.substring(0, idx) + "[" + line.charAt(idx) + "]" + line.substring(idx + 1) + "\n");
                break;
            }

            if (flag) {
                continue;
            }

            // 2. 단축키로 지정 안 된 것 있는지 확인
            for (int j = 0; j < line.length(); j++) {
                char ch = line.toLowerCase().charAt(j);
                if (ch == ' ' || set.contains(ch)) {
                    continue;
                }
                set.add(ch);
                flag = true;
                bw.write(line.substring(0, j) + "[" + line.charAt(j) + "]" + line.substring(j + 1) + "\n");
                break;
            }

            if (flag) {
                continue;
            }

            bw.write(line + "\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}
