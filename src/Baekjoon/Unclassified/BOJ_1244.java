/**
 * 문제 : 스위치 켜고 끄기
 *
 * @author Hc-5514
 */

package Baekjoon.Unclassified;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BOJ_1244 {

	static int[] switchNum;

	public static void changeSwitch1(int num) {

		for (int i = 0; i < switchNum.length; i++) {
			// 스위치 번호가 본인 번호의 배수라면 스위치 조작
			if ((i + 1) % num == 0) {
				if (switchNum[i] == 0)
					switchNum[i] = 1;
				else
					switchNum[i] = 0;
			}
		}
	}

	public static void changeSwitch2(int num) {

		num -= 1;

		for (int i = 0; i < switchNum.length; i++) {

			// 스위치 범위 밖이라면 break
			if (num - i < 0 || num + i == switchNum.length)
				break;

			// 스위치 번호 == 본인 번호 기준으로
			// 좌우 대칭이라면 스위치 조작
			if (switchNum[num - i] == switchNum[num + i]) {
				if (switchNum[num - i] == 0) {
					switchNum[num - i] = 1;
					switchNum[num + i] = 1;
				} else {
					switchNum[num - i] = 0;
					switchNum[num + i] = 0;
				}
			} else
				break;
		}
	}

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
		StringBuilder sb = new StringBuilder();
		StringTokenizer st;

		// 스위치 정보 (개수 / 번호 별 상태: 1켜짐, 0꺼짐)
		int switchCnt = Integer.parseInt(br.readLine());
		st = new StringTokenizer(br.readLine());
		switchNum = new int[switchCnt];
		for (int i = 0; i < switchCnt; i++) {
			switchNum[i] = Integer.parseInt(st.nextToken());
		}

		// 학생 정보 (1:남학생, 2:여학생 / 받은 수)
		int stuNum = Integer.parseInt(br.readLine());
		for (int i = 0; i < stuNum; i++) {
			st = new StringTokenizer(br.readLine());
			int sex = Integer.parseInt(st.nextToken());
			int num = Integer.parseInt(st.nextToken());

			if (sex == 1)
				changeSwitch1(num);
			else
				changeSwitch2(num);

		}

		for (int j = 0; j < switchCnt; j++) {

			sb.append(switchNum[j]);

			if (j != switchCnt - 1) {
				if (j != 0 && (j + 1) % 20 == 0) {
					sb.append("\n");
				} else
					sb.append(" ");
			}
		}

		System.out.println(sb.toString());
		br.close();
	}

}
