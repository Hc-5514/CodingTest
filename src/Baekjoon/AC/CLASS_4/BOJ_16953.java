/**
 * 문제 : A → B
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_4;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_16953 {

    static long startNum, goalNum;

    private static int bfs() {
        int cnt = 0;
        Queue<Long> q = new LinkedList<>();
        q.offer(startNum);
        while (!q.isEmpty()) {
            cnt++;
            int size = q.size();
            for (int i = 0; i < size; i++) {
                long n = q.poll();
                if (n > goalNum) continue;
                else if (n == goalNum) return cnt;
                q.offer(n * 2);
                q.offer(n * 10 + 1);
            }
        }
        return -1;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        startNum = Long.parseLong(st.nextToken());
        goalNum = Long.parseLong(st.nextToken());

        System.out.println(bfs());

        br.close();
    }
}
