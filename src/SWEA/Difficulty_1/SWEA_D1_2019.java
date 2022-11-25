/**
 * 문제 : 더블더블
 *
 * @author Hc-5514
 */

package SWEA.Difficulty_1;

import java.util.Scanner;

public class SWEA_D1_2019 {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        for (int test_case = 0; test_case <= T; test_case++) {
            System.out.print((int) Math.pow(2, test_case) + " ");
        }
    }

}
