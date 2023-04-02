package Programmers.High_Score_Kit.Hash;

import java.util.*;

public class 베스트앨범 {

    public int[] solution(String[] genres, int[] plays) {
        int[] answer;

        Map<String, ArrayList<int[]>> map = new HashMap<>();
        ArrayList<int[]> list;
        for (int i = 0; i < genres.length; i++) {
            if (map.containsKey(genres[i])) {
                list = map.get(genres[i]);
                list.add(new int[]{plays[i], i});
                map.put(genres[i], list);
            } else {
                list = new ArrayList<>();
                list.add(new int[]{plays[i], i});
                map.put(genres[i], list);
            }
        }

        ArrayList<Object[]> list2 = new ArrayList<>();

        int cnt = 0;
        for (String key : map.keySet()) {
            list = map.get(key);
            Collections.sort(list, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    // 재생 횟수가 같다면 고유번호 낮은 순
                    if (o1[0] == o2[0])
                        return o1[1] - o2[1];
                        // 재생 번호 높은 순
                    else return o2[0] - o1[0];
                }
            });

            int sum = 0;
            for (int i = 0; i < list.size(); i++) {
                sum += list.get(i)[0];
                if (i < 2)
                    cnt++;
            }

            list2.add(new Object[]{key, sum});
        }

        Collections.sort(list2, new Comparator<Object[]>() {
            @Override
            public int compare(Object[] o1, Object[] o2) {
                return (int) o2[1] - (int) o1[1];
            }
        });

        answer = new int[cnt];
        int idx = 0;
        for (int i = 0; i < list2.size(); i++) {
            list = map.get(list2.get(i)[0]);
            if (list.size() == 1) {
                answer[idx++] = list.get(0)[1];
            } else {
                answer[idx++] = list.get(0)[1];
                answer[idx++] = list.get(1)[1];
            }
        }

        return answer;
    }

}
