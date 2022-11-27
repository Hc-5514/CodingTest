/**
 * 문제 : 백만 장자 프로젝트
 *
 * @author Hc-5514
 */

package SWEA.Difficulty_2;

import java.util.ArrayList;
import java.util.Scanner;

public class SWEA_D2_1859 {

    public static void main(String[] args) throws Exception {

        Scanner sc = new Scanner(System.in);
        int T;
        T = sc.nextInt();

        ArrayList<Integer> al = new ArrayList<>();
        for (int test_case = 1; test_case <= T; test_case++) {

            int n = sc.nextInt();
            for (int i = 0; i < n; i++) {
                al.add(sc.nextInt());
            }
            System.out.println("#" + test_case + " " + result(al));
            al.clear();
        }
    }

    public static long result(ArrayList<Integer> al) {

        int idx = al.size() - 1;
        int max = al.get(idx);
        long answer = 0;

        for (int i = idx; i >= 0; i--) {

            if (al.get(i) > max) max = al.get(i);
            else answer += (max - al.get(i));
        }

        return answer;
    }
}
