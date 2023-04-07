/**
 * 문제 : 컵라면
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.Greedy;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_1781 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        PriorityQueue<int[]> pq = new PriorityQueue<>(new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                // 1. 데드라인  [0]: 오름차순
                // 2. 컵라면 수 [1]: 내림차순
                if (o1[0] == o2[0])
                    return o2[1] - o1[1];
                else return o1[0] - o2[0];
            }
        });

        int N = Integer.parseInt(br.readLine().trim());
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            int deadline = Integer.parseInt(st.nextToken());
            int cnt = Integer.parseInt(st.nextToken());
            pq.offer(new int[]{deadline, cnt});
        }

        int time = 0;
//        long[] maxCnt = new long[N + 1];
        PriorityQueue<Integer> pq2 = new PriorityQueue<>();
        while (!pq.isEmpty()) {
            time++;
//            maxCnt[time] = pq.poll()[1];
            pq2.offer(pq.poll()[1]);
            w1:
            while (!pq.isEmpty() && pq.peek()[0] <= time) {
                if (pq2.peek() < pq.peek()[1]) {
                    pq2.poll();
                    pq2.offer(pq.poll()[1]);
                } else pq.poll();
            }
        }

        int totalCnt = 0;
        while (!pq2.isEmpty()) {
            totalCnt += pq2.poll();
        }

        bw.write(totalCnt + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}