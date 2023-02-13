/**
 * 문제 : 에디터
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_1406 {

    // lStack: 왼쪽 스택, rStack: 오른쪽 스택
    static Stack<Character> lStack = new Stack<>();
    static Stack<Character> rStack = new Stack<>();

    static void command(char ch) {

        if (ch == 'L') {
            // 커서가 문장의 맨 앞이면 무시
            if (!lStack.isEmpty()) {
                rStack.push(lStack.pop());
            }
        } else if (ch == 'D') {
            // 커서가 문장의 맨 뒤이면 무시
            if (!rStack.isEmpty()) {
                lStack.push(rStack.pop());
            }
        } else if (ch == 'B') {
            if (!lStack.isEmpty()) {
                lStack.pop();
            }
        } else {
            lStack.push(ch);
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // 초기 문자열을 왼쪽 스택에 저장
        String str = br.readLine();
        for (int i = 0; i < str.length(); i++) {
            lStack.push(str.charAt(i));
        }

        // 명령어 수행
        int M = Integer.parseInt(br.readLine());
        for (int i = 0; i < M; i++) {
            String tmp = br.readLine();
            if (tmp.charAt(0) == 'P') {
                command(tmp.charAt(2));
            } else command(tmp.charAt(0));
        }

        // 출력
        while(!lStack.isEmpty()){
            rStack.push(lStack.pop());
        }

        while(!rStack.isEmpty()){
            sb.append(rStack.pop());
        }

        System.out.println(sb);
        br.close();
    }
}
