package Programmers._2022_KAKAO_TECH_INTERNSHIP;

import java.util.ArrayDeque;
import java.util.Queue;

public class 두_큐_합_같게_만들기 {

    public int solution(int[] queue1, int[] queue2) {
        Queue<Integer> q1 = new ArrayDeque<>();
        Queue<Integer> q2 = new ArrayDeque<>();

        long sum1 = 0, sum2 = 0;

        for (int i = 0; i < queue1.length; i++) {
            q1.offer(queue1[i]);
            sum1 += queue1[i];
        }
        for (int i = 0; i < queue2.length; i++) {
            q2.offer(queue2[i]);
            sum2 += queue2[i];
        }

        long rest = (sum1 + sum2) % 2;
        if (rest == 1) return -1;
        long goal = (sum1 + sum2) >> 1;

        int answer = 0;
        int size1 = queue1.length;
        int size2 = queue2.length;

        while (sum1 != sum2) {
            if (size1 == 0 || size2 == 0 || answer > queue1.length * 4) {
                answer = -1;
                break;
            }
            // 이동 진행
            if (sum1 > goal) {
                int num = q1.poll();
                sum1 -= num;
                sum2 += num;
                size1--;
                size2++;
                q2.offer(num);
            } else {
                int num = q2.poll();
                sum1 += num;
                sum2 -= num;
                size1++;
                size2--;
                q1.offer(num);
            }
            answer++;
        }
        return answer;
    }
}
