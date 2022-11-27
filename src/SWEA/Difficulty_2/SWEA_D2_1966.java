/**
 * 문제 : 숫자를 정렬하자
 *
 * @author Hc-5514
 */

package SWEA.Difficulty_2;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SWEA_D2_1966 {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();

        ArrayList<Integer> al = new ArrayList<>();
        for (int tc = 1; tc <= T; tc++) {

            al.clear();
            int N = sc.nextInt();
            for (int i = 0; i < N; i++) {
                al.add(sc.nextInt());
            }

            Collections.sort(al);

            System.out.print("#" + tc + " ");
            for (int i = 0; i < N; i++) {
                System.out.print(al.get(i) + " ");
            }

            System.out.println();
        }
    }

}
