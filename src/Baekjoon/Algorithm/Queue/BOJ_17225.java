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
        int totalCnt1 = 0, totalCnt2 = 0;
        for (int i = 0; i < N; i++) {
            // 주문 시각, 포장지 색깔, 선물 개수
            st = new StringTokenizer(br.readLine());
            int t = Integer.parseInt(st.nextToken());
            char color = st.nextToken().charAt(0);
            int orderCnt = Integer.parseInt(st.nextToken());

            // B: 상민이가 선물 포장, R: 지수가 선물 포장
            if (color == 'B') {
                for (int j = 0; j < orderCnt; j++) {
                    q1.add(t + j * A);
                    totalCnt1++;
                }
            } else {
                for (int j = 0; j < orderCnt; j++) {
                    q2.add(t + j * B);
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
