/**
 * 문제 : N개의 최소공배수
 *
 * @author Hc-5514
 */

package Programmers.Exercise;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class N개의_최소공배수 {

    public int solution(int[] arr) {
        // arr의 크기: 1 ~ 15
        // arr[i]의 범위: 1 ~ 100

        Set<Integer> number = new HashSet<>(); // arr 중복 제거
        Map<Integer, Integer> factorization = new HashMap<>(); // 소인수분해

        // arr 중복 제거
        for (Integer n : arr) {
            number.add(n);
        }

        // 소인수분해
        for (Integer n : number) {
            int tmp = n;
            for (int i = 2; i <= n; i++) {
                int cnt = 0;
                while (tmp % i == 0) {
                    tmp /= i;
                    cnt++;
                }
                // 소인수분해 누적 값 비교
                if (factorization.containsKey(i)) {
                    if (factorization.get(i) < cnt) {
                        factorization.put(i, cnt);
                    }
                } else {
                    factorization.put(i, cnt);
                }
            }

        }

        int answer = 1;
        for (Integer n : factorization.keySet()) {
            answer *= Math.pow(n, factorization.get(n));
        }

        return answer;
    }
}
