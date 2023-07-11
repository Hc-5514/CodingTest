/**
 * 문제 : JadenCase 문자열 만들기
 *
 * @author Hc-5514
 */

package Programmers.Exercise;

import java.util.*;

public class JadenCase_문자열_만들기 {

    class Solution {
        public String solution(String s) {
            StringTokenizer st = new StringTokenizer(s, " ", true);
            // 첫 글자를 제외한 나머지 문자는 모두 소문자로 변환
            // 첫 글자: 숫자 or 대문자
            // 공백 그대로 출력
            String answer = "";
            while (st.hasMoreTokens()) {
                String tmp = st.nextToken();
                Character ch = tmp.charAt(0);
                System.out.println(ch);
                // 공백 확인
                if (ch == ' ') {
                    answer += " ";
                    continue;
                }
                // 첫 글자
                if (ch >= 97 && ch <= 122) {
                    answer += (char) (ch - 32);
                    System.out.println("실행 안함?");
                } else {
                    answer += ch;
                    System.out.println("실행 했음");
                }
                // 나머지
                answer += tmp.substring(1, tmp.length()).toLowerCase();
            }
            return answer;
        }
    }
}
