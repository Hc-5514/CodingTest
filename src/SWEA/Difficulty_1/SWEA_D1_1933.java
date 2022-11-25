/**
 * 문제 : 간단한 N의 약수
 *
 * @author Hc-5514
 */

package SWEA.Difficulty_1;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class SWEA_D1_1933 {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		ArrayList<Integer> al = new ArrayList<>();

		for (int i = 1; i <= (int) Math.sqrt(T); i++) {
			if (getDivisor(i, T)) {
				al.add(i);
				if (T / i != i)
					al.add(T / i);
			}
		}

		Collections.sort(al);

		for (Integer integer : al) {
			System.out.print(integer + " ");
		}
	}

	public static boolean getDivisor(int num1, int num2) {
		return num2 % num1 == 0;
	}
}
