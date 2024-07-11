/**
 * 문제 : 정사면체
 * 소요 시간 : 27분
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.Geometry;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.util.StringTokenizer;

public class BOJ_1930 {

	// 각 면에 숫자가 적혀 있는 두 정사면체가 있다.
	// 두 정사면체가 같은 정사면체인지 판별하기. (회전했을 때 같은 경우도 같은 정사면체)
	// 4개의 수 (1번: 밑면, 2~4번: 옆면)

	public static void main(String[] args) throws IOException {
		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
		StringTokenizer st;

		int T = Integer.parseInt(br.readLine().trim());
		for (int i = 0; i < T; i++) {
			st = new StringTokenizer(br.readLine());

			// 첫 번째 정사면체 정보
			int[] nums1 = new int[4];
			for (int j = 0; j < 4; j++) {
				nums1[j] = Integer.parseInt(st.nextToken());
			}

			// 두 번째 정사면체 정보
			int[] nums2 = new int[4];
			for (int j = 0; j < 4; j++) {
				nums2[j] = Integer.parseInt(st.nextToken());
			}

			// 12가지 경우의 수
			boolean isSame = false;
			if (nums1[0] == nums2[0] && nums1[1] == nums2[1]
				&& nums1[2] == nums2[2] && nums1[3] == nums2[3]) {
				isSame = true;
			} else if (nums1[0] == nums2[0] && nums1[2] == nums2[1]
				&& nums1[3] == nums2[2] && nums1[1] == nums2[3]) {
				isSame = true;
			} else if (nums1[0] == nums2[0] && nums1[3] == nums2[1]
				&& nums1[1] == nums2[2] && nums1[2] == nums2[3]) {
				isSame = true;
			} else if (nums1[1] == nums2[0] && nums1[0] == nums2[1]
				&& nums1[3] == nums2[2] && nums1[2] == nums2[3]) {
				isSame = true;
			} else if (nums1[1] == nums2[0] && nums1[3] == nums2[1]
				&& nums1[2] == nums2[2] && nums1[0] == nums2[3]) {
				isSame = true;
			} else if (nums1[1] == nums2[0] && nums1[2] == nums2[1]
				&& nums1[0] == nums2[2] && nums1[3] == nums2[3]) {
				isSame = true;
			} else if (nums1[2] == nums2[0] && nums1[0] == nums2[1]
				&& nums1[1] == nums2[2] && nums1[3] == nums2[3]) {
				isSame = true;
			} else if (nums1[2] == nums2[0] && nums1[1] == nums2[1]
				&& nums1[3] == nums2[2] && nums1[0] == nums2[3]) {
				isSame = true;
			} else if (nums1[2] == nums2[0] && nums1[3] == nums2[1]
				&& nums1[0] == nums2[2] && nums1[1] == nums2[3]) {
				isSame = true;
			} else if (nums1[3] == nums2[0] && nums1[0] == nums2[1]
				&& nums1[2] == nums2[2] && nums1[1] == nums2[3]) {
				isSame = true;
			} else if (nums1[3] == nums2[0] && nums1[2] == nums2[1]
				&& nums1[1] == nums2[2] && nums1[0] == nums2[3]) {
				isSame = true;
			} else if (nums1[3] == nums2[0] && nums1[1] == nums2[1]
				&& nums1[0] == nums2[2] && nums1[2] == nums2[3]) {
				isSame = true;
			}

			if (isSame) {
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
