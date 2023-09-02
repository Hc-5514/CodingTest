package Programmers._2017_팁스타운;

public class 예상_대진표 {
	public int solution(int n, int a, int b) {
		int answer = 1;
		while (true) {
			if (a % 2 == 1) {
				a++;
			}
			if (b % 2 == 1) {
				b++;
			}
			if (a == b)
				break;
			a /= 2;
			b /= 2;
			answer++;
		}
		return answer;
	}
}
