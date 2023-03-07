/**
 * 문제 : 음악프로그램
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_5;

import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_2623 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] edgeCnt = new int[N + 1];
        ArrayList<ArrayList<Integer>> graph = new ArrayList<>();
        for (int i = 0; i <= N; i++) {
            graph.add(new ArrayList<>());
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            int n = Integer.parseInt(st.nextToken());
            int n1 = Integer.parseInt(st.nextToken());
            for (int j = 0; j < n - 1; j++) {
                int n2 = Integer.parseInt(st.nextToken());
                graph.get(n1).add(n2);
                edgeCnt[n2]++;
                n1 = n2;
            }
        }

        Queue<Integer> q = new ArrayDeque<>();

        for (int i = 1; i <= N; i++) {
            if (edgeCnt[i] == 0) q.offer(i);
        }

        while (!q.isEmpty()) {
            int n = q.poll();
            sb.append(n).append("\n");
            ArrayList<Integer> list = new ArrayList<>(graph.get(n));
            for (int i = 0; i < list.size(); i++) {
                edgeCnt[list.get(i)]--;
                if (edgeCnt[list.get(i)] == 0) q.offer(list.get(i));
            }
        }

        for (int i = 1; i <= N; i++) {
            if (edgeCnt[i] != 0) {
                sb.setLength(0);
                sb.append(0).append("\n");
            }
        }

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
