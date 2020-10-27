package algorithm.basic_ps.string_array;

public class MaximumSubarray {

    public static void main(String[] args) {
        int[] nums = { -2, 1, -3, 4, -1, 2, 1, -5, 4 };
        System.out.println(maxSubArray(nums));
    }

    public static int maxSubArray(int[] nums) {
        int sum = nums[0];  // -2
        int max = nums[0];  // -2

        for (int i = 1; i < nums.length; i++) {
            sum = Math.max(sum + nums[i], nums[i]);  // 해당 숫자가 부분 배열에 포함되는 것과 되지 않는 것 중에서 큰 값으로 sum을 지정한다.
            max = Math.max(max, sum); // 부분 배열 중에서 최대 값을 찾는다.
        }

        return max;
    }

}
