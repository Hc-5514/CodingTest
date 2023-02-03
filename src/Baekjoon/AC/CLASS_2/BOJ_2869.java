/**
 * 문제 : 달팽이는 올라가고 싶다
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_2;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_2869 {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringTokenizer st = new StringTokenizer(br.readLine());
		int A = Integer.parseInt(st.nextToken());
		int B = Integer.parseInt(st.nextToken());
		int V = Integer.parseInt(st.nextToken());

		int cnt = (V - A) / (A - B);
		if ((V - A) % (A - B) == 0) {
			cnt = cnt + 1;
		} else
			cnt = cnt + 2;

		System.out.println(cnt);
	}

}
