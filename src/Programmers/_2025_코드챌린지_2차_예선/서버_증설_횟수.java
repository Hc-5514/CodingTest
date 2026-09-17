package Programmers._2025_코드챌린지_2차_예선;

public class 서버_증설_횟수 {
	public int solution(int[] players, int m, int k) {
		int answer = 0; // 증설 횟수
		int[] servers = new int[24]; // 시간별 서버 개수
		for (int i = 0; i < 24; i++) {
			int need = (players[i] / m) - servers[i];
			if (need <= 0) {
				continue;
			}
			for (int j = i; j < i + k && j < 24; j++) {
				servers[j] += need;
			}
			answer += need;
		}
		return answer;
	}
}
