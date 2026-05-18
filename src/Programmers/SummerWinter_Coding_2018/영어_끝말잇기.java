package Programmers.SummerWinter_Coding_2018;

import java.util.HashSet;
import java.util.Set;

public class 영어_끝말잇기 {

    private Set<String> wordSet;

    private boolean isDuplicateWord(String word) {
        return wordSet.contains(word);
    }

    private boolean isWrongWord(String prev, String cur) {
        return (prev.charAt(prev.length() - 1) != cur.charAt(0));
    }

    public int[] solution(int n, String[] words) {
        wordSet = new HashSet<>();

        int[] answer = {0, 0};

        for (int i = 0; i < words.length; i++) {
            if (isDuplicateWord(words[i]) || (i != 0 && isWrongWord(words[i - 1], words[i]))) {
                answer[0] = (i % n) + 1;
                answer[1] = (i / n) + 1;
                break;
            } else {
                wordSet.add(words[i]);
            }
        }

        return answer;
    }
}
