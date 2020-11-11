package algorithm.basic_ps.dp;

import java.util.Arrays;

public class Lis {

    public static void main(String[] args) {

        Lis a = new Lis();
        int[] nums = {1, 2, 3, 2, 5, 2, 6, 10, 4, 12};
//		int[] nums = {9,11,2,8,4,7,88,15};

        System.out.println("value "+ a.lengthOfLIS(nums));
    }
    public int lengthOfLIS(int[] nums) {
        if(nums == null || nums.length == 0)
            return 0;

        int[] dp = new int[nums.length];

        int result = 1;

        for(int i = 0; i < nums.length; i++){
            dp[i] = 1;

            for(int j = 0; j < i; j++){
                if(nums[j] < nums[i]){
                    dp[i] = Math.max(dp[j] + 1, dp[i]);
                }
            }

            result = Math.max(result, dp[i]);
        }

        return result;
    }
}
