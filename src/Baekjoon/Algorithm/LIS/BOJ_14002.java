/**
 * 문제 : 가장 긴 증가하는 부분 수열 4
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.LIS;

import java.io.*;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * LIS 알고리즘 (Longest Increasing Subsequence)
 * 기본적으로 DP를 이용한다.
 * 이 문제는 O(N²) 풀이법을 이용했다.
 */
public class BOJ_14002 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine().trim());
        st = new StringTokenizer(br.readLine());

        int[] numArr = new int[N];
        for (int i = 0; i < N; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        // 길이 구하기
        int maxLen = 0, idx = 0;
        int[] dp = new int[N];
        for (int i = 0; i < N; i++) {
            int maxDP = 0;
            for (int j = 0; j < i; j++) {
                if (numArr[j] < numArr[i]) {
                    if (maxDP < dp[j]) maxDP = dp[j];
                }
            }
            dp[i] = maxDP + 1;
            if (maxLen < dp[i]) {
                maxLen = dp[i];
                idx = i;
            }
        }

        // 수열 구하기
        Stack<Integer> s = new Stack<>();
        s.push(numArr[idx]);
        int cur = idx;
        for (int i = idx - 1; i >= 0; i--) {
            if (dp[i] == dp[cur] - 1) {
                s.push(numArr[i]);
                cur = i;
            }
        }

        bw.write(maxLen + "\n");
        while (!s.isEmpty()) {
            bw.write(s.pop() + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}