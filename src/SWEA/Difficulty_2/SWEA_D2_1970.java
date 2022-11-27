/**
 * 문제 : 쉬운 거스름돈
 *
 * @author Hc-5514
 */

package SWEA.Difficulty_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA_D2_1970 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            // 8가지 화폐의 개수를 저장할 배열 arr
            int[] arr = new int[8];
            int N = Integer.parseInt(br.readLine());

            int cnt = 50000;
            for (int i = 0; i < 8; i++) {
                arr[i] = N / cnt;
                N %= cnt;
                if (i % 2 == 0) cnt /= 5;
                else cnt /= 2;
            }

            System.out.println("#" + tc);
            for (int i = 0; i < 8; i++)
                System.out.printf("%d ", arr[i]);
            System.out.println();
        }
    }

}
