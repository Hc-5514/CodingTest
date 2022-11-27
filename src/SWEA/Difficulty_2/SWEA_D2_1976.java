/**
 * 문제 : 시각 덧셈
 *
 * @author Hc-5514
 */

package SWEA.Difficulty_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class SWEA_D2_1976 {

    public static void main(String[] args) throws Exception {

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());

        for (int tc = 1; tc <= T; tc++) {

            String str = br.readLine();
            StringTokenizer st = new StringTokenizer(str, " ");

            // 시, 분 입력 받기
            int h1 = Integer.parseInt(st.nextToken());
            int m1 = Integer.parseInt(st.nextToken());
            int h2 = Integer.parseInt(st.nextToken());
            int m2 = Integer.parseInt(st.nextToken());

            int h = h1 + h2;
            int m = m1 + m2;

            // 60분이 넘었다면, 1시간으로 환산
            if (m >= 60) {
                m -= 60;
                h++;
            }

            // 12시간제이므로, 12시 초과 시는 버림
            if (h > 12)
                h -= 12;

            System.out.println("#" + tc + " " + h + " " + m);
        }
    }

}
