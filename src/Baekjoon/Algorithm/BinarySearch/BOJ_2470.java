/**
 * 문제 : 두 용액
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.BinarySearch;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2470 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // N개의 수 입력 받기 (2 <= N <= 10만)
        int N = Integer.parseInt(br.readLine());
        int[] numArr = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        // 정렬
        Arrays.sort(numArr);

        // -99 -2 -1 4 98

        int ans1 = 0;
        int ans2 = N - 1;
        int minSum = numArr[ans1] + numArr[ans2];

        int s = 0;
        int e = N - 1;

        while (s < e) {
            int sum = numArr[s] + numArr[e];

            if (Math.abs(sum) < Math.abs(minSum)) {
                ans1 = s;
                ans2 = e;
                minSum = sum;
            }

            if (sum < 0) {
                s++;
            } else {
                e--;
            }
        }

        bw.write(numArr[ans1] + " " + numArr[ans2] + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
