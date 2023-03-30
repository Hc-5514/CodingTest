/**
 * 문제 : 평범한 배낭
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_4;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_12865 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 물건 개수
        int K = Integer.parseInt(st.nextToken()); // 가방 목표 무게

        int[] weights = new int[N + 1];
        int[] profits = new int[N + 1];

        for (int i = 1; i <= N; i++) {
            st = new StringTokenizer(br.readLine());
            weights[i] = Integer.parseInt(st.nextToken());
            profits[i] = Integer.parseInt(st.nextToken());
        }

        int[][] d = new int[N + 1][K + 1];

        // 초기값 세팅: int[][] 배열의 자동 초기화를 이용
        for (int i = 1; i <= N; i++) { // i: 물건
            for (int k = 1; k <= K; k++) { // k: 가방의 무게
                // 해당 물건의 무게가 k를 초과하는지 확인
                if (weights[i] > k) {
                    d[i][k] = d[i - 1][k];
                } else {
                    d[i][k] = Math.max(d[i - 1][k], profits[i] + d[i - 1][k - weights[i]]);
                }
            }
        }

        bw.write(d[N][K] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}