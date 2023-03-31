/**
 * 문제 : 가장 큰 증가하는 부분 수열
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.DynamicProgramming;

import java.io.*;
import java.util.StringTokenizer;

/**
 * LIS 알고리즘 (Longest Increasing Subsequence)
 * 기본적으로 DP를 이용한다.
 * 이 문제는 O(N²) 풀이법을 이용했다.
 */
public class BOJ_11055 {

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

        int[] d = new int[N];
        int max = 0;

        for (int i = 0; i < N; i++) {
            int maxDP = 0;
            for (int j = 0; j < i; j++) {
                if (numArr[j] < numArr[i]) {
                    if (maxDP < d[j]) maxDP = d[j];
                }
            }
            d[i] = maxDP + numArr[i];
            if (max < d[i]) max = d[i];
        }

        bw.write(max + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}