package Programmers._2023_KAKAO_BLIND_RECRUITMENT;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

public class 표_병합 {

    static String[][] board = new String[50][50];
    static int[] set = new int[50 * 50];

    private static void union(int a, int b) {
        int aRoot = find(a);
        int bRoot = find(b);
        int tmp = set[bRoot];
        if (aRoot != bRoot) {
            for (int j = 0; j < 50 * 50; j++) {
                if (set[j] == tmp) {
                    set[j] = aRoot;
                }
            }
        }
    }

    private static int find(int n) {
        if (set[n] == n) return n;
        board[n / 50][n % 50] = "";
        return set[n] = find(set[n]);
    }

    public static String[] solution(String[] commands) {
        StringTokenizer st;

        ArrayList<String> strList = new ArrayList<>();

        for (int i = 0; i < set.length; i++) {
            set[i] = i;
        }

        for (int i = 0; i < 50; i++) {
            for (int j = 0; j < 50; j++) {
                board[i][j] = "";
            }
        }

        for (int i = 0; i < commands.length; i++) {
            st = new StringTokenizer(commands[i]);
            String cmd = st.nextToken();
            String str;
            int r1, r2, r3, c1, c2, c3, n1, n2, parent;
            switch (cmd) {
                case "UPDATE":
                    // 남은 토큰의 개수로 구분
                    int cnt = st.countTokens();
                    // UPDATE r c value
                    // (r,c) = value
                    if (cnt == 3) {
                        r1 = Integer.parseInt(st.nextToken()) - 1;
                        c1 = Integer.parseInt(st.nextToken()) - 1;
                        str = st.nextToken();
                        n1 = find(r1 * 50 + c1);
                        board[n1 / 50][n1 % 50] = str;
                    }
                    // UPDATE value1 value2
                    // 모든 value1 값 찾아서 value2 로 변경
                    else {
                        String str1 = st.nextToken();
                        String str2 = st.nextToken();
                        for (int j = 0; j < 50; j++) {
                            for (int k = 0; k < 50; k++) {
                                if (board[j][k].equals(str1)) {
                                    board[j][k] = str2;
                                }
                            }
                        }
                    }
                    break;
                case "MERGE":
                    // MERGE r1 c1 r2 c2
                    r1 = Integer.parseInt(st.nextToken()) - 1;
                    c1 = Integer.parseInt(st.nextToken()) - 1;
                    r2 = Integer.parseInt(st.nextToken()) - 1;
                    c2 = Integer.parseInt(st.nextToken()) - 1;

                    n1 = find(r1 * 50 + c1);
                    n2 = find(r2 * 50 + c2);

                    // 같은 셀일 경우 무시
                    if (n1 == n2) continue;

                    r3 = n1 / 50;
                    c3 = n1 % 50;

                    // board[r1][c1]이 비었으면
                    if (board[r3][c3].equals("")) {
                        union(n2, n1);
                    } else {
                        union(n1, n2);
                    }
                    break;
                case "UNMERGE":
                    // UNMERGE r c
                    r1 = Integer.parseInt(st.nextToken()) - 1;
                    c1 = Integer.parseInt(st.nextToken()) - 1;

                    n1 = r1 * 50 + c1;
                    parent = find(n1);

                    str = board[parent / 50][parent % 50];
                    for (int j = 0; j < 50 * 50; j++) {
                        if (set[j] == parent) {
                            set[j] = j;
                            r2 = j / 50;
                            c2 = j % 50;
                            if (r1 == r2 && c1 == c2) {
                                board[r1][c1] = str;
                            } else board[r2][c2] = "";
                        }
                    }
                    break;
                case "PRINT":
                    // PRINT r c
                    r1 = Integer.parseInt(st.nextToken()) - 1;
                    c1 = Integer.parseInt(st.nextToken()) - 1;
                    n1 = find(r1 * 50 + c1);
                    str = board[n1 / 50][n1 % 50];
                    if (str.equals("")) {
                        strList.add("EMPTY");
                    } else strList.add(str);

                    break;
            }
        }

        String[] answer = new String[strList.size()];
        for (int i = 0; i < strList.size(); i++) {
            answer[i] = strList.get(i);
        }
        return answer;
    }

    public static void main(String[] args) {
        String[] result1 = solution(new String[]{"UPDATE 1 1 menu", "UPDATE 1 2 category", "UPDATE 2 1 bibimbap", "UPDATE 2 2 korean", "UPDATE 2 3 rice", "UPDATE 3 1 ramyeon", "UPDATE 3 2 korean", "UPDATE 3 3 noodle", "UPDATE 3 4 instant", "UPDATE 4 1 pasta", "UPDATE 4 2 italian", "UPDATE 4 3 noodle", "MERGE 1 2 1 3", "MERGE 1 3 1 4", "UPDATE korean hansik", "UPDATE 1 3 group", "UNMERGE 1 4", "PRINT 1 3", "PRINT 1 4"});
        String[] result2 = solution(new String[]{"UPDATE 1 1 a", "UPDATE 1 2 b", "UPDATE 2 1 c", "UPDATE 2 2 d", "MERGE 1 1 1 2", "MERGE 2 2 2 1", "MERGE 2 1 1 1", "PRINT 1 1", "UNMERGE 2 2", "PRINT 1 1"});
        String[] result3 = solution(new String[]{"UPDATE 1 1 menu", "MERGE 1 1 1 2", "MERGE 1 1 1 3", "MERGE 1 1 1 4", "MERGE 1 2 1 3", "UPDATE 1 1 hansik", "PRINT 1 1", "PRINT 1 2", "PRINT 1 3", "PRINT 1 4"});
        String[] result4 = solution(new String[]{"UPDATE 1 1 A", "UPDATE 2 2 B", "UPDATE 3 3 C", "UPDATE 4 4 D", "MERGE 1 1 2 2", "MERGE 3 3 4 4", "MERGE 1 1 4 4", "UNMERGE 3 3", "PRINT 1 1", "PRINT 2 2", "PRINT 3 3", "PRINT 4 4"});
        System.out.println(Arrays.toString(result1));
        System.out.println(Arrays.toString(result2));
        System.out.println(Arrays.toString(result3));
        System.out.println(Arrays.toString(result4));
    }
}
