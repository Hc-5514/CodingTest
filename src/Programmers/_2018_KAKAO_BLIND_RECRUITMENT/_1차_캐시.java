/**
 * 문제 : [1차] 캐시
 *
 * @author Hc-5514
 */

package Programmers._2018_KAKAO_BLIND_RECRUITMENT;

import java.util.*;
public class _1차_캐시 {

    public int solution(int cacheSize, String[] cities) {
        // 캐쉬 크기만큼 저장이 가능하다.
        // 리스트를 큐의 구조(선입선출)로 사용을 하자.
        // 리스트에 일치하는 도시 이름이 없을 경우 비용은 5, 있을 경우 1이다.
        // 도시의 대소문자는 구분하지 않는다.
        List<String> list = new ArrayList<>();
        int cost = 0;
        for(int i=0; i<cities.length; i++){
            String str = cities[i].toLowerCase();
            if(list.contains(str)){
                cost++;
                int idx = list.indexOf(str);
                list.remove(idx);
                list.add(str);
            }
            else {
                cost += 5;
                if(cacheSize != 0){
                    if(list.size() == cacheSize){
                        list.remove(0);
                    }
                    list.add(str);
                }
            }
        }
        return cost;
    }
}
