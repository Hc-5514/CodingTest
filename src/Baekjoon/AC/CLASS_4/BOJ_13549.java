/**
 * 문제 : 숨바꼭질 3
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_4;

import java.io.*;
import java.util.ArrayDeque;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_13549 {

    static class Node implements Comparable<Node> {
        int val;
        int time;

        public Node(int val, int time) {
            this.val = val;
            this.time = time;
        }

        @Override
        public int compareTo(Node o) {
            return this.time - o.time;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        boolean[] visit = new boolean[100001];
        int time = 0;

        Queue<Node> q = new ArrayDeque<>();
        q.offer(new Node(N, time));
        while (!q.isEmpty()) {
            Node curNode = q.poll();
            visit[curNode.val] = true;
            if (curNode.val == K) {
                time = curNode.time;
                break;
            }
            // 순간이동
            if (curNode.val * 2 <= 100000 && !visit[curNode.val * 2]) {
                q.offer(new Node(curNode.val * 2, curNode.time));
            }
            // 왼쪽 이동
            if (curNode.val - 1 >= 0 && !visit[curNode.val - 1]) {
                q.offer(new Node(curNode.val - 1, curNode.time + 1));
            }
            // 오른쪽 이동
            if (curNode.val + 1 <= 100000 && !visit[curNode.val + 1]) {
                q.offer(new Node(curNode.val + 1, curNode.time + 1));
            }
        }
        bw.write(time + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
