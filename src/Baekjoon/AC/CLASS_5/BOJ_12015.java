/**
 * 문제 : 가장 긴 증가하는 부분 수열 2
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_5;

import java.io.*;
import java.util.ArrayList;
import java.util.StringTokenizer;

/**
 * LIS 알고리즘 (Longest Increasing Subsequence)
 * 이 문제는 O(N*logN) 풀이법을 이용했다.
 */
public class BOJ_12015 {

    static int N;
    static int[] numArr;
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

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        list.add(numArr[0]);
        for (int i = 1; i < N; i++) {
            // list 마지막 값보다 크다면 삽입
            if (list.get(list.size() - 1) < numArr[i]) {
                list.add(numArr[i]);
            } else {
                // lower_bound 를 이용하여 이분탐색 진행
                int idx = lowerBound(numArr[i]);
                // 해당 인덱스 자리에 값 교체
                list.set(idx, numArr[i]);
            }
        }

        bw.write(list.size() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}