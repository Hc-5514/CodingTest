/**
 * 문제 : 가장 긴 바이토닉 부분 수열
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_4;

import java.io.*;
import java.util.StringTokenizer;

/**
 * LIS 알고리즘 (Longest Increasing Subsequence)
 * 기본적으로 DP를 이용한다.
 * 이 문제는 O(N²) 풀이법을 이용했다.
 */
public class BOJ_11054 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine().trim());
        int[] numArr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        // 증가 수열
        int[] d1 = new int[N];
        for (int i = 0; i < N; i++) {
            int maxDP = 0;
            for (int j = 0; j < i; j++) {
                if (numArr[j] < numArr[i]) {
                    if (maxDP < d1[j]) maxDP = d1[j];
                }
            }
            d1[i] = maxDP + 1;
        }

        // 감소 수열
        int[] d2 = new int[N];
        for (int i = N - 1; i >= 0; i--) {
            int minDP = 0;
            for (int j = N - 1; j >= i; j--) {
                if (numArr[j] < numArr[i]) {
                    if (minDP < d2[j]) {
                        minDP = d2[j];
                    }
                }
            }
            d2[i] = minDP + 1;
        }

        int[] d = new int[N];
        int maxLen = 0;

        for (int i = 0; i < N; i++) {
            d[i] = d1[i] + d2[i] - 1;
            maxLen = Math.max(maxLen, d[i]);
        }

        bw.write(maxLen + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}