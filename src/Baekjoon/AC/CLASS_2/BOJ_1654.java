/**
 * 문제 : 랜선 자르기
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1654 {
    public static int[] arr_K;

    public static void main(String[] args) throws IOException {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        // 길이가 서로 다른 K개 랜선, 길이가 서로 같은 N개 랜선
        int K = Integer.parseInt(st.nextToken());
        int N = Integer.parseInt(st.nextToken());
        // K개 랜선 입력 받기
        arr_K = new int[K];
        long max = 0;
        for (int i = 0; i < K; i++) {
            arr_K[i] = Integer.parseInt(br.readLine());
            max = Math.max(max, arr_K[i]);
        }

        // max가 1이라면, mid가 0이 되기 때문에 +1을 해준다.
        max++;

        System.out.println(getUpperBound(0, max, N));
        br.close();
    }

    public static long getUpperBound(long min, long max, int N) {
        while(min < max){

            long cnt = 0;
            long mid = min + (max - min) / 2;

            for (int i = 0; i < arr_K.length; i++) {
                cnt += arr_K[i] / mid;
            }

            if (cnt < N) {
                max = mid;
            } else {
                min = mid + 1;
            }
        }

        return min -1;
    }
}
