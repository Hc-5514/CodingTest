/**
 * 문제 : 가장 긴 증가하는 부분 수열 5
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_5;

import java.io.*;
import java.util.ArrayList;
import java.util.Stack;
import java.util.StringTokenizer;

/**
 * LIS 알고리즘 (Longest Increasing Subsequence)
 * 이 문제는 O(N*logN) 풀이법을 이용했다.
 */
public class BOJ_14003 {

    static int N, dpLastIdx = 0, maxIdx = 0;
    static int[] numArr, dp;
    static ArrayList<Integer> list = new ArrayList<>();

    private static int lowerBound(int target) {
        int s = 0, e = list.size() - 1;
        while (s < e) {
            int m = (s + e) >> 1;
            if (list.get(m) >= target) {
                e = m;
            } else {
                s = m + 1;
            }
        }
        return e;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        N = Integer.parseInt(br.readLine().trim());
        numArr = new int[N];
        dp = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        list.add(numArr[0]);
        dp[0] = dpLastIdx++;
        for (int i = 1; i < N; i++) {
            // list 마지막 값보다 크다면 삽입
            if (list.get(list.size() - 1) < numArr[i]) {
                list.add(numArr[i]);
                dp[dpLastIdx] = dp[maxIdx] + 1;
                maxIdx = dpLastIdx++;
            } else {
                // lower_bound 를 이용하여 이분탐색 진행
                int idx = lowerBound(numArr[i]);
                // 해당 인덱스 자리에 값 교체
                list.set(idx, numArr[i]);
                dp[dpLastIdx++] = idx;
            }
        }

        int size = dp[maxIdx];
        bw.write((size + 1) + "\n");
        Stack<Integer> s = new Stack<>();
        for (int i = N - 1; i >= 0; i--) {
            if (dp[i] == size) {
                s.push(numArr[i]);
                size--;
            }
        }

        while (!s.isEmpty()) {
            bw.write(s.pop() + " ");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}