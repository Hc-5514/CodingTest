/**
 * 문제 : 한빈이와 Spot Mart
 *
 * @author Hc-5514
 */

package SWEA.Difficulty_3;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_D3_9229 {

    static int N, M, maxWeight;
    static int[] arr;

    private static void getWeight() {
        for (int i = 0; i < arr.length - 1; i++) {
            for (int j = i + 1; j < arr.length; j++) {
                int sum = arr[i] + arr[j];
                if (sum <= M) {
                    maxWeight = Math.max(maxWeight, sum);
                }
            }
        }
    }

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringBuilder sb = new StringBuilder();
        StringTokenizer st;

        int T = Integer.parseInt(br.readLine());
        for (int tc = 1; tc <= T; tc++) {
            // N, M, 과자 봉지 무게: int[] arr 입력 받기
            st = new StringTokenizer(br.readLine());
            N = Integer.parseInt(st.nextToken());
            M = Integer.parseInt(st.nextToken());
            st = new StringTokenizer(br.readLine());
            arr = new int[N];
            for (int i = 0; i < N; i++) {
                arr[i] = Integer.parseInt(st.nextToken());
            }
            // 무게 합 구하기
            maxWeight = -1;
            getWeight();
            sb.append('#').append(tc).append(" ").append(maxWeight).append("\n");
        }

        System.out.println(sb);
        br.close();
    }
}

