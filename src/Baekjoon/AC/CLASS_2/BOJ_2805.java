/**
 * 문제 : 나무 자르기
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_2;

import java.io.*;
import java.util.StringTokenizer;

public class BOJ_2805 {

    static int N, M, max = 0;
    static int[] tree;

    private static int search() {
        int s = 0;
        int e = max;
        int result = 0;
        while (s <= e) {
            int m = (s + e) >> 1;
            long sum = 0;
            for (int i = 0; i < N; i++) {
                if (tree[i] > m) {
                    sum += tree[i] - m;
                    if (sum >= M) break;
                }
            }
            if (sum >= M) {
                result = m;
                s = m + 1;
            } else {
                e = m - 1;
            }
        }
        return result;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());

        tree = new int[N];

        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            tree[i] = Integer.parseInt(st.nextToken());
            max = Math.max(max, tree[i]);
        }

        bw.write(search() + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}