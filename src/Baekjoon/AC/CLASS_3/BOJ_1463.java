/**
 * 문제 : 1로 만들기
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_3;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;

public class BOJ_1463 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

        int N = Integer.parseInt(br.readLine().trim());

        int[] d = new int[N];
        int cnt = 0;

        Queue<Integer> q = new ArrayDeque<>();
        q.offer(N);
        w1:
        while (!q.isEmpty()) {
            cnt++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int n = q.poll();
                if (n == 1) break w1;

                if (n % 3 == 0 && d[n / 3] == 0) {
                    d[n / 3] = cnt;
                    q.offer(n / 3);
                }
                if (n % 2 == 0 && d[n / 2] == 0) {
                    d[n / 2] = cnt;
                    q.offer(n / 2);
                }
                if (d[n - 1] == 0) {
                    d[n - 1] = cnt;
                    q.offer(n - 1);
                }
            }
        }

        bw.write(cnt - 1 + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}