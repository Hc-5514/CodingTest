/**
 * 문제: 겹치는 건 싫어
 * 난이도: 실버 1
 * 메모리: 45608KB, 시간: 404ms
 * 풀이: 투 포인터
 */

package Baekjoon.Algorithm.SlidingWindow;

import java.io.*;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class BOJ_20922 {

    // 같은 원소가 K개 이하로 포함된 최장 연속 부분 수열의 길이 구하기

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int n = Integer.parseInt(st.nextToken());
        int k = Integer.parseInt(st.nextToken());

        int[] nums = Stream.of(br.readLine().split(" "))
                .mapToInt(Integer::parseInt)
                .toArray();

        int[] cnt = new int[100001];
        int maxLen = 0;
        int len = 0;
        int s = 0;
        int e = 0;
        while (e < n) {
            cnt[nums[e]]++;
            len++;
            // cnt[nums[e]] > k 라면, <= 가 될 때까지 s 이동
            while (cnt[nums[e]] > k) {
                cnt[nums[s]]--;
                len--;
                s++;
            }
            maxLen = Math.max(maxLen, len);
            e++;
        }

        bw.write(maxLen + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
