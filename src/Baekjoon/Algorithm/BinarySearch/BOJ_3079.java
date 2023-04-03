/**
 * 문제 : 입국심사
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.BinarySearch;

import java.io.*;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_3079 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] times = new int[N];
        for (int i = 0; i < N; i++) {
            times[i] = Integer.parseInt(br.readLine().trim());
        }

        Arrays.sort(times);

        long s = 1l;
        long e = (long) times[N - 1] * M;
        while (s <= e) {
            long m = (s + e) >> 1;
            long sum = 0;
            for (int i = 0; i < N; i++) {
                sum += m / times[i];
                if (sum >= M) break;
            }
            if (sum < M) {
                s = m + 1;
            } else {
                e = m - 1;
            }
        }

        bw.write(s + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}