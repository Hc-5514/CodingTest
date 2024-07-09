/**
 * 문제 : 알고리즘 코드 챌린지 예선 2일차
 *
 * @author Hc-5514
 */

package Elice.CodeChallenge;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.Arrays;
import java.util.StringTokenizer;
import java.util.stream.Stream;

public class day02_0709 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		st = new StringTokenizer(br.readLine());
		int n = Integer.parseInt(st.nextToken());
		int m = Integer.parseInt(st.nextToken());

		int[] nums = Stream.of(br.readLine().split(" "))
			.mapToInt(Integer::parseInt)
			.toArray();

		for (int i = 0; i < m; i++) {
			st = new StringTokenizer(br.readLine());
			int from = Integer.parseInt(st.nextToken());
			int to = Integer.parseInt(st.nextToken());
			int k = Integer.parseInt(st.nextToken());
			int[] copyNums = new int[to - from + 1];
			System.arraycopy(nums, from - 1, copyNums, 0, to - from + 1);
			Arrays.sort(copyNums);
			bw.write(copyNums[k - 1] + "\n");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
