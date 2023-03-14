/**
 * 문제 : 최솟값 찾기
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.SlidingWindow;

import java.io.*;
import java.util.ArrayDeque;
import java.util.StringTokenizer;

public class BOJ_11003 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int L = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        ArrayDeque<int[]> dq = new ArrayDeque<>(); // [0]: value, [1]: idx
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(st.nextToken());
            while (!dq.isEmpty() && dq.peekLast()[0] > n) {
                dq.pollLast();
            }
            dq.offerLast(new int[]{n, i});
            if (dq.peekFirst()[1] == (i - L)) dq.pollFirst();
            bw.write(dq.peekFirst()[0] + " ");
        }
        bw.flush();
        bw.close();
        br.close();
    }
}