/**
 * 문제 : 동영상 재생기
 * 소요 시간 : 39분
 *
 * @author Hc-5514
 */

package Programmers.PCCP_기출문제;

import java.util.StringTokenizer;

public class _1번_동영상_재생기 {

	class Solution {

		// 3가지 기능
		// 1) 10초 전 이동: 현재 위치에서 10초 전으로 이동, 0분 0초 ~ 0분 10초 -> 0분 0초
		// 2) 10초 후 이동: 현재 위치에서 10초 후로 이동, 남은 시간이 10초 미만 -> 영상 끝
		// 3) 오프닝 구간일 경우: 오프닝 끝나는 지점으로 이동

		private int len_m, len_s, cur_m, cur_s, op_s, op_e, op_e_m, op_e_s;

		private void func(String command) {
			if (command.equals("prev")) { // prev
				if (cur_m == 0 && cur_s < 10) { // 10초 미만일 경우
					cur_s = 0;
				} else {
					cur_s -= 10;
					if (cur_s < 0) {
						cur_m -= 1;
						cur_s += 60;
					}
				}
			} else { // next
				cur_s += 10;
				if (cur_s >= 60) {
					cur_m += 1;
					cur_s -= 60;
				}
				if (cur_m * 60 + cur_s > len_m * 60 + len_s) {
					cur_m = len_m;
					cur_s = len_s;
				}
			}
		}

		private void checkOpening() {
			int cur = cur_m * 60 + cur_s;
			if (cur >= op_s && cur <= op_e) {
				cur_m = op_e_m;
				cur_s = op_e_s;
			}
		}

		public String solution(String video_len, String pos, String op_start, String op_end, String[] commands) {
			StringTokenizer st = new StringTokenizer(video_len, ":");
			len_m = Integer.parseInt(st.nextToken());
			len_s = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(pos, ":");
			cur_m = Integer.parseInt(st.nextToken());
			cur_s = Integer.parseInt(st.nextToken());

			st = new StringTokenizer(op_start, ":");
			op_s = Integer.parseInt(st.nextToken()) * 60 + Integer.parseInt(st.nextToken());

			st = new StringTokenizer(op_end, ":");
			op_e_m = Integer.parseInt(st.nextToken());
			op_e_s = Integer.parseInt(st.nextToken());
			op_e = op_e_m * 60 + op_e_s;

			checkOpening(); // 오프닝 구간 확인

			for (int i = 0; i < commands.length; i++) {
				func(commands[i]);
				checkOpening();
			}

			String answer = String.format("%02d:%02d", cur_m, cur_s);
			return answer;
		}
	}
}
