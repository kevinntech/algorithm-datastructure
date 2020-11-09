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
        backtrack(result, "", 0, 0, n);

        return result;
    }

    public void backtrack(List<String> ans, String cur, int open, int close, int max){
        // 문제에서 주어진 괄호는 2개 ['(' , ')'] 이다. 이것으로 만들 수 있는 것은 2N개다.
        if (cur.length() == max * 2) {
            ans.add(cur);
            return;
        }

        if (open < max)
            backtrack(ans, cur + "(", open + 1, close, max);

        if (close < open)
            backtrack(ans, cur + ")", open, close + 1, max);
    }
}
