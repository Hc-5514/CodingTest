package Programmers.Exercise;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;

public class 할인_행사 {

    Map<String, Integer> map = new HashMap<>();
    Queue<String> q = new ArrayDeque<>();

    private void reset(String[] want) {
        map.clear();
        q.clear();
        for (int i = 0; i < want.length; i++) {
            map.put(want[i], 0);
        }
    }

    private boolean check(String[] want, int[] number) {
        for (int i = 0; i < want.length; i++) {
            if (map.get(want[i]) != number[i]) return false;
        }
        return true;
    }

    public int solution(String[] want, int[] number, String[] discount) {
        int answer = 0;
        reset(want);
        for (int i = 0; i < discount.length; i++) {
            String fruit = discount[i];
            if (map.containsKey(fruit)) {
                map.put(fruit, map.get(fruit) + 1);
                q.offer(fruit);
                if (q.size() == 10) {
                    if (check(want, number)) {
                        answer++;
                    }
                    String tmp = q.poll();
                    map.put(tmp, map.get(tmp) - 1);
                }
            } else {
                reset(want);
            }
        }
        return answer;
    }
}
