/**
 * 문제 : 택배
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.Greedy;

import java.io.*;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_8980 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(br.readLine().trim());

        PriorityQueue<Box> pq = new PriorityQueue<>(new Comparator<Box>() {
            @Override
            public int compare(Box o1, Box o2) {
                if (o1.sub == o2.sub) {
                    return o1.from - o2.from;
                } else return o1.sub - o2.sub;
            }
        });

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            int weight = Integer.parseInt(st.nextToken());
            pq.offer(new Box(from, to, weight));
        }

        int totalBox = 0;
        int[] truck = new int[N];
        w1:
        while (!pq.isEmpty()) {
            Box box = pq.poll();
            if (box.sub == 1) {
                if (box.weight <= C)
                    truck[box.from] = box.weight;
                else truck[box.from] = C;
                totalBox += truck[box.from];
            } else {
                int weight = box.weight;
                for (int i = box.from; i < box.to; i++) {
                    weight = Math.min(weight, C - truck[i]);
                    if (weight == 0) continue w1;
                }
                if (box.weight <= weight)
                    weight = box.weight;
                for (int i = box.from; i < box.to; i++) {
                    truck[i] += weight;
                }
                totalBox += weight;
            }
        }


        bw.write(totalBox + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static class Box {
        int from;
        int to;
        int weight;
        int sub;

        public Box(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
            this.sub = to - from;
        }
    }
}