/**
 * 문제 : 거꾸로 출력해 보아요
 *
 * @author Hc-5514
 */

package SWEA.Difficulty_1;

import java.util.Scanner;

public class SWEA_D1_1545 {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = T; test_case >= 0; test_case--) {
            System.out.print(test_case + " ");
        }
    }

}
