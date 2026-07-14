package Programmers.Exercise;

import java.util.*;

public class 롤케이크_자르기 {
    public int solution(int[] topping) {
        Map<Integer, Integer> mapA = new HashMap<>();
        Map<Integer, Integer> mapB = new HashMap<>();
        int answer = 0;

        // init: 동생이 모든 토핑 획득
        for (int i=0; i<topping.length; i++) {
            mapB.put(topping[i], mapB.getOrDefault(topping[i],0)+1);
        }

        // 형이 토핑을 하나씩 가져감
        for (int i=0; i<topping.length; i++) {
            mapA.put(topping[i], mapA.getOrDefault(topping[i],0)+1);
            mapB.put(topping[i], mapB.get(topping[i])-1);
            if(mapB.get(topping[i]) == 0) {
                mapB.remove(topping[i]);
            }
            if(mapA.keySet().size() == mapB.keySet().size()) {
                answer++;
            }
        }
        return answer;
    }
}
