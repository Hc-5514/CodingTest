/**
 * 문제 : 청소년 상어
 *
 * @author Hc-5514
 */

package Baekjoon.Algorithm.BFSDFS;

import java.io.*;
import java.util.*;

public class BOJ_19236 {

    static int eatMaxCnt = Integer.MIN_VALUE;
    static final int[] dRow = {-1, -1, 0, 1, 1, 1, 0, -1}, dCol = {0, -1, -1, -1, 0, 1, 1, 1};
    static Shark shark = new Shark();

    static class Shark {
        int r;
        int c;
        int d; // ↑, ↖, ←, ↙, ↓, ↘, →, ↗ 8방향
    }

    static class Fish {
        int no;
        int r;
        int c;
        int d;

        public Fish(int no, int r, int c, int d) {
            this.no = no;
            this.r = r;
            this.c = c;
            this.d = d;
        }
    }

    private static void dfs(int[][] oriMap, ArrayList<Fish> oriList, int eatCnt) {
        // 사용할 배열, 리스트 복사
        int[][] useMap = copyMap(oriMap);
        ArrayList<Fish> useList = copyList(oriList);

        // 1. 물고기 이동
        moveFish(useMap, useList);

        // 2. 상어 이동, 불가능 할 경우 종료
        // 상어는 직선 여러 칸 중 선택 이동 가능 (물고기 있는 칸 만)
        // 현재 상어 정보 불러오기
        int curR = shark.r;
        int curC = shark.c;
        int curD = shark.d;
        // 맵 범위 내 상어 이동 가능 여부 확인
        int r = curR + dRow[curD];
        int c = curC + dCol[curD];
        while (r >= 0 && c >= 0 && r < 4 && c < 4) {
            // 물고기가 존재한다면, 이동
            if (useMap[r][c] >= 1 && useMap[r][c] <= 16) {
                int eat = useMap[r][c];
                // 사용할 배열, 리스트 복사 후 전달
                int[][] sharkMap = copyMap(useMap);
                ArrayList<Fish> sharkList = copyList(useList);
                // 1. 상어 정보 수정
                shark.r = r;
                shark.c = c;
                // 2. 배열 수정
                sharkMap[r][c] = 0; // 상어 이동
                sharkMap[curR][curC] = -1; // 빈칸은 -1 저장
                // 3. 리스트에서 해당 물고기 삭제
                for (int i = 0; i < sharkList.size(); i++) {
                    if (sharkList.get(i).no == eat) {
                        shark.d = sharkList.get(i).d;
                        sharkList.remove(i);
                    }
                }
                dfs(sharkMap, sharkList, eatCnt + eat);
            }
            r += dRow[curD];
            c += dCol[curD];
        }
        // 상어가 이동 못 하면 종료
        // 상어가 먹을 수 있는 물고기 번호의 합의 최댓값 구하기
        if (eatMaxCnt < eatCnt) eatMaxCnt = eatCnt;
    }

    private static int[][] copyMap(int[][] Ori) {
        int[][] copyMap = new int[4][4];
        for (int i = 0; i < 4; i++) {
            copyMap[i] = Arrays.copyOf(Ori[i], 4);
        }
        return copyMap;
    }

    private static ArrayList<Fish> copyList(ArrayList<Fish> Ori) {
        ArrayList<Fish> copyList = new ArrayList<>();
        for (int i = 0; i < Ori.size(); i++) {
            copyList.add(Ori.get(i));
        }
        return copyList;
    }

    private static void moveFish(int[][] useMap, ArrayList<Fish> useList) {
        for (int i = 0; i < useList.size(); i++) {
            // 현재 물고기 정보(좌표, 방향)
            int curNo = useList.get(i).no;
            int curR = useList.get(i).r;
            int curC = useList.get(i).c;
            int curD = useList.get(i).d; // ↑, ↖, ←, ↙, ↓, ↘, →, ↗ 8방향
            int changeNo = 0, changeR = 0, changeC = 0, changeD = 0;
            int curIdx = 0, changeIdx = 0;
            int cnt = 0;
            boolean isMove = false;
            while (!isMove) {
                // 8번 이동 못할 시, 이동 x
                if (cnt == 8) {
                    break;
                }
                // 이동 할 칸 좌표 r,c
                int r = curR + dRow[curD], c = curC + dCol[curD];
                // 배열 범위 확인, 상어 위치 확인
                if (r < 0 || c < 0 || r >= 4 || c >= 4 || useMap[r][c] == 0) {
                    // 이동 못 할 시, 45도 반시계 회전
                    curD = (curD + 1) % 8;
                    cnt++;
                    continue;
                }
                // 이동 가능하면, 물고기 정보 받고 종료
                isMove = true;
                changeNo = useMap[r][c];
                changeR = r;
                changeC = c;
                for (int j = 0; j < useList.size(); j++) {
                    if (useList.get(j).no == curNo) curIdx = j;
                    if (useList.get(j).no == changeNo) {
                        changeIdx = j;
                        changeD = useList.get(j).d;
                    }
                }
            }
            // 물고기 위치 바꾸기
            if (isMove) {
                // 1. 배열 수정
                useMap[curR][curC] = changeNo;
                useMap[changeR][changeC] = curNo;
                // 2. 리스트 정보 수정
                useList.set(curIdx, new Fish(curNo, changeR, changeC, curD));
                if (changeNo != -1) { // 빈 칸이 아니라면
                    useList.set(changeIdx, new Fish(changeNo, curR, curC, changeD));
                }
            }
        }
    }

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        BufferedWriter bw = new BufferedWriter(new OutputStreamWriter(System.out));
        StringTokenizer st;
        // 물고기 정보 저장
        int[][] map = new int[4][4];
        ArrayList<Fish> list = new ArrayList<>();
        for (int i = 0; i < 4; i++) {
            st = new StringTokenizer(br.readLine());
            for (int j = 0; j < 4; j++) {
                map[i][j] = Integer.parseInt(st.nextToken());
                list.add(new Fish(map[i][j], i, j, Integer.parseInt(st.nextToken()) - 1));
            }
        }
        Collections.sort(list, new Comparator<Fish>() {
            @Override
            public int compare(Fish o1, Fish o2) {
                return o1.no - o2.no;
            }
        });
        // 상어 정보 저장: 0,0 물고기 잡아 먹고 시작
        int eatCnt = map[0][0];
        shark.r = 0;
        shark.c = 0;
        shark.d = list.get(map[0][0] - 1).d;
        list.remove(map[0][0] - 1);
        map[0][0] = 0;

        dfs(map, list, eatCnt);

        bw.write(eatMaxCnt + "\n");
        bw.flush();
        bw.close();
        br.close();
    }
}