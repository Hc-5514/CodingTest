/**
 * 문제 : 소수 구하기
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1929 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st = new StringTokenizer(br.readLine());

        // M이상 N이하 소수 구하기
        int M = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        // 0 ~ N 범위 배열 선언
        boolean[] arr = new boolean[N + 1];

        // 소수 판별하기 (에라토스테네스의 체)
        // 소수: false, 소수가 아니면: true
        arr[0] = arr[1] = true;
        for (int i = 2; i <= Math.sqrt(N); i++) {
            if(arr[i]) continue;
            for (int j = i*i; j <= N; j+=i) {
                arr[j] = true;
            }
        }

        for (int i = M; i < N + 1; i++) {
            if (!arr[i]) sb.append(i).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}
