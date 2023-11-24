/**
 * 문제 : 거리두기 확인하기
 *
 * @author Hc-5514
 */

package Programmers._2022_KAKAO_BLIND_RECRUITMENT;

import java.util.ArrayDeque;
import java.util.Queue;

public class 거리두기_확인하기 {

    class Solution {
        final int[] dRow = {-1, 1, 0, 0}, dCol = {0, 0, -1, 1};

        boolean bfs(char[][] board) {
            Queue<int[]> q = new ArrayDeque<>();
            boolean[][] visit;
            for (int i = 0; i < board.length; i++) {
                for (int j = 0; j < board[0].length; j++) {
                    // 응시자o, 방문x
                    if (board[i][j] == 'P') {
                        visit = new boolean[5][5];
                        q.offer(new int[]{i, j, 0});
                        visit[i][j] = true;
                        while (!q.isEmpty()) {
                            int[] cur = q.poll();
                            // 맨해튼 거리 비교
                            if (cur[2] >= 2) {
                                continue;
                            }
                            for (int k = 0; k < 4; k++) {
                                int r = cur[0] + dRow[k];
                                int c = cur[1] + dCol[k];
                                if (r < 0 || c < 0 || r >= board.length || c >= board[0].length) {
                                    continue;
                                }
                                if (visit[r][c]) {
                                    continue;
                                }
                                if (board[r][c] == 'X') {
                                    continue;
                                }
                                if (board[r][c] == 'P') {
                                    return false;
                                }
                                q.offer(new int[]{r, c, cur[2] + 1});
                                visit[r][c] = true;
                            }
                        }
                    }
                }
            }
            return true;
        }

        public int[] solution(String[][] places) {

            int[] answer = new int[places.length]; // test case: 5

            for (int k = 0; k < places.length; k++) {
                // 대기실 입력 받기
                char[][] board = new char[5][5];
                for (int i = 0; i < 5; i++) {
                    board[i] = places[k][i].toCharArray();
                }

                if (bfs(board)) {
                    answer[k] = 1;
                }
            }

            return answer;
        }
    }
}


