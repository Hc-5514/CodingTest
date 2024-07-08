/**
 * 문제 : 수 찾기
 *
 * @author Hc-5514
 */

package Baekjoon.AC.CLASS_2;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.stream.Stream;

public class BOJ_1920 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		// init
		int N = Integer.parseInt(br.readLine());
		int[] nums = Stream.of(br.readLine().split(" "))
			.mapToInt(Integer::parseInt)
			.toArray();

		int M = Integer.parseInt(br.readLine());
		int[] findNums = Stream.of(br.readLine().split(" "))
			.mapToInt(Integer::parseInt)
			.toArray();

		// sort
		Arrays.sort(nums); // 1 2 3 4 5

		// binary search
		for (int i = 0; i < M; i++) {
			int s = 0;
			int e = N - 1;
			while (s < e) {
				int m = (s + e) >> 1;
				if (nums[m] < findNums[i]) {
					s = m + 1;
				} else {
					e = m;
				}
			}
			if (nums[s] == findNums[i]) {
				bw.write(1 + "\n");
			} else {
				bw.write(0 + "\n");
			}
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
