package algorithm.basic_ps.backtracking.another;

import java.util.ArrayList;
import java.util.List;

public class No2_Permutation {

    public static void main(String[] args) {
        No2_Permutation a = new No2_Permutation();
        int[] nums = {1,2,3};


        System.out.println(a.permute(nums));
    }

    List<Integer> elements = new ArrayList<>();
    List<Integer> prevElements = new ArrayList<>();
    List<List<Integer>> result = new ArrayList<>();

    public List<List<Integer>> permute(int[] nums) {
        if (nums == null || nums.length == 0) {
            return result;
        }

        for (int num : nums) {
            elements.add(num);
        }

        dfs(elements);
        //backtrackingView(elements); // 정답 계산 과정 보기

        return result;
    }

    private void dfs(List<Integer> elements) {
        /*
        * 이전 값을 하나씩 덧붙여 계속 재귀 호출을 진행하다가 리프 노드에 도달한 경우
        * 즉, element.size() == 0 일 때, 결과를 하나씩 담는다.
        * */
        // 리프 노드일 때 결과를 추가한다.
        if (elements.size() == 0) {
            List<Integer> temp = new ArrayList<>(prevElements);
            result.add(temp);
        }

        // 순열을 생성하기 위한 재귀 호출
        for(Integer e : elements){
            List<Integer> nextElements = new ArrayList<>(elements);
            nextElements.remove(e);

            System.out.println(nextElements);

            prevElements.add(e);
            dfs(nextElements);
            prevElements.remove(prevElements.size() - 1); // 마지막에 추가한 숫자를 삭제
        }
    }

    int count = 0;

    private void backtrackingView(List<Integer> elements) {
        count++;
        System.out.println("<START> : " + prevElements);

        if (elements.size() == 0) {
            System.out.println();
            System.out.println("----- ANSWER -----");
            List<Integer> temp = new ArrayList<>(prevElements);
            result.add(temp);
            System.out.println(temp);
            System.out.println("------------------");
            System.out.println();
        }

        // 순열을 생성하기 위한 재귀 호출
        for(Integer e : elements){
            List<Integer> nextElements = new ArrayList<>(elements);
            nextElements.remove(e);

            prevElements.add(e);
            backtrackingView(nextElements);
            prevElements.remove(prevElements.size() - 1); // 마지막에 추가한 숫자를 삭제
        }
    }

}
