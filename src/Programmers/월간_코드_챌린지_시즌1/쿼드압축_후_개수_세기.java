/**
 * 문제 : 쿼드압축 후 개수 세기
 *
 * @author Hc-5514
 */

package Programmers.월간_코드_챌린지_시즌1;

import java.util.ArrayDeque;
import java.util.Queue;

public class 쿼드압축_후_개수_세기 {
    class Solution {
        public int[] solution(int[][] arr) {
            // 압축 후 0개수, 1개수 리턴
            int cnt0 = 0;
            int cnt1 = 0;
            Queue<Rect> q = new ArrayDeque<>();
            q.offer(new Rect(0, 0, arr[0].length));
            w1:
            while (!q.isEmpty()) {
                Rect cur = q.poll();
                int r = cur.r;
                int c = cur.c;
                int size = cur.size;
                // 영역 탐색
                int num = arr[cur.r][cur.c];
                for (int i = 0; i < size; i++) {
                    for (int j = 0; j < size; j++) {
                        // num 과 다른 숫자가 나온다면 분할 후 다시 탐색
                        if (arr[r + i][c + j] != num) {
                            size /= 2;
                            q.offer(new Rect(r, c, size));
                            q.offer(new Rect(r + size, c, size));
                            q.offer(new Rect(r, c + size, size));
                            q.offer(new Rect(r + size, c + size, size));
                            continue w1;
                        }
                    }
                }
                // 영역 내 모든 수가 num이라면 압축 후 개수 세리기
                if (num == 0) {
                    cnt0++;
                } else {
                    cnt1++;
                }
            }
            int[] answer = new int[]{cnt0, cnt1};
            return answer;
        }
    }

    class Rect {
        int r;
        int c;
        int size;

        public Rect(int r, int c, int size) {
            this.r = r;
            this.c = c;
            this.size = size;
        }
    }
}
