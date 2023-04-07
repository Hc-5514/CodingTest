/**
 * 문제 : 택배
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.Greedy;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
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

        Box[] delivery = new Box[M];

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken()) - 1;
            int to = Integer.parseInt(st.nextToken()) - 1;
            int weight = Integer.parseInt(st.nextToken());
            delivery[i] = new Box(from, to, weight);
        }

        Arrays.sort(delivery, new Comparator<Box>() {
            @Override
            public int compare(Box o1, Box o2) {
                if (o1.to == o2.to) {
                    return o2.from - o1.from;
                } else return o1.to - o2.to;
            }
        });

        int totalBox = 0;
        int[] truck = new int[N];
        f1:
        for (int i = 0; i < M; i++) {
            Box box = delivery[i];
            int weight = box.weight;
            for (int j = box.from; j < box.to; j++) {
                weight = Math.min(weight, C - truck[j]);
                if (weight == 0) continue f1;
            }
            for (int j = box.from; j < box.to; j++) {
                truck[j] += weight;
            }
            totalBox += weight;
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

        public Box(int from, int to, int weight) {
            this.from = from;
            this.to = to;
            this.weight = weight;
        }
    }
}