package Programmers._2022_KAKAO_BLIND_RECRUITMENT;

/**
 * 풀이 방법
 * 가로, 세로 누적합
 * ex) (r1,c1) (r2,c2) 영역에 3만큼 타격
 * (r1, c1) = 3, (r1, c2+1) = -3
 * (r2+1, c1) = -3, (r2+1, c2+1) = 3
 * <p>
 * [시간 복잡도]
 * K(Skill 수만큼 반복) -> 4K
 * 누적합 2번 반복 -> 2NM
 * 기존 배열에 합산 -> NM
 * O(4K+3NM) = O(K+NM)
 */
public class 파괴되지_않은_건물 {

    public static int solution(int[][] board, int[][] skill) {
        int n = board.length;
        int m = board[0].length;
        int[][] sum = new int[n + 1][m + 1];
        for (int i = 0; i < skill.length; i++) {
            int status;
            if (skill[i][0] == 1) status = -1;
            else status = 1;
            sum[skill[i][1]][skill[i][2]] += status * skill[i][5];
            sum[skill[i][1]][skill[i][4] + 1] += -1 * status * skill[i][5];
            sum[skill[i][3] + 1][skill[i][2]] += -1 * status * skill[i][5];
            sum[skill[i][3] + 1][skill[i][4] + 1] += status * skill[i][5];
        }

        // 가로 누적합 구하기
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < m; j++) {
                sum[i][j] += sum[i][j - 1];
            }
        }

        // 세로 누적합 구하기
        for (int i = 1; i < n; i++) {
            for (int j = 0; j < m; j++) {
                sum[i][j] += sum[i - 1][j];
            }
        }

        // 기존 맵에 누적합 합치기 + 파괴되지 않은 건물 개수 구하기
        int answer = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                board[i][j] += sum[i][j];
                if (board[i][j] >= 1) answer++;
            }
        }

        return answer;
    }

    public static void main(String[] args) {
        int result1 = solution(new int[][]{{5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}, {5, 5, 5, 5, 5}}, new int[][]{{1, 0, 0, 3, 4, 4}, {1, 2, 0, 2, 3, 2}, {2, 1, 0, 3, 1, 2}, {1, 0, 1, 3, 3, 1}});
        int result2 = solution(new int[][]{{1, 2, 3}, {4, 5, 6}, {7, 8, 9}}, new int[][]{{1, 1, 1, 2, 2, 4}, {1, 0, 0, 1, 1, 2}, {2, 2, 0, 2, 0, 100}});
        System.out.println(result1);
        System.out.println(result2);
    }
}
