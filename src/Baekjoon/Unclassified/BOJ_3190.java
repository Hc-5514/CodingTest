/**
 * 문제 : 뱀
 *
 * @author Hc-5514
 */

package Baekjoon.Unclassified;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.StringTokenizer;

public class BOJ_3190 {

    static int N, time = 0;
    static int[][] board;
    static List<String[]> dirList = new ArrayList<>();
    static final int[] dRow = {-1, 1, 0, 0};
    static final int[] dCol = {0, 0, -1, 1};

    static class Snake {

        List<int[]> snakeInfo = new ArrayList<>(); // r, c 정보
        int d; // 상 0, 하 1, 좌 2, 우 3

        public Snake() {
            // 초기상태: (0,0) 시작, 길이 1, 방향: 우
            snakeInfo.add(new int[]{0, 0});
            this.d = 3;
        }
    }

    private static void startGame() {
        // 벽 또는 자신과 부딪히면 게임 오버
        // 게임이 몇 초에 끝나는가?

        Snake snake = new Snake();
        board[0][0] = 2;
        while (move(snake)) {
            // 방향 이동
            if (dirList.isEmpty()) continue;
            if (time == Integer.parseInt(dirList.get(0)[0])) {
                if (dirList.get(0)[1].equals("D")) {
                    // 오른쪽 회전
                    switch (snake.d) {
                        case 0:
                            snake.d = 3;
                            break;
                        case 1:
                            snake.d = 2;
                            break;
                        case 2:
                            snake.d = 0;
                            break;
                        case 3:
                            snake.d = 1;
                            break;
                    }
                } else {
                    // 왼쪽 회전
                    switch (snake.d) {
                        case 0:
                            snake.d = 2;
                            break;
                        case 1:
                            snake.d = 3;
                            break;
                        case 2:
                            snake.d = 1;
                            break;
                        case 3:
                            snake.d = 0;
                            break;
                    }
                }
                dirList.remove(0);
            }
        }
    }

    private static boolean move(Snake snake) {
        time++;
        // 한 칸 이동 후 좌표
        int d = snake.d;
        int r = snake.snakeInfo.get(0)[0] + dRow[d];
        int c = snake.snakeInfo.get(0)[1] + dCol[d];
        // 배열 범위 확인
        if (r < 0 || c < 0 || r >= N || c >= N) return false;
        // 몸통 확인
        if (board[r][c] == 2) return false;
        // 한 칸 이동
        snake.snakeInfo.add(0, new int[]{r, c});
        // 사과가 있으면, 길이 증가: 꼬리 위치 변화 x
        // 사과가 없으면, 이동: 꼬리 위치 이동
        if (board[r][c] == 0) {
            int size = snake.snakeInfo.size() - 1;
            board[snake.snakeInfo.get(size)[0]][snake.snakeInfo.get(size)[1]] = 0;
            snake.snakeInfo.remove(size);
        }
        board[r][c] = 2;
        return true;
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;

        // N x N 보드
        N = Integer.parseInt(br.readLine());
        board = new int[N][N]; // 0: 빈 칸, 1: 사과, 2: 뱀

        // K개의 사과 좌표, 사과: 1
        int K = Integer.parseInt(br.readLine());
        for (int i = 0; i < K; i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()) - 1;
            int b = Integer.parseInt(st.nextToken()) - 1;
            board[a][b] = 1;
        }

        // L번의 방향 변환
        int L = Integer.parseInt(br.readLine());
        for (int i = 0; i < L; i++) {
            st = new StringTokenizer(br.readLine());
            dirList.add(new String[]{st.nextToken(), st.nextToken()});
        }

        startGame();

        bw.write(time + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}
