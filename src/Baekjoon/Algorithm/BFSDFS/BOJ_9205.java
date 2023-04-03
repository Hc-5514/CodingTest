/**
 * 문제 : 맥주 마시면서 걸어가기
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.BFSDFS;

import java.io.*;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_9205 {

    static ArrayList<int[]> coordsList = new ArrayList<>();

    private static boolean bfs(int N) {
        boolean[] visit = new boolean[N + 2];
        Queue<int[]> q = new ArrayDeque<>();
        q.offer(coordsList.get(0));
        visit[0] = true;
        while (!q.isEmpty()) {
            int[] tmp = q.poll();
            if (tmp[0] == coordsList.get(coordsList.size() - 1)[0] && tmp[1] == coordsList.get(coordsList.size() - 1)[1])
                return true;
            for (int i = 0; i < coordsList.size(); i++) {
                if (visit[i]) continue;
                int dist = Math.abs(tmp[0] - coordsList.get(i)[0]) + Math.abs(tmp[1] - coordsList.get(i)[1]);
                if (dist <= 1000) {
                    q.offer(coordsList.get(i));
                    visit[i] = true;
                }
            }
        }
        return false;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine().trim());
        for (int tc = 1; tc <= T; tc++) {
            coordsList.clear();

            int N = Integer.parseInt(br.readLine().trim());
            // 출발 좌표
            st = new StringTokenizer(br.readLine());
            coordsList.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
            // 편의점 좌표
            for (int i = 0; i < N; i++) {
                st = new StringTokenizer(br.readLine());
                coordsList.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});
            }
            // 도착 좌표
            st = new StringTokenizer(br.readLine());
            coordsList.add(new int[]{Integer.parseInt(st.nextToken()), Integer.parseInt(st.nextToken())});

            if (bfs(N))
                bw.write("happy\n");
            else bw.write("sad\n");
        }

        bw.flush();
        bw.close();
        br.close();
    }
}