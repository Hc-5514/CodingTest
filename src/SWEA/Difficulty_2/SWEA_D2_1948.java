/**
 * 문제 : 날짜 계산기
 *
 * @author Hc-5514
 */

package SWEA.Difficulty_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_D2_1948 {

    public static int[] day = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        StringTokenizer st;
        for (int tc = 1; tc <= T; tc++) {

            // 두 날짜 입력 받기
            String str = br.readLine();
            st = new StringTokenizer(str);
            int m1 = Integer.parseInt(st.nextToken());
            int d1 = Integer.parseInt(st.nextToken());
            int m2 = Integer.parseInt(st.nextToken());
            int d2 = Integer.parseInt(st.nextToken());

            // 날짜 계산하기
            int date1 = 0, date2 = 0;

            for (int i = 0; i < m1; i++) {
                date1 += day[i];
            }
            date1 += d1;

            for (int i = 0; i < m2; i++) {
                date2 += day[i];
            }
            date2 += d2;

            System.out.println("#" + tc + " " + (date2 - date1 + 1));
        }
    }

}
