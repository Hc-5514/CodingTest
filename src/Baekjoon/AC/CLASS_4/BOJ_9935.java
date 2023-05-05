/**
 * 문제 : 문자열 폭발
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_4;

import java.io.*;
import java.util.Stack;

/**
 * Stack에는 get() 함수가 있다.
 */
public class BOJ_9935 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        // 문자열 폭발: 모든 폭발 문자열이 폭발, 남은 문자열 이어 붙임
        // 남아있는 문자가 없는 경우: FRULA 출력

        String ori = br.readLine();
        String bomb = br.readLine();

        Stack<Character> s = new Stack<>();

        for (int i = 0; i < ori.length(); i++) {
            s.push(ori.charAt(i));

            if (s.size() >= bomb.length()) {
                // 1. 폭발 문자열의 마지막 문자와 같다면 하나씩 비교
                boolean isBomb = true;
                for (int j = 0; j < bomb.length(); j++) {
                    if (s.get(s.size() - bomb.length() + j) != bomb.charAt(j)) {
                        isBomb = false;
                        break;
                    }
                }
                if (isBomb) {
                    for (int j = 0; j < bomb.length(); j++) {
                        s.pop();
                    }
                }
            }
        }

        if (s.isEmpty()) {
            bw.write("FRULA\n");
        } else {
            for (char ch : s) {
                bw.write(ch);
            }
            bw.write("\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}