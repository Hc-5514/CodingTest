/**
 * 문제 : 이모티콘 할인행사
 *
 * @author Hc-5514
 */

package Programmers._2023_KAKAO_BLIND_RECRUITMENT;

import java.util.Arrays;

public class 이모티콘_할인행사 {

    static int maxCnt = 0, maxCost = 0;

    static int[] discount;

    private static void func(int depth, int goal, int[][] users, int[] emoticons) {
        if (depth == goal) {
            // 가입자 수, 판매액 계산
            int cnt = 0, cost = 0;
            for (int i = 0; i < users.length; i++) {
                int tmp = 0;
                for (int j = 0; j < discount.length; j++) {
                    // 희망 할인율 <= 이모티콘 할인율 : 구매
                    if (users[i][0] <= discount[j]) {
                        tmp += emoticons[j] * (100 - discount[j]) / 100;
                    }
                }
                // 사용자 생각 비용 <= 이모티콘 구매 비용 : 구독 플러스 가입
                if (users[i][1] <= tmp) {
                    cnt++;
                } else {
                    cost += tmp;
                }
            }
            if (maxCnt == cnt) {
                maxCost = Math.max(maxCost, cost);
            } else if (maxCnt < cnt) {
                maxCnt = cnt;
                maxCost = cost;
            }
            return;
        }

        for (int i = 1; i <= 4; i++) {
            discount[depth] = i * 10;
            func(depth + 1, goal, users, emoticons);
        }
    }

    public static int[] solution(int[][] users, int[] emoticons) {
        int[] answer = new int[2];

        discount = new int[emoticons.length];

        func(0, emoticons.length, users, emoticons);

        answer[0] = maxCnt;
        answer[1] = maxCost;

        return answer;
    }

    public static void main(String[] args) {
        int[] result1 = solution(new int[][]{{40, 10000}, {25, 10000}}, new int[]{7000, 9000});
        int[] result2 = solution(new int[][]{{40, 2900}, {23, 10000}, {11, 5200}, {5, 5900}, {40, 3100}, {27, 9200}, {32, 6900}}, new int[]{1300, 1500, 1600, 4900});
        System.out.println(Arrays.toString(result1));
        System.out.println(Arrays.toString(result2));
    }
}