package algorithm.basic_ps.backtracking;

import java.util.*;

public class GenerateParentheses {

    public static void main(String[] args) {
        GenerateParentheses a = new GenerateParentheses();
//		System.out.println(a.generateParenthesis_backTrac(3));
        System.out.println(a.generateParenthesis(3));
    }

    public List<String> generateParenthesis(int n) {
        List<String> result = new ArrayList();
        go(result, "", 0, 0, n);

        return result;
    }

    public void go(List<String> ans, String cur, int open, int close, int max){
        // 문제에서 주어진 괄호는 2개 ['(' , ')'] 이다. 이것으로 만들 수 있는 것은 2N개다.
        if (cur.length() == max * 2) {
            ans.add(cur);
            return;
        }

        // 예를 들어 max가 3이면 여는 괄호를 3개까지는 허용한다.
        if (open < max)
            go(ans, cur + "(", open + 1, close, max);

        // 닫는 괄호의 개수가 여는 괄호 개수 보다 작다면 닫는 괄호를 추가한다.
        if (close < open)
            go(ans, cur + ")", open, close + 1, max);
    }
}
