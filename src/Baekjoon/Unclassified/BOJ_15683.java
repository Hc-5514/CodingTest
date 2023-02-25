/**
 * 문제 : 감시
 *
 * @author Hc-5514
 */

package Baekjoon.Unclassified;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class BOJ_15683 {

    static int N, M, minCnt = Integer.MAX_VALUE;
    static int[][] map, copyMap;
    static ArrayList<CCTV> cctvList = new ArrayList<>();

    static class CCTV {
        int n;  // CCTV 종류
        int r;  // row
        int c;  // col
        int d;  // direction

        public CCTV(int n, int r, int c, int d) {
            this.n = n;
            this.r = r;
            this.c = c;
            this.d = d;
        }
    }

    private static void setMap(int cnt) {
        // cctv의 방향만 돌린다.
        if (cnt == cctvList.size()) {
            for (int i = 0; i < map.length; i++) {
                copyMap[i] = Arrays.copyOf(map[i], map[0].length);
            }
            for (int i = 0; i < cnt; i++) {
                runCCTV(i);
            }
            getArea();
            return;
        }

        int no = cctvList.get(cnt).n;
        // 4방향
        if (no == 1 || no == 3 || no == 4) {
            for (int j = 0; j < 4; j++) {
                cctvList.get(cnt).d = j;
                setMap(cnt + 1);
            }
        }
        // 2방향
        else if (no == 2) {
            for (int j = 0; j < 2; j++) {
                cctvList.get(cnt).d = j;
                setMap(cnt + 1);
            }
        }
        // 1방향
        else {
            setMap(cnt + 1);
        }
    }

    private static void runCCTV(int num) {
        int n = cctvList.get(num).n;
        int r = cctvList.get(num).r;
        int c = cctvList.get(num).c;
        int d = cctvList.get(num).d;
        switch (n) {
            case 1:
                run(d, r, c);
                break;
            case 2:
                // 0: 상하, 1: 좌우
                run(d, r, c);
                run(d + 2, r, c);
                break;
            case 3:
                run(d % 4, r, c);
                run((d + 1) % 4, r, c);
                break;
            case 4: // 3방향
                for (int i = 0; i < 4; i++) {
                    if (i != d) {
                        run(i, r, c);
                    }
                }
                break;
            case 5: // 상하좌우
                for (int i = 0; i < 4; i++) {
                    run(i, r, c);
                }
                break;
        }
    }

    private static void run(int d, int r, int c) {
        switch (d) {
            case 0: // 오른쪽
                while (++c < copyMap[0].length && copyMap[r][c] != 6) {
                    if (copyMap[r][c] == 0) copyMap[r][c] = -1;
                }
                break;
            case 1: // 위쪽
                while (--r >= 0 && copyMap[r][c] != 6) {
                    if (copyMap[r][c] == 0) copyMap[r][c] = -1;
                }
                break;
            case 2: // 왼쪽
                while (--c >= 0 && copyMap[r][c] != 6) {
                    if (copyMap[r][c] == 0) copyMap[r][c] = -1;
                }
                break;
            case 3: // 아래쪽
                while (++r < copyMap.length && copyMap[r][c] != 6) {
                    if (copyMap[r][c] == 0) copyMap[r][c] = -1;
                }
                break;
        }
    }

    private static void getArea() {
        int cnt = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (copyMap[i][j] != 0) cnt++;
            }
        }
        minCnt = Math.min(minCnt, N * M - cnt);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        map = new int[N][M];
        copyMap = new int[N][M];
        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                if (map[i][j] > 0 && map[i][j] < 6) {
                    cctvList.add(new CCTV(map[i][j], i, j, 0));
                }
            }
        }

        setMap(0);

        System.out.println(minCnt);
        br.close();
    }
}