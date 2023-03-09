/**
 * 문제 : 숨바꼭질 2
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_4;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_12851 {

    static class Point {
        int time;
        int cnt;

        public Point(int time, int cnt) {
            this.time = time;
            this.cnt = cnt;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());
        Point[] visit = new Point[100001];
        Arrays.fill(visit, new Point(Integer.MAX_VALUE, 0));

        int time = 0;
        Queue<Integer> q = new ArrayDeque<>();
        q.offer(N);
        visit[N] = new Point(time, 1);
        while (!q.isEmpty()) {
            time++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                int cur = q.poll();
                if (cur == K) continue;
                int x;
                if (cur < K) {
                    x = cur * 2;
                    if (x <= 100000) {
                        if (visit[x].time == time) {
                            visit[x].cnt++;
                            q.offer(x);
                        } else if (visit[x].time > time) {
                            visit[x] = new Point(time, 1);
                            q.offer(x);
                        }
                    }
                    x = cur + 1;
                    if (x <= 100000) {
                        if (visit[x].time == time) {
                            visit[x].cnt++;
                            q.offer(x);
                        } else if (visit[x].time > time) {
                            visit[x] = new Point(time, 1);
                            q.offer(x);
                        }
                    }
                }
                x = cur - 1;
                if (x >= 0) {
                    if (visit[x].time == time) {
                        visit[x].cnt++;
                        q.offer(x);
                    } else if (visit[x].time > time) {
                        visit[x] = new Point(time, 1);
                        q.offer(x);
                    }
                }
            }
        }

        StringBuilder sb = new StringBuilder();
        sb.append(visit[K].time).append("\n").append(visit[K].cnt).append("\n");
        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}
