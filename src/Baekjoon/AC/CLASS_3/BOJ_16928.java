/**
 * 문제 : 뱀과 사다리 게임
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_3;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;
import java.util.StringTokenizer;

public class BOJ_16928 {

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());

        int[] board = new int[101]; // 1번 ~ 100번 게임판

        // 사다리, 뱀 정보 저장
        for (int i = 0; i < N + M; i++) {
            st = new StringTokenizer(br.readLine());
            int from = Integer.parseInt(st.nextToken());
            int to = Integer.parseInt(st.nextToken());
            board[from] = to;
        }

        PriorityQueue<Info> pq = new PriorityQueue<>(new Comparator<Info>() {
            @Override
            public int compare(Info o1, Info o2) {
                if (o1.idx == o2.idx) {
                    return o1.cnt - o2.cnt;
                }
                return o2.idx - o1.idx;
            }
        });
        pq.offer(new Info(1, 0));

        int[] visit = new int[101]; // 방문 지점까지의 최소 이동 횟수 저장
        Arrays.fill(visit, 100);
        int minCnt = 100;

        while (!pq.isEmpty()) {
            Info cur = pq.poll();

            if (cur.idx == 100) {
                minCnt = Math.min(cur.cnt, minCnt);
            }

            if(cur.cnt >= minCnt) continue;

            // 1칸 ~ 6칸 이동
            boolean isMove = false;

            for (int i = 6; i >= 0; i--) {
                int nextIdx = cur.idx + i;

                if (nextIdx > 100) continue;
                // 방문한 곳이라면 이동 횟수 비교
                if (visit[nextIdx] <= cur.cnt + 1) continue;

                // 사다리, 뱀 확인
                if (board[nextIdx] == 0) {
                    if (isMove) continue;
                    pq.offer(new Info(nextIdx, cur.cnt + 1));
                    visit[nextIdx] = cur.cnt + 1;
                    isMove = true;
                } else {
                    pq.offer(new Info(board[nextIdx], cur.cnt + 1));
                    visit[board[nextIdx]] = cur.cnt + 1;
                }
            }
        }

        bw.write(minCnt + "\n");
        bw.flush();
        bw.close();
        br.close();
    }

    static class Info {
        int idx;
        int cnt;

        public Info(int idx, int cnt) {
            this.idx = idx;
            this.cnt = cnt;
        }
    }
}