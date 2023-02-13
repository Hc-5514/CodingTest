/**
 * 문제 : 오큰수
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.Stack;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Stack;
import java.util.StringTokenizer;

public class BOJ_17298 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        // [0]: idx, [1]: 수열의 원소 -> 오큰수
        Stack<int[]> s = new Stack<>();
        int n = Integer.parseInt(br.readLine());
        int[][] arr = new int[n][2];
        StringTokenizer st = new StringTokenizer(br.readLine());
        for (int i = 0; i < n; i++) {
            arr[i][0] = i;
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        for (int i = 0; i < n; i++) {
            if (s.isEmpty()) {
                s.push(arr[i]);
            } else {
                while (!s.isEmpty()) {
                    // 새로운 수 > 스택의 수: 오큰수
                    if (arr[i][1] > s.peek()[1]) {
                        arr[s.peek()[0]][1] = arr[i][1];
                        s.pop();
                    } else break;
                }
                s.push(arr[i]);
            }
        }

        // 스택에 남은 수들은 모두 오큰 수가 없으므로 -1 반환
        while (!s.isEmpty()) {
            arr[s.pop()[0]][1] = -1;
        }

        // 출력
        for (int i = 0; i < arr.length; i++) {
            sb.append(arr[i][1]).append(" ");
        }
        System.out.println(sb);
        br.close();
    }
}
