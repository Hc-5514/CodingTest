/**
 * 문제 : 연월일 달력
 *
 * @author Hc-5514
 */

package SWEA.Difficulty_1;

import java.util.Scanner;

public class SWEA_D1_2056 {

	public static int[] arr = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		int T;
		T = sc.nextInt();

		for (int test_case = 1; test_case <= T; test_case++) {

			String date = sc.next();
			int year = Integer.parseInt(date.substring(0, 4));
			int month = Integer.parseInt(date.substring(4, 6));
			int day = Integer.parseInt(date.substring(6));

			if (month > 0 && month < 13 && day > 0 && day <= arr[month - 1]) {
				System.out.println("#" + test_case + " " + getYear(year) + "/" + getMonth(month) + "/" + getDay(day));
			} else
				System.out.println("#" + test_case + " " + "-1");
		}

	}

	public static String getYear(int num) {
		return String.format("%04d", num);
	}

	public static String getMonth(int num) {
		return String.format("%02d", num);
	}

	public static String getDay(int num) {
		return String.format("%02d", num);
	}

}
