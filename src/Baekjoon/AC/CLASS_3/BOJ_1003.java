/**
 * 문제 : 피보나치 함수
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_3;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class BOJ_1003 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();

        int[] fibo_0 = new int[41];
        int[] fibo_1 = new int[41];

        // 기본 값 설정
        fibo_0[0] = 1;
        fibo_0[1] = 0;
        fibo_1[0] = 0;
        fibo_1[1] = 1;

        // fibonacci(1) ~ fibonacci(40)의 호출 횟수 저장
        for (int i = 2; i < 41; i++) {
            fibo_0[i] = fibo_0[i - 2] + fibo_0[i - 1];
            fibo_1[i] = fibo_1[i - 2] + fibo_1[i - 1];
        }

        // 출력
        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            int n = Integer.parseInt(br.readLine());
            sb.append(fibo_0[n]).append(" ").append(fibo_1[n]).append("\n");
        }
        System.out.println(sb);
        br.close();
    }

}
