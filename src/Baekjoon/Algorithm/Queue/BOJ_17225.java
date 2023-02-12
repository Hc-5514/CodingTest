/**
 * 문제 : 세훈이의 선물가게
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.Queue;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class BOJ_17225 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        // A: 상민이가 선물을 포장하는 데 걸리는 시간
        // B: 지수가 선물을 포장하는 데 걸리는 시간
        // N: 손님의 가게 수
        st = new StringTokenizer(br.readLine());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());

        // q1: 상민이가 선물 포장을 시작할 시간 목록
        // q2: 지수가 선물 포장을 시작할 시간 목록
        Queue<Integer> q1 = new LinkedList<>();
        Queue<Integer> q2 = new LinkedList<>();

        // N명의 손님이 주문한 선물 정보
        // totalCnt1: 상민이가 포장한 선물 개수
        // totalCnt2: 지수가 포장한 선물 개수
        // lastValue1,2: 각 큐의 마지막 값
        int totalCnt1 = 0, totalCnt2 = 0;
        int lastValue1 = 0, lastValue2 = 0;
        for (int i = 0; i < N; i++) {
            // 주문 시각, 포장지 색깔, 선물 개수
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            char color = st.nextToken().charAt(0);
            int orderCnt = Integer.parseInt(st.nextToken());

            // B: 상민이가 선물 포장, R: 지수가 선물 포장
            if (color == 'B') {
                for (int j = 0; j < orderCnt; j++) {
                    if (q1.isEmpty()) {
                        // 첫 선물 포장일 경우
                        q1.add(t);
                        lastValue1 = t;
                    } else {
                        // 이미 포장중인 선물이 있을 경우, 해당 작업이 끝나야 시작 가능
                        if (lastValue1 + A >= t + j * A) {
                            lastValue1 += A;
                            q1.add(lastValue1);
                        } else {
                            lastValue1 = t + j * A;
                            q1.add(lastValue1);
                        }
                    }
                    totalCnt1++;
                }
            } else {
                for (int j = 0; j < orderCnt; j++) {
                    if (q2.isEmpty()) {
                        // 첫 선물 포장일 경우
                        q2.add(t);
                        lastValue2 = t;
                    } else {
                        // 이미 포장중인 선물이 있을 경우, 해당 작업이 끝나야 시작 가능
                        if (lastValue2 + B >= t + j * B) {
                            lastValue2 += B;
                            q2.add(lastValue2);
                        } else {
                            lastValue2 = t + j * B;
                            q2.add(lastValue2);
                        }
                    }
                    totalCnt2++;
                }
            }
        }

        // 상민, 지수가 포장한 선물 번호를 저장할 배열
        int[] arrInfo1 = new int[totalCnt1];
        int[] arrInfo2 = new int[totalCnt2];

        // giftCnt: 선물 번호, idx: 각 배열의 선물 번호를 저장할 인덱스
        int giftCnt = 1, idx1 = 0, idx2 = 0;
        // 선물 번호 확인하기
        while (!q1.isEmpty() || !q2.isEmpty()) {
            if (!q1.isEmpty() && !q2.isEmpty()) {
                // 주문 시각이 같을 땐 '상민이' 우선 순위
                if (q1.peek() <= q2.peek()) {
                    arrInfo1[idx1++] = giftCnt++;
                    q1.poll();
                } else {
                    arrInfo2[idx2++] = giftCnt++;
                    q2.poll();
                }
            } else if (q1.isEmpty()) {
                arrInfo2[idx2++] = giftCnt++;
                q2.poll();
            } else {
                arrInfo1[idx1++] = giftCnt++;
                q1.poll();
            }

        }

        // 출력
        sb.append(totalCnt1).append("\n");
        for (int n : arrInfo1) {
            sb.append(n).append(" ");
        }
        sb.append("\n").append(totalCnt2).append("\n");
        for (int n : arrInfo2) {
            sb.append(n).append(" ");
        }
        sb.append("\n");
        System.out.println(sb);
        br.close();
    }
}
