package Programmers.SummerWinter_Coding_2018;

public class 방문_길이 {

	class Solution {

		int[] dRow = {-1, 1, 0, 0}, dCol = {0, 0, -1, 1};
		int[] opposite = {1, 0, 3, 2};

		boolean[][][] visit = new boolean[11][11][4];

		private int getDirection(char cmd) {
			switch (cmd) {
				case 'U':
					return 0;
				case 'D':
					return 1;
				case 'L':
					return 2;
				case 'R':
					return 3;
				default:
					return -1;
			}
		}

		public int solution(String dirs) {
			int answer = 0;
			int r = 0;
			int c = 0;

			for (char cmd : dirs.toCharArray()) {
				int dir = getDirection(cmd);

				int nr = r + dRow[dir];
				int nc = c + dCol[dir];

				// 범위 확인
				if (nr < -5 || nc < -5 || nr > 5 || nc > 5) {
					continue;
				}

				// 처음 가는 길일 경우
				if (!visit[r + 5][c + 5][dir]) {
					answer++;
					// 양방향 처리
					visit[r + 5][c + 5][dir] = true;
					visit[nr + 5][nc + 5][opposite[dir]] = true;
				}

				r = nr;
				c = nc;
			}

			return answer;
		}
	}
}
