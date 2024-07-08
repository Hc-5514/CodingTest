/**
 * 문제 : 알고리즘 코드 챌린지 예선 1일차
 *
 * @author Hc-5514
 */

package Elice.CodeChallenge;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class day01_0708 {

	private static String s;
	private static boolean[] isSelected;
	private static int[] selectedNum;
	private static List<Integer> nums;

	private static void combination(int depth) {
		if (depth == s.length()) {
			int num = 0;
			for (int i = 0; i < selectedNum.length; i++) {
				num *= 10;
				num += selectedNum[i];
			}
			nums.add(num);
			return;
		}

		for (int i = 0; i < s.length(); i++) {
			if (isSelected[i]) {
				continue;
			}
			isSelected[i] = true;
			selectedNum[depth] = Character.getNumericValue(s.charAt(i));
			combination(depth + 1);
			isSelected[i] = false;
		}
	}

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));

		s = br.readLine();
		isSelected = new boolean[s.length()];
		selectedNum = new int[s.length()];
		nums = new ArrayList<>();

		combination(0);

		Collections.sort(nums);

		for (int i = 0; i < nums.size(); i++) {
			if (nums.get(i) > Integer.parseInt(s)) {
				bw.write(nums.get(i) + "\n");
				break;
			}
		}

		bw.flush();
		bw.close();
		br.close();
	}
}
