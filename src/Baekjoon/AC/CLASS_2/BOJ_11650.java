/**
 * 문제 : 좌표 정렬하기
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_11650 {

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int N = Integer.parseInt(br.readLine());
        int[][] arr = new int[N][2];

        // 좌표 입력 받기
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            arr[i][0] = Integer.parseInt(st.nextToken());
            arr[i][1] = Integer.parseInt(st.nextToken());
        }

        // x좌표 순 정렬, x좌표가 같다면 y좌표 순 정렬
        Arrays.sort(arr, (o1, o2) -> {
            int result;
            if (o1[0] == o2[0]) {
                result = Integer.compare(o1[1], o2[1]);
            } else {
                result = Integer.compare(o1[0], o2[0]);
            }
            return result;
        });

        // 출력
        for (int i = 0; i < N; i++) {
            sb.append(arr[i][0]).append(" ").append(arr[i][1]).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}
