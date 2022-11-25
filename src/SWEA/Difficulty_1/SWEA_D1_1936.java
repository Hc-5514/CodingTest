/**
 * 문제 : 1대1 가위바위보
 *
 * @author Hc-5514
 */

package SWEA.Difficulty_1;

import java.util.Scanner;

public class SWEA_D1_1936 {

	public static void main(String[] args) throws Exception {

		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();

		// 1: 가위, 2: 바위, 3: 보
		if (A == 1) { // 가위
			if (B == 2) { // 바위
				System.out.println("B");
			} else { // 보
				System.out.println("A");
			}
		} else if (A == 2) { // 바위
			if (B == 1) { // 가위
				System.out.println("A");
			} else { // 보
				System.out.println("B");
			}
		} else { // 보
			if (B == 1) { // 가위
				System.out.println("B");
			} else { // 바위
				System.out.println("A");
			}
		}
	}

}
