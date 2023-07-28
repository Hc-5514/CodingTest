/**
 * 문제 : 프로세스
 *
 * @author Hc-5514
 */

package Programmers.High_Score_Kit.Stack_Queue;

import java.util.*;

public class 프로세스 {

    public int solution(int[] priorities, int location) {
        Queue<int[]> q = new ArrayDeque<>();
        List<Integer> list = new ArrayList<>();
        int answer = 1;

        for (int i = 0; i < priorities.length; i++) {
            q.offer(new int[]{priorities[i], i});
            list.add(priorities[i]);
        }

        Collections.sort(list, Collections.reverseOrder());

        while (!q.isEmpty()) {
            int[] cur = q.poll();
            if (cur[0] == list.get(0)) {
                if (cur[1] == location) {
                    break;
                } else {
                    answer++;
                    list.remove(0);
                }
            }
            q.offer(cur);
        }
        return answer;
    }
}
