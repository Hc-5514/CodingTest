package Programmers.High_Score_Kit.BFSDFS;

import java.util.ArrayDeque;
import java.util.Queue;

public class 네트워크 {

    public int solution(int n, int[][] computers) {
        int answer = 0;
        boolean[] visit = new boolean[n];

        Queue<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < n; i++) {
            if (!visit[i]) {
                answer++;
                visit[i] = true;
                q.offer(i);
                while (!q.isEmpty()) {
                    int tmp = q.poll();
                    for (int j = 0; j < computers[tmp].length; j++) {
                        if (computers[tmp][j] == 0) continue;
                        if (visit[j]) continue;
                        visit[j] = true;
                        q.offer(j);
                    }
                }
            }
        }

        return answer;
    }

}
