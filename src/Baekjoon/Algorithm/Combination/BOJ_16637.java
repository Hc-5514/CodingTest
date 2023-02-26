/**
 * 문제 : 괄호 추가하기
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.Combination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_16637 {

    static int N;
    static long maxValue = Long.MIN_VALUE;
    static StringBuffer str = new StringBuffer();
    static StringBuffer tmp = new StringBuffer();
    static boolean[] isSelected;

    private static void combinationList() {
        for (int i = 0; i <= (N + 1) / 4; i++) {
            combination(0, 0, i);
        }
    }

    private static void combination(int cnt, int start, int goal) {
        if (cnt == goal) {
            // 괄호 추가
            tmp.setLength(0);
            tmp.append(str);

            if (tmp.length() == 1) {
                maxValue = Character.getNumericValue(tmp.charAt(0));
                return;
            }

            for (int i = isSelected.length - 1; i >= 0; i--) {
                if (isSelected[i]) {
                    tmp.insert(2 * i + 3, ")");
                    tmp.insert(2 * i, "(");
                }
            }
            // 연산 실행
            // 초기값 설정
            long value, n1, n2, n3, n4;
            char op, op2, ch = tmp.charAt(0);
            if (ch == '(') {
                n1 = Character.getNumericValue(tmp.charAt(1));
                op = tmp.charAt(2);
                n2 = Character.getNumericValue(tmp.charAt(3));
                tmp.delete(0, 5);
            } else {
                n1 = Character.getNumericValue(tmp.charAt(0));
                op = tmp.charAt(1);
                if (tmp.charAt(2) == '(') {
                    n3 = Character.getNumericValue(tmp.charAt(3));
                    n4 = Character.getNumericValue(tmp.charAt(5));
                    op2 = tmp.charAt(4);
                    n2 = operation(n3, n4, op2);
                    tmp.delete(0, 7);
                } else {
                    n2 = Character.getNumericValue(tmp.charAt(2));
                    tmp.delete(0, 3);
                }
            }

            value = operation(n1, n2, op);

            while (tmp.length() != 0) {
                op = tmp.charAt(0);
                tmp.delete(0, 1);
                n1 = value;
                if (tmp.length() == 1) {
                    n2 = Character.getNumericValue(tmp.charAt(0));
                    value = operation(n1, n2, op);
                    break;
                }
                ch = tmp.charAt(0);
                if (ch == '(') {
                    n3 = Character.getNumericValue(tmp.charAt(1));
                    n4 = Character.getNumericValue(tmp.charAt(3));
                    op2 = tmp.charAt(2);
                    n2 = operation(n3, n4, op2);
                    tmp.delete(0, 5);
                } else {
                    n2 = Character.getNumericValue(tmp.charAt(0));
                    tmp.delete(0, 1);
                }
                value = operation(n1, n2, op);
            }
            maxValue = Math.max(maxValue, value);
            return;
        }

        for (int i = start; i < N / 2; i++) {
            if (isSelected[i]) continue;
            isSelected[i] = true;
            combination(cnt + 1, i + 2, goal);
            isSelected[i] = false;
        }
    }

    private static long operation(long n1, long n2, char op) {
        long result;
        if (op == '+')
            result = n1 + n2;
        else if (op == '-')
            result = n1 - n2;
        else result = n1 * n2;
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        N = Integer.parseInt(br.readLine());
        str.append(br.readLine());
        isSelected = new boolean[N / 2];

        combinationList();

        System.out.println(maxValue);
        br.close();
    }
}