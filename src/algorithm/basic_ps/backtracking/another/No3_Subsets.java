package algorithm.basic_ps.backtracking.another;

import java.util.ArrayList;
import java.util.List;

public class No3_Subsets {

    public static void main(String[] args) {
        No3_Subsets a = new No3_Subsets();
        int[] nums = {1,2,3};

        System.out.println(a.subsets(nums));
    }

    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();
        List<Integer> cur = new ArrayList<>();

        if(nums == null || nums.length == 0)
            return result;

        go(nums, result, cur, 0);

        return result;
    }

    public void go(int[] nums, List<List<Integer>> result, List<Integer> path, int index) {
        List<Integer> list = new ArrayList<>(path);
        result.add(list);

        for(int i = index; i < nums.length; i++) {
            List<Integer> newPath = new ArrayList<>(path);
            newPath.add(nums[i]);
            go(nums, result, newPath,i + 1);
        }
    }
}
