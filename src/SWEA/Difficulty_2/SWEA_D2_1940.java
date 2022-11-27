/**
 * 문제 : 가랏! RC카!
 *
 * @author Hc-5514
 */

package SWEA.Difficulty_2;

import java.util.Scanner;

public class SWEA_D2_1940 {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        for (int tc = 1; tc <= T; tc++) {

            // dis: 총 이동거리, spd: 현재 속도, spd2: 증감 속도
            int dis = 0, spd = 0, spd2;

            int N = sc.nextInt();
            for (int i = 0; i < N; i++) {

                // command 받기 (0: 유지, 1: 가속, 2: 감속)
                int cmd = sc.nextInt();

                if (cmd == 0) { // 속도 유지
                    dis += spd;
                } else if (cmd == 1) { // 가속
                    spd2 = sc.nextInt();
                    spd += spd2;
                    dis += spd;
                } else { // 감속
                    spd2 = sc.nextInt();
                    spd -= spd2;
                    if (spd <= 0) spd = 0;
                    dis += spd;
                }
            }

            System.out.println("#" + tc + " " + dis);
        }
    }

}
