/**
 * 문제 : 전생했더니 슬라임 연구자였던 건에 대하여 (Easy)
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.Implementation;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class BOJ_14715 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int n = Integer.parseInt(br.readLine());
		int cnt = 1;

		while (true) {
			boolean isPrime = true;
			for (int i = 2; i * i <= n; i++) {
				if (n % i == 0) {
					isPrime = false;
					n /= i;
					cnt++;
					break;
				}
			}

			if (isPrime) {
				break;
			}
		}

		int ans = (int)Math.ceil(Math.log10(cnt) / Math.log10(2));
		bw.write(ans + "\n");
		bw.flush();
		bw.close();
		br.close();
	}
}
