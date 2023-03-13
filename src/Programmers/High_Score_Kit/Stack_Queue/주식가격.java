/**
 * 문제 : 주식가격
 *
 * @author Hc-5514
 */

package Programmers.High_Score_Kit.Stack_Queue;

import java.util.Stack;

public class 주식가격 {

    public int[] solution(int[] prices) {
        int[] answer = new int[prices.length];
        Stack<Integer> s = new Stack<>();
        s.push(0);
        for (int cur = 1; cur < prices.length; cur++) {
            int prev = s.peek();
            while (prices[prev] > prices[cur]) {
                answer[prev] = cur - prev;
                s.pop();
                if (s.isEmpty()) break;
                prev = s.peek();
            }
            s.push(cur);
        }
        while (!s.isEmpty()) {
            int cur = s.pop();
            answer[cur] = prices.length - 1 - cur;
        }
        return answer;
    }
}
