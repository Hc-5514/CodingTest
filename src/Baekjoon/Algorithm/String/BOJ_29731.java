/**
 * 문제 : 2033년 밈 투표
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.String;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.HashSet;
import java.util.Set;

public class BOJ_29731 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		int N = Integer.parseInt(br.readLine().trim());

		boolean isFalse = false;
		Set<String> set = new HashSet<>();
		set.add("Never gonna give you up");
		set.add("Never gonna let you down");
		set.add("Never gonna run around and desert you");
		set.add("Never gonna make you cry");
		set.add("Never gonna say goodbye");
		set.add("Never gonna tell a lie and hurt you");
		set.add("Never gonna stop");

		for (int i = 0; i < N; i++) {
			String str = br.readLine();
			if (!set.contains(str)) {
				isFalse = true;
				break;
			}
		}

		if (isFalse) {
			bw.write("Yes");
		} else {
			bw.write("No");
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
