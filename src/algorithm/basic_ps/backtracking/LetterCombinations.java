package algorithm.basic_ps.backtracking;

import java.util.*;

public class LetterCombinations{

    public static void main(String[] args) {
        LetterCombinations a = new LetterCombinations();
        System.out.println(a.letterCombinations("23"));

        StringBuilder sb = new StringBuilder("abc");
    }

    String phoneLetters[] = { "",    "",    "abc",  "def", "ghi",
            "jkl", "mno", "pqrs", "tuv", "wxyz" };

    public List<String> letterCombinations(String digits) {
        List<String> result = new ArrayList<>();

        if(digits.length() == 0)
            return result;

        go(digits, new StringBuilder(), 0, result);

        return result;
    }

    public void go(String digits, StringBuilder cur, int index, List<String> result) {
        int curlen = cur.length();

        // 정답을 저장하는 경우
        if(curlen == digits.length()) {
            result.add(cur.toString());
            return;
        }

        // 입력으로 주어진 digits에 사용할 반복문
        for(int i = index; i < digits.length(); i++) {
            String letters = phoneLetters[digits.charAt(i) - '0'];

            // phoneLetters에 사용할 반복문
            for(int j = 0; j < letters.length(); j++) {
                cur.append(letters.charAt(j));

                go(digits, cur, i + 1, result);

                cur.setLength(curlen); // go() 호출이 끝나면 끝 문자 삭제
                //cur.deleteCharAt(curlen); // 해당 코드로 대체 가능
            }
        }
    }
}