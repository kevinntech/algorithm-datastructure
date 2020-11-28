package algorithm.basic_ps.string_array;

import java.util.ArrayList;
import java.util.List;

public class MissingRanges {
    public static void main(String[] args) {
       // int[] nums = {2, 3, 5, 50, 75};

        int[] nums  = {0, 1, 3, 50, 75};
        int lower = 0, upper = 99;
        System.out.println(findMissingRanges(nums, lower, upper));
    }

    public static List<String> findMissingRanges(int[] nums, int lower, int upper) {
        List<String> res = new ArrayList<String>();

        // next 변수를 선언하여 lower로 초기화한다.
        int next = lower;

        for (int i = 0; i < nums.length; i++) {
            // nums [i] < next 이면 다음 num으로 이동하여 범위 내에 있는지 확인합니다.
            if (nums[i] < next) {
                continue;
            }

            // nums[i] == next 이면 범위에서 첫 번째 숫자를 찾은 것을 의미합니다. next를 1 증가시킵니다.
            if (nums[i] == next) {
                next++;
                continue;
            }

            // nums[i] > next 인 경우 : 누락 된 범위 [next, nums [i] — 1]을 추가합니다.
            res.add(getRange(next, nums[i] - 1));

            // 다음 값을 nums [i] + 1로 수정합니다.
            next = nums[i] + 1;
        }

        // 위의 반복을 마친 후 최종 next 값을 다시 확인해야합니다.
        // next ≤ upper이면 추가 할 누락 된 범위 [next, upper]가 있습니다.
        if (next <= upper) {
            res.add(getRange(next, upper));
        }

        return res;
    }

    public static String getRange(int n1, int n2) {
        return n1 == n2 ? String.valueOf(n1) : String.format("%d->%d" , n1, n2);
    }
}
