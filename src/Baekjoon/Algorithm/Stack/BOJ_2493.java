/**
 * 문제 : 탑
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_2493 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        Stack<int[]> s = new Stack<>();
        int n = Integer.parseInt(br.readLine());
        StringTokenizer st = new StringTokenizer(br.readLine());

        for (int i = 1; i <= n; i++) {
            int height = Integer.parseInt(st.nextToken());
            while (!s.isEmpty()) {
                // 스택의 마지막 탑의 높이 > 입력받은 탑의 높이: 레이저 닿음
                if (s.peek()[1] > height) {
                    sb.append(s.peek()[0]).append(" ");
                    s.push(new int[]{i, height});
                    break;
                }
                // 스택의 마지막 탑의 높이 <= 입력받은 탑의 높이: 레이저가 닿는 탑이 나올 때까지 pop()
                else {
                    s.pop();
                }
            }
            // 스택이 비었다면 레이저를 수신할 탑이 없다.
            if (s.isEmpty()) {
                s.push(new int[]{i, height});
                sb.append(0).append(" ");
            }
        }

        System.out.println(sb);
        br.close();
    }
}