/**
 * 문제 : 균형잡힌 세상
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_2;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_4949 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        w1:
        while (true) {
            st = new StringTokenizer(br.readLine(), ".");
            if (!st.hasMoreTokens()) break;

            String str = st.nextToken();

            Stack<Character> s = new Stack<>();

            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                switch (ch) {
                    case '[':
                        s.push('[');
                        break;
                    case '(':
                        s.push('(');
                        break;
                    case ']':
                        if (s.isEmpty() || s.pop() != '[') {
                            bw.write("no" + "\n");
                            continue w1;
                        }
                        break;
                    case ')':
                        if (s.isEmpty() || s.pop() != '(') {
                            bw.write("no" + "\n");
                            continue w1;
                        }
                        break;
                }
            }
            if (s.isEmpty()) bw.write("yes" + "\n");
            else bw.write("no" + "\n");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}