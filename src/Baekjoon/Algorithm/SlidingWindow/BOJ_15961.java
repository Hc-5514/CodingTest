/**
 * 문제 : 회전 초밥
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.SlidingWindow;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_15961 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken()); // 초밥 접시 수
        int d = Integer.parseInt(st.nextToken()); // 초밥 종류
        int k = Integer.parseInt(st.nextToken()); // 연속해서 먹는 접시
        int c = Integer.parseInt(st.nextToken()) - 1; // 쿠폰 번호

        int[] dish = new int[N];
        int[] kind = new int[d];

        kind[c]++;
        int size = 1, maxSize = 0;

        for (int i = 0; i < N; i++) {
            dish[i] = Integer.parseInt(br.readLine()) - 1;
            if (i < k) {
                if (kind[dish[i]] == 0) size++;
                kind[dish[i]]++;
            }
        }

        maxSize = Math.max(maxSize, size);

        for (int i = 0; i < N; i++) {
            // 첫 접시 제거
            kind[dish[i]]--;
            if (kind[dish[i]] == 0) size--;
            // 마지막 접시 추가
            if (i < N - k) {
                if (kind[dish[i + k]] == 0) size++;
                kind[dish[i + k]]++;
            } else {
                if (kind[dish[i + k - N]] == 0) size++;
                kind[dish[i + k - N]]++;
            }

            maxSize = Math.max(maxSize, size);
        }

        bw.write(maxSize + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}