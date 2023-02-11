/**
 * 문제 : 쇠막대기
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;

public class BOJ_10799 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        Stack<Character> s = new Stack<>();

        // str: 쇠막대기와 레이저 배치를 나타내는 문자열
        // barCnt: 레이저로 자를 때 나오는 막대기 개수
        // totalCnt: 전체 막대기 개수
        String str = br.readLine();
        int barCnt = 0, totalCnt = 0;
        for (int i = 0; i < str.length(); i++) {

            // 레이저 확인: ()가 쌍으로 나오면 레이저
            if (str.charAt(i) == '(' && str.charAt(i + 1) == ')') {
                barCnt = s.size();
                totalCnt += barCnt;
                i++;
            } else {
                // '(': 쇠막대 시작
                if (str.charAt(i) == '(') {
                    s.add('(');
                }
                // ')': 쇠막대 끝
                else {
                    s.pop();
                    totalCnt++;
                }
            }
        }

        // 출력
        System.out.println(totalCnt);
        br.close();
    }
}
