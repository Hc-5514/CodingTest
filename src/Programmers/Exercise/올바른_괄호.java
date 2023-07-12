/**
 * 문제 : 올바른 괄호
 *
 * @author Hc-5514
 */

package Programmers.Exercise;

import java.util.Stack;

public class 올바른_괄호 {
    class Solution {
        boolean solution(String str) {
            Stack<Character> s = new Stack<>();

            if (str.charAt(0) == ')') {
                return false;
            } else {
                s.push(str.charAt(0));
            }

            for (int i = 1; i < str.length(); i++) {
                if (s.isEmpty()) {
                    if (str.charAt(i) == '(') {
                        s.push('(');
                    } else {
                        return false;
                    }
                } else {
                    if (str.charAt(i) == '(') {
                        s.push('(');
                    } else {
                        s.pop();
                    }
                }
            }

            if (s.isEmpty()) {
                return true;
            } else {
                return false;
            }
        }
    }
}
