/**
 * 문제 : 최대 힙
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_3;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_11279 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });

        int N = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < N; i++) {
            int x = Integer.parseInt(br.readLine().trim());
            // 가장 큰 값 출력 후 제거
            if (x == 0) {
                if (pq.isEmpty()) bw.write(0 + "\n");
                else bw.write(pq.poll() + "\n");
            }
            // x 값 추가
            else {
                pq.offer(x);
            }
        }

        bw.flush();
        bw.close();
        br.close();
    }
}