/**
 * 문제 : 라면 사기 (Small)
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.Greedy;

import java.io.*;
import java.util.StringTokenizer;

/**
 * 접근 방식
 * 현재 인덱스(i) 기준: 구매 +3, 다음 인덱스 추가 구매 +2
 */
public class BOJ_18185 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine().trim());
        int[] ramen = new int[N + 2];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            ramen[i] = Integer.parseInt(st.nextToken());
        }

        int cost = 0;
        int idx = 0;
        while (idx < N) {
            if (ramen[idx] > 0) {
                // 1. i라면 공장의 모든 라면 구매 * 3
                cost += ramen[idx] * 3;
                // 2. i 공장의 라면 개수 이하만큼 i+1 공장의 라면 구매
                int min = Math.min(ramen[idx], ramen[idx + 1]);
                cost += min * 2;
                ramen[idx + 1] -= min;
                // 3. i+1 공장에 남은 라면 개수만을 남기고 i+2 공장에서 라면 구매
                min = Math.min(min, ramen[idx + 2] - Math.min(ramen[idx + 1], ramen[idx + 2]));
                cost += min * 2;
                ramen[idx + 2] -= min;
            }
            idx++;
        }

        bw.write(cost + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}