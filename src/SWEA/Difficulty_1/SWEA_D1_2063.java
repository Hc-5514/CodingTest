/**
 * 문제 : 중간값 찾기
 *
 * @author Hc-5514
 */

package SWEA.Difficulty_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SWEA_D1_2063 {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		ArrayList<Integer> al = new ArrayList<>();
		for (int test_case = 1; test_case <= T; test_case++) {
			al.add(sc.nextInt());

		}

		Collections.sort(al);
		System.out.println(al.get(T / 2));
	}

}
