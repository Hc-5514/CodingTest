/**
 * 문제 : 캐슬 디펜스
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.Combination;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class BOJ_17135 {

    static int N, M, D, maxKill = 0;
    static int[][] map, copyMap;

    static int[] selectedNum = new int[3];
    static boolean[] isSelected;
    static ArrayList<int[]> archerInfoList = new ArrayList<>();

    static class Monster {
        int x;
        int y;
        int d;

        public Monster(int x, int y, int d) {
            this.x = x;
            this.y = y;
            this.d = d;
        }
    }

    private static void setArcher(int cnt, int start) {
        // 궁수는 성벽(map[N])에 3명 배치 가능, 조합: NC3
        if (cnt == 3) {
            archerInfoList.add(new int[]{selectedNum[0], selectedNum[1], selectedNum[2]});
            return;
        }

        for (int i = start; i < M; i++) {
            if (isSelected[i]) continue;
            isSelected[i] = true;
            selectedNum[cnt] = i;
            setArcher(cnt + 1, i + 1);
            isSelected[i] = false;
        }
    }

    private static int attack(int[] archerInfo, int row) {
        // 궁수 동시 공격: 거리 D이하 가장 가까운 적 하나 공격, 같을 경우 제일 왼쪽
        int kill = 0;
        ArrayList<Monster> list = new ArrayList<>();
        ArrayList<Monster> killList = new ArrayList<>();
        for (int k = 0; k < 3; k++) {
            // 모든 적 거리 정보 저장
            list.clear();
            for (int i = row; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (copyMap[i][j] == 1) {
                        // 두 위치 (r1, c1), (r2, c2)의 거리는 |r1-r2| + |c1-c2|
                        int d = Math.abs(i - N) + Math.abs(j - archerInfo[k]);
                        list.add(new Monster(i, j, d));
                    }
                }
            }
            if (list.size() > 0) {
                // 1. 거리, 2. 왼쪽에 가까운 순으로 정렬
                Collections.sort(list, new Comparator<Monster>() {
                    @Override
                    public int compare(Monster o1, Monster o2) {
                        if (o1.d == o2.d) {
                            return o1.y - o2.y;
                        }
                        return o1.d - o2.d;
                    }
                });
                // 적 제거: 같은 적이 여러 번 공격 당할 수 있다.
                if (list.get(0).d <= D) {
                    killList.add(list.get(0));
                }
            }
        }
        while (!killList.isEmpty()) {
            if (copyMap[killList.get(0).x][killList.get(0).y] != 0) {
                copyMap[killList.get(0).x][killList.get(0).y] = 0;
                kill++;
            }
            killList.remove(0);
        }
        return kill;
    }

    private static void startGame(int[] archerInfo) {
        int round = 0, kill = 0;
        while (round < N) {
            // 1. 궁수 공격 시작
            kill += attack(archerInfo, round);
            // 2. 적 아래로 한 칸 이동, 성벽(map[N])에 도달 시 제외
            for (int i = N - 1; i >= round; i--) {
                for (int j = 0; j < M; j++) {
                    if (i != N - 1) {
                        copyMap[i + 1][j] = copyMap[i][j];
                    }
                    copyMap[i][j] = 0;
                }
            }
            // 3. 모든 적이 제외되면 게임 끝: round는 최대 N
            boolean gameOver = true;
            f1:
            for (int i = 0; i < N; i++) {
                for (int j = 0; j < M; j++) {
                    if (copyMap[i][j] != 0) {
                        gameOver = false;
                        break f1;
                    }
                }
            }
            if (gameOver) break;
            round++;
        }
        maxKill = Math.max(maxKill, kill);
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st;

        // N x M 격자판, N+1 행: 궁수 3명 배치
        st = new StringTokenizer(br.readLine());
        N = Integer.parseInt(st.nextToken());
        M = Integer.parseInt(st.nextToken());
        D = Integer.parseInt(st.nextToken());

        map = new int[N + 1][M];
        copyMap = new int[N + 1][M];
        isSelected = new boolean[M];

        for (int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < M; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
            }
        }

        setArcher(0, 0);

        for (int i = 0; i < archerInfoList.size(); i++) {
            // map 복사
            for (int j = 0; j < N + 1; j++) {
                System.arraycopy(map[j], 0, copyMap[j], 0, M);
            }
            startGame(archerInfoList.get(i));
        }

        System.out.println(maxKill);
        br.close();
    }
}
