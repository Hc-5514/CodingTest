package Programmers.High_Score_Kit.Stack_Queue;

import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.List;
import java.util.Queue;

public class 기능개발 {
    public int[] solution(int[] progresses, int[] speeds) {
        // 개발 시간 계산: (100-progresses)/speeds 올림
        int[] time = new int[progresses.length];
        for (int i = 0; i < time.length; i++) {
            time[i] = (int) Math.ceil((100 - progresses[i]) * 1.0 / speeds[i]);
        }

        List<Integer> list = new ArrayList<>();
        Queue<Integer> q = new ArrayDeque<>();

        for (int i = 0; i < time.length; i++) {
            q.offer(time[i]);
            for (int j = 1; j < time.length - i; j++) {
                // 현재 개발보다 일찍 끝나거나 동시에 끝난다면 큐 추가
                if (q.peek() >= time[i + j]) {
                    q.offer(time[i + j]);
                } else {
                    break;
                }
            }
            i += q.size() - 1;
            list.add(q.size());
            q.clear();
        }

        int[] answer = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            answer[i] = list.get(i);
        }
        return answer;
    }
}
