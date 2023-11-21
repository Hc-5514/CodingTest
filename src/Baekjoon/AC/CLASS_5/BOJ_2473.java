/**
 * 문제 : 세 용액
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_5;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_2473 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine().trim()); // 3 <= N <= 5,000
        int[] numArr = new int[N]; // -1,000,000,000 <= N값 <= 1,000,000,000

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            numArr[i] = Integer.parseInt(st.nextToken());
        }

        Arrays.sort(numArr);

        long ans = Long.MAX_VALUE;
        int n1 = 0, n2 = 0, n3 = 0;
        for (int i = 0; i < N - 2; i++) {
            int min = numArr[i];
            int s = i + 1;
            int e = N - 1;

            while (s < e && i < s) {
                long cur = numArr[s] + numArr[e];
                if (Math.abs(min + cur) < Math.abs(ans)) {
                    ans = min + cur;
                    n1 = numArr[i];
                    n2 = numArr[s];
                    n3 = numArr[e];
                }

                if (min + cur < 0) {
                    s++;
                } else {
                    e--;
                }
            }
        }

        bw.write(n1 + " " + n2 + " " + n3 + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
