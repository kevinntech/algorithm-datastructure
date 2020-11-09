package algorithm.basic_ps.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Subsets {


    public static void main(String[] args) {
        Subsets a = new Subsets();
        int[] nums = {1,2,3};

        System.out.println(a.subsets(nums));
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();

        if(nums == null || nums.length == 0)
            return result;

        dfs(nums, result, cur, 0);

        return result;
    }

    // cur : [ ] -> [1] -> [1, 2] -> [1, 2, 3] -> 마지막 숫자 제거 -> [1, 3] -> [2, 3] -> [3]
    private void dfs(int[] nums, List<List<Integer>> result, List<Integer> cur, int index) {
        List<Integer> list = new ArrayList<>(cur);
        result.add(list);

        //2 for 저장, 탈출
        for(int i = index; i < nums.length; i++) {
            System.out.print(nums[i] + " ");
            cur.add(nums[i]);

            dfs(nums, result, cur,i + 1);

            cur.remove(cur.size() - 1); // dfs() 호출이 끝나면 끝 자리 삭제
        }
    }
}
