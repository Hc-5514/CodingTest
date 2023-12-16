/**
 * 문제 : 오픈채팅방
 *
 * @author Hc-5514
 */

package Programmers._2019_KAKAO_BLIND_RECRUITMENT;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.StringTokenizer;


public class 오픈채팅방 {

	public String[] solution(String[] record) {
		// map으로 관리 - key: 유저 아이디, value: 닉네임
		// map의 값은 언제 생성, 수정되는가?
		// -> 입장 했을 때, 변경했을 때

		// record 두 번 탐색
		// 1. map에 값을 저장하기 위해
		// 2. 출력하기 위해

		// 유저 아이디와 닉네임을 관리
		Map<String, String> user = new HashMap<>();
		StringTokenizer st;

		// 아이디 별 닉네임을 저장
		for (int i = 0; i < record.length; i++) {
			st = new StringTokenizer(record[i]);
			String cmd = st.nextToken();

			if (cmd.equals("Enter") || cmd.equals("Change")) {
				user.put(st.nextToken(), st.nextToken());
			}
		}

		List<String> list = new ArrayList<>();

		// 출력 결과 저장
		for (int i = 0; i < record.length; i++) {
			st = new StringTokenizer(record[i]);
			String cmd = st.nextToken();

			if (cmd.equals("Enter")) {
				list.add(user.get(st.nextToken()) + "님이 들어왔습니다.");
			}

			if (cmd.equals("Leave")) {
				list.add(user.get(st.nextToken()) + "님이 나갔습니다.");
			}
		}

		String[] answer = list.stream().toArray(String[]::new);
		return answer;
	}
}



