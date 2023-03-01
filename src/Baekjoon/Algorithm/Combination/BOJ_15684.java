/**
 * 문제 : 사다리 조작
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.Combination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15684 {

    static int N, M, H, minCnt = -1;
    static int[][] map, copyMap;
    static ArrayList<int[]> list = new ArrayList<>();
    static boolean isSuccess = false;
    static boolean[] visit;

    private static void setCombination() {
        // 설치 가능한 사다리 좌표 저장
        for (int r = 1; r <= H; r++) {
            for (int c = 0; c < N - 1; c++) {
                if (map[r][2 * c + 1] != 1)
                    list.add(new int[]{r, 2 * c + 1});
            }
        }
        visit = new boolean[list.size()];
        // test code: 설치 가능한 사다리 좌표 출력
        /*for (int i = 0; i < list.size(); i++) {
            System.out.print("[" + list.get(i)[0] + ", " + list.get(i)[1] + "] ");
        }*/
    }

    private static void combinationList() {
        // 사다리 0 ~ 3개 뽑아서 백트래킹
        // 사다리 설치x
        combination(0, 0, 0);
        if (isSuccess) return;
        // 사다리 1개
        combination(0, 0, 1);
        if (isSuccess) return;
        // 사다리 2개
        combination(0, 0, 2);
        if (isSuccess) return;
        // 사다리 3개
        combination(0, 0, 3);
    }

    private static void combination(int cnt, int start, int goal) {
        if (cnt == goal) {
            // 배열 복사
            for (int i = 0; i < map.length; i++) {
                copyMap[i] = Arrays.copyOf(map[i], map[0].length);
            }

            // 사다리 설치 후 게임 시작
            for (int i = 0; i < visit.length; i++) {
                if (visit[i]) {
                    int r = list.get(i)[0];
                    int c = list.get(i)[1];
                    copyMap[r][c] = 1;
                }
            }
            startGame(goal);
            return;
        }

        for (int i = start; i < list.size(); i++) {
            if (visit[i]) continue;
            visit[i] = true;
            combination(cnt + 1, i + 1, goal);
            visit[i] = false;
        }
    }

    private static void startGame(int cnt) {
        // 1번 ~ N번 사다리 출발
        for (int i = 0; i < N; i++) {
            int r = 1, c = 2 * i;
            while (r < H + 1) {
                // 좌, 우 확인: 배열 범위 내 && 사다리가 있으면 이동
                if (c - 2 >= 0 && copyMap[r][c - 1] == 1) {
                    c -= 2;
                } else if (c + 2 < copyMap[0].length && copyMap[r][c + 1] == 1) {
                    c += 2;
                }
                r++;
            }
            // n번 사다리가 n번에 도착하지 않으면 실패
            if ((2 * i) != c) return;
        }
        isSuccess = true;
        minCnt = cnt;
    }

    public static void main(String[] args) throws IOException {
        setInit();
        setCombination();
        combinationList();
        System.out.println(minCnt);
    }

    private static void setInit() throws IOException {
        // 사다리 기본 세팅: 사다리 영역은 1로 표현
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        H = Integer.parseInt(st.nextToken());

        map = new int[H + 2][2 * N - 1];
        copyMap = new int[H + 2][2 * N - 1];
        for (int r = 0; r < H + 2; r++) {
            for (int c = 0; c < N; c++) {
                map[r][c * 2] = 1;
            }
        }

        for (int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            // b, b+1 세로 선 위 a 줄에 연결
            int a = Integer.parseInt(st.nextToken());
            int b = Integer.parseInt(st.nextToken());
            map[a][(b - 1) * 2 + 1] = 1;
        }

        br.close();
    }
}
