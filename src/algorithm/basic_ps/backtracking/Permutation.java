package algorithm.basic_ps.backtracking;

import java.util.ArrayList;
import java.util.List;

public class Permutation {

    public static void main(String[] args) {
        Permutation a = new Permutation();
        int[] nums = {1,2,3};

        System.out.println(a.permute(nums));
    }

    public List<List<Integer>> permute(int[] nums) {
        List<List<Integer>> result = new ArrayList<>();

        if (nums == null || nums.length == 0) {
            return result;
        }

        go(nums, result, new ArrayList<>());
        backtrackingView(nums, result, new ArrayList<Integer>()); // 정답 계산 과정 보기

        return result;
    }

    private void go(int[] nums, List<List<Integer>> result, List<Integer> cur) {
        // cur에 저장된 숫자가 nums의 길이와 같다면 정답을 구한 경우이다.
        if (cur.size() == nums.length) {
            List<Integer> temp = new ArrayList<>(cur);
            result.add(temp);
        }

        for (int i = 0; i < nums.length; i++) {
            // 중복을 허용하지 않도록 함 (무조건 한번만 사용 되도록 함)
            if (cur.contains(nums[i])) {
                continue; // 반복을 건너 뜀
            }

            cur.add(nums[i]);

            go(nums, result, cur);

            cur.remove(cur.size() - 1); // 마지막에 추가한 숫자 삭제
        }
    }

    int count = 0;

    private void backtrackingView(int[] nums, List<List<Integer>> lists, List<Integer> cur) {
        count++;
        System.out.println("<START> : " + cur);

        if (cur.size() == nums.length) {
            System.out.println();
            System.out.println("----- ANSWER -----");
            List<Integer> list = new ArrayList<>(cur);
            lists.add(list);
            System.out.println(list);
            System.out.println("------------------");
            System.out.println();
        }

        for (int i = 0; i < nums.length; i++) {

            // 문제에서 요구한 정답 출력
            if (cur.contains(nums[i])) {
                continue;
            }

//            // 모든 순열 출력
//	        if (cur.size() == nums.length) {
//        	    continue;
//	        }

            cur.add(nums[i]);
            backtrackingView(nums, lists, cur);
            cur.remove(cur.size() - 1);
        }

    }

}
