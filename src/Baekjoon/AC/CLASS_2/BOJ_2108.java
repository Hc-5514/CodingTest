/**
 * 문제 : 통계학
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_2;

import java.io.*;
import java.util.Arrays;
import java.util.Comparator;

public class BOJ_2108 {

    static class Count {
        int val;
        int cnt;

        public Count(int val) {
            this.val = val;
            this.cnt = 0;
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringBuilder sb = new StringBuilder();

        int N = Integer.parseInt(br.readLine().trim());
        int sum = 0; // 산술 평균: sum/N
        int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
        int[] numArr = new int[N]; // 중앙값: 오름차순 정렬
        Count[] numCnt = new Count[8001]; // 최빈값: 숫자 count
        for (int i = 0; i < 8001; i++) {
            numCnt[i] = new Count(i - 4000);
        }

        // 0~3999 : 음수
        // 4000 : 0
        // 4001 ~ 8000 : 양수
        for (int i = 0; i < N; i++) {
            int n = Integer.parseInt(br.readLine().trim());
            sum += n;
            numArr[i] = n;
            numCnt[4000 + n].cnt++;
            if (n > max) max = n;
            if (n < min) min = n;
        }

        // 산술 평균: 소수점 첫째 자리 반올림
        double avg = Math.round(sum * 1.0 / N);
        sb.append((int) avg).append("\n");

        // 중앙값
        Arrays.sort(numArr);
        sb.append(numArr[N / 2]).append("\n");

        // 최빈값: 여러개 있을 경우, 두 번째로 작은 값
        Arrays.sort(numCnt, new Comparator<Count>() {
            @Override
            public int compare(Count o1, Count o2) {
                if (o1.cnt == o2.cnt) {
                    return o1.val - o2.val;
                }
                return o2.cnt - o1.cnt;
            }
        });
        if (numCnt[0].cnt != numCnt[1].cnt)
            sb.append(numCnt[0].val);
        else {
            sb.append(numCnt[1].val);
        }
        sb.append("\n");

        // 범위
        sb.append(max - min).append("\n");

        bw.write(sb.toString());
        bw.flush();
        bw.close();
        br.close();
    }
}