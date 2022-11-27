/**
 * 문제 : 간단한 소인수분해
 *
 * @author Hc-5514
 */

package SWEA.Difficulty_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class SWEA_D2_1945 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            int N = Integer.parseInt(br.readLine());
            int[] arr = new int[5]; // 2, 3, 5, 7, 11 개수

            // 소인수분해
            while (true) {

                if (N % 11 == 0) {
                    arr[4]++;
                    N /= 11;
                } else if (N % 7 == 0) {
                    arr[3]++;
                    N /= 7;
                } else if (N % 5 == 0) {
                    arr[2]++;
                    N /= 5;
                } else if (N % 3 == 0) {
                    arr[1]++;
                    N /= 3;
                } else if (N % 2 == 0) {
                    arr[0]++;
                    N /= 2;
                } else break;
            }

            System.out.printf("#%d %d %d %d %d %d\n", tc, arr[0], arr[1], arr[2], arr[3], arr[4]);
        }
    }

}
