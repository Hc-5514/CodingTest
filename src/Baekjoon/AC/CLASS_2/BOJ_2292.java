/**
 * 문제 : 벌집
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_2;

import java.io.BufferedReader;
import java.io.InputStreamReader;

// 1: 1 ~ 1		- 1	~ 1		0
// 2: 2 ~ 7 	- 1 ~ 6		1
// 3: 8 ~ 19 	- 6 ~ 12    2
// 4: 20 ~ 37 	- 12 ~ 18	3
// 5: 38 ~ 61 	- 18 ~ 24	4
// 6: 62 ~

public class BOJ_2292 {

	public static int a = 1, b = 1, count = 0;

	public static int Solution(int num) {

		if (num == 1)
			return 1;
		else {
			a += 6 * count;
			b += 6 * (count + 1);
			count++;
			if (a <= num && num <= b)
				return count + 1;
			else
				return Solution(num);
		}

	}

	public static void main(String[] args) throws Exception {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		int n = Integer.parseInt(br.readLine());
		System.out.println(Solution(n));
	}

}
